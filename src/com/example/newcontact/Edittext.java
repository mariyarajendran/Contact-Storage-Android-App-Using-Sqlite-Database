package com.example.newcontact;

import android.os.Bundle;
import android.os.Handler;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

public class Edittext extends Activity {
TextView tv;
EditText name,phone,mail,mainid;
DBAdapter db;
Button save;
final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edittext);
		name=(EditText)findViewById(R.id.name);
		phone=(EditText)findViewById(R.id.phone);
		mail=(EditText)findViewById(R.id.mail);
		mainid=(EditText)findViewById(R.id.id);
		db	= new DBAdapter(getApplicationContext());
	    save=(Button)findViewById(R.id.save);
	    
	    
	    
	    ActionBar bar = getActionBar();
		//for color
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
		
		
		 Intent intent = getIntent();
		 
			
		    
		     String NAME = intent.getStringExtra("name");
		    String PHONE = intent.getStringExtra("phone");
		     String MAIL = intent.getStringExtra("mail");
		     String ID=intent.getStringExtra("id");
		    
		    
		   
		    
		    
		//custom
		    name.setText(NAME.substring(5));          
		    phone.setText(PHONE.substring(6));
		    mail.setText(MAIL.substring(6));
		    mainid.setText(ID);
		    
		   
		  save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String iddd=mainid.getText().toString();
				String Name=name.getText().toString();
				String Phone=phone.getText().toString();
				String Mail=mail.getText().toString();
				if(Name.equalsIgnoreCase("")||Phone.equalsIgnoreCase("")||Mail.equalsIgnoreCase("")){
					
					 Toast.makeText(getApplicationContext(), "Please Fill The Fields", Toast.LENGTH_LONG).show();
					}
				else if(Mail.matches(emailPattern)){
					db.open();
					db.updateContact(iddd, Name, Phone, Mail);
					mainid.setText("");
					name.setText("");
					phone.setText("");
					mail.setText("");
					
					graphics();
					 new Handler().postDelayed(new Runnable() {
		                 @Override
		                 public void run() {
		                	
		            
					Intent i=new Intent(Edittext.this,NewContact.class);
					//finish();
					startActivity(i);
			         
		                 }
		             }, 2000);
					 Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
					 
				}
					else {
						Toast.makeText(getApplicationContext(), "Give Correct Mail Id", Toast.LENGTH_LONG).show();}
						
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edittext, menu);
		return true;
	}
	
	private int getDisplayHeight() {
	    return this.getResources().getDisplayMetrics().heightPixels;
	}
	
	public void graphics(){
		
		 save.clearAnimation();
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
                
                save.clearAnimation();
                final int left = save.getLeft();
                final int top = save.getTop();
                final int right = save.getRight();
                final int bottom = save.getBottom();
               save.layout(left, top, right, bottom);

            }
        });
        save.startAnimation(transAnim);
       
    }
	@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
		if(item.getItemId()==R.id.previous){
			Intent intent=new Intent (Edittext.this,ViewContact.class);
			//finish();
			startActivity(intent);
			
		}
			return super.onOptionsItemSelected(item);
		}

}
