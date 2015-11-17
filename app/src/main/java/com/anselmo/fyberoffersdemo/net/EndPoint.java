package com.anselmo.fyberoffersdemo.net;

import com.anselmo.fyberoffersdemo.utils.Constants;

/**
 * Created by Anselmo Hernández Bazaldúa on 11/17/15.
 * chemo.baza@gmail.com
 */
public class EndPoint {
    public static final String PATH_FYBER = Constants.API_HOST + "/" + Constants.API_VERSION + "/";

    public static String getUrlOffers( DefaultParameter parameters ) {
        return PATH_FYBER + "offers.json?appid=" + parameters.getAppid()     + "&" +
                            "device_id="         + parameters.getDevice_id() + "&" +
                            "ip=" + parameters.getIp()                       + "&" +
                            "locale=" + parameters.getLocale()               + "&" +
                            "offer_types=" + parameters.getOffer_types()     + "&" +
                            "pub0=" + parameters.getPub0()                   + "&" +
                            "timestamp=" + parameters.getTimestamp()         + "&" +
                            "uid=" + parameters.getUid()                     + "&" +
                            "hashkey=" + parameters.getHashkey();
    }
}
