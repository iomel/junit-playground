package userRepo_tests;

import org.junit.Before;
import org.junit.Test;
import users.User;
import users.UserRepository;
import users.exception.UserNotFoundException;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.*;

public class UserRepositorySpyTest {
    private UserRepository uRepo;

    private User[] testUsersSet;
    private User testUser;

    @Before
    public void setUp() throws Exception {
        testUser = new User(1111, "Petya", "pppT");
        User[] users = {testUser, null, new User(1121, null, null), new User(3333, "Vasya", "pppV"), };
        testUsersSet = users;
        uRepo = spy(new UserRepository(testUsersSet));
    }

    @Test
    public void UR_saveTest_RIGHT_USER() throws Exception {
        System.out.println("Mock of UserRepository class save method test with RIGHT USER");
        User newUser = new User(1199, "Piter", "gggPT");

        //before test
        System.out.println(Arrays.toString(uRepo.getUsers()));
        doThrow(UserNotFoundException.class).when(uRepo).findById(1199);

        // test
        assertEquals(newUser, uRepo.save(newUser));

        //After test
        System.out.println(Arrays.toString(uRepo.getUsers()));
        assertArrayEquals(testUsersSet, uRepo.getUsers());
    }

}
