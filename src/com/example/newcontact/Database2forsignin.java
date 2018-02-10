package com.example.newcontact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database2forsignin extends SQLiteOpenHelper{

	public Database2forsignin(Context context) {
		super(context, "SIGNINDB", null, 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		try {
			Log.e("signerror1", "signinerror1");
			Log.e("signerror2", "signinerror2");
	        db.execSQL("CREATE TABLE SIGNIN(NAME TEXT );");
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }

	

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void insert(String passwords){
		SQLiteDatabase db=getWritableDatabase();
		Log.e("signerror3", "signinerror3");
	ContentValues	 contentValues=new ContentValues();
		contentValues.put("NAME", passwords);
		Log.e("signerror4", "signinerror4");
		db.insert("SIGNIN", null, contentValues);
	}
	
	public boolean check(){
		SQLiteDatabase db = getWritableDatabase();
		String count = "SELECT count(*) FROM SIGNIN";
		Cursor mcursor = db.rawQuery(count, null);
		mcursor.moveToFirst();
		int icount = mcursor.getInt(0);
		if(icount<0){
			return true;
		}
		else{
			return false;
		}
		
	}

}
