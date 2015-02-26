package com.example.viewpager_fragment;

import java.util.ArrayList;
import java.util.List;

import com.wangxue.adapter.FragmentAdapter;
import com.wangxue.fragment.Fragment1;
import com.wangxue.fragment.Fragment2;
import com.wangxue.fragment.Fragment3;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	ViewPager vp;
	LinearLayout layout;
	List<Fragment> list;
	FragmentAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		vp = (ViewPager) findViewById(R.id.viewpager);
		layout = (LinearLayout) findViewById(R.id.layout);
		
		layout.getChildAt(0).setBackgroundColor(Color.BLUE);
		
		list = new ArrayList<Fragment>();
		list.add(new Fragment1());
		list.add(new Fragment2());
		list.add(new Fragment3());
		
		adapter = new FragmentAdapter(getSupportFragmentManager(),list);
		vp.setAdapter(adapter);
		vp.setOnPageChangeListener(new OnPageChangeListener() {
			int checked;
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				TextView tv1 = (TextView) layout.getChildAt(checked);
				tv1.setBackgroundColor(Color.WHITE);
				TextView tv2 = (TextView) layout.getChildAt(arg0);
				tv2.setBackgroundColor(Color.BLUE);
				checked = arg0;
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}

}
