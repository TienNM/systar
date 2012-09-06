package com.soyomaker.handlers.task;

import org.springframework.stereotype.Component;

import com.soyomaker.lang.GameObject;
import com.soyomaker.net.AbHandler;
import com.soyomaker.net.UserSession;

@Component("applyTaskHandler")
public class ApplyTaskHandler extends AbHandler {

	@Override
	public void handleMessage(UserSession session, GameObject msg) {
		//(1)取待申请任务ID
		int id = msg.getInt("id");
		//(2)是否已经申请
		//(3)是否可以申请
		
	}

}