package com.TechFiesta.htreport.fragments;

import com.TechFiesta.htreport.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyReportingFragment extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.my_reporting, container, false);
         
        return rootView;
    }
}
