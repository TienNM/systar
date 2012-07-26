package com.soyomaker.model.typeHelper;

import org.dom4j.Element;

import com.soyomaker.data.GDataType;

/**
 * 数据类型的描述
 * 
 * @author zhangjun
 * 
 */
public class PropertyHelper {
	public static PropertyHelper fromElement(Element e) {
		PropertyHelper map = new PropertyHelper();
		map.setFieldName(e.attributeValue("name"));
		map.setColumnName(e.attributeValue("column"));
		map.setType(GDataType.fromTypeName(e.attributeValue("type")));
		return map;
	}

	private String fieldName;
	private String columnName;

	private GDataType type;

	public String getColumnName() {
		return columnName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public GDataType getType() {
		return type;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setType(GDataType type) {
		this.type = type;
	}
}