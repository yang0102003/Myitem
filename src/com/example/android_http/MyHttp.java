package com.example.android_http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class MyHttp {
	public static Bitmap httpURLconnection(String str) throws IOException{
		URL url = new URL(str);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		InputStream input = con.getInputStream();
		Bitmap bit = BitmapFactory.decodeStream(input);
		return bit;
	}
}
