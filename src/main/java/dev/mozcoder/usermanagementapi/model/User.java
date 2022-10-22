package dev.mozcoder.usermanagementapi.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User{

    @Id
    @GenericGenerator(name = "user_id", strategy = "dev.mozcoder.usermanagementapi.util.UserUUID")
    @GeneratedValue(generator = "user_id")
    @Column(updatable = false,nullable = false)
    private String id;
    private String username;
    private String password;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate age = LocalDate.now();
    private String firstName;
    private String lastName;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime created = LocalDateTime.now();
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updated = LocalDateTime.now();
    private String phoneNumber;

    public User(){}

    public User(String username, String password, String email, String firstName, String lastName, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = LocalDate.now();
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
