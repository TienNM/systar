package com.soyomaker.model.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.soyomaker.data.ISMObject;
import com.soyomaker.data.SMDataType;
import com.soyomaker.data.SMObject;

public class TableProxy {

	private static final String INT = "int";

	private static final String FLOAT = "float";

	private static final String STRING = "string";

	private static Logger log = Logger.getLogger(TableProxy.class);

	private Map<String, SMDataType> fieldMap = new HashMap<String, SMDataType>();

	private String primaryKey = null;

	private String tableName = null;

	private String name = null;

	public TableProxy(String name, String tableName, String primaryKey) {
		super();
		this.primaryKey = primaryKey;
		this.tableName = tableName;
		this.name = name;
	}

	public boolean insert(ISMObject data) {
		List<String> keys = new ArrayList<String>();
		keys.addAll(fieldMap.keySet());
		return this.insert(keys, data);
	}

	public boolean insert(List<String> keys, ISMObject data) {
		String psSql = "insert into " + this.getTableName() + "("
				+ TableProxy.getKeyString(keys) + ")" + " values ("
				+ TableProxy.getMarkString(keys.size()) + ")";
		List<Object> params = new ArrayList<Object>();
		for (int i = 0; i < keys.size(); i++) {
			params.add(TableProxy.getValue(keys.get(i), data));
		}
		boolean status = SQLUtil.execute(psSql, params);
		return status;
	}

	public ISMObject selectWherePrimaryKey(Object value) {
		List<ISMObject> resList = this.selectWhere(this.getPrimaryKey(), value);
		if (resList.size() > 0) {
			return resList.get(0);
		} else {
			return null;
		}
	}

	public List<ISMObject> selectWhere(String key, Object value) {
		List<String> keys = new ArrayList<String>();
		keys.add(key);
		List<Object> values = new ArrayList<Object>();
		values.add(value);
		return this.selectWhere(keys, values);
	}

	public List<ISMObject> selectWhere(List<String> keys, List<Object> values) {
		String psSql = "select * from " + this.getTableName() + " where "
				+ TableProxy.getKeyString(keys) + " = "
				+ TableProxy.getMarkString(keys.size());
		final List<ISMObject> resList = new ArrayList<ISMObject>();
		SQLUtil.query(psSql, values, new IResultSetProcessor() {
			@Override
			public void proceResultSet(ResultSet rs) {
				try {
					while (rs.next()) {
						ISMObject obj = new SMObject();
						for (String key : fieldMap.keySet()) {
							log.debug("key:"+key);
							SMDataType type = fieldMap.get(key);
							switch (type) {
							case INT:
								obj.putInt(key, rs.getInt(key));
								break;
							case FLOAT:
								obj.putFloat(key, rs.getFloat(key));
								break;
							case STRING:
								obj.putString(key, rs.getString(key));
								break;
							default:
								break;
							}
						}
						resList.add(obj);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		return resList;
	}

	public String getName() {
		return name;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public String getTableName() {
		return tableName;
	}

	public void putField(String name, String type) {
		if (type.equalsIgnoreCase(INT)) {
			fieldMap.put(name, SMDataType.INT);
		} else if (type.equalsIgnoreCase(FLOAT)) {
			fieldMap.put(name, SMDataType.FLOAT);
		} else if (type.equalsIgnoreCase(STRING)) {
			fieldMap.put(name, SMDataType.STRING);
		}
	}

	private static Object getValue(String key, ISMObject obj) {
		return obj.get(key).getValue();
	}

	private static String getKeyString(List<String> keys) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			sb.append(key);
			if (i != keys.size() - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

	private static String getMarkString(int num) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			sb.append("?");
			if (i != num - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

}
