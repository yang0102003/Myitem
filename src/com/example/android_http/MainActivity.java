package com.example.android_http;

import java.io.IOException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	final String str = "http://a.hiphotos.baidu.com/zhidao/pic/item/728da9773912b31bb82f07408418367adab4e11c.jpg";
	Button but;
	ImageView image;
	Bitmap bit;
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				bit = (Bitmap) msg.obj;
				image.setImageBitmap(bit);
				break;

			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		but = (Button) this.findViewById(R.id.but);
		image = (ImageView) this.findViewById(R.id.image);
		new MyThread().start();
		but.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				new MyThread().start();
			}
		});
	}

	class MyThread extends Thread {
		@Override
		public void run() {

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				bit = MyHttp.httpURLconnection(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			handler.sendMessage(handler.obtainMessage(1, bit));
		}
	}
}
