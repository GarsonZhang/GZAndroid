package com.garsonzhang.Library.gztest;



import com.garsonzhang.Common.ToastEx;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by GarsonZhang on 2016-04-19.
 */
public class sample {
    public  void Test(){
        OkHttpClient okHttpClient =new OkHttpClient();
        StringParser parser=new StringParser();
        String url="http://www.baidu.com";
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback<String>(parser){
            @Override
            public void onResponse(String s) {
                ToastEx.showShort(null,s);
            }
        });

    }
}
