package dev.mozcoder.usermanagementapi.service;

import dev.mozcoder.usermanagementapi.dto.responses.RoleWithoutUsers;
import dev.mozcoder.usermanagementapi.model.Role;
import dev.mozcoder.usermanagementapi.model.User;
import dev.mozcoder.usermanagementapi.repository.UserRepository;
import dev.mozcoder.usermanagementapi.dto.responses.UserResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            response.setCreated(user.getCreatedAt());
            response.setEmail(user.getEmail());
            response.setUpdated(user.getUpdatedAt());
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setPhoneNumber(user.getPhoneNumber());

            Set<RoleWithoutUsers> rolesResponse = new HashSet<>();

            for (Role role:user.getRoles()) {
                RoleWithoutUsers roleWithoutUsers = new RoleWithoutUsers();
                roleWithoutUsers.setId(role.getId());
                roleWithoutUsers.setName(role.getName());
                roleWithoutUsers.setDescription(role.getDescription());
                rolesResponse.add(roleWithoutUsers);
            }
            response.setRoles(rolesResponse);
            userResponses.add(response);
        }

        return userResponses;
    }
}
