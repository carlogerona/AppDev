package com.applock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Launcher extends Activity {
	int DEFAULT = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		
		SharedPreferences sharedPreferences = getSharedPreferences("MyPassword", Context.MODE_PRIVATE);
		int getPin = sharedPreferences.getInt("pin", DEFAULT);
		Toast.makeText(getApplicationContext(), "pin is: " + getPin, Toast.LENGTH_SHORT).show();
		
		
		if(getPin != DEFAULT){
			Intent intent = new Intent(getBaseContext(), PasswordPrompt.class);
			startActivity(intent);
		}
		else{
			// Kung walay naset nga password
		}
	}
	
	public void onBackPressed(){
		SharedPreferences sharedPreferences = getSharedPreferences("MyPassword", Context.MODE_PRIVATE);
		int getReservePin = sharedPreferences.getInt("reservepin", DEFAULT);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putInt("pin", getReservePin);
		editor.commit();
		finish();
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	Intent intent = new Intent(Launcher.this, SetPassword.class);
			startActivityForResult(intent,0);
            return true;
        }
		return false;
        
    }

}
