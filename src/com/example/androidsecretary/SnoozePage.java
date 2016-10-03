package com.example.androidsecretary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SnoozePage extends Activity   {

	Button b5,b10,b15,b20,later;

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snooze_chooser);
        b5=(Button)findViewById(R.id.snoozeChooserPage05);
        b5.setOnClickListener(new OnClickListener(){
      	  public void onClick(View v){
      	    //place code to execute here
      		  Intent intent = new Intent(getBaseContext(), Chooser.class);
 		       // put if required
      		  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      		  getBaseContext().startActivity(intent);
 			  
      	  }
      	});
        b10=(Button)findViewById(R.id.snoozeChooserPage10);
        b10.setOnClickListener(new OnClickListener(){
      	  public void onClick(View v){
      	    //place code to execute here
      		  Intent intent = new Intent(getBaseContext(), Chooser.class);
 		       // put if required
      		  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      		  getBaseContext().startActivity(intent);
 			  
      	  }
      	});
        b15=(Button)findViewById(R.id.snoozeChooserPage15);
        b15.setOnClickListener(new OnClickListener(){
      	  public void onClick(View v){
      	    //place code to execute here
      		  Intent intent = new Intent(getBaseContext(), Chooser.class);
 		       // put if required
      		  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      		  getBaseContext().startActivity(intent);
 			  
      	  }
      	});
        b20=(Button)findViewById(R.id.snoozeChooserPage20);
        b20.setOnClickListener(new OnClickListener(){
      	  public void onClick(View v){
      	    //place code to execute here
      		  Intent intent = new Intent(getBaseContext(), Chooser.class);
 		       // put if required
      		  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      		  getBaseContext().startActivity(intent);
 			  
      	  }
      	});
        later=(Button)findViewById(R.id.snoozeChooserPageDoLater);
        later.setOnClickListener(new OnClickListener(){
      	  public void onClick(View v){
      	    //place code to execute here
      		  Intent intent = new Intent(getBaseContext(), Chooser.class);
 		       // put if required
      		  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      		  getBaseContext().startActivity(intent);
 			  
      	  }
      	});
    }
	
		
}
