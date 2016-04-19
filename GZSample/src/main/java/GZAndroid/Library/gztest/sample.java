package GZAndroid.Library.gztest;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import GZAndroid.Common.ToastEx;

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
