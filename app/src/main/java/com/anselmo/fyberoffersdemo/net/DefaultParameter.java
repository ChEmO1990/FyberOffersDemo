package com.anselmo.fyberoffersdemo.net;

/**
 * Created by Anselmo Hernández Bazaldúa on 11/17/15.
 * chemo.baza@gmail.com
 */
public class DefaultParameter {
    private String appid;
    private String device_id;
    private String ip;
    private String locale;
    private String offer_types;
    private String pub0;
    private String timestamp;
    private String uid;
    private String hashkey;

    public DefaultParameter() {}

    public DefaultParameter(String appid, String device_id, String ip, String locale, String offer_types, String pub0, String timestamp, String uid) {
        this.appid = appid;
        this.device_id = device_id;
        this.ip = ip;
        this.locale = locale;
        this.offer_types = offer_types;
        this.pub0 = pub0;
        this.timestamp = timestamp;
        this.uid = uid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getOffer_types() {
        return offer_types;
    }

    public void setOffer_types(String offer_types) {
        this.offer_types = offer_types;
    }

    public String getPub0() {
        return pub0;
    }

    public void setPub0(String pub0) {
        this.pub0 = pub0;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHashkey() {
        return hashkey;
    }

    public void setHashkey(String hashkey) {
        this.hashkey = hashkey;
    }
}
