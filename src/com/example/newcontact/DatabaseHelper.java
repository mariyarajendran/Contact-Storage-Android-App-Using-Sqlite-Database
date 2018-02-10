package com.example.newcontact;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;





class DBAdapter{
	
	public static final String _id="ID";
	public static final String _name="NAME";
	public static final String _phone="PHONE";
	public static final String _mail="MAILID";
	
	private static final String _database="MYDB";
	private static final String _table="CONTACTS";
	private static final int  _version=2;
	
	private static final String _createdatabase="CREATE TABLE CONTACTS(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT NOT NULL,PHONE TEXT NOT NULL,MAILID TEXT NOT NULL);";
	private final Context context;

	private DatabaseHelper DBHelper;
	  private SQLiteDatabase db;
	  
	  public DBAdapter(Context ctx) {
		    this.context = ctx;
		    DBHelper = new DatabaseHelper(context);
		  }
	
public class DatabaseHelper extends SQLiteOpenHelper{
 DatabaseHelper(Context context){
	 super(context,_database,null,_version);
 }

@Override
public void onCreate(SQLiteDatabase db) {
	// TODO Auto-generated method stub
	try {
        db.execSQL(_createdatabase);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

@Override
public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
	// TODO Auto-generated method stub
}
	
}

public DBAdapter open() throws SQLException {
    db = DBHelper.getWritableDatabase();
    return this;
  }


public void close() {
    DBHelper.close();
  }

public void insertContact(String name, String phone,String mailid) {
    ContentValues initialValues = new ContentValues();
    initialValues.put(_name, name);
    initialValues.put(_phone, phone);
    initialValues.put(_mail, mailid);
     db.insert(_table, null, initialValues);
     
  }

public Cursor getAllContacts() {
    return db.query(_table, new String[] { _id, _name,
       _phone,_mail }, null, null, null, null, null);
    
  }

public Cursor getContact(String rowId) throws SQLException {
    Cursor mCursor = db.query(true, _table, new String[] {
        _id, _name, _phone,_mail }, _id + "=" + rowId,
        null, null, null, null, null);
    if (mCursor != null) {
      mCursor.moveToFirst();
    }
    return mCursor;
  }

public Cursor display(){
	
	Cursor cursor;
	 cursor=db.rawQuery(("SELECT * FROM CONTACTS"), null);
	 return cursor;
}

public boolean deleteContact(int id) {
    return db.delete("CONTACTS","ID=?",new String[] {Integer.toString(id)})>0;
  }

public Cursor search(String name){
	Cursor cursor;
	cursor=db.query(_table, new String[] { _id,
           _name, _phone }, _name+ "=?",
            new String[] { String.valueOf(name) }, null, null, null, null);
	return cursor;
}


public boolean updateContact (String id, String name, String phone, String email)
{

   ContentValues contentValues = new ContentValues();
   contentValues.put("NAME", name);
   contentValues.put("PHONE", phone);
   contentValues.put("MAILID", email);
   db.update("CONTACTS", contentValues, "id = ? ", new String[] {id } );
   return true;
}





}




