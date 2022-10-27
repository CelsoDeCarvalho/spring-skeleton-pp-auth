package dev.mozcoder.usermanagementapi.controller;

import dev.mozcoder.usermanagementapi.dto.requests.UserRequest;
import dev.mozcoder.usermanagementapi.dto.responses.RoleWithoutUsers;
import dev.mozcoder.usermanagementapi.model.Role;
import dev.mozcoder.usermanagementapi.model.User;
import dev.mozcoder.usermanagementapi.dto.responses.UserResponse;
import dev.mozcoder.usermanagementapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user/list")
    public ResponseEntity<List<UserResponse>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest){
        // convert UserDto to User entity
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setAge(userRequest.getAge());
        user.setEmail(userRequest.getEmail());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setRoles(userRequest.getRoles());
        User savedUser = userService.save(user);

        // convert User entity to Response class
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setUsername(savedUser.getUsername());
        response.setAge(savedUser.getAge());
        response.setCreated(savedUser.getCreatedAt());
        response.setEmail(savedUser.getEmail());
        Set<RoleWithoutUsers> roleRespons = new HashSet<>();

        for (Role role:savedUser.getRoles()) {
            RoleWithoutUsers roleWithoutUsers = new RoleWithoutUsers();
            roleWithoutUsers.setId(role.getId());
            roleWithoutUsers.setName(role.getName());
            roleWithoutUsers.setDescription(role.getDescription());
            roleRespons.add(roleWithoutUsers);
        }

        response.setRoles(roleRespons);
        response.setUpdated(savedUser.getUpdatedAt());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setPhoneNumber(savedUser.getPhoneNumber());

        return new ResponseEntity<UserResponse>(response, HttpStatus.CREATED);
    }
}
