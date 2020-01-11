package net.javaguides.springmvc.service;

import net.javaguides.springmvc.entity.User;
import net.javaguides.springmvc.exception.UserNotFoundException;
import net.javaguides.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        user.getPhones().forEach(phone -> {
            phone.setUser(user);
        });
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(int id, User user) {
        User userToUpdate = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException(id, "No user with such id"));

        user.setId(id);
        user.getPhones().forEach(phone -> {
            phone.setUser(userToUpdate);
        });
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User getUser(int id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException(id, "No user with such id"));
    }

    @Override
    @Transactional
    public void deleteUser(int theId) throws UserNotFoundException{
        try {
            userRepository.deleteById(theId);
        } catch (Exception e) {
            throw new UserNotFoundException(theId, "User can not be deleted");
        }
    }
}
