//package com.sda.expensetrackerproject.service;
//
//import com.sda.expensetrackerproject.entity.User;
//import com.sda.expensetrackerproject.exception.UserDetailsFoundException;
//import com.sda.expensetrackerproject.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;

//@Service
//public class UserService {
//    public UserRepository userRepository;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public User save(User user){
//        if (findByUsername(user.getName()).isPresent()) {
//            throw new UserDetailsFoundException("Person with username: " +
//                    user.getName() + " already exists");
//        } else if (findByEmail(user.getEmail()).isPresent()) {
//            throw new UserDetailsFoundException("Person with email: " +
//                    user.getEmail() + " already exists");
//        }
//        return userRepository.save(user);
//    }
//
//    public Optional<User> findByUsername(String userName) {
//        return userRepository.findUsersByNameContaining(userName);
//    }
//
//    public Optional<User> findByEmail (String email){
//        return userRepository.findUsersByEmailContaining(email);
//    }
//}
