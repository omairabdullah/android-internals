package com.intel.android.logcommon;

import com.intel.android.logcommon.Message;
import com.intel.android.logcommon.ILogListener;

interface ILogService {
	void log(int priority, String tag, String message);
	void logMessage(in Message msg);
	oneway void logMessageAsync(in Message msg, in ILogListener il);
}