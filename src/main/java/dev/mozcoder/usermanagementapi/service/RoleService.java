package dev.mozcoder.usermanagementapi.service;

import dev.mozcoder.usermanagementapi.dto.responses.RoleResponse;
import dev.mozcoder.usermanagementapi.model.Role;

import java.util.List;

public interface RoleService {

    public Role save(Role role);

    public List<RoleResponse> findAll();
}
