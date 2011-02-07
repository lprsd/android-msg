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
import android.widget.EditText;
import android.widget.Toast;

public class settings extends Activity {
	/** Called when the activity is first created. */
	static int flag = 0;
	static int flag1 = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.settings);
		SQLiteDatabase myDB = this.openOrCreateDatabase("DatabaseName", MODE_PRIVATE, null);


		Cursor c = myDB.rawQuery("SELECT * FROM settings Where id='a' ;", null);
		c.moveToFirst();
		// Toast.makeText(this, c.getString(c.getColumnIndex("number")),
		// 5).show();
		((EditText) findViewById(R.id.editText1)).setText(c.getString(c
				.getColumnIndex("number")));

		((Button) findViewById(R.id.buttonsave))
				.setOnClickListener(new OnClickListener() {

					SQLiteDatabase myDB = settings.this.openOrCreateDatabase(
							"DatabaseName", MODE_PRIVATE, null);

					@Override
					public void onClick(View v) {
						String number;

						// TODO Auto-generated method stub
						number = ((EditText) findViewById(R.id.editText1))
								.getText().toString();
						SQLiteDatabase myDB = settings.this
								.openOrCreateDatabase("DatabaseName",
										MODE_PRIVATE, null);
						myDB.execSQL("CREATE TABLE IF NOT EXISTS " + "settings"
								+ " (id varchar(2) , number varchar(20));");

						myDB.execSQL("UPDATE settings SET number='" + number
								+ "'  WHERE id='a';");

						Toast.makeText(settings.this,
								"number" + number + " saved", 5).show();
						Intent intent = new Intent(settings.this,
								com.msg.msg.class);

						startActivity(intent);

					}
				});
	}
}