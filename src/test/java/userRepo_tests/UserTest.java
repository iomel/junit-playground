package userRepo_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import users.User;

public class UserTest {
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User(123, "Ivan", "abcd");
    }


    @Test
    public void user_getIdTest () {
        System.out.println("User class getId method test");
        assertEquals(123, user.getId());
    }

    @Test
    public void user_getNameTest () {
        System.out.println("User class getName method test");
        assertEquals("Ivan", user.getName());
    }

    @Test
    public void user_getSessionIdTest () {
        System.out.println("User class getSessionId method test");
        assertEquals("abcd", user.getSessionId());
    }



}
