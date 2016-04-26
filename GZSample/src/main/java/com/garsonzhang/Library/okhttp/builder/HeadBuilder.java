package com.garsonzhang.Library.okhttp.builder;

import com.garsonzhang.Library.okhttp.OkHttpUtils;
import com.garsonzhang.Library.okhttp.request.OtherRequest;
import com.garsonzhang.Library.okhttp.request.RequestCall;

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
