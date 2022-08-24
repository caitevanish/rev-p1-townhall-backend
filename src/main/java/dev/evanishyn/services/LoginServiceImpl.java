package dev.evanishyn.services;

import dev.evanishyn.daos.userDAOS.UserDao;
import dev.evanishyn.entities.User;
import dev.evanishyn.services.interfaces.LoginService;

public class LoginServiceImpl implements LoginService {

    private UserDao userDao;

    public LoginServiceImpl(UserDao userDao){this.userDao = userDao; }

    @Override
    public User validateUser(String username, String password) {
        User user = this.userDao.getAccountByUsername(username);
        if(user==null){
            throw new RuntimeException("No user with that username");
        }
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Wrong password entered");
        }
        return user;
    }
}
