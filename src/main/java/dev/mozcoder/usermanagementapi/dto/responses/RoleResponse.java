package dev.mozcoder.usermanagementapi.dto.responses;

import dev.mozcoder.usermanagementapi.model.User;
import java.time.LocalDateTime;
import java.util.Set;

public class RoleResponse {

    private String id;
    private String name;
    private String description;
    private Set<UserWithoutRoles> users;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public RoleResponse(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UserWithoutRoles> getUsers() {
        return users;
    }

    public void setUsers(Set<UserWithoutRoles> users) {
        this.users = users;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
