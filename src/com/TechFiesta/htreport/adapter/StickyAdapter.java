package com.TechFiesta.htreport.adapter;

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

    private String[] listData;
    private String [] headerList;
    private LayoutInflater inflater;

    public StickyAdapter(Context context) {
        inflater = LayoutInflater.from(context);
       
        listData = context.getResources().getStringArray(R.array.list_data);
        headerList=context.getResources().getStringArray(R.array.header_list);
       Log.d("length", " "+listData.length+" "+headerList.length );
    }

    @Override
    public int getCount() {
        return listData.length;
    }

    @Override
    public Object getItem(int position) {
        return listData[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override 
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
          
            convertView = inflater.inflate(R.layout.drawerlayout, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.drawerrow1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText(listData[position]);

        return convertView;
    }

    @Override 
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        
        int headerindex=0;
        if(position==0||position==1){
        	headerindex= 0;
    	}else if(position>=2 && position<=6){
    		headerindex= 1;
    	}else if(position>=7 && position<=10){
    		headerindex= 2;
    	}else if(position>=11 && position<=15){
    		headerindex= 3;
    	}
        
        if (convertView == null) {
            holder = new HeaderViewHolder();
           
            convertView = inflater.inflate(R.layout.nav_menu_header, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.header_text);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }
        //set header text as first char in name
        String headerText =  headerList[headerindex];
        holder.text.setText(headerText);
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        //return the first character of the country as ID because this is what headers are based upon
    	//Log.d("index ", ""+position);
    	if(position==0||position==1){
    		return 0;
    	}else if(position>=2 && position<=6){
    		return 1;
    	}else if(position>=7 && position<=10){
    		return 2;
    	}else if(position>=11 && position<=15){
    		return 3;
    	}
    	
    	
        return 0;
    }

    class HeaderViewHolder {
        TextView text;
    }

    class ViewHolder {
        TextView text;
    }

}