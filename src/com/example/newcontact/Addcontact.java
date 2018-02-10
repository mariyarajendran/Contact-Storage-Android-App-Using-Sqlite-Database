package com.example.newcontact;

import android.os.Bundle;
import android.os.Handler;
import android.provider.Contacts.Intents.Insert;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Addcontact extends Activity {

Button done;
EditText nam,phon,mai,ma;
DBAdapter db ;
TextView addcon;
String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("above on", "above on");
		setContentView(R.layout.activity_addcontact);
		Log.d("above on declare", "above on declare");
		done=(Button)findViewById(R.id.send);
		nam=(EditText)findViewById(R.id.name);
		phon=(EditText)findViewById(R.id.phone);
		addcon=(TextView)findViewById(R.id.addcon);
		Log.d("above on declare", "above on declare");
		//done.getBackground().setAlpha(100);
		
		//nam.setBackgroundColor(Color.parseColor("#FFFFFF"));
		
		
		
		Log.d("above on declare color7", "above on declare color7");
		ActionBar bar = getActionBar();
		//for color
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
		
		
		
		db = new DBAdapter(this);
		Log.d("above on declare color6", "above on declare color6");
		ma=(EditText)findViewById(R.id.mail);
		
		done.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.d("above on declare color5", "above on declare color5");
				Log.d("above on declare button5", "above on declare button5");
				String name=nam.getText().toString();
				String phone=phon.getText().toString();
		
				String emailss=ma.getText().toString();
				
				if(name.equalsIgnoreCase("")||phone.equalsIgnoreCase("")){
			
					Log.d("above on declare color", "above on declare color");
				
				
				 Toast.makeText(getApplicationContext(), "Please Fill All The Fields", Toast.LENGTH_LONG).show();
				}
				else if(emailss.matches(emailPattern)){{
					
					db.open();
					Log.d("above on declare color4", "above on declare color4");
					 db.insertContact(name, phone,emailss);
					 nam.setText("");
				        phon.setText("");
				        ma.setText("");
					 
					Toast.makeText(getApplicationContext(), "Stored Successfully", Toast.LENGTH_SHORT).show();
					
					 db.close();}
			graphics();
			 new Handler().postDelayed(new Runnable() {
				 
                 @Override
                 public void run() {
                	 Log.d("above on declare color3", "above on declare color3");
                	 Intent i=new Intent(Addcontact.this,NewContact.class);
 					startActivity(i);
 					Log.d("above on declare color3", "above on declare color3");
                 }
             }, 2000);
					}
				
				
				
				else{
					Toast.makeText(getApplicationContext(), "Give Correct Mail Id", Toast.LENGTH_LONG).show();
					
				}
				
				
				
			} 
			
		});
		
	}
	
	@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
		if(item.getItemId()==R.id.previous){
		Intent intent=new Intent(Addcontact.this,NewContact.class);
		//finish();
		startActivity(intent);}
		return super.onOptionsItemSelected(item);
		}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.addcontact, menu);
		
		return true;
	}
	private int getDisplayHeight() {
	    return this.getResources().getDisplayMetrics().heightPixels;
	}
	
	public void graphics(){
		Log.d("above on declare color2", "above on declare color2");
		 done.clearAnimation();
        TranslateAnimation transAnim = new TranslateAnimation(0, 0, 0,
                getDisplayHeight()/2);
        transAnim.setStartOffset(500);
        transAnim.setDuration(1500);
        transAnim.setFillAfter(true);
        transAnim.setInterpolator(new BounceInterpolator());
       
        transAnim.setAnimationListener(new AnimationListener() {

            @Override
            public  void onAnimationStart(Animation animation) {
               

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            	Log.d("above on declare color1", "above on declare color1");
                done.clearAnimation();
                final int left = done.getLeft();
                final int top = done.getTop();
                final int right = done.getRight();
                final int bottom = done.getBottom();
               done.layout(left, top, right, bottom);

            }
        });
        done.startAnimation(transAnim);
       
    }
	
	
	

}
