package io.github.thesunilvarma.pwa_c;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static io.github.thesunilvarma.pwa_c.MainActivity.mAppLogos;
import static io.github.thesunilvarma.pwa_c.MainActivity.mAppNames;
import static io.github.thesunilvarma.pwa_c.MainActivity.mAppOpenLink;
import static io.github.thesunilvarma.pwa_c.MainActivity.mAppDescription;

public class webview extends AppCompatActivity {

    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.setContentView(R.layout.webview);

        myWebView = new WebView(this);
      //  WebView myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        myWebView.setWebViewClient(new WebViewClient());
        webSettings.setJavaScriptEnabled(true);

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
