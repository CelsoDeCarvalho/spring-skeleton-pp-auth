package dev.mozcoder.usermanagementapi.controller;

import dev.mozcoder.usermanagementapi.dto.UserDTO;
import dev.mozcoder.usermanagementapi.model.User;
import dev.mozcoder.usermanagementapi.response.UserResponse;
import dev.mozcoder.usermanagementapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserDTO userDTO){
        // convert UserDto to User entity
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        User savedUser = userService.save(user);

        // convert User entity to Response class
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setUsername(savedUser.getUsername());
        response.setAge(savedUser.getAge());
        response.setCreated(savedUser.getCreated());
        response.setEmail(savedUser.getEmail());
        response.setUpdated(savedUser.getUpdated());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setPhoneNumber(savedUser.getPhoneNumber());

        return new ResponseEntity<UserResponse>(response, HttpStatus.CREATED);
    }
}
