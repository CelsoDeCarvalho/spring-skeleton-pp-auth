package dev.mozcoder.usermanagementapi.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserDTO{

    @NotBlank(message = "Username cannot bet null")
    @Size(min = 3,message = "Invalid username, at last 3 characters")
    private String username;
    @Size(min = 8,message = "Invalid password, at last 8 characters")
    @NotBlank(message = "Password cannot bet null")
    private String password;
    @Email
    @NotBlank(message = "Email cannot bet null")
    private String email;
    @NotBlank(message = "Age cannot bet null")
    private LocalDate age;
    @NotBlank(message = "First name cannot bet null")
    private String firstName;
    @NotBlank(message = "Last name cannot bet null")
    private String lastName;
    @NotBlank(message = "Phone number cannot bet null")
    private String phoneNumber;

    public UserDTO(){}

    public UserDTO(String username, String password, String email, LocalDate age, String firstName, String lastName, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
