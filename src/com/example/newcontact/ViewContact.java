package com.example.newcontact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.xml.sax.Parser;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ViewContact extends Activity {
	DBAdapter db;
	ListView lists;
	 Viewdatas viewdatas=new Viewdatas();
	Cursor cursor;
	SearchView searchView;
	 final ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();                        
ImageView image;
AlertDialog.Builder alert;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("viewcont","starts");
		setContentView(R.layout.activity_view_contact);
		
		 lists=(ListView)findViewById(R.id.listView1);
	db=	 new DBAdapter(this);
		 db.open();
		 name();Log.d("viewcont","statsin1");

		  String[] from={"id","name","no","mail"};
		  int [] to= {R.id.id,R.id.name,R.id.no,R.id.mail};
		  Log.d("viewcont","startsin2");

		 final SimpleAdapter adapter = new SimpleAdapter(
		            this,
		            list,
		            R.layout.listfile,from,to
		            
		           
		            );
		 
		 
		 
		 ActionBar bar = getActionBar();
			//for color
			bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
			bar.setTitle("View");
			
		 lists.setAdapter(adapter);
		   
			  
			    db.close();
			    Log.d("viewcont","startsin3");

		  lists.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

		    	 @Override
		    	 public boolean onItemLongClick(AdapterView<?> parent, View view,
		    final	 int position, long id) {
		    	 // TODO Auto-generated method stub
		    		 Log.d("Clicked item id", " "+ id); 
		    	 Log.d("abov", "Above");
		    	
				  	 
				  	AlertDialog.Builder alb=new AlertDialog.Builder(ViewContact.this);
					alb.setMessage("Are you sure to delete")
					.setCancelable(false)
					.setPositiveButton("YES", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							
							//finish();
							 db.open();
					    	 Cursor  cursor=db.display();
					    	 
					    	 adapter.notifyDataSetChanged();
							  	list.remove(position);
							  	 Log.d("ais", "ine");
							  	 cursor.moveToPosition(position);
							 	
							  
							  	 Log.d("ins", "ins");
							  final	 int idss= cursor.getInt(cursor.getColumnIndex("ID"));
							  	 
							 db.deleteContact(idss);
							 db.close();
							  Intent i=new Intent(ViewContact.this,NewContact.class);
							 // finish();
							  startActivity(i);
					  		 Toast.makeText(getApplicationContext(), "Item Deleted ", Toast.LENGTH_LONG).show();
						}
					})
					.setNegativeButton("NO", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							Toast.makeText(getApplicationContext(), "Not Deleted ", Toast.LENGTH_LONG).show();
							arg0.cancel();
						}
					});
					AlertDialog al=alb.create();
					al.setTitle("Alert!!");
					al.show();
				  	 
				  	 
				  	
				  		
				  		 
				  		 
				  		 
				  		 
				  		 
				  		 
				  		 
				 
				  Log.d("ialer", "ale");
		    	
		    	
				    	 return true;
				    	 
		  
		    	 
		    	 
		    	 
		    	
		    	 }
		    	 
		    	 });
		  
		    
			    Log.d("viewcont","startsin4");

		 OnItemClickListener itemClickListener = new OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
	                // Getting the Container Layout of the ListView
	            	Log.d("viewcont","startsins5");

	                LinearLayout linearLayoutParent = (LinearLayout) container;

	                // Getting the inner Linear Layout
	                LinearLayout linearLayoutChild = (LinearLayout ) linearLayoutParent.getChildAt(1);
	                Log.d("viewcont","startsins6");

	             	
	                TextView tvname = (TextView) linearLayoutChild.getChildAt(1);
	                TextView tvphone = (TextView) linearLayoutChild.getChildAt(2);
	                TextView tvmail = (TextView) linearLayoutChild.getChildAt(3);
	               
	                Log.d("viewcont","startsins7");

	               	   final             String one=tvname.getText().toString();
	           final     String two=tvphone.getText().toString();
	          final      String three=tvmail.getText().toString();
	              //  String four=tvid.getText().toString();
	                cursor.moveToPosition(position);
				 	
					  
				  	
				  	 int idm= cursor.getInt(cursor.getColumnIndex("ID"));
				  	
	      final         String idms=Integer.toString(idm);
	                Log.d("viewcont","startsins8");

	             
			        
	                Intent i=new Intent(ViewContact.this,Custom.class);
	               
	                Log.d("viewcont","startsins9");

	                  i.putExtra("disname", one);
	                  i.putExtra("disphone", two);
	                  i.putExtra("dismail", three);
	                 
					 	
	               
					  	
					  	
					  	
		                
	                  i.putExtra("idss", idms);
	                 Bundle bundle=new Bundle();
		                bundle.putInt("image",R.drawable.qq);
		                i.putExtras(bundle);
	                  Log.d("viewcont","startsins10");
	                //  finish();
	                  startActivity(i);
	                 

	               // Toast.makeText(getBaseContext(), one+"\n"+two+"\n"+three, Toast.LENGTH_LONG).show();
	               
	            }
	        };
	        Log.d("viewcont","startsins11");


	        // Setting the item click listener for the listview
	        lists.setOnItemClickListener(itemClickListener);
	        Log.d("viewcont","startsins12");

	     
			
	           
	        
	    }
		    
	   
		   
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.view_contact, menu);
		 MenuInflater inflater = getMenuInflater();
		    inflater.inflate(R.menu.view_contact, menu);
		    String[] from={"id","name","no","mail"};
			  int [] to= {R.id.id,R.id.name,R.id.no,R.id.mail};
			  Log.d("viewcont","startsin2");

			 final SimpleAdapter adapter = new SimpleAdapter(
			            this,
			            list,
			            R.layout.listfile,from,to
			            
			           
			            );
		    
			 lists.setAdapter(adapter);
			  lists.setTextFilterEnabled(true);
			   
		    
		    SearchManager searchManager =
		            (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		     SearchView searchView =
		             (SearchView) menu.findItem(R.id.search).getActionView();
		     searchView.setSearchableInfo(
		             searchManager.getSearchableInfo(getComponentName()));
		    // searchView.setIconifiedByDefault(false);  
		     
		     SearchView.OnQueryTextListener textChangeListener = new SearchView.OnQueryTextListener() 
             {
                 @Override
                 public boolean onQueryTextChange(String newText) 
                 {

           		
           		  
                	
					// this is your adapter that will be filtered
                    adapter.getFilter().filter(newText);
                   // ActionBar bar = getActionBar();
        			//for color
        			//bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#008000")));
        		//	bar.setTitle("Search");

                   // lists.setBackgroundColor(Color.parseColor("#2196F3"));
                  //  Toast.makeText(getApplicationContext(), newText, Toast.LENGTH_SHORT).show();
                   
                     return true;
                 }
                 @Override
                 public boolean onQueryTextSubmit(String query) 
                 {
                     // this is your adapter that will be filtered
                     adapter.getFilter().filter(query);
                    
                     Toast.makeText(getApplicationContext(), query, Toast.LENGTH_SHORT).show();
                     
                     return true;
                 }
             };
             searchView.setOnQueryTextListener(textChangeListener);
          //   searchView.setBackgroundColor(Color.parseColor("#000000"));
             return super.onCreateOptionsMenu(menu);

   
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId()==R.id.search){
			
		}
		else if(item.getItemId()==R.id.add){
		Intent i=new Intent(ViewContact.this,Addcontact.class);
	//	finish();
		startActivity(i);}
		
		
		else {
			Intent i=new Intent(ViewContact.this,NewContact.class);
		//	finish();
			startActivity(i);	
		}
		
		
		return super.onOptionsItemSelected(item);
	}
	
	 public void name(){
		
		  cursor=db.display();
		  cursor.moveToFirst();
			
			
		  
		 do{
			  if(cursor.isAfterLast()){
				  return;
			  }
			  else{
				  Log.d("viewcont","startsins13");
		
				  HashMap<String,String> temp = new HashMap<String,String>();
				    
				  Log.d("viewcont","startsins14");

		    temp.put("id", "Id:" +" "+cursor.getString(0));
		      temp.put("name","Name: "+ cursor.getString(1));
		     
		      Log.d("viewcont","startsins15");

		   temp.put("no", "Phone:"+cursor.getString(2));
		   temp.put("mail",  "Mail: "+cursor.getString(3));
		      cursor.moveToNext();
		      list.add(temp);
		      Log.d("viewcont","startsins17");

		  	}
		  }while(true);

		 }
	 
	
	 
		 
	
	 }
