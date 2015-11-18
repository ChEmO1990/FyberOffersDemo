package com.anselmo.fyberoffersdemo.tests;


import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
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
    private Button btnGetOffers;
    private CheckBox check;
    private Toolbar tool;

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
        tool = (Toolbar) solo.getView(R.id.toolbar_actionbar);
    }

    public void test_PreConditions() {
        assertNotNull("mFirstTestActivity is null", editUid);
        assertNotNull("mFirstTestActivity is null", editApiKey);
        assertNotNull("mFirstTestActivity is null", editAppId);
        assertNotNull("mFirstTestActivity is null", editPub0);
        assertNotNull("mFirstTestActivity is null", btnGetOffers);
        assertNotNull("mFirstTestActivity is null", check);
    }

    public void test_PreToolbar() {
        assertEquals("Message", getActivity().getString(R.string.activity_home), tool.getTitle().toString());
    }

    @SmallTest
    public void test_AutoCompleteDefaultParameters() {
        TouchUtils.clickView(this, check);
    }

    @SmallTest
    public void test_getOffersByParametersDefault() {
        solo.enterText(editUid, Constants.UID);
        solo.enterText(editApiKey, Constants.API_KEY);
        solo.enterText(editAppId, Constants.APP_ID);
        solo.clickOnButton(0);
        assertFalse(solo.waitForText(getActivity().getString(R.string.message_parameters_empty)));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
