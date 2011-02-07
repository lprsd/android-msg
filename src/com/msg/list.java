package com.msg;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class list extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);

		ListView mListView = (ListView) findViewById(R.id.messagelistListView);

		SQLiteDatabase myDB = this.openOrCreateDatabase("DatabaseName", MODE_PRIVATE, null);

		
		myDB.execSQL("INSERT INTO " + "mytable" + " (msg)"
				+ " VALUES ('Saranga');");

		Cursor c = myDB.rawQuery("SELECT * FROM " + "mytable", null);

		c.moveToFirst();
		

		List<Map> lMapList = new ArrayList<Map>();
		
		if (c != null) {
			// Loop through all Results
			do {
				Map mMap = new HashMap();
				mMap.put("Id", c.getInt(c.getColumnIndex("id")));
				mMap.put("msg", c.getString(c.getColumnIndex("msg")));
				lMapList.add(mMap);
			} while (c.moveToNext());
		}
		

		String[] strFrom = { "Id", "msg" };
		int[] iTo = { R.id.textView1, R.id.textView2 };

		SimpleAdapter saAdapter = new SimpleAdapter(this.getApplicationContext(),
				(List<? extends Map<String, ?>>) lMapList, R.layout.listelement,
				strFrom, iTo);
		mListView.setAdapter(saAdapter);

		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String msg = ((TextView) arg1
						.findViewById(R.id.textView2)).getText().toString();
				
				String Id = ((TextView) arg1
						.findViewById(R.id.textView1)).getText().toString();
				
				// Takes to the Order Detail Page to display the order details.
				  PendingIntent pi = PendingIntent.getActivity(list.this, 0,
				            new Intent(list.this, list.class), 0);  
				SmsManager sms = SmsManager.getDefault();
				
		        sms.sendTextMessage("1234",null,msg,pi,null);   	
		        Toast.makeText(list.this,"message number"+ Id+"  "+"sent",5).show();
			}

		});

	}
}