package com.anselmo.fyberoffersdemo.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;

import com.anselmo.fyberoffersdemo.ui.OffersActivity;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * Created by Anselmo Hernández Bazaldúa on 11/18/15.
 * chemo.baza@gmail.com
 */
public class OffersActivityTest extends ActivityInstrumentationTestCase2<OffersActivity> {
    private Solo solo;

    public OffersActivityTest() {
        super(OffersActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);

        solo = new Solo(getInstrumentation(), getActivity());
    }

    @SmallTest
    public void chech() {
        Assert.assertTrue( 5 > 1 );
    }
}
