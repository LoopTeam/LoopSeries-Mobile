package com.bandmate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.bandmate.custom.CustomActivity;

/**
 * The Class BlogDetail is an Activity class that shows the detail of Blog. The
 * current implementation simply shows the dummy detail text and image. You need
 * to write your own logic for actual text and image display.
 */
public class BlogDetail extends CustomActivity
{

	/* (non-Javadoc)
	 * @see com.chatt.custom.CustomActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blog_detail);

		getActionBar().setTitle("Blog");
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.edit, menu);
		return super.onCreateOptionsMenu(menu);
	}

	/* (non-Javadoc)
	 * @see com.newsfeeder.custom.CustomActivity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if (item.getItemId() == android.R.id.home)
			finish();
		return super.onOptionsItemSelected(item);
	}
}
