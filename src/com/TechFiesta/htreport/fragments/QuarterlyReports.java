package com.TechFiesta.htreport.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.TechFiesta.htreport.R;

public class QuarterlyReports extends Fragment{
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.quaterly_report, container, false);
         
        return rootView;
    }

}
