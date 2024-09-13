package com.tms.backend.services;

import com.tms.backend.models.User;
import org.springframework.stereotype.Service;
import com.tms.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User userSignup(String email, String username, String password) {
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }


    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public User addUser(String email) {
        User user = new User();
        user.setEmail(email);
        return userRepository.save(user);
        // TODO : generate the password and send it by email
    }

    public User updateUser(Long id, String email, String username, String password) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }


}



