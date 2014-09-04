package com.TechFiesta.htreport;



import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.TechFiesta.htreport.helper.Constants;
import com.TechFiesta.htreport.helper.JsonParser;
import com.TechFiesta.htreport.helper.ServerResponse;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class JoinGroupActivity extends ActionBarActivity {
	
	private ProgressDialog pDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.join_group);
		Button join=(Button) findViewById(R.id.join_btn);
		pDialog=new ProgressDialog(JoinGroupActivity.this);
		
		final EditText userIDet=(EditText)findViewById(R.id.userID_edittext);
		final EditText pinEt =(EditText)findViewById(R.id.user_pic_code_edittext);
		
		
		
		join.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String userId=userIDet.getText().toString().trim();
				String pin=pinEt.getText().toString().trim();
				if(userId.isEmpty()){
					alert("Enter userid",false);
					return;
				}
				if(pin.isEmpty()){
					alert("Enter Authorization Code", false);
					return;
				}
				
				authenticat(userId,pin);
				
			}

			
		});
		
		
		
		
	}
	
	private void authenticat(String userid,String pin) {
		// TODO Auto-generated method stub
		new JoinGroupRequest().execute(userid,pin);
	}
	
	
	
	
	
	public class JoinGroupRequest extends AsyncTask<String, Void, String> {

	

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog.setMessage("Loading...");
			pDialog.setIndeterminate(true);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... arg) {
		
			Log.e("aea",""+ arg[0]+" "+arg[1]);
			List<NameValuePair> params=new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("command","userInfo"));
			params.add(new BasicNameValuePair("uid","1094"));
			
			
				ServerResponse response = JsonParser.retrieveServerData(Constants.REQUEST_TYPE_POST, Constants.URLRoot, params, null, null);

				if (response.getStatus() == 200) {
					Log.d(">>>><<<<", "success in retrieving user info");
					 response.getjObj();
					return response.getjObj();
				} else
					return null;
		}

		@Override
		protected void onPostExecute(String str) {
			if (pDialog.isShowing())
				pDialog.dismiss();
			JSONArray jarray = null;
			try {
				jarray = new JSONArray(str);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (jarray != null) {
				try {
					JSONObject job=jarray.getJSONObject(0);
					Log.d("Success", job.getString("FirstName"));
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					alert("Connection error, please try again.",false);
					e.printStackTrace();
				}
			} else {
				alert("Connection error, please try again.",false);
			}
		}
	}


	void alert(String message, final Boolean success) {
		AlertDialog.Builder bld = new AlertDialog.Builder(JoinGroupActivity.this);
		bld.setMessage(message);
		bld.setNeutralButton("OK", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (success)
					finish();

			}
		});
		bld.create().show();
	}
	
}
