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
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Activity_Splashscreen extends Activity {
	private ImageView img_Logo, img_Logo_Plasa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_activity__splashscreen);

		img_Logo = (ImageView) findViewById(R.id.img_trasco);
		img_Logo_Plasa = (ImageView)findViewById(R.id.img_plasaf);
		
//		new Async_Load().execute();
		AnimationSet set = new AnimationSet(true);
		AlphaAnimation anim_reveal = new AlphaAnimation(0.00f, 1.00f);
		anim_reveal.setDuration(1000);
//			anim_reveal.setStartOffset(5000);

		AlphaAnimation anim_dissappear = new AlphaAnimation(1.00f, 0.00f);
		anim_dissappear.setDuration(1000);
		anim_dissappear.setStartOffset(2500);

		anim_dissappear.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				img_Logo.setVisibility(View.GONE);

				AnimationSet set = new AnimationSet(true);
				AlphaAnimation anim_reveal = new AlphaAnimation(0.00f, 1.00f);
				anim_reveal.setDuration(2500);

				AlphaAnimation anim_dissappear = new AlphaAnimation(1.00f, 0.00f);
				anim_dissappear.setDuration(2500);
				anim_dissappear.setStartOffset(3500);

				set.addAnimation(anim_reveal);
				set.addAnimation(anim_dissappear);

				anim_dissappear.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation animation) {

					}

					@Override
					public void onAnimationEnd(Animation animation) {
						startActivity(new Intent(getApplicationContext(),
								Activity_MenuUtama.class));
						finish();
					}

					@Override
					public void onAnimationRepeat(Animation animation) {

					}
				});

				img_Logo_Plasa.startAnimation(set);

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});

		set.addAnimation(anim_reveal);
		set.addAnimation(anim_dissappear);

		img_Logo.startAnimation(set);
	}



	private class Async_Load extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			AnimationSet set = new AnimationSet(true);
			AlphaAnimation anim_reveal = new AlphaAnimation(0.00f, 1.00f);
			anim_reveal.setDuration(2000);
//			anim_reveal.setStartOffset(5000);

			AlphaAnimation anim_dissappear = new AlphaAnimation(1.00f, 0.00f);
			anim_dissappear.setDuration(2000);
			anim_dissappear.setStartOffset(5000);

			anim_dissappear.setAnimationListener(new Animation.AnimationListener() {
				@Override
				public void onAnimationStart(Animation animation) {

				}

				@Override
				public void onAnimationEnd(Animation animation) {
					img_Logo.setVisibility(View.GONE);

					AnimationSet set = new AnimationSet(true);
					AlphaAnimation anim_reveal = new AlphaAnimation(0.00f, 1.00f);
					anim_reveal.setDuration(5000);

					AlphaAnimation anim_dissappear = new AlphaAnimation(1.00f, 0.00f);
					anim_dissappear.setDuration(5000);
					anim_dissappear.setStartOffset(7000);

					set.addAnimation(anim_reveal);
					set.addAnimation(anim_dissappear);

					img_Logo_Plasa.startAnimation(set);

				}

				@Override
				public void onAnimationRepeat(Animation animation) {

				}
			});

			set.addAnimation(anim_reveal);
			set.addAnimation(anim_dissappear);

			img_Logo.startAnimation(set);

//			Animation test = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_tv_anim);
//			img_Logo.setVisibility(View.VISIBLE);
//			img_Logo.startAnimation(test);


		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(2000);
			} catch (Exception e) {

			}


			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			new Async_Load_2().execute();
		}
	}

	private class Async_Load_2 extends AsyncTask<Void,Void,Void>{

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			AnimationSet set = new AnimationSet(true);
			AlphaAnimation anim_reveal = new AlphaAnimation(0.00f, 1.00f);
			anim_reveal.setDuration(5000);
//			anim_reveal.setStartOffset(5000);

			AlphaAnimation anim_dissappear = new AlphaAnimation(1.00f, 0.00f);
			anim_dissappear.setDuration(5000);
			anim_dissappear.setStartOffset(7000);

			set.addAnimation(anim_reveal);
			set.addAnimation(anim_dissappear);

			img_Logo_Plasa.startAnimation(set);

//			Animation test_dissappear = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_tv_anim_dissapear);
//			img_Logo_Plasa.setVisibility(View.VISIBLE);
//			img_Logo_Plasa.startAnimation(test_dissappear);
		}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {

			}
			return null;
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);


		}
	}
}
