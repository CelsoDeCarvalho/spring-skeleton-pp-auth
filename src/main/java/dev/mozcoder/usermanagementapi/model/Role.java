package dev.mozcoder.usermanagementapi.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GenericGenerator(name = "role_id", strategy = "dev.mozcoder.usermanagementapi.util.generators.RoleUUID")
    @GeneratedValue(generator = "role_id")
    @Column(updatable = false,nullable = false)
    private String id;
    @NotEmpty
    private String name;
    private String description;

    public Role(){}

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

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
