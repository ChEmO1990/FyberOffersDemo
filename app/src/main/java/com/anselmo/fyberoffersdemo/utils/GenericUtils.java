package com.anselmo.fyberoffersdemo.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.anselmo.fyberoffersdemo.net.DefaultParameter;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Anselmo Hernández Bazaldúa on 11/17/15.
 * chemo.baza@gmail.com
 */
public class GenericUtils {

    public static String getIP( Context context ) {
        WifiManager wifiMan = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInf = wifiMan.getConnectionInfo();
        int ipAddress = wifiInf.getIpAddress();
        return String.format("%d.%d.%d.%d", (ipAddress & 0xff),(ipAddress >> 8 & 0xff),(ipAddress >> 16 & 0xff),(ipAddress >> 24 & 0xff));
    }

    public static long getUnixFormatTimestamp() {
        return System.currentTimeMillis() / 1000L;
    }

    public static String getIMEI( Context context ) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

    public static String getSHA1FromParameters( DefaultParameter parameters ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String concatenate = null;

        if( TextUtils.isEmpty( parameters.getIp() ) ) {
            concatenate = "appid=" + parameters.getAppid()           + "&" +
                    "device_id="         + parameters.getDevice_id() + "&" +
                    "locale=" + parameters.getLocale()               + "&" +
                    "offer_types=" + parameters.getOffer_types()     + "&" +
                    "pub0=" + parameters.getPub0()                   + "&" +
                    "timestamp=" + parameters.getTimestamp()         + "&" +
                    "uid=" + parameters.getUid()                     + "&" +
                    parameters.getApiKey();
        } else {
            concatenate = "appid=" + parameters.getAppid()           + "&" +
                    "device_id="         + parameters.getDevice_id() + "&" +
                    "ip=" + parameters.getIp()                       + "&" +
                    "locale=" + parameters.getLocale()               + "&" +
                    "offer_types=" + parameters.getOffer_types()     + "&" +
                    "pub0=" + parameters.getPub0()                   + "&" +
                    "timestamp=" + parameters.getTimestamp()         + "&" +
                    "uid=" + parameters.getUid()                     + "&" +
                    parameters.getApiKey();
        }

        Log.i("URL_SHA", concatenate);

        return SimpleSHA1.getSHA1(concatenate);
    }
}
