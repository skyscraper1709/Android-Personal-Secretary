package com.example.androidsecretary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMedicine extends Activity implements OnClickListener {
	
	EditText medName;
	EditText medDetail;
	EditText medDate;// add option today tomorrow for ease of use or populate next with day names.
	EditText medTime;
	Button submitMed;
	Button options;
	Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_rem_page_design);
        medName=(EditText)findViewById(R.id.addMedicinePageTitleInputBox);
        medDetail=(EditText)findViewById(R.id.addMedicinePageDetailsInputBox);
        medDate=(EditText)findViewById(R.id.addMedicinePageDateInputBox);
        medTime=(EditText)findViewById(R.id.addMedicinePageTimeInputBox);
        submitMed=(Button)findViewById(R.id.addMedicinePageSubmitButton);
        options=(Button)findViewById(R.id.addMedicinePageMoreOptionsButton);
        reset=(Button)findViewById(R.id.addMedicinePageResetButton);
    }

    

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main_page, menu);
    return true;
    
}
@Override
public void onClick(View v) {

	  switch(v.getId()){

	  case R.id.addMedicinePageSubmitButton: 
		 
		  if ((medName.getText().toString().length())==0 || (medDate.getText().toString().length())==0 || (medTime.getText().toString().length())==0) {
		      Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
		      return;
		  }
	       Intent intent = new Intent(this, AddMedicine.class);
	       // put if required
	       this.startActivity(intent);
		  
	       break;

	  /*case R.id.addMedicinePageMoreOptionsButton: 
	       Intent intent2 = new Intent(this, AddReminder.class); // create add options later class
	       // put if required
	       this.startActivity(intent2);
	       
	       ******* Later . idea ok but not on this activity should be on the alarm showing activity
           snooze,reschedule, delete.




	       break;
	       */
	  case R.id.addMedicinePageResetButton: 
	       
	       // put if required
	       medName.setText("");
	       medDetail.setText("");
	       medDate.setText("");
	       medTime.setText("");

	       break;
	  }
}

}
