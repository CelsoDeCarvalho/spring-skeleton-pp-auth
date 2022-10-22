package dev.mozcoder.usermanagementapi.service;

import dev.mozcoder.usermanagementapi.model.User;
import dev.mozcoder.usermanagementapi.repository.UserRepository;
import dev.mozcoder.usermanagementapi.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserResponse> findAll() {
        List<UserResponse> userResponses = new ArrayList<>();
        List<User> users = userRepository.findAll();

        for (User user:users) {
            UserResponse response = new UserResponse();
            response.setId(user.getId());
            response.setUsername(user.getUsername());
            response.setAge(user.getAge());
            response.setCreated(user.getCreated());
            response.setEmail(user.getEmail());
            response.setUpdated(user.getUpdated());
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setPhoneNumber(user.getPhoneNumber());
            userResponses.add(response);
        }

        return userResponses;
    }
}
