package com.example.homework01;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;


/*

This is the first homework.  The purpose of this homework is to help you
understand how a custom adapter works.  It is very similar to the in class
assignment.  

The difference is it creates an adapter class called myAdapter which
inherits from BaseAdapter.  Ninety percent of the code is complete.  Your
job is to complete two sections identified with:

// YOUR CODE GOES HERE

The critical methods to understand are:
yourLayout.setBackgroundColor(getResources().getColor(R.color.Light_Blue))
yourImageView.setBackgroundResource(R.drawable.male)


*/


public class CustomAdapter extends Activity {

	// Create a Person class with
	// String name
	// boolean isMale
	// String superpower (x-ray eyes, invisablity, eta.)

	class Person {
		String name = "";
		boolean isMale = true;
		String superpower = "";
	}

	// Create an ArrayList with Person as the generic type
	ArrayList<Person> myPeople = new ArrayList<Person>();

	// Create a person instance for temp storage
	Person myPerson = new Person();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen001);

		// Clear your arraylist
		myPeople.clear();

		// Set your person instance to a new person and
		// add to person arraylist
		myPerson = new Person();
		myPerson.name = "Bob Smith";
		myPerson.superpower = "X-Ray Eyes";
		myPerson.isMale = true;
		myPeople.add(myPerson);

		// Repeat process several times to create a full list
		myPerson = new Person();
		myPerson.name = "Sally Hendrix";
		myPerson.superpower = "Invisablity";
		myPerson.isMale = false;
		myPeople.add(myPerson);

		myPerson = new Person();
		myPerson.name = "Tom Miner";
		myPerson.superpower = "Super Strong";
		myPerson.isMale = true;
		myPeople.add(myPerson);

		myPerson = new Person();
		myPerson.name = "John Simpson";
		myPerson.superpower = "Evil Genius";
		myPerson.isMale = true;
		myPeople.add(myPerson);

		myPerson = new Person();
		myPerson.name = "Mary Plank";
		myPerson.superpower = "Hypnosis";
		myPerson.isMale = false;
		myPeople.add(myPerson);

		myPerson = new Person();
		myPerson.name = "Michele Ringer";
		myPerson.superpower = "Super Speed";
		myPerson.isMale = false;
		myPeople.add(myPerson);

		// Use the findViewById method to get
		// definition of "list" entry from XML
		ListView addressList = (ListView) findViewById(R.id.list);

		// Create an adapter with a type of your custom adapter
		myAdapter currentAdapter = new myAdapter(this);

		// Use the "setAdapter" method on your ListView to link the adapter
		addressList.setAdapter(currentAdapter);

	}

	class myAdapter extends BaseAdapter {
		private LayoutInflater mInflater;

		// set the inflater 
		public myAdapter(Context context) {
			mInflater = LayoutInflater.from(context);
		}

		// return a count of the total number of possible elements
		public int getCount() {
			return myPeople.size();
		}

		// tell the custom adapter to use position when getting the item
		public Object getItem(int position) {
			return position;
		}

		// tell the custom adapter to use position when getting the id
		public long getItemId(int position) {
			return position;
		}

		// Android controls the selection of the multiple views 
		// In most cases, there are more views than can fit on the screen
		// ConvertView is a holder for each view
		// We used the setTag method to hold previously constructed views
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder;

			// this is a new view
			if (convertView == null) {
				
				// this method inflates the row layout into memory
				convertView = mInflater.inflate(R.layout.row, null);
				convertView.setId(position);
				
				// holder is a new instance of the custom ViewHolder object
				holder = new ViewHolder();
				
				// we use the findViewById method for convertView to link
				// the individual elements of the layout
				holder.name = (TextView) convertView.findViewById(R.id.name);
				holder.power = (TextView) convertView
						.findViewById(R.id.superpower);
				holder.picture = (ImageView) convertView
						.findViewById(R.id.photo);

			
				// Check the myPeople ListView by using the .get(position)
				// method.  Based on its value, set the color to Light_Blue or 
				// Pink.  These are found in the color.xml file.  You reference
				// them in code as getResources().getColor(R.color.Light_Blue).
				// This code gets placed in setBackgroundColor method.  Your 
				// code should look like:
				// convertView.setBackgroundColor(getResources().getColor(
				//		R.color.Light_Blue));
				// You will do a similar set up for pink/female
				
				// YOUR CODE GOES HERE

				
				
				// save the defined view using the setTag (which accepts 
				// an object)
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			// This section lets you define logic for each layout instance

			// Use Name string to set holder name using setText method
			holder.name.setText(myPeople.get(position).name);

			// Use the same process for superpower
			holder.power.setText(myPeople.get(position).superpower);

			// Test isMale like you did above and use 
			// setBackgroundResource and R.drawable.male or
			// R.drawable.female to change the picture
			
			// YOUR CODE GOES HERE

			// return the view
			return convertView;
		}

		// this is the view holder class
		class ViewHolder {
			ImageView picture;
			TextView name;
			TextView power;
		}
	}

}
