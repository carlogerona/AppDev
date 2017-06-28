package com.applock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PasswordPrompt extends Activity implements OnClickListener {
	EditText input;
	Button enter;
	int pin, DEFAULT = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.password_prompt);
		
		input = (EditText)findViewById(R.id.editTextInput);
		enter = (Button)findViewById(R.id.buttonEnter);
		
		enter.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == enter){
			pin = Integer.parseInt(input.getText().toString());
			SharedPreferences sharedPreferences = getSharedPreferences("MyPassword", Context.MODE_PRIVATE);
			int getPin = sharedPreferences.getInt("pin", DEFAULT);
			if(pin == getPin){
				SharedPreferences sharedPref = getSharedPreferences("MyPassword", Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = sharedPref.edit();
				editor.putInt("pin", 0);
				editor.commit();
				Intent intent = new Intent(getBaseContext(), Launcher.class);
				startActivity(intent);
			}
		}
	}
}
