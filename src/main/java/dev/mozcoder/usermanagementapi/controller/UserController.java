package dev.mozcoder.usermanagementapi.controller;

import dev.mozcoder.usermanagementapi.model.User;
import dev.mozcoder.usermanagementapi.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)

public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/list")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok().body(userRepository.save(user));
    }
}
