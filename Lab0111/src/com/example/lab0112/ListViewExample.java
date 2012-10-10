package com.example.lab0112;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListViewExample extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // pull ListView definition from XML using findViewById lookup against auto-generated R.Java
        ListView lv= (ListView)findViewById(R.id.listview);

        // create the "from" mapping as two element String array
        String[] from = new String[] {"Row", "Data"};
        
        // create the "to" mapping as two element integer array
        int[] to = new int[] { R.id.item1, R.id.item2 };

        // create List of HashMaps
        List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
        
        // count for 10 rows
        for(int i = 0; i < 10; i++){
        	
        	// create new HashMap for this particular row
        	HashMap<String, String> map = new HashMap<String, String>();
        	
        	// add two elements to the HashMap, row and data
        	map.put("Row", "" + i);
        	map.put("Data", "Item " + i);
        	
        	// add new two element HashMap to the List of HashMaps
        	fillMaps.add(map);
        }

        // fill in the grid_item layout
        SimpleAdapter adapter = new SimpleAdapter(this, fillMaps, R.layout.grid_item, from, to);
        lv.setAdapter(adapter);
    }

    
}
