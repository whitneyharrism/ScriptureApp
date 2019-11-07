package com.example.scripturestudyapp;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class QuizTest {
    @Test
    public void isDataSaving() throws JSONException {
        JSONObject jo = new JSONObject();

        // putting data to JSONObject
        jo.put("question 1", "answer choice");
        assertNotNull(jo);
    }
}