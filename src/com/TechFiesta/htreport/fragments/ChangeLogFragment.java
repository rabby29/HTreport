package com.TechFiesta.htreport.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.TechFiesta.htreport.R;

public class ChangeLogFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.changeslog, container, false);
		ListView listview = (ListView) rootView
				.findViewById(R.id.changes_log_listview);

		
		// Create ArrayAdapter using the planet list.
		ListAdapter listAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_multiple_choice,
				R.array.donate_listdata);

		// Add more planets. If you passed a String[] instead of a List<String>
		// into the ArrayAdapter constructor, you must not add more items.
		// Otherwise an exception will occur.
		
		// Set the ArrayAdapter as the ListView's adapter.
		listview.setAdapter(listAdapter);
		return rootView;
	}

}
