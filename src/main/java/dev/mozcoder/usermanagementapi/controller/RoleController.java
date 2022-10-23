package dev.mozcoder.usermanagementapi.controller;

import dev.mozcoder.usermanagementapi.model.Role;
import dev.mozcoder.usermanagementapi.repository.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> save(@RequestBody Role role){
        Role savedRole = roleRepository.save(role);
        return new ResponseEntity<Role>(savedRole, HttpStatus.CREATED);
    }

    @GetMapping("/role/list")
    public ResponseEntity<List<Role>> findAll(){
        return  ResponseEntity.ok().body(roleRepository.findAll());
    }

}
