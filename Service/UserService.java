package com.example.serverDevelopment.Service;

import com.example.serverDevelopment.Model.User;
import com.example.serverDevelopment.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        log.info("использован метод getAllUsers()");
        return userRepository.findAll();
    }

    public User addUser(User user) {
        log.info("использован метод addUser");
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        log.info("использован метод updateUser");
        return userRepository.save(user);
    }

    public User findById(Long id) {
        log.info("использован метод findById");
        return userRepository.findUserById(id);
    }
    public void deleteUser(Long id) {
        log.info("использован метод deleteUser()");
        userRepository.deleteById(id);
    }
}
