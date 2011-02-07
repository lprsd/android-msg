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

		SQLiteDatabase myDB = this.openOrCreateDatabase("DatabaseName",
				MODE_PRIVATE, null);

		myDB.execSQL("CREATE TABLE IF NOT EXISTS " + "settings"
				+ " (id varchar(2) , number varchar(20));");
		if (settings.flag1 == 1) {

			myDB.execSQL("INSERT INTO " + "settings" + " (id,number)"
					+ " VALUES ('a' ,'" + 123 + "');");
			settings.flag1 = 0;
		}

		myDB.execSQL("CREATE TABLE IF NOT EXISTS " + "mytable"
				+ " (id integer primary key autoincrement , msg varchar(500));");

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
				Intent intent = new Intent(msg.this, com.msg.list.class);

				startActivity(intent);
			}
		});

		Button setting = (Button) findViewById(R.id.mainbuttonsave);

		setting.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Takes to the Order Booking Page.
				Intent intent = new Intent(msg.this, com.msg.settings.class);

				startActivity(intent);
			}
		});
	}
}