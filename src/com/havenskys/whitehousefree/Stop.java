package com.havenskys.whitehousefree;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Stop extends Activity {
	
	
	private static String TAG = "Stop";
	
	private Custom mLog;

	private NotificationManager mNM;
	private final int NOTIFY_ID = 1;
	//private Handler mHandler;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.start);
        mLog = new Custom(this);
        
		Toast.makeText(this, mLog.APP +" synchronizing is disabled, restart this application to reactivate.", Toast.LENGTH_LONG).show();
		
        mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent service = new Intent();
		service.setClass(this, com.havenskys.whitehousefree.SyncService.class);
		
    	stopService(service);
		mNM.cancel(NOTIFY_ID);
		finish();

    }



}










