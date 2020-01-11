package net.javaguides.springmvc.controller.rest;

import net.javaguides.springmvc.entity.User;
import net.javaguides.springmvc.exception.UserNotFoundException;
import net.javaguides.springmvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("rest")
@RequestMapping("/api/v1/")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> listUsers() {
        return userService.getUsers();
    }

    @ResponseStatus(value = HttpStatus.CREATED, reason = "User successfully created")
    @PostMapping("/users")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user); }

    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable Integer id) throws UserNotFoundException {
        return userService.getUser(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) throws UserNotFoundException {
        userService.deleteUser(id);
    }

}
