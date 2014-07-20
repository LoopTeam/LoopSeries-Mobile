package com.bandmate.ui;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bandmate.R;
import com.bandmate.custom.CustomFragment;
import com.bandmate.model.Data;

/**
 * The Class Updates is the Fragment class that is launched when the user clicks
 * on Artist Updates option in Left navigation drawer and it simply shows a
 * dummy list of Artist's updates. You can customize this to display actual
 * contents.
 */
public class Updates extends CustomFragment
{

	/** The content list. */
	private ArrayList<Data> uList;

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.updates, null);
		setHasOptionsMenu(true);

		setUpdatesList(v);
		return v;
	}

	/**
	 * Setup the list view for displaying the Artist's updates.
	 * 
	 * @param v
	 *            the root view
	 */
	private void setUpdatesList(View v)
	{
		loadDummyUpdates();

		ListView list = (ListView) v.findViewById(R.id.list);
		list.setAdapter(new UpdatesAdapter());
	}

	/**
	 * Load a dummy list of updates from various sources like Blogs, Twitter,
	 * Instagram etc. You need to write your own logic to load actual list of
	 * updates.
	 */
	private void loadDummyUpdates()
	{
		ArrayList<Data> sl = new ArrayList<Data>();
		sl.add(new Data(
				"@ItsJay",
				"Sometime you will never know the true value of"
						+ " a small movement until it becomes a memory. Stay tuned with me.",
				"just now", R.drawable.ic_tw));
		sl.add(new Data("Instagram", "Jaye posted a photo on Instagram",
				"5 minutes ago", R.drawable.ic_instagram));
		sl.add(new Data(
				"Upcoming show",
				"Jay has an upcoming show at"
						+ " City center on 7th march at 20:00 PM. Entry is free for all fans.",
				"9 minutes ago", R.drawable.ic_tv));
		sl.add(new Data(
				"Upcoming show",
				"Jay has an upcoming show at"
						+ " WestZee center on 10th march at 20:00 PM. Entry is free for all fans.",
				"45 minutes ago", R.drawable.ic_tv));
		sl.add(new Data("Blog update", "Jay updated his blog called Childhood",
				"19 hours ago", R.drawable.ic_cal));

		uList = new ArrayList<Data>(sl);
		uList.addAll(sl);
		uList.addAll(sl);
		uList.addAll(sl);
		uList.addAll(sl);
		uList.addAll(sl);
	}

	/**
	 * The Class UpdatesAdapter is the adapter class for updates ListView. The current
	 * implementation simply shows dummy contents and you can customize this
	 * class to display actual contents as per your need.
	 */
	private class UpdatesAdapter extends BaseAdapter
	{

		/* (non-Javadoc)
		 * @see android.widget.Adapter#getCount()
		 */
		@Override
		public int getCount()
		{
			return uList.size();
		}

		/* (non-Javadoc)
		 * @see android.widget.Adapter#getItem(int)
		 */
		@Override
		public Data getItem(int position)
		{
			return uList.get(position);
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
						R.layout.update_item, null);

			Data d = getItem(position);
			TextView lbl = (TextView) convertView.findViewById(R.id.lbl1);
			lbl.setText(d.getTitle1());

			lbl = (TextView) convertView.findViewById(R.id.lbl2);
			lbl.setText(d.getDesc());

			lbl = (TextView) convertView.findViewById(R.id.lbl3);
			lbl.setText(d.getTitle2());

			ImageView img = (ImageView) convertView.findViewById(R.id.img);
			img.setImageResource(d.getImage1());
			if (d.getImage1() == R.drawable.ic_tw)
				convertView.findViewById(R.id.vTw).setVisibility(View.VISIBLE);
			else
				convertView.findViewById(R.id.vTw).setVisibility(View.GONE);

			return convertView;
		}

	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateOptionsMenu(android.view.Menu, android.view.MenuInflater)
	 */
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		inflater.inflate(R.menu.refresh, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}
}
