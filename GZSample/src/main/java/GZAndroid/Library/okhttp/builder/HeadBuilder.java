package GZAndroid.Library.okhttp.builder;

import GZAndroid.Library.okhttp.OkHttpUtils;
import GZAndroid.Library.okhttp.request.OtherRequest;
import GZAndroid.Library.okhttp.request.RequestCall;

import GZAndroid.Library.okhttp.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers).build();
    }
}
