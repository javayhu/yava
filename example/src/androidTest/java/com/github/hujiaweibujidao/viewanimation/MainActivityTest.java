package com.github.hujiaweibujidao.viewanimation;

import android.test.AndroidTestCase;
import android.util.Log;
import android.widget.Toast;

/**
 * @author hujiawei 16/5/25
 */
public class MainActivityTest extends AndroidTestCase {

    public void setUp() throws Exception {

    }

    public void tearDown() throws Exception {

    }

    public void testOnCreate() throws Exception {
        Log.d("test","ok");
        Toast.makeText(getContext(), "test ok", Toast.LENGTH_SHORT).show();
    }
}