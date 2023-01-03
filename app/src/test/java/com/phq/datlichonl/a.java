//package com.phq.datlichonl;
//
//public class a {
//}
//    <?xml version="1.0" encoding="utf-8"?>
//<androidx.constraintlayout.widget.ConstraintLayout
//        xmlns:android="http://schemas.android.com/apk/res/android"
//        xmlns:app="http://schemas.android.com/apk/res-auto"
//        xmlns:tools="http://schemas.android.com/tools"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        tools:context=".MainActivity">
//
//<EditText
//        android:id="@+id/editText_addressBar"
//                android:layout_width="375dp"
//                android:layout_height="48dp"
//                android:layout_marginStart="16dp"
//                android:layout_marginLeft="16dp"
//                android:layout_marginTop="25dp"
//                android:layout_marginEnd="16dp"
//                android:layout_marginRight="16dp"
//                android:ems="10"
//                android:inputType="textPersonName"
//                app:layout_constraintEnd_toEndOf="parent"
//                app:layout_constraintStart_toStartOf="parent"
//                app:layout_constraintTop_toTopOf="parent" />
//
//<LinearLayout
//        android:id="@+id/linearLayout"
//                android:layout_width="0dp"
//                android:layout_height="wrap_content"
//                android:layout_marginStart="16dp"
//                android:layout_marginLeft="16dp"
//                android:layout_marginTop="16dp"
//                android:layout_marginEnd="16dp"
//                android:layout_marginRight="16dp"
//                android:orientation="horizontal"
//                app:layout_constraintEnd_toEndOf="parent"
//                app:layout_constraintStart_toStartOf="parent"
//                app:layout_constraintTop_toBottomOf="@+id/editText_addressBar">
//
//<Space
//            android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_weight="1" />
//
//<Button
//            android:id="@+id/button_static"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_weight="0"
//                    android:text="Static Content" />
//
//<Button
//            android:id="@+id/button_go"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:layout_weight="0"
//                    android:text="Go" />
//</LinearLayout>
//
//<WebView
//        android:id="@+id/webView"
//                android:layout_width="0dp"
//                android:layout_height="0dp"
//                android:layout_marginStart="16dp"
//                android:layout_marginLeft="16dp"
//                android:layout_marginTop="16dp"
//                android:layout_marginEnd="16dp"
//                android:layout_marginRight="16dp"
//                android:layout_marginBottom="16dp"
//                app:layout_constraintBottom_toBottomOf="parent"
//                app:layout_constraintEnd_toEndOf="parent"
//                app:layout_constraintStart_toStartOf="parent"
//                app:layout_constraintTop_toBottomOf="@+id/linearLayout" />
//</androidx.constraintlayout.widget.ConstraintLayout>

//package org.o7planning.androidwebview;
//
//import android.graphics.Bitmap;
//import android.util.Log;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//import android.widget.EditText;
//
//
//public class MyWebViewClient extends WebViewClient {
//
//    private EditText addressBar;
//
//    public MyWebViewClient(EditText addressBar) {
//        this.addressBar= addressBar;
//    }
//
//    // When you click on any interlink on webview.
//    @Override
//    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        Log.i("MyLog","Click on any interlink on webview that time you got url :-" + url);
//        addressBar.setText(url);
//        return super.shouldOverrideUrlLoading(view, url);
//    }
//
//    // When page loading
//    @Override
//    public void onPageStarted(WebView view, String url, Bitmap favicon) {
//        super.onPageStarted(view, url, favicon);
//        Log.i("MyLog", "Your current url when webpage loading.." + url);
//    }
//
//    // When page load finish.
//    @Override
//    public void onPageFinished(WebView view, String url) {
//        Log.i("MyLog", "Your current url when webpage loading.. finish" + url);
//        super.onPageFinished(view, url);
//    }
//
//    @Override
//    public void onLoadResource(WebView view, String url) {
//        super.onLoadResource(view, url);
//    }
//
//}

//package org.o7planning.androidwebview;
//
//import android.app.Activity;
//import android.os.Bundle;
//
//import android.view.View;
//
//import android.webkit.WebView;
//
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//public class MainActivity extends Activity  {
//
//
//    private  EditText addressBar;
//
//    private WebView webView;
//    private Button buttonGo;
//    private Button buttonStatic;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        buttonGo =(Button)findViewById(R.id.button_go);
//        buttonStatic =(Button)findViewById(R.id.button_static);
//
//        addressBar =(EditText)findViewById(R.id.editText_addressBar);
//        webView =(WebView)findViewById(R.id.webView);
//
//
//        // Tùy biến WebViewClient để điều khiển các sự kiện trên WebView
//        webView.setWebViewClient(new MyWebViewClient(addressBar));
//
//        buttonGo.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                goUrl();
//            }
//        });
//
//        buttonStatic.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showStaticContent();
//            }
//        });
//    }
//
//    private void goUrl()  {
//        String url = addressBar.getText().toString().trim();
//        if(url.isEmpty())  {
//            Toast.makeText(this,"Please enter url",Toast.LENGTH_SHORT).show();
//            return;
//        }
//        webView.getSettings().setLoadsImagesAutomatically(true);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//        webView.loadUrl(url);
//    }
//
//
//    private void showStaticContent()  {
//        String staticContent="<h2>Select web page</h2>"
//                + "<ul><li><a href='http://eclipse.org'>Eclipse</a></li>"
//                +"<li><a href='http://google.com'>Google</a></li></ul>";
//        webView.loadData(staticContent, "text/html", "UTF-8");
//    }
//
//}