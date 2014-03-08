package com.peralmq.sunrise;

import com.peralmq.sunrise.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SunriseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sunrise);
		
	    getWindow().addFlags(
	            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|
	            WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON|
	            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		View view2 = (View) findViewById(R.id.view2);
		Animation animFadein = AnimationUtils.loadAnimation(
				getApplicationContext(), R.anim.sunrise);
		view2.setVisibility(View.VISIBLE);
		view2.startAnimation(animFadein);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
