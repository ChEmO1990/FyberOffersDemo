package com.anselmo.fyberoffersdemo.models;

import java.util.ArrayList;

/**
 * Created by Anselmo Hernández Bazaldúa on 11/17/15.
 * chemo.baza@gmail.com
 */
public class JsonModelOffer {
    private String code;
    private String message;
    private String count;
    private String pages;
    private Information information;
    private ArrayList<Offer> offers;

    public JsonModelOffer() {}

    public JsonModelOffer(String code, String message, String count, String pages, Information information, ArrayList<Offer> offers) {
        this.code = code;
        this.message = message;
        this.count = count;
        this.pages = pages;
        this.information = information;
        this.offers = offers;
    }

    //Information Node
    public class Information {
        private String app_name;
        private String appid;
        private String virtual_currency;
        private String virtual_currency_sale_enabled;
        private String country;
        private String language;
        private String support_url;

        public Information() {}

        public Information(String app_name, String appid, String virtual_currency, String virtual_currency_sale_enabled, String country, String language, String support_url) {
            this.app_name = app_name;
            this.appid = appid;
            this.virtual_currency = virtual_currency;
            this.virtual_currency_sale_enabled = virtual_currency_sale_enabled;
            this.country = country;
            this.language = language;
            this.support_url = support_url;
        }

        //Getters and Setters
        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getVirtual_currency() {
            return virtual_currency;
        }

        public void setVirtual_currency(String virtual_currency) {
            this.virtual_currency = virtual_currency;
        }

        public String getVirtual_currency_sale_enabled() {
            return virtual_currency_sale_enabled;
        }

        public void setVirtual_currency_sale_enabled(String virtual_currency_sale_enabled) {
            this.virtual_currency_sale_enabled = virtual_currency_sale_enabled;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getSupport_url() {
            return support_url;
        }

        public void setSupport_url(String support_url) {
            this.support_url = support_url;
        }
    }

    //Offers Node
    public class Offer {
        private String title;
        private String offer_id;
        private String teaser;
        private String required_actions;
        private String link;
        private ArrayList<OfferType> offer_types;
        private String payout;
        private TimeToPay time_to_payout;
        private Thumbnail thumbnail;
        private String store_id;

        public Offer() {}

        public Offer(String title, String offer_id, String teaser, String required_actions, String link, ArrayList<OfferType> offer_types, String payout, TimeToPay time_to_payout, Thumbnail thumbnail, String store_id) {
            this.title = title;
            this.offer_id = offer_id;
            this.teaser = teaser;
            this.required_actions = required_actions;
            this.link = link;
            this.offer_types = offer_types;
            this.payout = payout;
            this.time_to_payout = time_to_payout;
            this.thumbnail = thumbnail;
            this.store_id = store_id;
        }

        //Offer Types Node
        public class OfferType {
            private String offer_type_id;
            private String readable;

            public OfferType() {
            }

            public OfferType(String offer_type_id, String readable) {
                this.offer_type_id = offer_type_id;
                this.readable = readable;
            }

            public String getOffer_type_id() {
                return offer_type_id;
            }

            public void setOffer_type_id(String offer_type_id) {
                this.offer_type_id = offer_type_id;
            }

            public String getReadable() {
                return readable;
            }

            public void setReadable(String readable) {
                this.readable = readable;
            }
        }

        public class TimeToPay {
            private String amount;
            private String readable;

            public TimeToPay() {}

            public TimeToPay(String amount, String readable) {
                this.amount = amount;
                this.readable = readable;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getReadable() {
                return readable;
            }

            public void setReadable(String readable) {
                this.readable = readable;
            }
        }

        public class Thumbnail {
            private String lowres;
            private String hires;

            public Thumbnail() {}

            public Thumbnail(String lowres, String hires) {
                this.lowres = lowres;
                this.hires = hires;
            }

            public String getLowres() {
                return lowres;
            }

            public void setLowres(String lowres) {
                this.lowres = lowres;
            }

            public String getHires() {
                return hires;
            }

            public void setHires(String hires) {
                this.hires = hires;
            }
        }

        //Getters and Setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOffer_id() {
            return offer_id;
        }

        public void setOffer_id(String offer_id) {
            this.offer_id = offer_id;
        }

        public String getTeaser() {
            return teaser;
        }

        public void setTeaser(String teaser) {
            this.teaser = teaser;
        }

        public String getRequired_actions() {
            return required_actions;
        }

        public void setRequired_actions(String required_actions) {
            this.required_actions = required_actions;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public ArrayList<OfferType> getOffer_types() {
            return offer_types;
        }

        public void setOffer_types(ArrayList<OfferType> offer_types) {
            this.offer_types = offer_types;
        }

        public String getPayout() {
            return payout;
        }

        public void setPayout(String payout) {
            this.payout = payout;
        }

        public TimeToPay getTime_to_payout() {
            return time_to_payout;
        }

        public void setTime_to_payout(TimeToPay time_to_payout) {
            this.time_to_payout = time_to_payout;
        }

        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }
    }

    //Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }

    public void setOffers(ArrayList<Offer> offers) {
        this.offers = offers;
    }
}