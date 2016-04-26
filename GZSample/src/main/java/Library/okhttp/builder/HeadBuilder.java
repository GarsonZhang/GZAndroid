package Library.okhttp.builder;

import Library.okhttp.OkHttpUtils;
import Library.okhttp.request.OtherRequest;
import Library.okhttp.request.RequestCall;

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
