package com.anselmo.fyberoffersdemo.ui;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.anselmo.fyberoffersdemo.FyberApp;
import com.anselmo.fyberoffersdemo.R;
import com.anselmo.fyberoffersdemo.adapters.OfferAdapter;
import com.anselmo.fyberoffersdemo.models.JsonModelOffer;
import com.anselmo.fyberoffersdemo.net.DefaultParameter;
import com.anselmo.fyberoffersdemo.net.EndPoint;
import com.anselmo.fyberoffersdemo.net.GsonRequest;
import com.anselmo.fyberoffersdemo.utils.Constants;
import com.anselmo.fyberoffersdemo.utils.GenericUtils;
import com.anselmo.fyberoffersdemo.utils.NetworkUtil;
import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;
import com.vlonjatg.progressactivity.ProgressActivity;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OffersActivity extends ToolbarControlBaseActivity<ObservableRecyclerView> {
    @Bind(R.id.rvOffers)
    ObservableRecyclerView recyclerView;

    @Bind(R.id.progress)
    ProgressActivity progressView;

    private ArrayList<JsonModelOffer.Offer> items;
    private OfferAdapter adapter;
    private DefaultParameter parameters;
    private String hashKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = getToolbar();
        toolbar.setTitle(R.string.activity_offers);
        toolbar.setNavigationIcon(R.mipmap.ic_up);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Init params
        parameters = new DefaultParameter();

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            //Pick up parameters by user
            parameters.setUid(extras.getString(Constants.INTENT_EXTRA_UID));
            parameters.setApiKey(extras.getString(Constants.INTENT_EXTRA_API_KEY));
            parameters.setAppid(extras.getString(Constants.INTENT_EXTRA_APPID));
            parameters.setPub0(extras.getString(Constants.INTENT_EXTRA_PUB0));

            //Set others parameters
            parameters.setDevice_id(GenericUtils.getIMEI(this));

            //Get ip
            String currentIp = GenericUtils.getIP(this);

            //Check if the device have an valid ip
            if (!currentIp.equals("0.0.0.0")) {
                parameters.setIp(currentIp);
            } else {
                parameters.setIp(null);
            }

            parameters.setLocale(Constants.LOCALE); //Default Example PDF
            parameters.setOffer_types(Constants.OFFER_TYPE); //Default Example PDF
            parameters.setTimestamp(String.valueOf(GenericUtils.getUnixFormatTimestamp()));

            try {
                hashKey = GenericUtils.getSHA1FromParameters(parameters);
                parameters.setHashkey(hashKey);
            } catch (NoSuchAlgorithmException error1) {
                error1.printStackTrace();

            } catch (UnsupportedEncodingException error2) {
                error2.printStackTrace();
            } finally {
                //Make Request
                doRequestOffers();
            }
        }
    }

    @Override
    protected ObservableRecyclerView createScrollable() {
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        items = new ArrayList<>();

        adapter = new OfferAdapter(this, items);
        recyclerView.setAdapter(adapter);

        return recyclerView;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_offers;
    }

    private Response.Listener<JsonModelOffer> successListener() {
        return new Response.Listener<JsonModelOffer>() {
            @Override
            public void onResponse(JsonModelOffer response) {
                if( response.getOffers().isEmpty() ) {
                    progressView.showEmpty(getResources().getDrawable(R.mipmap.ic_empty), getString(R.string.no_offers), getString(R.string.message_no_offers));
                } else {
                    items.addAll(response.getOffers());
                    adapter.notifyDataSetChanged();
                    progressView.showContent();
                }
            }
        };
    }

    private Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

                String strError = null;

                switch ( error.networkResponse.statusCode ) {
                    case 400: strError = "400 Bad Request "; break;
                    case 401: strError = "401 Unauthorized "; break;
                    case 404: strError = "404 Not found "; break;
                    case 500: strError = "500 Internal Server Error "; break;
                    case 502: strError = "502 Bad Gateway "; break;
                }

                progressView.showError(getResources().getDrawable(R.mipmap.ic_error), getString(R.string.title_error) + strError,
                        getString(R.string.message_error),
                        getString(R.string.try_again), errorClickListenerAgain);
            }
        };
    }

    private void doRequestOffers() {
        progressView.showLoading();

        if (NetworkUtil.getConnectivityStatus(this) == NetworkUtil.TYPE_NOT_CONNECTED) {
            progressView.showError(getResources().getDrawable(R.mipmap.ic_error), getString(R.string.no_connection),
                    getString(R.string.message_no_connection),
                    getString(R.string.message_try_again), errorClickListener);
        } else {
            GsonRequest<JsonModelOffer> request = new GsonRequest<>(Request.Method.GET,
                    EndPoint.getUrlOffers(parameters),
                    JsonModelOffer.class,
                    successListener(),
                    errorListener(),
                    null,
                    Request.Priority.IMMEDIATE);
            FyberApp.getInstance().addToRequestQueue(request);
        }
    }

    private View.OnClickListener errorClickListenerAgain = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    private View.OnClickListener errorClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            doRequestOffers();
        }
    };
}
