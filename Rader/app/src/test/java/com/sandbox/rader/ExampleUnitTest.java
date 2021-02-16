package com.sandbox.rader;

import android.content.Context;

import com.sandbox.rader.app.App;
import com.sandbox.rader.ui.MainActivity;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class ExampleUnitTest {


    private static final String FAKE_STRING = "Login was successful";

    @Test
    public void login() {
        MainActivity testMain = new MainActivity();
        testMain.userRepository.login("rade", "ribic");
        boolean testLoggedIn = App.getUserManager().isLoggedIn();
        assertTrue(testLoggedIn);
    }

    @Test
    public void testRegister() {
        MainActivity testMain = new MainActivity();
        testMain.userRepository.registerUser("dusan", "jovanovic");
        boolean testLoggedIn = App.getUserManager().isLoggedIn();
        assertTrue(testLoggedIn);
    }


}