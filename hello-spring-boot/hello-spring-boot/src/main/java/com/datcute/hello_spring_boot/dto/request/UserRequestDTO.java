package com.datcute.hello_spring_boot.dto.request;

import com.datcute.hello_spring_boot.util.PhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

public class UserRequestDTO implements Serializable {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    //@Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    @PhoneNumber
    private String phone;

    @Email(message = "Email should be valid")
    private String email;

    public UserRequestDTO(String firstName, String phone, String email, String lastName) {
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
