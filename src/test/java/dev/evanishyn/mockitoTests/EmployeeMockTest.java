package dev.evanishyn.mockitoTests;

import dev.evanishyn.daos.userDAOS.UserDao;
import dev.evanishyn.entities.User;
import dev.evanishyn.services.LoginServiceImpl;
import dev.evanishyn.services.interfaces.LoginService;
import dev.evanishyn.utilities.enums.AcctType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EmployeeMockTest {

    @Test
    void user_must_have_username(){
        UserDao userDao = Mockito.mock(UserDao.class);
        User user = new User(0, "hannahevanish", "shideezhi","Hannah", "Evanishyn", AcctType.CONSTITUENT);
        Mockito.when(userDao.createNewAccount(user)).thenReturn(user);
        LoginService userService = new LoginServiceImpl(userDao);

        Assertions.assertThrows(RuntimeException.class, ()->{
            userService.validateUser(user.getUsername(), user.getPassword());
        });

    }
}
