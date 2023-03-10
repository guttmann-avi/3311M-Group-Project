package src.Testing_Suite;

import static org.junit.Assert.*;
import org.junit.Test;

import src.PrintingInformation.UserInformation;
import src.UserImplements.User;

public class UserInformationTest {

    @Test
    public void testPrintinfo1() {
        User user = new User("Avi0001", 0, null);
        UserInformation info = new UserInformation(user);
        String expected = "User Name: Avi0001\n";
        assertEquals(expected, info.printinfo());
    }

    @Test
    public void testPrintinfo2() {
        User user = new User("Avi0005", 0, null);
        UserInformation info = new UserInformation(user);
        String expected = "User Name: Avi0005\n";
        assertEquals(expected, info.printinfo());
    }

    @Test
    public void testPrintinfo3() {
        User user = new User("Avi0007", 0, null);
        UserInformation info = new UserInformation(user);
        String expected = "User Name: Avi0007\n";
        assertEquals(expected, info.printinfo());
    }

}
