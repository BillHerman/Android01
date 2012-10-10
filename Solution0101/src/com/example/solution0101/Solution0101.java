package com.example.solution0101;

import com.example.solution0101.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class Solution0101 extends Activity {

	// create a string array and name it itemNames
	String[] itemNames = {"Bob","Sue","Bill"};
	
	// create an array adapter and name it arrayAdapter
	ArrayAdapter<String> arrayAdapter;
	
	// create a list view and name it ListView
	ListView listView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // set your content for the activity to R.layout.screen001
        setContentView(R.layout.screen001);

        // reference the "list" item in your layout through the findViewById method
        // make sure to cast the resulting object to ListView
        // and assign the resulting ListView to your view 
		listView = (ListView) findViewById(R.id.list);
        
		// create new ArrayAdapter and reference the R.id.entry in R.layout.row
		arrayAdapter = new ArrayAdapter<String>(this,
				R.layout.row, R.id.entry, itemNames);

		// use the setAdapter method on your ListView to reference the arrayAdapter
		listView.setAdapter(arrayAdapter);
    
    }


    
}
