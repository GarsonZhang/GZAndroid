package com.garsonzhang.Library.gztest;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by GarsonZhang on 2016-04-19.
 */
public class Callback<T> implements okhttp3.Callback {
    private Parser<T> mParser;

    private static final int CALLBACK_SUCCESSFUL = 0x01;
    private static final int CALLBACK_FAILED = 0x02;

    public Callback(Parser<T> mParser) {
        if (mParser == null) {
            throw new IllegalArgumentException("Parser cna't be null");
        }
        this.mParser = mParser;
    }

    public void onResponse(T t) {

    }

    public void onFailure(IOException e) {

    }

    private Handler mHandler = new UIHandler(this);

    @Override
    public void onFailure(Call call, IOException e) {
        Message message = Message.obtain();
        message.what = CALLBACK_FAILED;
        message.obj = e;
        //mHandler.sendMessage(message);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (response.isSuccessful()) {
            T parseResult = mParser.parse(response);
            Message message = Message.obtain();
            message.what = CALLBACK_SUCCESSFUL;
            message.obj = parseResult;
            mHandler.sendMessage(message);
        } else {
            Message message = Message.obtain();
            message.what = CALLBACK_FAILED;
            mHandler.sendMessage(message);
        }
    }

    static class UIHandler<T> extends Handler {
        private WeakReference mWeakReference;

        public UIHandler(com.garsonzhang.Library.gztest.Callback<T> callback) {
            super(Looper.getMainLooper());
            mWeakReference = new WeakReference(callback);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CALLBACK_SUCCESSFUL: {
                    T t = (T) msg.obj;
                    com.garsonzhang.Library.gztest.Callback callback = (com.garsonzhang.Library.gztest.Callback) mWeakReference.get();
                    if (callback != null) {
                        callback.onResponse(t);
                    }
                    break;
                }
                case CALLBACK_FAILED: {
                    IOException e = (IOException) msg.obj;
                    com.garsonzhang.Library.gztest.Callback callback = (com.garsonzhang.Library.gztest.Callback) mWeakReference.get();
                    if (callback != null) {
                        callback.onFailure(e);
                    }
                    break;
                }
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    }
}
