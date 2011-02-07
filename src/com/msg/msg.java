package com.msg;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class msg extends Activity {
	/** Called when the activity is first created. */

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		SQLiteDatabase myDB = this.openOrCreateDatabase("DatabaseName", MODE_PRIVATE, null);

		
		myDB.execSQL("INSERT INTO " + "mytable" + " (msg)"
				+ " VALUES ('hello');");


		myDB.execSQL("INSERT INTO " + "mytable" + " (msg)"
				+ " VALUES ('hello');");


		myDB.execSQL("INSERT INTO " + "mytable" + " (msg)"
				+ " VALUES ('hello');");


		myDB.execSQL("INSERT INTO " + "mytable" + " (msg)"
				+ " VALUES ('hello');");


		Button listpage = (Button) findViewById(R.id.listpagebutton);
		
		listpage.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Takes to the Order Booking Page.
				Intent intent = new Intent(msg.this,
						com.msg.list.class);
				
				startActivity(intent);
			}
		});

	}
}