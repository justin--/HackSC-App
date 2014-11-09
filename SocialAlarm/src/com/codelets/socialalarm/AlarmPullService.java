package com.codelets.socialalarm;

import android.app.IntentService;
import android.content.Intent;

public class AlarmPullService extends IntentService {

	public AlarmPullService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		
		// Gets data from the incoming Intent
		String dataString = intent.getDataString();

		// Do work here, based on the contents of dataString

	}

}
