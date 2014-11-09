package com.codelets.socialalarm;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	public final static String apiURL = "";
	final static int ADD = 0;
	EditText userID;
	Button login;
	LinearLayout xmlMain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initialize();
	}

	/*
	 * This function initializes variables Post: Variables initialized
	 */
	public void initialize() {
		// EditText
		userID = (EditText) findViewById(R.id.etUserID);

		// Button
		login = (Button) findViewById(R.id.bLogin);

		// Set Listener
		login.setOnClickListener(this);

	}

	/*
	 * This function handles listeners Pre: a listener is activated
	 */

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bLogin:
			verify();
			break;
		}

	}

	/*
	 * This function verifies valid id Pre: user inputs id Post: returns true or
	 * false
	 */
	public void verify() {
		String id = userID.getText().toString();
		if (id != null && !id.isEmpty()) {
			String urlString = apiURL + "/" + id;
			new CallAPI().execute(urlString);

		} else {
			Toast.makeText(this, "Field is Empty", Toast.LENGTH_SHORT).show();
		}

	}

	private class CallAPI extends AsyncTask<String, String, String> {

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String urlString = params[0]; // URL
			String resultToDisplay = "";
			InputStream in = null;

			// HTTP Get
			try {
				URL url = new URL(urlString);
				HttpURLConnection urlConnection = (HttpURLConnection) url
						.openConnection();
				in = new BufferedInputStream(urlConnection.getInputStream());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return e.getMessage();
			}
			return resultToDisplay;
		}

		protected void onPostExecute(String result) {
			// set alarm
			int hour_alarm, minute_alarm, days_alarm;
			hour_alarm = 2;									// grab hour from db
			minute_alarm = 2;								// grab minute from db
			days_alarm = 2;									// grab days from db

			// Set Alarm Time Intent
			Intent i = new Intent(android.provider.AlarmClock.ACTION_SET_ALARM);
			i.putExtra(android.provider.AlarmClock.EXTRA_HOUR, hour_alarm);
			i.putExtra(android.provider.AlarmClock.EXTRA_MINUTES, minute_alarm);
			i.putExtra(android.provider.AlarmClock.EXTRA_DAYS, days_alarm);
			i.putExtra(android.provider.AlarmClock.EXTRA_SKIP_UI, true);
			startActivity(i);
			setResult(RESULT_OK);
			finish();

		}

	}
}
