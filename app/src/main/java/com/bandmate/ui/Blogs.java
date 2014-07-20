package com.bandmate.ui;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bandmate.BlogDetail;
import com.bandmate.R;
import com.bandmate.custom.CustomFragment;
import com.bandmate.model.Data;

/**
 * The Class Blogs is the Fragment class that is launched when the user clicks
 * on Blogs option in Left navigation drawer and it simply shows a dummy list of
 * Blogs. You can customize this to display actual Blog listing.
 */
public class Blogs extends CustomFragment
{

	/** The blog list. */
	private ArrayList<Data> uList;

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.blogs, null);
		setHasOptionsMenu(true);

		setBlogList(v);
		return v;
	}

	/**
	 * Setup and initialize the blog list view.
	 * 
	 * @param v
	 *            the new blog list
	 */
	private void setBlogList(View v)
	{
		loadDummyBlogs();

		ListView list = (ListView) v.findViewById(R.id.list);
		list.setAdapter(new BlogAdapter());
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3)
			{
				startActivity(new Intent(getActivity(), BlogDetail.class));
			}
		});
	}

	/**
	 * Load a dummy list of blogs. You need to write your own logic to load
	 * actual list of Blogs.
	 */
	private void loadDummyBlogs()
	{
		ArrayList<Data> sl = new ArrayList<Data>();
		sl.add(new Data("Latest music show",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit"
						+ ",  sed ", "just now", R.drawable.img1));
		sl.add(new Data("Thoughts on I'm so faded",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit"
						+ ",  sed ", "just now", R.drawable.img2));
		sl.add(new Data("Beuty on sky",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit"
						+ ",  sed ", "just now", R.drawable.img3));
		sl.add(new Data("Top hits 2014",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit"
						+ ",  sed ", "just now", R.drawable.img4));
		sl.add(new Data("Spread my wings",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit"
						+ ",  sed ", "just now", R.drawable.img5));
		sl.add(new Data("new upcoming show",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit"
						+ ",  sed ", "just now", R.drawable.img6));
		sl.add(new Data("MTV awards",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit"
						+ ",  sed ", "just now", R.drawable.img7));
		sl.add(new Data("Salena Gomez",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit"
						+ ",  sed ", "just now", R.drawable.img8));

		uList = new ArrayList<Data>(sl);
		uList.addAll(sl);
		uList.addAll(sl);
		uList.addAll(sl);
		uList.addAll(sl);
		uList.addAll(sl);
	}

	/**
	 * The Class BlogAdapter is the adapter class for Blog ListView. The current
	 * implementation simply shows dummy contents and you can customize this
	 * class to display actual contents as per your need.
	 */
	private class BlogAdapter extends BaseAdapter
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
						R.layout.blog_item, null);

			Data d = getItem(position);
			TextView lbl = (TextView) convertView.findViewById(R.id.lbl1);
			lbl.setText(d.getTitle1());

			lbl = (TextView) convertView.findViewById(R.id.lbl2);
			lbl.setText(d.getDesc());

			lbl = (TextView) convertView.findViewById(R.id.lbl3);
			lbl.setText(d.getTitle2());

			ImageView img = (ImageView) convertView.findViewById(R.id.img);
			img.setImageResource(d.getImage1());

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
