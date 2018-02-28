package userRepo_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import users.User;
import users.UserRepository;

public class UserRepositoryTest {
    private UserRepository userRepository;
    private User[] testUsersSet;

    @Before
    public void setUp() throws Exception {
        User[] users = {new User(1111, "Petya", "pppT"), null, new User(1121, null, null), new User(3333, "Vasya", "pppV"), };
        userRepository = new UserRepository(users);
        testUsersSet = users;
    }


    @Test
    // userRepository getUsers test
    public void userRepositoryGetUsersTest(){
        System.out.println("UserRepository class getUsers method test");
        assertArrayEquals(testUsersSet, userRepository.getUsers());
    }

    @Test
    // userRepository getUserNames test
    public void userRepositoryGetUserNamesTest(){
        System.out.println("UserRepository class getUserNames method test");
//        int count = 0;
//        String[] names;
//        for (int i = 0; i < testUsersSet.length; i++)
//            if(testUsersSet[i].getName() != null)
//                count++;
//        count = 0;
//        names = new String[count];
//
//        for (int i = 0; i < testUsersSet.length; i++)
//            if(testUsersSet[i].getName() != null)
//                names[count++] = testUsersSet[i].getName();
        String[] names = {"Petya", null, "Vasya"};
        assertArrayEquals(names, userRepository.getUserNames());
    }

    @Test
    // userRepository getUserNames test
    public void userRepositoryGetUserIdsTest() {
        System.out.println("UserRepository class getUserIds method test");
        long[] ids = {1111, 1121, 3333};
        assertArrayEquals(ids, userRepository.getUserIds());
    }

    @Test
    public void UserRepositoryGetUserNameByIdTest_NULL_NAME() throws Exception {
        System.out.println("UserRepository class getUserNameById method test with NULL name");
        String nullName = null;
        assertEquals(nullName, userRepository.getUserNameById(1121));
    }

    @Test
    public void UserRepositoryGetUserNameByIdTest_RIGHT_NAME() throws Exception {
        System.out.println("UserRepository class getUserNameById method test with NOT NULL name");
        String name = "Vasya";
        assertEquals(name, userRepository.getUserNameById(3333));
    }

    @Test
    public void UserRepositoryGetUserNameByIdTest_WRONG_ID() throws Exception {
        System.out.println("UserRepository class getUserNameById method test with wrong ID");
        String name = null;
        assertEquals(name, userRepository.getUserNameById(9999));
    }


}
