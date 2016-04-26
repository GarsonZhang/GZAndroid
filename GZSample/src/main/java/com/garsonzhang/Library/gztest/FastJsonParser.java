package com.garsonzhang.Library.gztest;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by GarsonZhang on 2016-04-19.
 */
public class FastJsonParser<T> implements Parser<T> {
    private Class<T> mClass = null;

    public FastJsonParser(Class<T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("Class can't be null");
        }
        this.mClass = clazz;
    }

    @Override
    public T parse(Response response) {
        try {
//            String jsonstr = response.body().string();
//            List<ControllerInfo> lst = JSON.parseArray(jsonstr, ControllerInfo.class);
//            Message msg = new Message();
//            msg.obj = lst;
//            handler.sendMessage(msg);
            String jsonstr = response.body().string();
            T t = JSON.parseObject(jsonstr, mClass);
            return t;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
