package com.example.firstdemo;

import android.view.View;

public class BottomButton {
	//menu text
	private String text;
	
	//menu image
	private int backgroundResource;

	//menu click listener
	private View.OnClickListener clickListener;
	
	//menu whether checked
	private boolean isCurrent=false;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public int getBackgroundResource() {
		return backgroundResource;
	}

	public void setBackgroundResource(int backgroundResource) {
		this.backgroundResource = backgroundResource;
	}

	public View.OnClickListener getClickListener() {
		return clickListener;
	}

	public void setClickListener(View.OnClickListener clickListener) {
		this.clickListener = clickListener;
	}

	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	
}
