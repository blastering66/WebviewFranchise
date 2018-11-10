package com.franchise;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;

public class Activity_MenuUtama extends FragmentActivity implements View.OnTouchListener {
	private WebView mWebView;
	private String url = "http://www.franchiseglobal.com";
	private boolean isTouched = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);

		mWebView = (WebView) findViewById(R.id.webview);
		mWebView.setFocusable(true);
		mWebView.setFocusableInTouchMode(true);
		mWebView.getSettings().setJavaScriptEnabled(true);
		// mWebView.getSettings().setPluginState(true);
		mWebView.getSettings().setRenderPriority(RenderPriority.HIGH);
		mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
		mWebView.getSettings().setDomStorageEnabled(true);
		mWebView.getSettings().setDatabaseEnabled(true);
		mWebView.getSettings().setAppCacheEnabled(true);
		mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

		mWebView.getSettings().setLoadWithOverviewMode(true);
		mWebView.getSettings().setUseWideViewPort(true);
		// mWebView.getSettings().setBuiltInZoomControls(true);
		mWebView.getSettings().setDisplayZoomControls(true);

		mWebView.setWebViewClient(new MyWebViewClient());
		mWebView.setOnTouchListener(this);
		mWebView.loadUrl(url);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			isTouched = true;
			break;

		default:
			break;
		}
		return false;
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (mWebView.canGoBack())
			mWebView.goBack();
		else
			super.onBackPressed();
	}

	private class MyWebViewClient extends WebViewClient {
		private DialogFragmentProgress pDialog;

		public MyWebViewClient() {
			// TODO Auto-generated constructor stub
			// pDialog = new DialogFragmentProgress();
			// pDialog.setCancelable(false);

		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			if (isTouched) {

				if (!url.contains("franchiseglobal")) {
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
					view.stopLoading();
				} else {
					view.loadUrl(url);
				}
			} else {
				view.loadUrl(url);
			}

			// Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			// startActivity(intent);
			return true;
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);

			// pDialog.show(getSupportFragmentManager(), "");

		}

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
			// pDialog.dismiss();
		}

	}

}
