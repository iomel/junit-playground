package userRepo_tests;

import org.junit.Before;
import org.junit.Test;
import users.User;
import users.UserRepository;
import users.exception.UserNotFoundException;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
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
        uRepo = mock(UserRepository.class);
   }

    @Test
    public void UR_saveTest_RIGHT_USER() throws Exception {
        System.out.println("Mock of UserRepository class save method test with RIGHT USER");
        User newUser = new User(1199, "Piter", "gggPT");

        // before test
        when(uRepo.getUsers()).thenReturn(testUsersSet);
        when(uRepo.findById(1199)).thenThrow(UserNotFoundException.class);
        when(uRepo.save(any(User.class))).thenCallRealMethod();
        System.out.println(Arrays.toString(uRepo.getUsers()));

        // test
        assertEquals(newUser, uRepo.save(newUser));

        // after test
        System.out.println(Arrays.toString(uRepo.getUsers()));
        assertArrayEquals(testUsersSet, uRepo.getUsers());

    }

}
