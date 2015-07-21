package com.example.firstdemo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import com.example.firstdemo.base.BaseBottomMenuActivity;
import com.example.firstdemo.BottomButton;

public class Demo extends BaseBottomMenuActivity {

	public List<BottomButton> getButtonList() {
		Map<String,String> buttonMaps =  new HashMap<String,String>();
		buttonMaps.put("Menu1", String.valueOf(R.drawable.mybat_icon));
    	buttonMaps.put("Menu2", String.valueOf(R.drawable.mybat_icon));
    	buttonMaps.put("Menu3", String.valueOf(R.drawable.mybat_icon));
    	buttonMaps.put("Menu4", String.valueOf(R.drawable.mybat_icon));

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

	public int getContentViewLayoutResId() { return R.layout.demo; }

	protected void onCreatOverride(Bundle savedInstanceState) { }
}