package Common;

import android.content.Context;

/**
 * Created by GarsonZhang on 2016-04-19.
 */
public class Tools {
    public static boolean IsEmpty(String str) {
        boolean empty = true;
        //empty = str == nul || str.equals("");
        //empty = str.isEmpty();
        //empty = str == null || str == "";
        empty = str == null || str.length() <= 0;

        return empty;

    }

    public static boolean IsNotEmpty(String str) {
        return !IsEmpty(str);
    }

    public static boolean ValidateToToast(String str, Context context, CharSequence ErrorMsg) {
        boolean empty = IsEmpty(str);
        if (empty == true) {
            ToastEx.showShort(context, ErrorMsg);
        }
        return !empty;
    }
}
