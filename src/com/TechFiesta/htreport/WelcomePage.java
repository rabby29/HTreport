package com.TechFiesta.htreport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WelcomePage extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_page);
		
		Button createGroup=(Button) findViewById(R.id.creat_group_btn);
		
		createGroup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(WelcomePage.this,CreateGroupActivity.class);
				startActivity(intent);
			}
		});
		
		Button joinGroup=(Button) findViewById(R.id.join_agroup_btn);
		joinGroup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(WelcomePage.this, JoinGroupActivity.class);
				startActivity(intent);
				
			}
		});
		
		Button demoGroup = (Button)findViewById(R.id.demoapp_btn);
		
		demoGroup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(WelcomePage.this, MainActivity.class);
				startActivity(intent);
				
			}
		});
	}

}
