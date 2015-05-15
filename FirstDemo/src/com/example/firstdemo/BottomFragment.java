package com.example.firstdemo;
import android.R;
import android.support.v4.app.Fragment;
import android.view.*;
import android.os.Bundle;

public class BottomFragment extends Fragment {
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceSate){
		return inflater.inflate(com.example.firstdemo.R.layout.bottom_view,container,false);
	}
}
