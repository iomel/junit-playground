package users;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User[] users = {new User(1111, "Petya", "pppT"), null, new User(1121, null, null), new User(3333, "Vasya", "pppV"), };
        UserRepository uR = new UserRepository(users);

        System.out.println(uR.getUserNameById(1121));
        System.out.println(uR.getUserNameById(-1121));

        System.out.println(Arrays.toString(uR.getUserNames()));
        System.out.println(Arrays.toString(uR.getUserIds()));



    }
}
