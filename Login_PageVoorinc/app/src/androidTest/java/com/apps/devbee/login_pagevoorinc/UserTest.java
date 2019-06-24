package com.apps.devbee.login_pagevoorinc;

import com.apps.devbee.login_pagevoorinc.utils.User;



import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User user;
    @Before
    public void SetUp(){
        user=new User();
    }

    @Test
    public void returnName(){
        String name=user.getUsername();
        assertEquals(name, "Test");
    }

    @Test
    public void testUser_id(){
        String id=user.getUser_id();
        assertEquals(id, null);
    }
}
