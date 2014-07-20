package com.bandmate.ui;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bandmate.R;
import com.bandmate.model.Data;

/**
 * The Adapter class for the ListView displayed in the left navigation drawer.
 */
public class LeftNavAdapter extends BaseAdapter
{

	/** The items. */
	private ArrayList<Data> items;

	/** The context. */
	private Context context;

	/** The selected. */
	private int selected;

	/**
	 * Sets the selection.
	 *
	 * @param position the new selection
	 */
	public void setSelection(int position)
	{
		selected = position;
		notifyDataSetChanged();
	}

	/**
	 * Instantiates a new left navigation adapter.
	 * 
	 * @param context
	 *            the context of activity
	 * @param items
	 *            the array of items to be displayed on ListView
	 */
	public LeftNavAdapter(Context context, ArrayList<Data> items)
	{
		this.context = context;
		this.items = items;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount()
	{
		return items.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Data getItem(int arg0)
	{
		return items.get(arg0);
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
			convertView = LayoutInflater.from(context).inflate(
					R.layout.left_nav_item, null);
		TextView lbl = (TextView) convertView;
		lbl.setText(getItem(position).getTitle1());

		if (position == selected)
		{
			lbl.setCompoundDrawablesWithIntrinsicBounds(getItem(position)
					.getImage2(), 0, 0, 0);
			lbl.setBackgroundColor(context.getResources().getColor(
					R.color.blue_dk));
			lbl.setTextColor(Color.WHITE);
		}
		else
		{
			lbl.setCompoundDrawablesWithIntrinsicBounds(getItem(position)
					.getImage1(), 0, 0, 0);
			lbl.setBackgroundResource(0);
			lbl.setTextColor(context.getResources().getColor(R.color.nav_color));
		}
		return convertView;
	}

}
