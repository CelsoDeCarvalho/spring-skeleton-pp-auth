package dev.mozcoder.usermanagementapi.dto.responses;

public class RoleWithoutUsers {

    private String id;
    private String name;
    private String description;

    public RoleWithoutUsers(){}

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
}
