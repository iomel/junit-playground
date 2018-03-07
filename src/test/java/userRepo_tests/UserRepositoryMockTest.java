package userRepo_tests;

import org.junit.Before;
import org.junit.Test;
import users.User;
import users.UserRepository;

import java.util.Arrays;

import static org.mockito.Mockito.*;
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
        uRepo = spy(new UserRepository(users));

    }

    @Test
    public void UR_saveTest_RIGHT_USER() throws Exception {
        System.out.println("Mock of UserRepository class save method test with RIGHT USER");
        System.out.println(Arrays.toString(uRepo.getUserNames()));

        User newUser = new User(1199, "Piter", "gggPT");
        doReturn(null).when(uRepo).findById(1199);
        assertEquals(newUser, uRepo.save(newUser));

        System.out.println(Arrays.toString(uRepo.getUserNames()));
        verify(uRepo).findById(1199);
    }

}
