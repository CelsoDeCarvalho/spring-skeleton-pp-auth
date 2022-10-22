package dev.mozcoder.usermanagementapi.response;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserResponse {

    private String id;
    private String username;
    private String email;
    private LocalDate age;
    private String firstName;
    private String lastName;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String phoneNumber;

    public UserResponse(){}

    public UserResponse(String id, String username, String email, LocalDate age, String firstName, String lastName, LocalDateTime created, LocalDateTime updated, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = created;
        this.updated = updated;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
