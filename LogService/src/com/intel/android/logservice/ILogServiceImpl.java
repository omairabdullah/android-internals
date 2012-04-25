package com.intel.android.logservice;

import android.os.RemoteException;

import com.intel.android.logcommon.ILogListener;
import com.intel.android.logcommon.ILogService;
import com.intel.android.logcommon.Message;
import com.intel.android.loglib.LogLib;

public class ILogServiceImpl extends ILogService.Stub {

	public void log(int priority, String tag, String message) throws RemoteException {
		LogLib.log(priority, tag, message);
	}

	public void logMessage(Message msg) throws RemoteException {
		LogLib.log(msg.getPriority(), msg.getTag(), msg.getMessage());		
	}

	public void logMessageAsync(Message msg, ILogListener listener)
			throws RemoteException {
		LogLib.log(msg.getPriority(), msg.getTag(), msg.getMessage());	
		listener.onResponse(new Message(Message.INFO, "LogServImpl", "Wake up listener"));
	}
}