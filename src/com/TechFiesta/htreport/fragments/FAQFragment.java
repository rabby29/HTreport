package com.TechFiesta.htreport.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.TechFiesta.htreport.R;


public class FAQFragment extends Fragment{
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.tutorial_mls_webview, container, false);
        WebView webview=(WebView)  rootView.findViewById(R.id.mlsimport_webview);
        WebSettings settings=webview.getSettings();

        settings.setJavaScriptEnabled(true);
       
        webview.loadUrl("http://hometeachingreporter.com/faq.php");
         
        return rootView;
    }
}
