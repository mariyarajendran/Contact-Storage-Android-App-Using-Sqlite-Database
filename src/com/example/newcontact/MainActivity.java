package com.example.newcontact;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
Button sig,log;
Database2forsignin database2forsignin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sig=(Button)findViewById(R.id.signin);
		log=(Button)findViewById(R.id.login);
		database2forsignin=new Database2forsignin(getApplicationContext());
		sig.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				sig.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
				
				
				if(database2forsignin.check()==true){
					
					
					Intent intent=new Intent(MainActivity.this,Signin.class);
					startActivity(intent);}
					
					else{
						Toast.makeText(getApplicationContext(), "you already signed in please login", Toast.LENGTH_LONG).show();
					}
				
					}
				});
				
				log.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if(database2forsignin.check()==false){
							Intent intent=new Intent(MainActivity.this,Login.class);
							startActivity(intent);
						}
						else{
							
							Toast.makeText(getApplicationContext(), "you are not signed in please signin first", Toast.LENGTH_LONG).show();
						}
					}
				});
					
				}
				
			
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
