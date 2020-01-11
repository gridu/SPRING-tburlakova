package net.javaguides.springmvc.service;

import net.javaguides.springmvc.entity.User;
import net.javaguides.springmvc.exception.UserNotFoundException;

public interface UserService {

    Iterable<User> getUsers();

    User saveUser(User user);

    User updateUser(int id, User user);

    User getUser(int theId) throws UserNotFoundException;

    void deleteUser(int theId) throws UserNotFoundException;

}
