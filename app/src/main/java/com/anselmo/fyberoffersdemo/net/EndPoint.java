package com.anselmo.fyberoffersdemo.net;

/**
 * Created by Anselmo Hernández Bazaldúa on 11/17/15.
 * chemo.baza@gmail.com
 */
public class EndPoint {
    public static final String PATH_FYBER = Constants.API_HOST + "/" + Constants.API_VERSION + "/";

    public static String getCategoriesUrl() {
        return PATH_FYBER + "offers.json?";
    }
}
