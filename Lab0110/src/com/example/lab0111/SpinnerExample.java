package com.example.lab0111;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.support.v4.app.NavUtils;

public class SpinnerExample extends Activity {

	// Create an array adapter with a String type generic
	ArrayAdapter<String> adapter;
	
	// Create string array with three elements
	String Names[] = {"Bill", "Sue", "Bob"};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen001);
        
        // findViewById gets object based on integer R.id.spinner
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
    	
        // Since Activity inherits from Context, the "this" reference will give you context
		// Alternately you could use getApplicationContext()
        // R.layout.row is the integer representing the layout
        // R.id.entry is the individual item in the R.layout.row
        // Names is the string array
        adapter = new ArrayAdapter<String>(this, R.layout.row, R.id.entry, Names);
		
        // Set the adapter to the spinner view
        spinner.setAdapter(adapter);
	
    }

    
}
