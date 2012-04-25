package com.intel.android.logclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.intel.android.logcommon.ILogListener;
import com.intel.android.logcommon.ILogService;
import com.intel.android.logcommon.Message;

public class LogManager {
	public static final String TAG = "LogClientActivity";
	private ILogService logService;
	private Handler handler;
	public static int MESSAGE_ID=47;
	
	public LogManager(Context context) {
		boolean isBound = context.bindService(new Intent(
				"com.intel.android.logcommon.ILogService"),
				new ServiceConnection() {
					@Override
					public void onServiceConnected(ComponentName name,
							IBinder binder) {
						logService = ILogService.Stub.asInterface(binder);
						Log.d(TAG, "onServiceConnected");
					}

					@Override
					public void onServiceDisconnected(ComponentName name) {
						logService = null;
						Log.d(TAG, "onServiceDisconnected");
					}
				}, Context.BIND_AUTO_CREATE);
		Log.d(TAG, "onCreated isBound: " + isBound);
	}

	public void log(int priority, String tag, String message) {
		try {
			logService.log(priority, tag, message);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void logMessage(Message message) {
		try {
			logService.logMessage(message);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void logMessageAsync(Message message, Handler h) {
		try {
			logService.logMessageAsync(message, listener);
			this.handler = h;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	private ILogListener listener = new ILogListener.Stub() {
		@Override
		public void onResponse(Message msg) throws RemoteException {
			Log.d("onResponse", msg.toString());
			android.os.Message outputMsg = handler.obtainMessage(MESSAGE_ID, msg);
			handler.sendMessage(outputMsg);
		}
	};
}
