package userRepo_tests;

import org.junit.Before;
import org.junit.Test;
import users.User;
import users.UserRepository;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class UserRepositoryTest {
    private UserRepository userRepository;
    private User[] testUsersSet;
    private User testUser;

    @Before
    public void setUp() throws Exception {
        testUser = new User(1111, "Petya", "pppT");
        User[] users = {testUser, null, new User(1121, null, null), new User(3333, "Vasya", "pppV"), };
        testUsersSet = users;
        userRepository = new UserRepository(users);
    }


    @Test
    // userRepository getUsers test
    public void UR_GetUsersTest(){
        System.out.println("UserRepository class getUsers method test");
        assertArrayEquals(testUsersSet, userRepository.getUsers());
    }

    @Test
    // userRepository getUserNames test
    public void UR_GetUserNamesTest(){
        System.out.println("UserRepository class getUserNames method test");
        String[] names = {"Petya", null, "Vasya"};
        assertArrayEquals(names, userRepository.getUserNames());
    }

    @Test
    // userRepository getUserNames test
    public void UR_GetUserIdsTest() {
        System.out.println("UserRepository class getUserIds method test");
        long[] ids = {1111, 1121, 3333};
        assertArrayEquals(ids, userRepository.getUserIds());
    }

    @Test
    public void UR_GetUserNameByIdTest_NULL_NAME() throws Exception {
        System.out.println("UserRepository class getUserNameById method test with NULL name");
        String nullName = null;
        assertEquals(nullName, userRepository.getUserNameById(1121));
    }

    @Test
    public void UR_GetUserNameByIdTest_RIGHT_NAME() throws Exception {
        System.out.println("UserRepository class getUserNameById method test with NOT NULL name");
        String name = "Vasya";
        assertEquals(name, userRepository.getUserNameById(3333));
    }

    @Test
    public void UR_GetUserNameByIdTest_WRONG_ID() throws Exception {
        System.out.println("UserRepository class getUserNameById method test with wrong ID");
        String name = null;
        assertEquals(name, userRepository.getUserNameById(9999));
    }

    @Test
    public void UR_getUserByNameTest_RIGHT_NAME() throws Exception {
        System.out.println("UserRepository class getUserByName method test with RIGHT name");
        assertEquals(testUser, userRepository.getUserByName("Petya"));

    }

    @Test
    public void UR_getUserByNameTest_WRONG_NAME() throws Exception {
        System.out.println("UserRepository class getUserByName method test with wrong name");
        User user = null;
        assertEquals(user, userRepository.getUserByName("Absent name"));
    }

    @Test
    public void UR_getUserByNameTest_NULL_NAME() throws Exception {
        System.out.println("UserRepository class getUserByName method test with NULL name");
        User user = null;
        assertEquals(user, userRepository.getUserByName(null));
    }

    @Test
    public void UR_getUserBySessionIdTest_RIGHT_SESSION() throws Exception {
        System.out.println("UserRepository class getUserBySessionId method test with RIGHT session");
        assertEquals(testUser, userRepository.getUserBySessionId("pppT"));
    }

    @Test
    public void UR_getUserBySessionIdTest_NULL_SESSION() throws Exception {
        System.out.println("UserRepository class getUserBySessionId method test with NULL session");
        User user = null;
        assertEquals(user, userRepository.getUserBySessionId(null));
    }

    @Test
    public void UR_getUserBySessionId_WRONG_SESSION() throws Exception {
        System.out.println("UserRepository class getUserBySessionId method test with WRONG session");
        User user = null;
        assertEquals(user, userRepository.getUserBySessionId("pppTTppp"));
    }

    @Test
    public void UR_findByIdTest_RIGHT_ID() throws Exception {
        System.out.println("UserRepository class findById method test with RIGHT ID");
        assertEquals(testUser, userRepository.findById(1111));
    }

    @Test
    public void UR_findByIdTest_WRONG_ID() throws Exception {
        System.out.println("UserRepository class findById method test with WRONG ID");
        User user = null;
        assertEquals(user, userRepository.findById(0));
    }

    @Test
    public void UR_saveTest_RIGHT_USER() throws Exception {
        System.out.println("UserRepository class save method test with RIGHT USER");
        User newUser = new User(1199, "Piter", "gggPT");
        assertEquals(newUser, userRepository.save(newUser));
    }

    @Test
    public void UR_saveTest_ID_DUPLICATE() throws Exception {
        System.out.println("UserRepository class save method test with id duplicate");
        User newUser = new User(1111, "Piter", "gggPT");
        User result = null;
        assertEquals(result, userRepository.save(newUser));
    }

    @Test
    public void UR_saveTest_NULL_USER() throws Exception {
        System.out.println("UserRepository class save method test with USER USER");
        User result = null;
        // Exception TODO
        assertEquals(result, userRepository.save(null));
    }

    @Test
    public void UR_saveTest_EMPTY_REPOSITORY() throws Exception {
        System.out.println("UserRepository class save method test with EMPTY REPOSITORY");
        User newUser = new User(1111, "Piter", "gggPT");
        User[] newUsers = new User[10];
        UserRepository newRepo = new UserRepository(newUsers);
        assertEquals(newUser, newRepo.save(newUser));
    }

    @Test
    public void UR_saveTest_NULL_NAME_USER() throws Exception {
        System.out.println("UserRepository class save method test with NULL NAME USER");
        User newUser = new User(1199, null, "gggPT");
        assertEquals(newUser, userRepository.save(newUser));
    }

    @Test
    public void UR_saveTest_NULL_SESSION_ID_USER() throws Exception {
        System.out.println("UserRepository class save method test with NULL SESSION ID USER");
        User newUser = new User(1199, "Piter", null);
        assertEquals(newUser, userRepository.save(newUser));
    }

    @Test
    public void UR_updateTest_RIGHT_USER() throws Exception {
        System.out.println("UserRepository class save method test with RIGHT USER");
        User newUser = new User(1111, "Putya Hakuna", "pppT");
        assertEquals(newUser, userRepository.update(newUser));
    }

    @Test
    public void UR_updateTest_NULL_USER() throws Exception {
        System.out.println("UserRepository class save method test with NULL USER");
        User newUser = null;
        assertEquals(newUser, userRepository.update(newUser));
    }

    @Test
    public void UR_updateTest_WRONG_USER() throws Exception {
        System.out.println("UserRepository class save method test with WRONG USER (by ID)");
        User newUser = new User(1199, "Putya Hakuna", "pppT");;
        User resultUser = null;
        assertEquals(resultUser, userRepository.update(newUser));
    }

    @Test
    public void UR_updateTest_EMPTY_REPOSITORY() throws Exception {
        System.out.println("UserRepository class update method test with EMPTY REPOSITORY");
        User newUser = new User(1111, "Piter", "gggPT");
        User[] newUsers = new User[10];
        User resultUser = null;
        UserRepository newRepo = new UserRepository(newUsers);
        assertEquals(resultUser, newRepo.update(newUser));
    }

    @Test
    public void UR_deleteTest_RIGHT_ID() throws Exception {
        System.out.println("UserRepository class delete method test with RIGHT ID");
        userRepository.delete(1111);
        User resultUser = null;
        assertEquals(resultUser, userRepository.findById(1111));
    }
}
