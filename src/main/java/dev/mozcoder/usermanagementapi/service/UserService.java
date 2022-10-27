package dev.mozcoder.usermanagementapi.service;

import dev.mozcoder.usermanagementapi.model.User;
import dev.mozcoder.usermanagementapi.dto.responses.UserResponse;

import java.util.List;

public interface UserService {

    public User save(User user);
    public List<UserResponse> findAll();
}
