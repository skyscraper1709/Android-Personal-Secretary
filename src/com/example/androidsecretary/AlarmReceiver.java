package com.example.androidsecretary;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Toast.makeText(arg0, "Your Time is up!!!!!", Toast.LENGTH_LONG).show(); // edit to start ac tivity that shows data and allows rescheduling
        
        Intent intent=new Intent(arg0, ShowReminderPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        arg0.startActivity(intent);
        
        
        
        
        
        Vibrator vibrator = (Vibrator) arg0.getSystemService(Context.VIBRATOR_SERVICE); // register in manifest
        vibrator.vibrate(2000);
     //   final MediaPlayer mp = MediaPlayer.create(this, R.raw.alarma_67560);
      //  mp.setDataSource("/sdcard/audio/temp.wav");
       // mp.start();
    }

}