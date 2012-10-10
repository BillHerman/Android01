package com.example.lab0113;

import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.ContactsContract;
import android.provider.ContactsContract.RawContacts;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;
import android.support.v4.app.NavUtils;

public class GridViewExample extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen001);
        
        // pull in the grid view definition from the XML layout file
        GridView gv = (GridView)findViewById(R.id.gridview);

        // create a list of contact info to receive from the contacts content provider
        final String[] projection = new String[] {ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME}; 
 
        // create a cursor over the contacts content provider
        Cursor c = managedQuery(ContactsContract.Contacts.CONTENT_URI, projection, null, null, ContactsContract.Contacts.DISPLAY_NAME);  
        
        // set the source column to feed into the grid view 
        String[] cols = new String[]{ContactsContract.Contacts.DISPLAY_NAME};
        
        // identify the name of the text view - note android.R prefix
        int[]   views = new int[]   {android.R.id.text1};

        // create simple cursor adapter - note android.R prefix on layout
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                c, cols, views);
        
        // set the grid view adapter
        gv.setAdapter(adapter);
        
    }

    
}
