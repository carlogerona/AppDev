package com.applock;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SetPassword extends Activity implements OnClickListener {
EditText PIN, confirmPin;
Button enter;
Button show;
static int DEFAULT=0;
int pin, confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        enter = (Button)findViewById(R.id.buttonEnter);
        show = (Button)findViewById(R.id.buttonShow);
        PIN = (EditText)findViewById(R.id.editTextInput);
        confirmPin  =(EditText)findViewById(R.id.editTextPIN);
        
		enter.setOnClickListener(this);
		show.setOnClickListener(this);
		
		SharedPreferences sharedPreferences = getSharedPreferences("MyPassword", Context.MODE_PRIVATE);
		int getPin = sharedPreferences.getInt("pin", DEFAULT);
		
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v == enter){
			
			if(PIN.getText().toString().trim().length()== 0 || confirmPin.getText().toString().trim().length() == 0){
				Toast.makeText(getApplicationContext(), "Please Fill all Fields!", Toast.LENGTH_LONG).show();
			}
			else{
				pin = Integer.parseInt(PIN.getText().toString());
				confirm = Integer.parseInt(confirmPin.getText().toString());
				
				if(pin != confirm){
					Toast.makeText(getApplicationContext(), "PINs do not match!", Toast.LENGTH_LONG).show();
				}
				else{
				pin = Integer.parseInt(PIN.getText().toString());
				SharedPreferences sharedPreferences = getSharedPreferences("MyPassword", Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = sharedPreferences.edit();
				editor.putInt("pin",pin);
				editor.putInt("reservepin", pin);
				editor.commit();
				Toast.makeText(getApplicationContext(), "PINs successfully saved!", Toast.LENGTH_SHORT).show();
				}
			}
	}	
			
		
		if(v == show){
			try{
				SharedPreferences sharedPreferences = getSharedPreferences("MyPassword", Context.MODE_PRIVATE);
				int getPin = sharedPreferences.getInt("pin", DEFAULT);
				Toast.makeText(getApplicationContext(), "PIN is: " + getPin,  Toast.LENGTH_SHORT).show();
			}catch(Exception e){
				Toast.makeText(getApplicationContext(), e.toString(),  Toast.LENGTH_LONG).show();
			}
		}
	}

  
}
