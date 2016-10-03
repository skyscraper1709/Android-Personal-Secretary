package com.example.androidsecretary;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainPage extends Activity  {

    
	
    	Button mainPageAddButton;
    	Button  mainPageViewButton;
    	Button  mainPageAboutButton;
    	Button mainPageExitButton;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main_page_design);
	        mainPageAddButton=(Button)findViewById(R.id.mainAddButton);
	        mainPageAddButton.setOnClickListener(new OnClickListener(){
	        	  public void onClick(View v){
	        	    //place code to execute here
	        		  Intent intent = new Intent(getBaseContext(), Chooser.class);
	   		       // put if required
	        		  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        		  getBaseContext().startActivity(intent);
	   			  
	        	  }
	        	});
	        mainPageViewButton=(Button)findViewById(R.id.mainViewButton);
	        mainPageViewButton.setOnClickListener(new OnClickListener(){
	        	  public void onClick(View v){
	        	    //place code to execute here
	        		  
	        	  }
	        	});
	        mainPageExitButton=(Button)findViewById(R.id.mainExitButton);
	        mainPageExitButton.setOnClickListener(new OnClickListener(){
	        	  public void onClick(View v){
	        	    //place code to execute here
	        		  Intent intent2 = new Intent(getBaseContext(), CloseChooser.class);
	   		       // put if required
	        		  intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        		  getBaseContext().startActivity(intent2);
	        	  }
	        	});
	        mainPageAboutButton=(Button)findViewById(R.id.mainAboutButton);
	        mainPageAboutButton.setOnClickListener(new OnClickListener(){
	        	  public void onClick(View v){
	        	    //place code to execute here
	        		  AlertDialog.Builder adb =new AlertDialog.Builder(MainPage.this);
	  			    adb.setTitle("About: ");
	  			    adb.setCancelable(false); //cannot understand which to use?
	  			    adb.setMessage("A personal Secretary Designed for Android Users." +
	  			    		" Let us know about your comments @skyscraper1709@gmail.com\n" +
	  			    		"Thank You for Using my App.");
	  			    adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	  			        public void onClick(DialogInterface dialog, int which) { 
	  			            // my; close the Dialog; How??
	  			        	
	  			        }
	  			     });
//	  			    adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
//	  			        public void onClick(DialogInterface dialog, int which) { 
//	  			            // do nothing
//	  			        }
//	  			     });
	  			    AlertDialog alert11 = adb.create();
	  	            alert11.show();
	        	  }
	        	});
	    }
	
	



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_page, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
       
        case R.id.action_settings:
            // Settings option clicked. 
        	
        	// nod17 see tictactoe to implement the settings.
        	
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    

		}
