/**
 * @Project Name:demo-fragment-samples
 * @File Name:   ViewPagerFragmentActivity.java
 * @Package:     com.demo.fragment.samples
 * @Date:        2015年6月29日下午4:35:30
 *
*/

package com.demo.fragment.samples;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;

/**
 * @ClassName:ViewPagerFragmentActivity 
 * @Reason:	  TODO 
 * @Date:     2015年6月29日 下午4:35:30 
 * @author:   Luhx
 * @version:  
 * @see: 	  
 */
public class ViewPagerFragmentActivity extends FragmentActivity {

	List<Integer> fragmentTagIds;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewpager_fragment);
		
		ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
		viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
		TitlePageIndicator indicator = (TitlePageIndicator) findViewById(R.id.pageindicator);
		indicator.setViewPager(viewPager);
	}
	
	
	class FragmentsAdapter extends FragmentStatePagerAdapter {

		public FragmentsAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			Fragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return 3;
		}
		
		@Override
		public CharSequence getPageTitle(int position) {
			int strId;
			if(position == 0) strId = R.string.nav1;
			else if(position == 1) strId = R.string.nav2;
			else strId = R.string.nav3;
			return getString(strId);
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			super.destroyItem(container, position, object);
		}
	}

}

