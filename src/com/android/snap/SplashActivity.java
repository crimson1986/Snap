package com.android.snap;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

/**
 * This activty will be shown whenever App starts. Once required things are 
 * initialized it will open the main activity. 
 *
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        AnalyizeTask analyziseTask = new AnalyizeTask();
        analyziseTask.execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }
    
    private class AnalyizeTask extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			// TODO
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}
    	
		@Override
		protected void onPostExecute(Void result) {
			startActivity(new Intent(SplashActivity.this, GalleryActivity.class));
			super.onPostExecute(result);
		}

    }
    
}
