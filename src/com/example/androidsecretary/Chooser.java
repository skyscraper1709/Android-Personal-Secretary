package com.example.androidsecretary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Chooser extends Activity {
	
	Button medicineButton;
	Button nonMedicineButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooser_design);
        medicineButton=(Button)findViewById(R.id.chooserPageAddPresMed);
        medicineButton.setOnClickListener(new OnClickListener(){
      	  public void onClick(View v){
      	    //place code to execute here
      		  
      		 Intent intent = new Intent(getBaseContext(), AddMedicine.class); //todesign addmed
  	       // put if required
      		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      		getBaseContext().startActivity(intent);
      		  
      		  
 			  
      	  }
      	});
        nonMedicineButton=(Button)findViewById(R.id.chooserPageAddDailyActs);
        nonMedicineButton.setOnClickListener(new OnClickListener(){
        	  public void onClick(View v){
        	    //place code to execute here
        		  
        		  Intent intent2 = new Intent(getBaseContext(), AddReminder.class);  //todesign addmed
       	       // put if required
        		  intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        		  getBaseContext().startActivity(intent2);

       	     
   			  
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
