package com.example.formlogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	private String[][] dataUser = {
			{"admin","admin","Administrator"},{"ilham","coba1","Muhammad Ilham Fhadilah"},{"mahier","coba2","Maghier Fhadilah"}
	};
	private EditText userName, password;
	private final int Success=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		userName = (EditText)findViewById(R.id.editTextUsername);
		password = (EditText)findViewById(R.id.editTextPassword);
		findViewById(R.id.buttonLogin).setOnClickListener(this);
		findViewById(R.id.buttonKeluar).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.buttonLogin:
			int i=0;
			boolean Success = false;
			
			while((i<dataUser.length)&&(!Success)){
				if((userName.getText().toString().equals(dataUser[i][0]))&&(password.getText().toString().equals(dataUser[i][1]))){
					Success = true;
				} else {
					i++;
				}
			}
			
			Intent intent;
			if(Success){
				intent = new Intent(this, LoginBerhasil.class);
				intent.putExtra("NamaUser", dataUser[i][2]);
				startActivity(intent);
			} else {
				intent = new Intent(this, LoginGagal.class);
				startActivity(intent);
			}
			break;
		case R.id.buttonKeluar:
			System.exit(0);
		}
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		switch (requestCode) {
		case Success:
			userName.setText("");
			password.setText("");
			break;
		}
	}
}
