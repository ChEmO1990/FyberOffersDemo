package com.anselmo.fyberoffersdemo.tests;


import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.CheckBox;
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
    private CheckBox check;
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
        check = (CheckBox) solo.getView(R.id.checkDefaultParams);
    }

    @SmallTest
    public void test_check_default_parameters() {
        TouchUtils.clickView(this, check); //Touch checkbox
        assertEquals(Constants.UID, editUid.getText().toString());
        assertEquals(Constants.API_KEY, editApiKey.getText().toString());
        assertEquals(Constants.APP_ID, editAppId.getText().toString());
    }

    @SmallTest
    public void test_uncheck_default_parameters() {
        if( !solo.isCheckBoxChecked(0) ) {
            assertEquals("", editUid.getText().toString());
            assertEquals("", editApiKey.getText().toString());
            assertEquals("", editAppId.getText().toString());
        }
    }

    @MediumTest
    public void test_values_get_offers() {
        TouchUtils.clickView(this, btnGetOffers);

        if( solo.isCheckBoxChecked(0)) {
            assertEquals(Constants.UID, editUid.getText().toString());
            assertEquals(Constants.API_KEY, editApiKey.getText().toString());
            assertEquals(Constants.APP_ID, editAppId.getText().toString());
        } else {
            solo.waitForText( getActivity().getString(R.string.message_parameters_empty));
            assertEquals("", editUid.getText().toString());
            assertEquals("", editApiKey.getText().toString());
            assertEquals("", editAppId.getText().toString());
        }
    }
}
