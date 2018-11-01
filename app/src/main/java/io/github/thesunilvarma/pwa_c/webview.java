package io.github.thesunilvarma.pwa_c;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static io.github.thesunilvarma.pwa_c.MainActivity.mAppLogos;
import static io.github.thesunilvarma.pwa_c.MainActivity.mAppNames;
import static io.github.thesunilvarma.pwa_c.MainActivity.mAppOpenLink;
import static io.github.thesunilvarma.pwa_c.MainActivity.mAppDescription;

public class webview extends AppCompatActivity {

    /**
     * WebViewClient subclass loads all hyperlinks in the existing WebView
     */
    public class GeoWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // When user clicks a hyperlink, load in the existing WebView
            view.loadUrl(url);
            return true;
        }
    }

    /**
     * WebChromeClient subclass handles UI-related calls
     * Note: think chrome as in decoration, not the Chrome browser
     */
    public class GeoWebChromeClient extends WebChromeClient {
        @Override
        public void onGeolocationPermissionsShowPrompt(String origin,
                                                       GeolocationPermissions.Callback callback) {
            // Always grant permission since the app itself requires location
            // permission and the user has therefore already granted it
            callback.invoke(origin, true, false);
        }
    }

    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.setContentView(R.layout.webview);

        myWebView = new WebView(this);
      //  WebView myWebView = (WebView) findViewById(R.id.webview);
     //   WebSettings webSettings = myWebView.getSettings();
        myWebView.setWebViewClient(new WebViewClient());
     //   webSettings.setJavaScriptEnabled(true);
        // Brower niceties -- pinch / zoom, follow links in place
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.setWebViewClient(new GeoWebViewClient());
        // Below required for geolocation
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setGeolocationEnabled(true);
        myWebView.setWebChromeClient(new GeoWebChromeClient());

    //    RecyclerViewAdapter RvA = new RecyclerViewAdapter(this,mAppNames,mAppDescription,mAppLogos,mAppOpenLink);


        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            int j = (int) b.get("posi");

            myWebView.loadUrl(mAppOpenLink.get(j));
            setContentView(myWebView);
        }

//        @Override
//        public void onBackPressed() {          //this is use for the accessing or impleament back button
//            if (myWebView.canGoBack())
//                myWebView.goBack();
//            else
//                super.onBackPressed();
//        }
//        int posi = RvA.openApp(getAdapterPosition());
//        String test = RvA.openApp();
//        RvA.openApp(Integer.parseInt(test));
//
//        myWebView.loadUrl();
//        setContentView(myWebView);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (this.myWebView.canGoBack()) {
                        myWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
