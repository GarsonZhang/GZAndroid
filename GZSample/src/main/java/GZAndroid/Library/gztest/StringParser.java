package GZAndroid.Library.gztest;

import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by GarsonZhang on 2016-04-19.
 */
public class StringParser implements Parser<String> {

    @Override
    public String parse(Response response) {
        String result = null;
        try {
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
