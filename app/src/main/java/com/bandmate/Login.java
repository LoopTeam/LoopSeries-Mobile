package com.bandmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bandmate.custom.CustomActivity;

/**
 * The Class Login is an Activity class that shows the login screen to users.
 * The current implementation simply start the MainActivity. You can write your
 * own logic for actual login using Twitter.
 */
public class Login extends CustomActivity
{

	/* (non-Javadoc)
	 * @see com.chatt.custom.CustomActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		setTouchNClick(R.id.btnTw);
	}

	/* (non-Javadoc)
	 * @see com.chatt.custom.CustomActivity#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v)
	{
		super.onClick(v);
		if (v.getId() == R.id.btnTw)
		{
			startActivity(new Intent(this, MainActivity.class));
			finish();
		}
	}
}
