package com.intel.android.logcommon;

import com.intel.android.logcommon.Message;

oneway interface ILogListener {
	void onResponse(in Message msg);
}