package com.demo.fragment.samples;

import java.util.ArrayList;
import java.util.List;

import com.demo.fragment.samples.R.string;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DisplayFragmentActivity extends ActionBarActivity {

	FrameLayout mContainer;
	FragmentManager mFragmentManager;
	FragmentTransaction mFragmentTransaction;
	
	List<Integer> fragmentTagIds;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_fragment);
		if (savedInstanceState == null) {
			Fragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putString(getString(R.string.bundle_key), getString(R.string.nav1));
			fragment.setArguments(args);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, fragment, fragmentTag(R.id.nav1)).commit();
		}
		
		mFragmentManager = getSupportFragmentManager();
		mFragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTagIds = new ArrayList<Integer>();
		
		mContainer = (FrameLayout) findViewById(R.id.container);
		
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio);
		int count = radioGroup.getChildCount();
		for (int i = 0; i < count; i++) {
			if(radioGroup.getChildAt(i) instanceof RadioButton) {
				RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
				fragmentTagIds.add(radioButton.getId());
				radioButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						
						if (isChecked) {
							setRadioButtionChecked(buttonView.getId());
							
							mFragmentTransaction = mFragmentManager.beginTransaction();
							for (int id : fragmentTagIds) {
								String tag = fragmentTag(id);
								Fragment fragment = mFragmentManager.findFragmentByTag(tag);
								if (id == buttonView.getId()) {
									if(fragment == null) {
										fragment = new PlaceholderFragment();
										Bundle args = new Bundle();
										args.putString(getString(R.string.bundle_key), tag);
										fragment.setArguments(args);
										mFragmentTransaction.add(R.id.container, fragment, fragmentTag(buttonView.getId()));
									} else {
										mFragmentTransaction.show(fragment);
									}
								} else {
									if (fragment != null) {
										mFragmentTransaction.hide(fragment);
									}
								}
								
							}
							mFragmentTransaction.commit();
						}
					}
				});
			}
		}
		setRadioButtionChecked(R.id.nav1);
	}
	
	private void setRadioButtionChecked(int id) {
		if(fragmentTagIds == null || fragmentTagIds.isEmpty()) return;
		for (int i : fragmentTagIds) {
			findViewById(i).setBackgroundResource(i == id ? R.drawable.indicator_pressed : R.drawable.indicator_normal);
			if (i == id) {
			}
		}
	}

	private String fragmentTag(int id) {
		switch (id) {
		case R.id.nav1:
			return getString(R.string.nav1);
		case R.id.nav2:
			return getString(R.string.nav2);
		case R.id.nav3:
			return getString(R.string.nav3);
		}
		return getString(R.string.nav1);
	}
	
}
