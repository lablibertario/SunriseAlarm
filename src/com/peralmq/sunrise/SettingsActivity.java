package com.peralmq.sunrise;

import java.sql.Time;

import com.peralmq.sunrise.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TimePicker;

public class SettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void button8Clicked(View v) {
		Intent intent = new Intent(this, SunriseActivity.class);
		PendingIntent pi = PendingIntent.getActivity(this, 0, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker1);
		Time time = new Time(System.currentTimeMillis());
		
		time.setHours(timePicker.getCurrentHour());
		time.setMinutes(timePicker.getCurrentMinute());
		time.setSeconds(0);

		AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP, time.getTime(), pi);
//		alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1000, pi);
	}

}
