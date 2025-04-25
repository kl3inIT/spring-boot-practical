package com.datcute.hello_spring_boot.controller;

import com.datcute.hello_spring_boot.dto.request.UserRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
public class  UserController {

    @PostMapping("/")
    //@RequestMapping(method = POST, path = "/", headers = "apiKey=v1.0")
    public String addUser(@Valid @RequestBody UserRequestDTO userDTO){
        return "user add success";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @Valid @RequestBody UserRequestDTO userDTO) {
        System.out.println("RequestBody update userId = " + userId);
        return "User updated";
    }

    @PatchMapping("/{userId}")
    public String changeStatus (@PathVariable int userId, @RequestParam(required = false) boolean status) {
        System.out.println("Request change user status, userId= " + userId);
        return "User status changed";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@Min(1) @PathVariable int userId) {
        System.out.println("Request delete userId = " + userId);
        return "User deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId) {
        System.out.println("Request get userId = " + userId);
        return new UserRequestDTO("Nguyen Van A", "0123456789", "email", "Nguyen Van A");
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getAllUsers(
            @RequestParam(defaultValue ="0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        System.out.println("Request get all users");
        return List.of(
                new UserRequestDTO("Nguyen Van A", "0123456789", "email", "Nguyen Van A"),
                new UserRequestDTO("Nguyen Van B", "0123456789", "email", "Nguyen Van B")
        );
    }

}
