package com.anselmo.fyberoffersdemo.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anselmo.fyberoffersdemo.R;
import com.anselmo.fyberoffersdemo.models.JsonModelOffer;
import com.squareup.picasso.Picasso;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.List;

/**
 * Created by naranya on 9/28/15.
 */
public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {
    private Activity context;
    private List<JsonModelOffer.Offer> items;

    public OfferAdapter(Activity context, List<JsonModelOffer.Offer> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public OfferAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_offer, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(OfferAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        JsonModelOffer.Offer item = items.get(position);

        Picasso.with(context)
                .load(item.getThumbnail().getHires())
                .resize(100,100)
                .placeholder(R.mipmap.ic_launcher)
                .into(viewHolder.imageOffer);

        viewHolder.title.setText(item.getTitle());
        viewHolder.teaser.setText( item.getTeaser() );
        viewHolder.payout.setText( item.getPayout() );
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageOffer;
        public TextView title;
        public TextView teaser;
        public TextView payout;

        public ViewHolder(View itemView) {

            super(itemView);

            imageOffer = (ImageView) itemView.findViewById(R.id.item_icon_offer);
            title = (TextView) itemView.findViewById(R.id.item_title_offer);
            teaser = (TextView) itemView.findViewById(R.id.item_teaser_offer);
            payout = (TextView) itemView.findViewById(R.id.item_payout_offer);

            title.setTypeface(EasyFonts.robotoBold(context));
            teaser.setTypeface(EasyFonts.robotoLight(context));
            payout.setTypeface(EasyFonts.robotoThin(context));

            // Attach a click listener to the entire row view
            itemView.setOnClickListener(this);
        }

        // Handles the row being being clicked
        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
        }
    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return items.size();
    }
}
