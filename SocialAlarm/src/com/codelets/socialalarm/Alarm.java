package com.codelets.socialalarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;

public class Alarm extends Activity implements OnClickListener {
	Button setAlarm;
	TimePicker alarmTime;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialogue_alarm);
		initialize();
	}

	public void initialize() {

		// Button
		setAlarm = (Button) findViewById(R.id.bSetAlarm);
		alarmTime = (TimePicker) findViewById(R.id.tpTimePick);

		// Set Listener
		setAlarm.setOnClickListener(this);
		alarmTime.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSetAlarm:

			// Grab Alarm Time
			int hour_alarm,
			minute_alarm;
			hour_alarm = alarmTime.getCurrentHour();
			minute_alarm = alarmTime.getCurrentMinute();

			// Set Alarm Time Intent
			Intent i = new Intent(android.provider.AlarmClock.ACTION_SET_ALARM);
			i.putExtra(android.provider.AlarmClock.EXTRA_HOUR, hour_alarm);
			i.putExtra(android.provider.AlarmClock.EXTRA_MINUTES, minute_alarm);
			i.putExtra(android.provider.AlarmClock.EXTRA_SKIP_UI, true);
			startActivity(i);
			setResult(RESULT_OK);
			finish();
			break;
		default:
			;
		}

	}
}
