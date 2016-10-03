package com.example.androidsecretary;
import com.example.androidsecretary.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ShowReminderPage extends Activity {
	
	Button ok,snooze,rs; Intent i;
	TextView title,desc;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_rem_page_design);
      Toast.makeText(ShowReminderPage.this, "pre bundle",Toast.LENGTH_LONG).show();
      //  Bundle b=getIntent().getExtras();
        
        /*only for reference
        intent.putExtra("title",remName.getText().toString());
        intent.putExtra("dayOfMonth",remDate.getDayOfMonth());
        intent.putExtra("year",remDate.getYear());
        intent.putExtra("month",remDate.getMonth());
        //Toast.makeText(AddReminder.this, "Month is:"+remDate.getMonth(),Toast.LENGTH_LONG).show();
        intent.putExtra("hour",remTime.getCurrentHour());
        intent.putExtra("minute",remTime.getCurrentMinute());
        */
        
//        Toast.makeText(ShowReminderPage.this, "pre textview",Toast.LENGTH_LONG).show();  
        title=(TextView)findViewById(R.id.showPageTitleBox);
  //why this does not work??     //String got =b.getString("title");
		  //String got =b.getStringExtra("title");
       String hh= getIntent().getStringExtra("title");
       Toast.makeText(ShowReminderPage.this, hh,Toast.LENGTH_LONG).show();
       title.setText(hh);
        //getString is crasing the app.
        //title.setText(b.getString("title"));
        
       // desc=(TextView)findViewById(R.id.showPageDetailBoxBottom);
       // desc.setText(b.getString("desc")+"\n"+"Time: "+b.getInt("hour")+":"+b.getInt("minute")+"\n"+"Date: "+b.getInt("dayOfMonth")+"/"+b.getInt("month")+"/"+b.getInt("year"));
        
        
        ok=(Button)findViewById(R.id.showPageThanksButton);
        ok.setOnClickListener(new OnClickListener(){
      	  public void onClick(View v){
      	    //place code to execute here
      		  onBackPressed();
      	  }
      	});
        snooze=(Button)findViewById(R.id.showPageSnoozeButton);
        snooze.setOnClickListener(new OnClickListener(){
      	  public void onClick(View v){
      	    //place code to execute here
      		  Intent intent = new Intent(getBaseContext(), Chooser.class);
 		       // put if required
      		  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      		  getBaseContext().startActivity(intent);
 			  
      	  }
      	});
        rs=(Button)findViewById(R.id.showPageRescheduleButton);
        rs.setOnClickListener(new OnClickListener(){
      	  public void onClick(View v){
      	    //place code to execute here
//      		  Intent intent = new Intent(getBaseContext(), Chooser.class);
// 		       // put if required
//      		  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//      		  getBaseContext().startActivity(intent);
// 			  
      	  }
      	});
    }

	
	  
}
