package com.example.sunstreetcenters;


import com.example.sunstreetcenters.Mainscreen;
import com.example.sunstreetcenters.R;
import com.example.sunstreetcenters.SunsetWebsite;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Mainscreen extends Activity {


	//Test commit to check network path


	//URLS to parse
	static private final String FACEBOOK_URL = "https://www.facebook.com/SunStreetCenters";
	static private final String TWITTER_URL  = "https://twitter.com/SunStreetTweet";
	static private final String INSTAGRAM_URL = "http://instagram.com/instasteps";
	
	static private final String CHOOSER_TEXT = "Open link with.."; //IMPLICIT BOX TEXT
	
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
				Button ExtraFeatures = (Button) findViewById(R.id.extraInformationButton);
				Button puzzleGame = (Button) findViewById(R.id.gameButton);
				//Button News = (Button) findViewById(R.id.topNewsButton);
				//Button otherDrugs = (Button) findViewById(R.id.additionalDrugsButton);
				//Button mythFacts = (Button) findViewById(R.id.mythsAndFactsButton);
				

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
				
				ExtraFeatures.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						startExtraFeatures();
					}
				});
				
				parentsInformation.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						startParentsInformation();

					}
				});
				
				puzzleGame.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startPuzzleGame();
						
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
	    case R.id.action_settings:
	    	return true;
	    case R.id.action_group:
	    	return true;
	    case R.id.action_mail:
	    	Intent intent = new Intent(
	    		    Intent.ACTION_SENDTO,
	    		    Uri.parse("mailto:info@sunstreet.org")
	    		);
	    		startActivity(intent);
	    	return true;
	       
        default:
            return super.onOptionsItemSelected(item);
	    }
	}
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.mainscreen, menu);
//		return true;
//	}
	
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
	
	private void startPuzzleGame(){
		Intent game = new Intent(Mainscreen.this,PictureTakerActivity.class);
		startActivity(game);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	private void facebookPage()
	{
		Uri fBPage = Uri.parse(FACEBOOK_URL);
		Intent visitFacebook = new Intent(Intent.ACTION_VIEW, fBPage);
		
		Intent chooserFB = Intent.createChooser(visitFacebook, CHOOSER_TEXT);
		startActivity(chooserFB);
	}
	
	private void twitterPage()
	{
		Uri tweetPage = Uri.parse(TWITTER_URL);
		Intent visitTwitter = new Intent(Intent.ACTION_VIEW, tweetPage);
		
		Intent chooseTweet = Intent.createChooser(visitTwitter, CHOOSER_TEXT);
		startActivity(chooseTweet);
	}
	
	private void instagramPage()
	{
		Uri instaPage = Uri.parse(INSTAGRAM_URL);
		Intent visitInsta = new Intent(Intent.ACTION_VIEW, instaPage);
		
		Intent chooseInsta = Intent.createChooser(visitInsta, CHOOSER_TEXT);
		startActivity(chooseInsta);
	}

}
