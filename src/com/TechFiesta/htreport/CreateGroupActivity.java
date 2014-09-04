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
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class CreateGroupActivity extends ActionBarActivity {
	
	private ProgressDialog pDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_group);
		pDialog = new ProgressDialog(CreateGroupActivity.this);
		
		final EditText grpNameField=(EditText) findViewById(R.id.groupe_name_edittext);
		final EditText firstNameField =(EditText)findViewById(R.id.first_name_edittext);
		final EditText lastNameField =(EditText)findViewById(R.id.last_name_edit_text);
		
		Button createBtn=(Button) findViewById(R.id.grp_page_create_btn);
		
		createBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String grpName=grpNameField.getText().toString().trim();
				String firstName=firstNameField.getText().toString().trim();
				String lastName = lastNameField.getText().toString().trim();
				
				if(grpName.isEmpty()){
					alert("Enter Group Name",false);
					return;
				}
				if(firstName.isEmpty()){
					alert("Enter First Name", false);
					return;
				}
				if(lastName.isEmpty()){
					alert("Enter Last Name",false);
					return;
				}
				
				createGroup(grpName, firstName, lastName);
			}
		});
	}
	
	void createGroup(String groupName,String firstName,String lastName){
		
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
		AlertDialog.Builder bld = new AlertDialog.Builder(CreateGroupActivity.this);
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
