package GZAndroid.Library.gztest;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * Created by GarsonZhang on 2016-04-19.
 */
public class Callback<T> implements com.squareup.okhttp.Callback {
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

    @Override
    public void onFailure(Request request, IOException e) {
        Message message = Message.obtain();
        message.what = CALLBACK_FAILED;
        message.obj = e;
        //mHandler.sendMessage(message);
    }

    @Override
    public void onResponse(Response response) throws IOException {
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

    private Handler mHandler = new UIHandler(this);

    static class UIHandler<T> extends Handler {
        private WeakReference mWeakReference;

        public UIHandler(GZAndroid.Library.gztest.Callback<T> callback) {
            super(Looper.getMainLooper());
            mWeakReference = new WeakReference(callback);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CALLBACK_SUCCESSFUL: {
                    T t = (T) msg.obj;
                    GZAndroid.Library.gztest.Callback callback = (GZAndroid.Library.gztest.Callback) mWeakReference.get();
                    if (callback != null) {
                        callback.onResponse(t);
                    }
                    break;
                }
                case CALLBACK_FAILED: {
                    IOException e = (IOException) msg.obj;
                    GZAndroid.Library.gztest.Callback callback = (GZAndroid.Library.gztest.Callback) mWeakReference.get();
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
