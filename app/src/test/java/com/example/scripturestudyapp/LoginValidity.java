package com.example.scripturestudyapp;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;


public class LoginValidity {
    @Test
    //Test if the user exists in the database
    public void testLoginValidity(){
        List users = new ArrayList();
        users.add("bob@gmail.com");
        //System.out.println("hello");
        assertTrue(users.contains("bob@gmail.com"));
    }

}
