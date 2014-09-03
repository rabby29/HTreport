package com.TechFiesta.htreport.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.TechFiesta.htreport.R;

public class DonateFragment extends Fragment implements OnItemSelectedListener {
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)  {
 
        View rootView = inflater.inflate(R.layout.donate, container, false);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.donate_spinner);
      
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.donate_listdata,R.layout.donet_spiner_item);  
        
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

       
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        return rootView;
    }

	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
		
		Log.d("donate", " "+pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
 
}
