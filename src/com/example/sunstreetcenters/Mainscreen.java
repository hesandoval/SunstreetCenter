package com.example.sunstreetcenters;


import com.example.sunstreetcenters.Mainscreen;
import com.example.sunstreetcenters.R;
import com.example.sunstreetcenters.SunsetWebsite;

import android.net.Uri;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ActionBar.OnNavigationListener;
import android.app.AlertDialog.Builder;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class Mainscreen extends Activity {


	//Test commit to check network path


	//URLS to parse
	static private final String FACEBOOK_URL = "https://www.facebook.com/SunStreetCenters";
	static private final String TWITTER_URL  = "https://twitter.com/SunStreetTweet";
	static private final String INSTAGRAM_URL = "http://instagram.com/instasteps";
	
	static private final String CHOOSER_TEXT = "Open link with.."; //IMPLICIT BOX TEXT
	
	String number;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainscreen);
		
		
				Button website = (Button) findViewById(R.id.urlButton);
				
				//Drug Buttons
				Button prescriptionButton = (Button) findViewById(R.id.prescriptionMedicineButon);
				Button cigaretteButton = (Button) findViewById(R.id.cigaretteButton);
				Button marijuanaButton = (Button) findViewById(R.id.marijuanaButton);
				Button alcoholButton = (Button) findViewById(R.id.alcoholButton);
				
				//Buttons for other features
				Button parentsInformation = (Button) findViewById(R.id.infoForParentsButton);
				//Button News = (Button) findViewById(R.id.topNewsButton);
				//Button otherDrugs = (Button) findViewById(R.id.additionalDrugsButton);
				//Button mythFacts = (Button) findViewById(R.id.mythsAndFactsButton);
				Button ExtraFeatures = (Button) findViewById(R.id.extraInformationButton);

				prescriptionButton.setOnClickListener(new OnClickListener() {

					//Call prescriptionActivity when pressed.
					@Override
					public void onClick(View v) {
						
						prescriptionActivity();
					
					}
				});
				
				cigaretteButton.setOnClickListener(new OnClickListener(){
					
					//Call prescriptionActivity when pressed.
					
					public void onClick(View v){
						
						cigarettesActivity();
					}
				});
				
				website.setOnClickListener(new OnClickListener(){
					
					//Call website implicit activity when pressed.
					
					public void onClick(View v){
						createWebsiteLink();
					}
				});
				
				marijuanaButton.setOnClickListener(new OnClickListener(){
					
					//call prescriptionActivity button when pressed
					
					public void onClick(View v){
						marijuanaActivity();
					}
				});
				
				alcoholButton.setOnClickListener(new OnClickListener(){
					
					//call prescriptionActivity button when pressed
					
					public void onClick(View v){
						alcoholActivity();
					}
				});
				
				
				
				parentsInformation.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						startParentsInformation();

					}
				});
				
				ExtraFeatures.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						startExtraFeatures();
					}
				});
				

	}

	@Override

	public void onBackPressed() {
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.mainscreen, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {	
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	    
	    case R.id.salinasAdmin:
	    	
	    	number = "8317535135";
	    	callAlertDialog(number);
	    	return true;

	    case R.id.salinasResidential:
	    	
	    	number = "8317535145";
	    	callAlertDialog(number);
	    	return true;
	    
	    case R.id.salinasCounseling:
	    	
	    	number = "8317536001";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.salinasPrevention:
	    	
	    	number = "8317535150";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.seasidePrevention:
	    	
	    	number = "8318996577";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.soledadPrevention:
	    	
	    	number = "8313850100";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.marinaPueblo:
	    	
	    	number = "8315829461";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.salinasDUI:
	    	
	    	number = "8317535140";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.seasideDUI:
	    	
	    	number = "8313939316";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.soledadDUI:
	    	
	    	number = "8313850187";
	    	callAlertDialog(number);
	    	return true;
	    	
	    case R.id.action_mail:
	    	Intent intent = new Intent(
	    		    Intent.ACTION_SENDTO,
	    		    Uri.parse("mailto:info@sunstreet.org")
	    		);
	    		startActivity(intent);
	    	return true;
	    	
	    case R.id.facebook:
	    	try {
	    	    Intent intentFacebook = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/286851634055"));
	    	    startActivity(intentFacebook);
	    	    return true;
	    	} catch(Exception e) {
	    	    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/SunStreetCenters")));
	    	    return true;
	    	}
		    
	    case R.id.twitter:
		    Intent intentTwitter = null;
		    try {
		        // get the Twitter app if possible
		        this.getPackageManager().getPackageInfo("com.twitter.android", 0);
		        intentTwitter = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=1648349780"));
		        intentTwitter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    } catch (Exception e) {
		        // no Twitter app, revert to browser
		        intentTwitter = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/SunStreetTweet"));
		        
		    }
		    this.startActivity(intentTwitter);
		    return true;
		    
	    case R.id.instagram:
	    	Uri uri = Uri.parse("http://instagram.com/_u/instasteps");
	        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

	        likeIng.setPackage("com.instagram.android");

	        try {
	            startActivity(likeIng);
	            return true;
	        } catch (ActivityNotFoundException e) {
	            startActivity(new Intent(Intent.ACTION_VIEW,
	                    Uri.parse("http://instagram.com/instasteps")));
	            return true;
	        }
	    case R.id.youtube:
	    	Intent intentYoutube=null;     
	    	try {
	    	        intentYoutube =new Intent(Intent.ACTION_VIEW);
	    	        intentYoutube.setPackage("com.google.android.youtube");
	    	        intentYoutube.setData(Uri.parse("http://www.youtube.com/user/SunStreetCentersORG/videos"));
	    	        startActivity(intentYoutube);
	    	        return true;
	    	    } catch (ActivityNotFoundException e) {
	    	        intentYoutube = new Intent(Intent.ACTION_VIEW);
	    	        intentYoutube.setData(Uri.parse("http://www.youtube.com/user/SunStreetCentersORG/videos"));
	    	        startActivity(intentYoutube);
	    	        return true;
	    	    }
	    	
	    	
	    case R.id.action_info:
	    	Intent location = new Intent(Mainscreen.this, Locations.class);
			startActivity(location);
	    	return true;
	    
	       
        default:
            return super.onOptionsItemSelected(item);
	    }
	    
	   
	}
	
	private void callAlertDialog(final String x)
	{
		AlertDialog.Builder builder = new Builder(Mainscreen.this);
		builder.setMessage("Are you sure you want to launch your phone app?");
		builder.setTitle("Confirmation:");


		builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});	

		builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				Intent intent = new Intent(Intent.ACTION_DIAL);
		    	intent.setData(Uri.parse("tel:"+ x));
		    	startActivity(intent); 
			}
		});	
		

		builder.create().show();
	}

	
	private void createWebsiteLink()
	{
		//creates instance of website class
		SunsetWebsite websiteLink = new SunsetWebsite();
		startActivity(websiteLink.linkToSite());
	}
	
	private void prescriptionActivity()
	{

		Intent prescription = new Intent(Mainscreen.this, Prescriptiondrugs_brochures.class);
		
		startActivity(prescription);
		
	}
	
	private void cigarettesActivity()
	{

		Intent cigarette = new Intent(Mainscreen.this, Cigarettes_brochure.class);
		
		startActivity(cigarette);
		
	}
	
	private void marijuanaActivity()
	{

		Intent marijuana = new Intent(Mainscreen.this, Marijuana_brochure.class);
		
		startActivity(marijuana);
		
	}
	
	private void alcoholActivity()
	{

		Intent alcohol = new Intent(Mainscreen.this, Alcohol_brochure.class);
		
		startActivity(alcohol);
		
	}
	
	private void contactActivity() {
		Intent contactIn = new Intent(Mainscreen.this,ContactInfo.class);
		startActivity(contactIn);
		// finish();
	}
	
	private void startExtraFeatures() {
		Intent features = new Intent(Mainscreen.this,ExtraFeatures.class);
		startActivity(features);
	}
	
	private void startParentsInformation() {
		Intent parents = new Intent(Mainscreen.this,ParentsActivity.class);
		startActivity(parents);
	}
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	

}
