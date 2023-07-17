package com.javatechie.validationerrorhandling.service;

import com.javatechie.validationerrorhandling.dto.UserRequest;
import com.javatechie.validationerrorhandling.entity.User;
import com.javatechie.validationerrorhandling.exception.UserNotFoundException;
import com.javatechie.validationerrorhandling.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(
                0,
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getGender(),
                userRequest.getAge(),
                userRequest.getNationality()

        );
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUserId(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User with id: " + id + " NOT FOUND");
        }
    }

    public String deleteUser(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if (user != null) {
            userRepository.deleteById(id);
            return "The user with id: " + id + " has been deleted successfully";
        } else {
            throw new UserNotFoundException("this id does not exsit!");
        }
    }

    public User updateUserById(int id, UserRequest userRequest) {
        User oldUser = userRepository.findByUserId(id);
        oldUser.setName(userRequest.getName());
        oldUser.setEmail(userRequest.getEmail());
        oldUser.setMobile(userRequest.getMobile());
        oldUser.setGender(userRequest.getGender());
        oldUser.setAge(userRequest.getAge());
        oldUser.setNationality(userRequest.getNationality());
        return oldUser;
    }
}
