package com.TechFiesta.htreport.helper;

import com.TechFiesta.htreport.R;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.content.Context;

public class StickyAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private String[] countries;
    private LayoutInflater inflater;

    public StickyAdapter(Context context) {
        inflater = LayoutInflater.from(context);
       
        countries = context.getResources().getStringArray(R.array.drawableArray);
        Log.d("gfgg", ""+countries[0]);
    }

    @Override
    public int getCount() {
    	Log.d(""," length"+countries.length);
        return countries.length;
    }

    @Override
    public Object getItem(int position) {
    	Log.d("", "get item");
        return countries[position];
    }

    @Override
    public long getItemId(int position) {
    	Log.d("", "get itemid");
        return position;
    }

    @Override 
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        Log.d("be", "crash?");
        if (convertView == null) {
            holder = new ViewHolder();
            Log.d("", "crash?");
            convertView = inflater.inflate(R.layout.drawerlayout, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.drawerrow1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText(countries[position]);

        return convertView;
    }

    @Override 
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        Log.d("akdhak", "ada");
        if (convertView == null) {
            holder = new HeaderViewHolder();
           
            convertView = inflater.inflate(R.layout.drawerlayout, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.drawerrow1);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }
        //set header text as first char in name
        String headerText = "" + countries[position].subSequence(0, 1).charAt(0);
        holder.text.setText(headerText);
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        //return the first character of the country as ID because this is what headers are based upon
    	Log.d("da", "adad");
        return countries[position].subSequence(0, 1).charAt(0);
    }

    class HeaderViewHolder {
        TextView text;
    }

    class ViewHolder {
        TextView text;
    }

}