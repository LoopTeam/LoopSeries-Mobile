package com.bandmate.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bandmate.R;
import com.bandmate.custom.CustomFragment;

/**
 * The Class Player is the Fragment class that is launched when the user clicks
 * on Music Player option in Left navigation drawer and it simply shows a dummy
 * Music player layout. You can customize this to implement actual functionality
 * of Music Player as per your needs..
 */
public class Player extends CustomFragment
{

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.player, null);

		setTouchNClick(v.findViewById(R.id.random));
		setTouchNClick(v.findViewById(R.id.repeat));
		setTouchNClick(v.findViewById(R.id.play));
		setTouchNClick(v.findViewById(R.id.next));
		setTouchNClick(v.findViewById(R.id.prev));
		setHasOptionsMenu(true);
		return v;
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateOptionsMenu(android.view.Menu, android.view.MenuInflater)
	 */
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		inflater.inflate(R.menu.edit, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}
}
