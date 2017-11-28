package com.example.temperature;

import java.math.BigDecimal;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity
{

	public float celsius, farenheit;
	
	public String fstring,cstring;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		EditText editText1 = (EditText) findViewById(R.id.editText1);  
		EditText editText2 = (EditText) findViewById(R.id.editText2);		

		editText1.addTextChangedListener(new TextWatcher()
		{
			EditText editText1 = (EditText) findViewById(R.id.editText1);  
			EditText editText2 = (EditText) findViewById(R.id.editText2);
			@Override
			public void afterTextChanged(Editable s)
			{
				final double result;
				if (editText1.isFocused())
				{
					try
					{
					celsius = Float.parseFloat(editText1.getText().toString());
					}
					catch (NumberFormatException e)
					{
						celsius=0;
					}
					result=round((celsius*1.8+32),4);
					fstring = String.valueOf(result);
					editText2.setText(fstring);
				}				
			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after){}
			public void onTextChanged(CharSequence s, int start, int before, int count) {}
		});
		
		editText2.addTextChangedListener(new TextWatcher()
		{
			EditText editText1 = (EditText) findViewById(R.id.editText1);  
			EditText editText2 = (EditText) findViewById(R.id.editText2);
			@Override
			public void afterTextChanged(Editable s) 
			{
				final double result;
				if (editText2.isFocused())
				{
				try
				{	
				
					farenheit = Float.parseFloat(editText2.getText().toString());
				}
				catch (NumberFormatException e)
				{
					farenheit=0;
				}
				result=round(((farenheit-32)*.5556),4);
				cstring = String.valueOf(result);
				editText1.setText(cstring);
				}				
			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after){}
			public void onTextChanged(CharSequence s, int start, int before, int count) {}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public static double round(double unrounded, int precision)
	{
	    BigDecimal bd = new BigDecimal(unrounded);
	    bd = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
	    return bd.doubleValue();
	}

}
