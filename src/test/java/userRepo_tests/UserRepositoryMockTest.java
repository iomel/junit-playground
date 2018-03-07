package userRepo_tests;

import org.junit.Before;
import org.junit.Test;
import users.User;
import users.UserRepository;

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
//        uRepo = new UserRepository(users);
        uRepo = mock(UserRepository.class);

    }

    @Test
    public void UR_saveTest_RIGHT_USER() throws Exception {
        System.out.println("Mock of UserRepository class save method test with RIGHT USER");
        User newUser = new User(1199, "Piter", "gggPT");
        when(uRepo.findById(1199)).thenReturn(null);

        assertEquals(newUser, uRepo.save(newUser));
    }

    @Test
    public void UR_saveTest_ID_DUPLICATE() throws Exception {
        System.out.println("Mock of UserRepository class save method test with id duplicate");
        User newUser = new User(1111, "Piter", "gggPT");
        User result = null;
        when(uRepo.findById(1111)).thenReturn(newUser);

        assertEquals(result, uRepo.save(newUser));
    }


    @Test
    public void UR_updateTest_RIGHT_USER() throws Exception {
        System.out.println("UserRepository class save method test with RIGHT USER");
        User newUser = new User(1111, "Putya Hakuna", "pppT");
        when(uRepo.findById(1111)).thenReturn(newUser);

        assertEquals(newUser, uRepo.update(newUser));
    }

    @Test
    public void UR_updateTest_WRONG_USER() throws Exception {
        System.out.println("Mock of UserRepository class save method test with WRONG USER (by ID)");
        User newUser = new User(1199, "Putya Hakuna", "pppT");;
        User resultUser = null;
        when(uRepo.findById(1199)).thenReturn(null);

        assertEquals(resultUser, uRepo.update(newUser));
    }

    @Test
    public void UR_updateTest_EMPTY_REPOSITORY() throws Exception {
        System.out.println("UserRepository class update method test with EMPTY REPOSITORY");
        User newUser = new User(1111, "Piter", "gggPT");
        User resultUser = null;
        when(uRepo.findById(1111)).thenReturn(null);

        assertEquals(resultUser, uRepo.update(newUser));
    }

}
