package com.example.firstdemo.util;
import android.view.Display;
import android.view.WindowManager;
import android.graphics.Point;

public class GlobalUtils {
	private  static GlobalUtils instance;
	
	private int screenHeight;
	private int screenWidth;
	
	public GlobalUtils(WindowManager windowManager)
	{
		instance=this;
		Display display=windowManager.getDefaultDisplay();
		this.screenHeight=display.getHeight();
		this.screenWidth=display.getWidth();
	}
	
	public static GlobalUtils getInstance()
	{
			return instance;
	}
	
	public int getScreenHeight(){
		return this.screenHeight;
	}
	
	public int getScreenWidth(){
		return this.screenWidth;
		
	}
	
}
