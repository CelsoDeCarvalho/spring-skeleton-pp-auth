package dev.mozcoder.usermanagementapi.dto;

import javax.validation.constraints.NotEmpty;

public class RoleDTO {

    @NotEmpty
    private String name;
    private String description;

    public RoleDTO(){}

    public RoleDTO(String name, String description) {
        this.name = name;
        this.description = description;
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
}
