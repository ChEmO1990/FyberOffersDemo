package com.anselmo.fyberoffersdemo.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anselmo.fyberoffersdemo.R;
import com.anselmo.fyberoffersdemo.adapters.OfferAdapter;
import com.anselmo.fyberoffersdemo.models.JsonModelOffer;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OffersActivity extends BaseActivity {
    @Bind(R.id.recyclerOffers)
    RecyclerView recycler;

    private ArrayList<JsonModelOffer.Offer> items;
    private OfferAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        ButterKnife.bind(this);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        items = new ArrayList<>();

        adapter = new OfferAdapter(this, items);
        recycler.setAdapter(adapter);
    }
}
