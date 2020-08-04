package com.sda.expensetrackerproject.controller;
import com.sda.expensetrackerproject.entity.User;
import com.sda.expensetrackerproject.entity.UserDTO.UserDTO;
import com.sda.expensetrackerproject.repository.UserRepository;
import com.sda.expensetrackerproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

//@RestController
//public class UserController {
//
//    @Autowired
//    public UserRepository userRepository;
//
//    @Autowired
//    public UserService userService;
//
//    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<UserDTO> user(){
//        Optional<User> myUser = userRepository.findUsersByNameContaining("adam");
//
//        if(!myUser.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        User userFromOptional = myUser.get();
//
//        UserDTO dto = new UserDTO(
//                userFromOptional.getUserId(), userFromOptional.getName(), "14 July 2020");
//
//        return new ResponseEntity<>(dto, HttpStatus.OK);
//    }
//
//
//}

