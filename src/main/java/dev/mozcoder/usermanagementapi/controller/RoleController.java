package dev.mozcoder.usermanagementapi.controller;

import dev.mozcoder.usermanagementapi.dto.requests.RoleRequest;
import dev.mozcoder.usermanagementapi.dto.responses.RoleResponse;
import dev.mozcoder.usermanagementapi.model.Role;
import dev.mozcoder.usermanagementapi.repository.RoleRepository;
import dev.mozcoder.usermanagementapi.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> save(@RequestBody RoleRequest roleRequest){
        Role role = new Role();
        role.setName(roleRequest.getName());
        role.setDescription(roleRequest.getDescription());
        Role savedRole = roleService.save(role);
        return new ResponseEntity<Role>(savedRole, HttpStatus.CREATED);
    }

    @GetMapping("/role/list")
    public ResponseEntity<List<RoleResponse>> findAll(){
        return  ResponseEntity.ok().body(roleService.findAll());
    }

}
