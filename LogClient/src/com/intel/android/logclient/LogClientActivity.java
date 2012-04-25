package com.intel.android.logclient;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import android.widget.TextView;

import com.intel.android.logcommon.Message;

public class LogClientActivity extends Activity {
	private LogManager logManager;
	private TextView output;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        output = (TextView) findViewById(R.id.output);
        
        logManager = new LogManager(this);
    }
      
    /** Called when button is pressed. 
	 * @throws RemoteException */
	public void onClick(View v) {
		logManager.logMessage(new Message(Message.DEBUG, "LogLib", "onClick"));
	}
	
	public void onClickAsync(View v) {
		logManager.logMessageAsync(new Message(Message.DEBUG, "LogLib", "onClickAsync"), handler);
	}
	
	private Handler handler = new Handler() {
		//@Override
		public void handleMessage(android.os.Message msg) {	
			if(msg.what==logManager.MESSAGE_ID) {
				Message outputMsg = (Message)msg.obj;
				output.append("\nOP: "+outputMsg.toString());
			}
		}
	};
}
