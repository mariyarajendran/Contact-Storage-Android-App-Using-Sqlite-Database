package com.example.newcontact;

import android.net.Uri;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Custom extends Activity {
TextView cust,na,ph,ma,id;
ImageButton phones,chats;

DBAdapter db;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom);
		cust=(TextView)findViewById(R.id.custom);
		db=new DBAdapter(getApplicationContext());
		na=(TextView)findViewById(R.id.name);
		ph=(TextView)findViewById(R.id.phone);
		ma=(TextView)findViewById(R.id.mail);
		id=(TextView)findViewById(R.id.idms);
		chats=(ImageButton)findViewById(R.id.c);
		phones=(ImageButton)findViewById(R.id.p);
		
		
		 ActionBar bar = getActionBar();
			//for color
			bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
			
			 Intent intent = getIntent();
			 
				
			    
			    final String nam = intent.getStringExtra("disname");
			    String pho = intent.getStringExtra("disphone");
			    final String mai = intent.getStringExtra("dismail");
			    final String ids=intent.getStringExtra("idss");
			    
			    
			   
			    
			    
			//custom
			    na.setText(nam);
			    ph.setText(pho);
			    ma.setText(mai);
			    id.setText(ids);
			    
			    
			 
			  
			    
			    chats.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent i=new Intent(Custom.this,Messages.class);
						 String number=ph.getText().toString();
						i.putExtra("nu",number );
						startActivity(i);
					}
				});
			    
			    phones.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						 Intent callIntent = new Intent(Intent.ACTION_CALL);  
					      
			               callIntent.setData(Uri.parse("tel:"+ph.getText().toString().substring(6)));  
			              
			                startActivity(callIntent);  
					}
				});
			    
			   
			   
			    
			    
			    
	}
@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.custom, menu);
		return true;
	}
	
	@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
		if(item.getItemId()==R.id.edit){
	    Intent i=new Intent(Custom.this,Edittext.class);
        
        Log.d("viewcont","startsins9");

        String one=na.getText().toString();
        String two=ph.getText().toString();
        String three=ma.getText().toString();
        String four=id.getText().toString();
        
          i.putExtra("name", one);
          i.putExtra("phone", two);
          i.putExtra("mail", three);
         
		 	
       
		  	
		  	
		  	
            
          i.putExtra("id", four);
       /*  Bundle bundle=new Bundle();
            bundle.putInt("image",R.drawable.qq);
            i.putExtras(bundle);
          Log.d("viewcont","startsins10");*/
         // finish();
          startActivity(i);}
		
		else {
			Intent intent=new Intent(Custom.this,ViewContact.class);
		//	finish();
			startActivity(intent);
		}
         
	   
			
		
			return super.onOptionsItemSelected(item);
		}
	

	}
