package com.android.snap;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.android.snap.view.ImageAdapter;

public class GalleryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionbarSetUp();
		setContentView(R.layout.activity_gallery);

		GridView gridview = (GridView) findViewById(R.id.gallery_view);
		gridview.setAdapter(new ImageAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Toast.makeText(GalleryActivity.this, "" + position, Toast.LENGTH_SHORT).show();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		menu.findItem(R.id.search).setVisible(true);

		ShareActionProvider mShareActionProvider;
		/** Inflating the current activity's menu with res/menu/items.xml */
		mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.share).getActionProvider();
		/** Setting a share intent */
		mShareActionProvider.setShareIntent(getDefaultShareIntent());
		return true;
	}
	/** Returns a share intent */
	private Intent getDefaultShareIntent(){
		//TODO : Proper intent to pass.
		Intent intent = new Intent(Intent.ACTION_SEND);
		//        intent.setType("image/*");
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT");
		intent.putExtra(Intent.EXTRA_TEXT,"Extra Text");
		return intent;
	}
	
	private void actionbarSetUp(){
		ActionBar actionbar = getActionBar();
		if(actionbar == null){
			return;
		}
		actionbar.setDisplayShowHomeEnabled(false);
		int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
		TextView actionBarTitleView = (TextView) findViewById(titleId);
		actionBarTitleView.setTextColor(Color.MAGENTA);
		actionBarTitleView.setTextSize(25.0f);
		
	}
	public void onClick(View v){
		switch (v.getId()) {

		default:
			break;
		}
	}

}
