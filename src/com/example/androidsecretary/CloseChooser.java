package com.example.androidsecretary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CloseChooser extends Activity  {
	
	Button keepHelpingMe;
	Button takeRest;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.close_chooser_page_design);
        keepHelpingMe=(Button)findViewById(R.id.chooserPageAddPresMed);
        keepHelpingMe.setOnClickListener(new OnClickListener(){
      	  public void onClick(View v){
      	    //place code to execute here
      		  onBackPressed();

      	  }
      	});
        takeRest=(Button)findViewById(R.id.chooserPageAddDailyActs);
        takeRest.setOnClickListener(new OnClickListener(){
      	  public void onClick(View v){
      	    //place code to execute here
      		android.os.Process.killProcess(android.os.Process.myPid());
      	  }
      	});
        
        
    }





@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main_page, menu);
    return true;
}


}
