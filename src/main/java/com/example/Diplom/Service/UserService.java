package com.example.Diplom.Service;

import com.example.Diplom.Model.User;
import com.example.Diplom.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    //TODO: ADVICE
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //TODO: ADVICE
    public User updateUser(User upUser) {
        return userRepository.save(upUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
