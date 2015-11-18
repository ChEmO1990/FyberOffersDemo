package com.anselmo.fyberoffersdemo.tests;


import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;

import com.anselmo.fyberoffersdemo.R;
import com.anselmo.fyberoffersdemo.ui.MainActivity;
import com.anselmo.fyberoffersdemo.utils.Constants;
import com.robotium.solo.Solo;

/**
 * Created by Anselmo Hernández Bazaldúa on 11/18/15.
 * chemo.baza@gmail.com
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;

    private EditText editUid;
    private EditText editApiKey;
    private EditText editAppId;
    private EditText editPub0;
    private Button btnGetOffers;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);

        solo = new Solo(getInstrumentation(), getActivity());

        editUid = (EditText) solo.getView(R.id.editUid);
        editApiKey = (EditText) solo.getView(R.id.editApiKey);
        editAppId = (EditText) solo.getView(R.id.editAppId);
        editPub0 = (EditText) solo.getView(R.id.editPub0);
        btnGetOffers = (Button) solo.getView(R.id.btnGetOffers);
    }

    @SmallTest
    public void test_getOffersByParametersDefault() {
        solo.enterText(editUid, Constants.UID);
        solo.enterText(editApiKey, Constants.API_KEY);
        solo.enterText(editAppId, Constants.APP_ID);
        solo.clickOnButton(0);
    }
}
