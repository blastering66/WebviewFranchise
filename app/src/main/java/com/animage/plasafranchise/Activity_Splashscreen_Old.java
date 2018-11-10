package com.animage.plasafranchise;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Activity_Splashscreen_Old extends Activity {
	private ImageView img_Logo, img_txt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_activity__splashscreen_old);

		img_Logo = (ImageView) findViewById(R.id.img_logo);
		img_txt = (ImageView)findViewById(R.id.img_txt);

		new Async_Load().execute();
	}

	private class Async_Load extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			Animation logo_anim = AnimationUtils.loadAnimation(
					getApplicationContext(), R.anim.logo_anim_reveal);
			// img_Logo.setAnimation(logo_anim);
			int cx = img_txt.getWidth() / 2;
			int cy = img_txt.getHeight() / 2;



			if(Build.VERSION.SDK_INT > 21){
				int finalRadius = Math.max(img_txt.getWidth(), img_txt.getHeight());
				Animator anim_tv = ViewAnimationUtils.createCircularReveal(img_txt, cx, cy, 0, finalRadius);



				anim_tv.addListener(new AnimatorListenerAdapter() {
					@Override
					public void onAnimationEnd(Animator animation) {
						// TODO Auto-generated method stub
						super.onAnimationEnd(animation);
						img_txt.setVisibility(View.VISIBLE);
					}
				});

				anim_tv.start();
			}
			Animation test = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_tv_anim);

//			Animation test = AnimationUtils.makeInAnimation(getApplicationContext(), true);

			img_Logo.setVisibility(View.VISIBLE);
			img_Logo.startAnimation(test);

			img_txt.setVisibility(View.VISIBLE);
			img_txt.startAnimation(test);
		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(2500);
			} catch (Exception e) {

			}


			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			Animation test_dissappear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_tv_anim_dissapear);
			img_Logo.startAnimation(test_dissappear);


		}
	}

	private class Async_Load_2 extends AsyncTask<Void,Void,Void>{

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... params) {
			return null;
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);


			startActivity(new Intent(getApplicationContext(),
					Activity_MenuUtama.class));
			finish();
		}
	}
}
