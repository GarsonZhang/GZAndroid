package com.garsonzhang.Common;

/**
 * Created by GarsonZhang on 2016-04-19.
 */

import android.content.Context;
import android.widget.Toast;

/**
 * Created by gz on 2016-04-01.
 */
public class ToastEx {

    /**
     * 短时间显示Toast
     * @param context 上下文
     * @param message 消息
     */
    public  static  void showShort(Context context, CharSequence message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    /**
     * 上时间显示Toast
     * @param context 上下文
     * @param message 消息
     */
    public  static  void showLong(Context context,CharSequence message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    /**
     * 自定义显示Toast时间
     * @param context 上下文
     * @param message 消息
     * @param duration 显示时间
     */
    public  static  void show(Context context,CharSequence message,int duration){
        Toast.makeText(context,message,duration).show();
    }
}
