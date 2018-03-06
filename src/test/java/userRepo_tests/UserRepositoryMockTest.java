package userRepo_tests;

import org.junit.Before;
import org.junit.Test;
import users.User;
import users.UserRepository;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class UserRepositoryMockTest {
    private UserRepository uRepo;
    private User[] testUsersSet;
    private User testUser;

    @Before
    public void setUp() throws Exception {
        testUser = new User(1111, "Petya", "pppT");
        User[] users = {testUser, null, new User(1121, null, null), new User(3333, "Vasya", "pppV"), };
        testUsersSet = users;
        uRepo = mock(UserRepository.class);
    }


    @Test
    // userRepository getUsers test
    public void UR_GetUsersTest(){
        System.out.println("Mock of UserRepository class getUsers method test");

        when(uRepo.getUsers()).thenReturn(testUsersSet);
        assertArrayEquals(testUsersSet, uRepo.getUsers());
        verify(uRepo).getUsers();
    }

    @Test
    // userRepository getUserNames test
    public void UR_GetUserNamesTest(){
        System.out.println("Mock of UserRepository class getUserNames method test");

        String[] names = {"Petya", null, "Vasya"};
        when(uRepo.getUserNames()).thenReturn(names);
        assertArrayEquals(names, uRepo.getUserNames());
        verify(uRepo).getUserNames();
    }

    @Test
    // userRepository getUserNames test
    public void UR_GetUserIdsTest() {
        System.out.println("Mock of UserRepository class getUserIds method test");
        long[] ids = {1111, 1121, 3333};
        when(uRepo.getUserIds()).thenReturn(ids);
        assertArrayEquals(ids, uRepo.getUserIds());
        verify(uRepo).getUserIds();
    }

    @Test
    public void UR_GetUserNameByIdTest_NULL_NAME() throws Exception {
        System.out.println("Mock of UserRepository class getUserNameById method test with NULL name");
        String nullName = null;
        when(uRepo.getUserNameById(1121)).thenReturn(nullName);
        assertEquals(nullName, uRepo.getUserNameById(1121));
        verify(uRepo).getUserNameById(1121);
    }

    @Test
    public void UR_GetUserNameByIdTest_RIGHT_NAME() throws Exception {
        System.out.println("Mock of UserRepository class getUserNameById method test with NOT NULL name");
        String name = "Vasya";
        when(uRepo.getUserNameById(3333)).thenReturn(name);
        assertEquals(name, uRepo.getUserNameById(3333));
        verify(uRepo).getUserNameById(3333);
    }

    @Test
    public void UR_GetUserNameByIdTest_WRONG_ID() throws Exception {
        System.out.println("Mock of UserRepository class getUserNameById method test with wrong ID");
        String name = null;
        when(uRepo.getUserNameById(9999)).thenReturn(name);
        assertEquals(name, uRepo.getUserNameById(9999));
        verify(uRepo).getUserNameById(9999);
    }

    @Test
    public void UR_getUserByNameTest_RIGHT_NAME() throws Exception {
        System.out.println("Mock of UserRepository class getUserByName method test with RIGHT name");
        when(uRepo.getUserByName("Petya")).thenReturn(testUser);
        assertEquals(testUser, uRepo.getUserByName("Petya"));
        verify(uRepo).getUserByName("Petya");
    }

    @Test
    public void UR_getUserByNameTest_WRONG_NAME() throws Exception {
        System.out.println("Mock of UserRepository class getUserByName method test with wrong name");
        User user = null;
        when(uRepo.getUserByName("Absent name")).thenReturn(null);
        assertEquals(user, uRepo.getUserByName("Absent name"));
        verify(uRepo).getUserByName("Absent name");
    }

    @Test
    public void UR_getUserByNameTest_NULL_NAME() throws Exception {
        System.out.println("Mock of UserRepository class getUserByName method test with NULL name");
        User user = null;
        when(uRepo.getUserByName(null)).thenReturn(null);
        assertEquals(user, uRepo.getUserByName(null));
        verify(uRepo).getUserByName(null);
    }

    @Test
    public void UR_getUserBySessionIdTest_RIGHT_SESSION() throws Exception {
        System.out.println("Mock of UserRepository class getUserBySessionId method test with RIGHT session");

        assertEquals(testUser, uRepo.getUserBySessionId("pppT"));
    }

    @Test
    public void UR_getUserBySessionIdTest_NULL_SESSION() throws Exception {
        System.out.println("UserRepository class getUserBySessionId method test with NULL session");
        User user = null;
        assertEquals(user, uRepo.getUserBySessionId(null));
    }

    @Test
    public void UR_getUserBySessionId_WRONG_SESSION() throws Exception {
        System.out.println("UserRepository class getUserBySessionId method test with WRONG session");
        User user = null;
        assertEquals(user, uRepo.getUserBySessionId("pppTTppp"));
    }

    @Test
    public void UR_findByIdTest_RIGHT_ID() throws Exception {
        System.out.println("UserRepository class findById method test with RIGHT ID");
        assertEquals(testUser, uRepo.findById(1111));
    }

    @Test
    public void UR_findByIdTest_WRONG_ID() throws Exception {
        System.out.println("UserRepository class findById method test with WRONG ID");
        User user = null;
        assertEquals(user, uRepo.findById(0));
    }

    @Test
    public void UR_saveTest_RIGHT_USER() throws Exception {
        System.out.println("UserRepository class save method test with RIGHT USER");
        User newUser = new User(1199, "Piter", "gggPT");
        assertEquals(newUser, uRepo.save(newUser));
    }

    @Test
    public void UR_saveTest_ID_DUPLICATE() throws Exception {
        System.out.println("UserRepository class save method test with id duplicate");
        User newUser = new User(1111, "Piter", "gggPT");
        User result = null;
        assertEquals(result, uRepo.save(newUser));
    }

    @Test
    public void UR_saveTest_NULL_USER() throws Exception {
        System.out.println("UserRepository class save method test with USER USER");
        User result = null;
        assertEquals(result, uRepo.save(null));
    }

    @Test
    public void UR_saveTest_EMPTY_REPOSITORY() throws Exception {
        System.out.println("UserRepository class save method test with EMPTY REPOSITORY");
        User newUser = new User(1111, "Piter", "gggPT");
        assertEquals(newUser, uRepo.save(newUser));
    }

    @Test
    public void UR_saveTest_NULL_NAME_USER() throws Exception {
        System.out.println("UserRepository class save method test with NULL NAME USER");
        User newUser = new User(1199, null, "gggPT");
        assertEquals(newUser, uRepo.save(newUser));
    }

    @Test
    public void UR_saveTest_NULL_SESSION_ID_USER() throws Exception {
        System.out.println("UserRepository class save method test with NULL SESSION ID USER");
        User newUser = new User(1199, "Piter", null);
        assertEquals(newUser, uRepo.save(newUser));
    }

    @Test
    public void UR_updateTest_RIGHT_USER() throws Exception {
        System.out.println("UserRepository class save method test with RIGHT USER");
        User newUser = new User(1111, "Putya Hakuna", "pppT");
        assertEquals(newUser, uRepo.update(newUser));
    }

    @Test
    public void UR_updateTest_NULL_USER() throws Exception {
        System.out.println("UserRepository class save method test with NULL USER");
        User newUser = null;
        assertEquals(newUser, uRepo.update(newUser));
    }

    @Test
    public void UR_updateTest_WRONG_USER() throws Exception {
        System.out.println("UserRepository class save method test with WRONG USER (by ID)");
        User newUser = new User(1199, "Putya Hakuna", "pppT");;
        User resultUser = null;
        assertEquals(resultUser, uRepo.update(newUser));
    }

    @Test
    public void UR_updateTest_EMPTY_REPOSITORY() throws Exception {
        System.out.println("UserRepository class update method test with EMPTY REPOSITORY");
        User newUser = new User(1111, "Piter", "gggPT");
        User resultUser = null;
        assertEquals(resultUser, uRepo.update(newUser));
    }

    @Test
    public void UR_deleteTest_RIGHT_ID() throws Exception {
        System.out.println("UserRepository class delete method test with RIGHT ID");
        User resultUser = null;
        assertEquals(resultUser, uRepo.findById(1111));
    }
}
