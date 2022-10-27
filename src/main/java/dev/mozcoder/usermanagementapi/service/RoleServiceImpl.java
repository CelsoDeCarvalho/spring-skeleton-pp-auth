package dev.mozcoder.usermanagementapi.service;

import dev.mozcoder.usermanagementapi.dto.responses.RoleResponse;
import dev.mozcoder.usermanagementapi.dto.responses.UserWithoutRoles;
import dev.mozcoder.usermanagementapi.model.Role;
import dev.mozcoder.usermanagementapi.model.User;
import dev.mozcoder.usermanagementapi.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<RoleResponse> findAll() {
        List<RoleResponse> roleResponses = new ArrayList<>();
        for (Role role:roleRepository.findAll()) {
            RoleResponse roleResponse = new RoleResponse();

            roleResponse.setId(role.getId());
            roleResponse.setName(role.getName());
            roleResponse.setDescription(role.getDescription());
            roleResponse.setCreatedAt(role.getCreatedAt());
            roleResponse.setUpdatedAt(role.getUpdatedAt());

            Set<UserWithoutRoles> usersWithoutRoles = new HashSet<>();
            for (User user:role.getUsers()) {
                UserWithoutRoles userWithoutRoles = new UserWithoutRoles();
                userWithoutRoles.setId(user.getId());
                userWithoutRoles.setUsername(user.getUsername());
                userWithoutRoles.setEmail(user.getEmail());
                userWithoutRoles.setFirstName(user.getFirstName());
                userWithoutRoles.setLastName(user.getLastName());
                userWithoutRoles.setAge(user.getAge());
                userWithoutRoles.setPhoneNumber(user.getPhoneNumber());
                usersWithoutRoles.add(userWithoutRoles);
            }
            roleResponse.setUsers(usersWithoutRoles);

            roleResponses.add(roleResponse);
        }

        return roleResponses;
    }
}
