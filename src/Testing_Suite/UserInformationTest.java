package src.Testing_Suite;

import static org.junit.Assert.*;
import org.junit.Test;

import src.PrintingInformation.UserInformation;
import src.UserImplements.User;

public class UserInformationTest {

    @Test
    public void testPrintinfo() {
        User user = new User("Avi0001", 0, null);
        UserInformation info = new UserInformation(user);
        String expected = "User Name: Avi0001\n";
        assertEquals(expected, info.printinfo());
    }

}
