package dev.evanishyn.services.interfaces;

import dev.evanishyn.entities.User;

public interface LoginService {

    User validateUser(String username, String password);
}
