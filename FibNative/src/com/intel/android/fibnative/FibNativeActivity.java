package com.intel.android.fibnative;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FibNativeActivity extends Activity {
    EditText input;
    TextView output;
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
    }
    
    public void onClickJ(View v) {
    	long n = Long.parseLong(input.getText().toString());
    	long resultJ = FibLib.fibJ(n);
    	output.append(String.format("fibJ(%d)=%d", n, resultJ));
    }
    
    public void onClickN(View v) {
    	long n = Long.parseLong(input.getText().toString());
    	long resultN = FibLib.fibN(n);
    	output.append(String.format("fibN(%d)=%d", n, resultN));
    }
}