package com.example.scripturestudyapp;

import org.junit.Test;
import java.util.regex.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EmailTest {

    @Test
    public void email_isCorrect() {
        //if(username.contains("@")) {
         //   System.out.println("it is an email");
        //}
        //if(!username.contains("@")){
        //    System.out.println(("its not an email"));
        //}

        Pattern p = Pattern.compile(".+@.+(\\.com)");//. represents single character
        Matcher m = p.matcher("cody@gmail.com");
        assertTrue(m.matches());



        }


    }


