package com.anselmo.fyberoffersdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.anselmo.fyberoffersdemo.R;
import com.anselmo.fyberoffersdemo.utils.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @Bind(R.id.editUid)
    EditText editUid;

    @Bind(R.id.editApiKey)
    EditText editApiKey;

    @Bind(R.id.editAppId)
    EditText editAppId;

    @Bind(R.id.editPub0)
    EditText editPub0;

    @Bind(R.id.checkDefaultParams)
    CheckBox checkDefault;

    @Bind(R.id.btnGetOffers)
    Button btnOffers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkDefaultParams:
                if ( !checked ) {
                    editUid.setText("");
                    editApiKey.setText("");
                    editAppId.setText("");
                    editPub0.setText("");
                } else {
                    editUid.setText(Constants.UID);
                    editApiKey.setText(Constants.API_KEY);
                    editAppId.setText(Constants.APP_ID);
                }
                break;
        }
    }

    @OnClick(R.id.btnGetOffers) void getAllOffers() {

        /**
         * Params to be used
         * format: json
         * appid: Application ID, provided as simple data
         * uid: User ID, provided as simple data
         * device_id: use Android advertising identifier
         * locale: provided as simple data
         * ip: provided as simple data
         * offer_types: 112
         */
        Intent offersIntent = new Intent(this, OffersActivity.class);
        offersIntent.putExtra(Constants.INTENT_EXTRA_UID, editUid.getText().toString().trim());
        offersIntent.putExtra(Constants.INTENT_EXTRA_API_KEY, editApiKey.getText().toString().trim());
        offersIntent.putExtra(Constants.INTENT_EXTRA_APPID, editAppId.getText().toString().trim());
        offersIntent.putExtra(Constants.INTENT_EXTRA_PUB0, editPub0.getText().toString().trim());
        startActivity(offersIntent);
    }
}
