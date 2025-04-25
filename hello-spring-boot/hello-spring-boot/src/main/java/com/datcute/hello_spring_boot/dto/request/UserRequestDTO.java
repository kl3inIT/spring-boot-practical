package com.datcute.hello_spring_boot.dto.request;

import com.datcute.hello_spring_boot.util.*;
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

    //@Pattern(regexp = "^(ACTIVE|INACTIVE|NONE)$", message = "Status must be ACTIVE, INACTIVE or NONE")
    @EnumPattern(name = "status", regexp = "^(ACTIVE|INACTIVE|NONE)$")
    private UserStatus status;

    @EnumValue(name = "types", enumClass = UserTypes.class)
    private String types;

    public String getTypes() {
        return types;
    }

    public UserStatus getStatus() {
        return status;
    }

    public UserRequestDTO(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
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
