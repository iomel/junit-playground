package userRepo_tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunSpyMockitoTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(UserRepositorySpyTest.class);
        if(result.wasSuccessful())
            System.out.println("Tests completed successfully!");
        else
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
    }
}
