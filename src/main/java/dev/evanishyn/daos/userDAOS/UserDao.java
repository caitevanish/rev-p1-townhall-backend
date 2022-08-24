package dev.evanishyn.daos.userDAOS;

import dev.evanishyn.entities.User;

public interface UserDao {

    User createNewAccount(User user);

    User getAccountByUsername(String username);

}
