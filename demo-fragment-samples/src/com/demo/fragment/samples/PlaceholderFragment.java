/**
 * @Project Name:demo-fragment-samples
 * @File Name:   PlaceholderFragment.java
 * @Package:     Name:com.demo.fragment.samples
 * @Date:        2015年6月26日下午3:54:36
 *
*/

package com.demo.fragment.samples;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @ClassName:PlaceholderFragment 
 * @Reason:	  TODO 
 * @Date:     2015年6月26日 下午3:54:36 
 * @author:   Luhx
 * @version:  
 * @see: 	  
 */
public class PlaceholderFragment extends Fragment {

	public PlaceholderFragment() {
		super();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		return rootView;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		TextView textView = (TextView) view.findViewById(R.id.text);
		EditText editText = (EditText) view.findViewById(R.id.edit);
		Bundle bundle = getArguments();
		if (bundle != null) {
			String text = bundle.getString(getString(R.string.bundle_key));
			textView.setText(text);
			editText.setText(text);
		}
	}
	
	
}

