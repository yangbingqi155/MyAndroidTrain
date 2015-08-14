package com.example.firstdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.example.firstdemo.base.BaseBottomMenuActivity;
import com.example.firstdemo.BottomButton;


public class MainActivity extends BaseBottomMenuActivity {
	public final static String EXTRA_MESSAGE="com.example.firstdemo.MESSAGE";
	
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
            return true;
        }
      
        return super.onOptionsItemSelected(item);
    }
    
    public void sendMessage(View view)
    {
    	
    }
    
    public List<BottomButton> getButtonList() {
		Map<String,String> buttonMaps =  new HashMap<String,String>();
		buttonMaps.put("Home", String.valueOf(R.drawable.mybat_icon));
    	buttonMaps.put("Account", String.valueOf(R.drawable.mybat_icon));
    	buttonMaps.put("Cart", String.valueOf(R.drawable.mybat_icon));
    	buttonMaps.put("Search", String.valueOf(R.drawable.mybat_icon));
    
    	
    	List<BottomButton> buttons = new ArrayList<BottomButton>();
        Iterator<String> itKey = buttonMaps.keySet().iterator();
        while(itKey.hasNext())
        {
        	String key = itKey.next();
        	String valueRes = buttonMaps.get(key);
        	BottomButton oneBottomButton = new BottomButton();
        	oneBottomButton.setText(key);
        	oneBottomButton.setBackgroundResource(Integer.parseInt(valueRes));
        	buttons.add(oneBottomButton);
        }
        return buttons;
	}

	public int getContentViewLayoutResId() { return R.layout.activity_main; }

	protected void onCreatOverride(Bundle savedInstanceState) { }
}
