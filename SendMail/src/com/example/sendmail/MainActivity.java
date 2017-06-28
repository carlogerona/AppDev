package com.example.sendmail;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
 

public class MainActivity extends Activity {
	Button send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {

        	public void onClick(View v) {
        		if (v == send){
	        		// TODO Auto-generated method stub
		        	new Thread(new Runnable() {
		        		public void run() {
		        			try {
		        				GMailSender sender = new GMailSender("geronacarlo@gmail.com", "p0ornogr4phy");
//		        				sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/gwapo.jpg");
			        			sender.sendMail("SOSTracking Mail", "This mail has been sent to you using the SOSTracking App. Attached is the location on where the phone is used without your consent, along with the user who committed such action.","geronacarlo@gmail.com","cg.kill.16@gmail.com");
			        		} catch (Exception e) {
			        			Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
			        		}
		        		}
		        	}).start();
        		}
        	}
        });
	}
}