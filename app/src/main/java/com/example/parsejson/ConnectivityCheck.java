/**
 *
 */
package com.example.parsejson;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author lynn
 */
public class ConnectivityCheck {
    Context context;

    ConnectivityCheck(Context context) {
        this.context = context;
    }

    public boolean isNetworkReachable() {
        ConnectivityManager mManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo current = mManager.getActiveNetworkInfo();
        if (current == null) {
            return false;
        }
        return (current.getState() == NetworkInfo.State.CONNECTED);
    }

    /**
     * @return very cheesy, splash up a big cant do it screen instead of doing something useful
     * like waiting a bit, testing connectivity, and then trying again
     */
    public boolean isNetworkReachableAlertUserIfNot() {
        boolean isReachable = isNetworkReachable();
        if (!isReachable) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("No Network Connection");
            builder.setMessage("The Network is unavailable. Please try your request again later.");
            builder.setPositiveButton("OK", null);
            builder.create().show();
        }
        return isReachable;
    }

    /***
     *
     * @return
     */
    public boolean isWifiReachable() {
        ConnectivityManager mManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo current = mManager.getActiveNetworkInfo();
        if (current == null) {
            return false;
        }
        return (current.getType() == ConnectivityManager.TYPE_WIFI);
    }
}
