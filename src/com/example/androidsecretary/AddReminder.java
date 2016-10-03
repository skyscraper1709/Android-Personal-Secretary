package com.example.androidsecretary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.Time;
import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlarmManager;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.widget.TextView;

import java.util.Date;


public class AddReminder extends Activity implements OnTimeSetListener,OnDateSetListener {

	  final static int RQS_1 = 1;
	PendingIntent pendingIntent;
	EditText remName;
	EditText remDetail;
	DatePicker remDate;// add option today tomorrow for ease of use or populate next with day names.
	TimePicker remTime;
	Button submitRem;
	Button options;
	Button reset;
//	TimePickerDialog timePickerDialog;
	TimePicker TimePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_rem_page_design);
        //options button listener left to do 
        submitRem=(Button)findViewById(R.id.addPageSubmitButton);
        submitRem.setOnClickListener(new OnClickListener(){
      	  public void onClick(View v){
      	    //place code to execute here
      		if ((remName.getText().toString().length())==0)// || (remDate.getText().toString().length())==0 || (remTime.getText().toString().length())==0) {
  		  {    Toast.makeText(getBaseContext(), "You did not enter a Title", Toast.LENGTH_LONG).show();
  		      return;
  		  }
      		 Time timeNow=new Time();
   		  timeNow.setToNow();
   		  Time timeNotNow=new Time();
   		  timeNotNow.set(0, remTime.getCurrentMinute(), remTime.getCurrentHour(), remDate.getDayOfMonth(), remDate.getMonth(), remDate.getYear()/*-1900*/);
   		 if(timeNotNow.before(timeNow))
		  {
		   Toast.makeText(getBaseContext(), "I cant Time Travel to the Past", Toast.LENGTH_LONG).show();return;
			}
		  if(Time.compare(timeNow, timeNotNow)==0)
		  {
			  Toast.makeText(getBaseContext(), "You should leave me and do it NOW!!!", Toast.LENGTH_LONG).show();return;
		  }
		  else
		  {
			  // if duplicate found give warning, reset and then call setAlarm <= not done yet V.V.I.

				
//			    MyDB mdb=new MyDB();
//			    mbd.add(myCreatedDataObject);//add file in phone with name = title. 
			  // and after adding use search method to confirm adding also as neccessary update list or whatever.
				
				
			  Calendar calendar=Calendar.getInstance();
			  calendar.set(Calendar.YEAR, remDate.getYear());
			  calendar.set(Calendar.MONTH, remDate.getMonth());
			  calendar.set(Calendar.DAY_OF_MONTH, remDate.getDayOfMonth());                 
			  calendar.set(Calendar.HOUR_OF_DAY, remTime.getCurrentHour());
			  calendar.set(Calendar.MINUTE, remTime.getCurrentMinute());
			  Toast.makeText(getBaseContext(), "I cant Time Travel to the Past", Toast.LENGTH_LONG).show();
			  setAlarm(calendar);
		  }
      	  }
      	});
        options=(Button)findViewById(R.id.addPageMoreOptionsButton);
        reset=(Button)findViewById(R.id.addPageResetButton);
        reset.setOnClickListener(new OnClickListener(){
        	  public void onClick(View v){
        	    //place code to execute here
        		  Calendar cal=Calendar.getInstance();

        		  int year=cal.get(Calendar.YEAR);
        		  int month=cal.get(Calendar.MONTH);
        		  int day=cal.get(Calendar.DAY_OF_MONTH);
        		  int hour=cal.get(Calendar.HOUR_OF_DAY);
        		  int min=cal.get(Calendar.MINUTE);

        		  remDate.updateDate(year, month, day);

        		  remTime.setCurrentHour(hour);
        		  remTime.setCurrentMinute(min);
        		  remName.setText("");
        	       remDetail.setText("");
        	       
        	       Toast.makeText(getBaseContext(), "Info Reset!", Toast.LENGTH_LONG).show();//return;
        	  }
        	});
        remName=(EditText)findViewById(R.id.addPageTitleInputBox);
        remName.addTextChangedListener(new TextWatcher() {
        	 
        	   public void afterTextChanged(Editable s) {
        	   }
        	 
        	   public void beforeTextChanged(CharSequence s, int start, 
        	     int count, int after) {
        	   }
        	 
        	   public void onTextChanged(CharSequence s, int start, int before, int count) {
        	   
        	   }
        	  });
        remDetail=(EditText)findViewById(R.id.addPageDetailsInputBox);
        remDate=(DatePicker)findViewById(R.id.datePicker1);
        remTime=(TimePicker)findViewById(R.id.timePicker1);  
        
    }

    

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main_page, menu);
    return true;
    
}

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
    	
    	remTime.setCurrentHour(hourOfDay);
		  remTime.setCurrentMinute(minute);
    	
//        Calendar calNow = Calendar.getInstance();
//        Calendar calSet = (Calendar) calNow.clone();
//        calSet.set(Calendar.MONTH_OF_YEAR,5);
//        calSet.set(Calendar.DAY_OF_MONTH,2);
//        calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
//        calSet.set(Calendar.MINUTE, minute);
//        calSet.set(Calendar.SECOND, 0);   // edit this method to use user given DATE(to intro date) and Time
//        calSet.set(Calendar.MILLISECOND, 0);
//
//        if (calSet.compareTo(calNow) < 0) { //deleted an equal sign
//
//            calSet.add(Calendar.DATE, 1);
//        }
//
//        setAlarm(calSet);
    }


    

private void setAlarm(Calendar targetCal) {

    Toast.makeText(AddReminder.this, "Alarm is set at" + targetCal.getTime(),Toast.LENGTH_LONG).show();
    Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
    intent.putExtra("title",remName.getText().toString());
    intent.putExtra("desc",remDetail.getText().toString());
    intent.putExtra("dayOfMonth",remDate.getDayOfMonth());
    intent.putExtra("year",remDate.getYear());
    intent.putExtra("month",remDate.getMonth());
    //Toast.makeText(AddReminder.this, "Month is:"+remDate.getMonth(),Toast.LENGTH_LONG).show();
    intent.putExtra("hour",remTime.getCurrentHour());
    intent.putExtra("minute",remTime.getCurrentMinute());
    PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),pendingIntent);
    
    
}

public void CancelAlarm(Context context)
{
    Intent intent = new Intent(context, AlarmReceiver.class);
    
    
    PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    alarmManager.cancel(sender);
}
@Override
public void onDateSet(DatePicker arg, int day, int month, int year) {
	
	remDate.updateDate(year, month, day);	
	  
}

}
