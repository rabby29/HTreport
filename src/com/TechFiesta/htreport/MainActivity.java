package com.TechFiesta.htreport;




import com.TechFiesta.htreport.adapter.StickyAdapter;
import com.TechFiesta.htreport.fragments.ChangeLogFragment;
import com.TechFiesta.htreport.fragments.DistrictSetupFragment;
import com.TechFiesta.htreport.fragments.DonateFragment;
import com.TechFiesta.htreport.fragments.FAQFragment;
import com.TechFiesta.htreport.fragments.FamiliesFragment;
import com.TechFiesta.htreport.fragments.MLSImportFragment;
import com.TechFiesta.htreport.fragments.MyAccountFragment;
import com.TechFiesta.htreport.fragments.MyReportingFragment;
import com.TechFiesta.htreport.fragments.QuarterlyReports;
import com.TechFiesta.htreport.fragments.TeachersFragment;
import com.TechFiesta.htreport.fragments.TutorialFragment;
import com.TechFiesta.htreport.fragments.UnvisitedFamiliesFragment;

import android.support.v4.app.ActionBarDrawerToggle;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;
import android.widget.ListView;

@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity {

	private DrawerLayout mDrawerLayout;
	private StickyListHeadersListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nav_drawerl);
 
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_nav);
		mDrawerList = (StickyListHeadersListView) findViewById(R.id.drawer_list);

		StickyAdapter adapter = new StickyAdapter(this);

		      
		mDrawerList.setAdapter(adapter);
		// Set the adapter for the list view

		Log.d("tat", "to");

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, // nav menu toggle icon
				R.string.app_name, // nav drawer open - description for
									// accessibility
				R.string.app_name // nav drawer close - description for
									// accessibility
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle("title");
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle("title");
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			

		}

	}

	private class DrawerItemClickListener implements ListView.OnItemClickListener {
	    @Override
	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	       displayView(position);
	    	
	    	Log.d("clicked position", "message: "+position);
	    }
	}
	
	private void displayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new MyReportingFragment();
			break;
		case 1:
			fragment=new MyAccountFragment();
			break;
		case 2:
			break;
		case 3:
			fragment=new DistrictSetupFragment();
			break;
		case 4:
			fragment=new FamiliesFragment();
			break;
		case 5:
			fragment=new TeachersFragment();
			break;
		case 6:
			fragment=new MLSImportFragment();
			break;
		case 7:
		case 8:
			fragment =new UnvisitedFamiliesFragment();
			break;
		case 9:
			fragment =new QuarterlyReports();
			break;
		case 10:
			fragment =new ChangeLogFragment();
			break;
		case 11:
			fragment =new FAQFragment();
			break;
		case 12:
			fragment =new TutorialFragment();
			break;
		case 13:
			launchMarket();
			break;
		case 14:
		case 15:
			fragment=new DonateFragment();
			break;
		case 16:
			

		default:
			break;
		}

		Log.d("index", " "+position);
		if (fragment != null) {
			FragmentManager fragmentManager =getFragmentManager();
			fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			//setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}

	private void launchMarket() {
	    Uri uri = Uri.parse("market://details?id=" + getPackageName());
	    Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
	    try {
	        startActivity(myAppLinkToMarket);
	    } catch (ActivityNotFoundException e) {
	        Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show();
	    }
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		 if (mDrawerToggle.onOptionsItemSelected(item)) {
	          return true;
	        }
	        // Handle your other action bar items...

	        return super.onOptionsItemSelected(item);
	}
}
