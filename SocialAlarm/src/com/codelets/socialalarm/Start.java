package com.codelets.socialalarm;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

public class Start extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
	}
	private class CallAPI extends AsyncTask<String, String, String> {

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String urlString = params [0];	//URL
			String resultToDisplay = "";
			InputStream in = null;
			
			// HTTP Get
			try {
				URL url = new URL(urlString);
				HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
				in = new BufferedInputStream(urlConnection.getInputStream());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return e.getMessage();
			}
			return resultToDisplay;
		}
		
		protected void onPostExecute(String result) {
			
		}
	}
}
