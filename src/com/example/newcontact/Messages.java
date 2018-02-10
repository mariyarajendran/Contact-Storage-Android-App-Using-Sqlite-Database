package com.example.newcontact;

import android.os.Bundle;
import android.os.Handler;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
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

public class Messages extends Activity {
TextView num;
EditText writemsg;
Button send;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_messages);
		num=(TextView)findViewById(R.id.textView1);
		writemsg=(EditText)findViewById(R.id.editText1);
		send=(Button)findViewById(R.id.send);
		Intent intent=getIntent();
		String msgnumber=intent.getStringExtra("nu");
		num.setText(msgnumber);
		
		 
		 ActionBar bar = getActionBar();
			//for color
			bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
			
	
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Log.i("Send SMS", "");
			      String phoneNo = num.getText().toString();
			      String message = writemsg.getText().toString();
			      
			    
			    	  
			      
			      try {
			        
			      
			         SmsManager smsManager = SmsManager.getDefault();
			         smsManager.sendTextMessage(phoneNo, null, message, null, null);
			         Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();}
			      
			      
			      catch (Exception e) {
			         Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
			         e.printStackTrace();
			      }
			      graphics();
			      new Handler().postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						Intent intent=new Intent(Messages.this,ViewContact.class);
						//finish();
						startActivity(intent);
					}
				}, 1000);
			   
			      
			}	});
		
	}
	
	
	private int getDisplayHeight() {
	    return this.getResources().getDisplayMetrics().heightPixels;
	}
	
	public void graphics(){
		Log.d("above on declare color2", "above on declare color2");
		 send.clearAnimation();
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
                send.clearAnimation();
                final int left = send.getLeft();
                final int top = send.getTop();
                final int right = send.getRight();
                final int bottom = send.getBottom();
               send.layout(left, top, right, bottom);

            }
        });
        send.startAnimation(transAnim);
       
    }
	
	

		}	
	
	
	
			

