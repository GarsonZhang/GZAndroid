package GZAndroid.Library.gztest;

import com.squareup.okhttp.Response;

/**
 * Created by GarsonZhang on 2016-04-19.
 */
public interface Parser<T> {
    T parse(Response response);
}