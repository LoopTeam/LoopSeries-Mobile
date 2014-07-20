package com.bandmate.ui;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bandmate.R;
import com.bandmate.custom.CustomFragment;
import com.bandmate.model.Data;

/**
 * The Class Profile is the Fragment class that is launched when the user clicks
 * on Profile option in Left navigation drawer and it simply shows a dummy
 * profile of user with some dummy songs of user. You can customize this to
 * display actual profile data.
 */
public class Profile extends CustomFragment
{

	/** The song list. */
	private ArrayList<Data> sList;

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.profile, null);
		setHasOptionsMenu(true);

		setTouchNClick(v.findViewById(R.id.btnTweet));

		setSongList(v);
		return v;
	}

	/**
	 * Setup the song list view.
	 * 
	 * @param v
	 *            the root view
	 */
	private void setSongList(View v)
	{
		loadDummySongs();

		ListView list = (ListView) v.findViewById(R.id.list);
		list.setAdapter(new SongAdapter());
	}

	/**
	 * Load a dummy list of Songs. You need to write your own logic to load
	 * actual list of Songs.
	 */
	private void loadDummySongs()
	{
		ArrayList<Data> sl = new ArrayList<Data>();
		sl.add(new Data("Black britain", "3.44"));
		sl.add(new Data("Friends forever", "4.12"));
		sl.add(new Data("The pull over", "5.02"));
		sl.add(new Data("Spread the words", "2.16"));
		sl.add(new Data("Where's the party", "6.43"));

		sList = new ArrayList<Data>(sl);
		sList.addAll(sl);
		sList.addAll(sl);
		sList.addAll(sl);
		sList.addAll(sl);
		sList.addAll(sl);
	}

	/**
	 * The Class SongAdapter is the adapter class for Song ListView. The current
	 * implementation simply shows dummy contents and you can customize this
	 * class to display actual contents as per your need.
	 */
	private class SongAdapter extends BaseAdapter
	{

		/* (non-Javadoc)
		 * @see android.widget.Adapter#getCount()
		 */
		@Override
		public int getCount()
		{
			return sList.size();
		}

		/* (non-Javadoc)
		 * @see android.widget.Adapter#getItem(int)
		 */
		@Override
		public Data getItem(int position)
		{
			return sList.get(position);
		}

		/* (non-Javadoc)
		 * @see android.widget.Adapter#getItemId(int)
		 */
		@Override
		public long getItemId(int position)
		{
			return position;
		}

		/* (non-Javadoc)
		 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			if (convertView == null)
				convertView = getLayoutInflater(null).inflate(
						R.layout.profile_item, null);

			Data d = getItem(position);
			TextView lbl = (TextView) convertView.findViewById(R.id.lbl1);
			lbl.setText(position + 1 + ". " + d.getTitle1());

			lbl = (TextView) convertView.findViewById(R.id.lbl2);
			lbl.setText(d.getTitle2());
			return convertView;
		}

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
