package com.sgglabs.retail;

import com.sgglabs.retail.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired(required = true)
    UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            usersList.add(user);
        }
        return usersList;
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable String userName) {
        return userRepository.findByUserName(userName);
    }
}