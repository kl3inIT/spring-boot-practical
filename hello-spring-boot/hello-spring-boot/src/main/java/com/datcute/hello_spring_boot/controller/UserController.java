package com.datcute.hello_spring_boot.controller;

import com.datcute.hello_spring_boot.dto.request.UserRequestDTO;
import com.datcute.hello_spring_boot.dto.response.ResponseData;
import com.datcute.hello_spring_boot.dto.response.ResponseSuccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;


@RestController
@RequestMapping("/user")
@Validated
public class UserController {

//    @Operation(summary = "summary", description = "description", responses = {
//            @ApiResponse(responseCode = "201", description = "User added successfully",
//                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
//                            examples = @ExampleObject(name = "ex name", summary = "ex summary",
//                                    value = """
//                                            {
//                                                "status": 201,
//                                                "message": "User added successfully",
//                                                "data": 1
//                                            }
//                                            """))
//            )
//    })
    @PostMapping("/")
    //@RequestMapping(method = POST, path = "/", headers = "apiKey=v1.0")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        System.out.println("Request add user " + userDTO.getFirstName());
        return new ResponseData<>(HttpStatus.CREATED.value(), "User added successfully", 1);
    }

    @Operation(summary = "summary", description = "description", responses = {
            @ApiResponse(responseCode = "202", description = "User updated successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(name = "ex name", summary = "ex summary",
                                    value = """
                                            {
                                                "status": 202,
                                                "message": "User updated successfully",
                                                "data": null
                                            }
                                            """))
            )
    })
    @PutMapping("/{userId}")
    //@ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseSuccess updateUser(@PathVariable int userId, @Valid @RequestBody UserRequestDTO userDTO) {
        System.out.println("RequestBody update userId = " + userId);
        return new ResponseSuccess(HttpStatus.ACCEPTED, "User updated successfully");
    }

    @PatchMapping("/{userId}")
    //@ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseSuccess changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status) {
        System.out.println("Request change user status, userId= " + userId);
        return new ResponseSuccess(HttpStatus.ACCEPTED, "User status changed");
    }

    @DeleteMapping("/{userId}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseData<?> deleteUser(@Min(1) @PathVariable int userId) {
        System.out.println("Request delete userId = " + userId);
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted successfully");
    }

    @GetMapping("/{userId}")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseSuccess getUser(@PathVariable int userId) {
        System.out.println("Request get userId = " + userId);
        return new ResponseSuccess(HttpStatus.OK, "user", new UserRequestDTO("Nguyen Van A", "0123456789", "email", "Nguyen Van A"));
    }

    @GetMapping("/list")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseSuccess getAllUsers(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        System.out.println("Request get all users");
        return new ResponseSuccess(HttpStatus.OK, "users", List.of(
                new UserRequestDTO("Nguyen Van A", "0123456789", "email", "Nguyen Van A"),
                new UserRequestDTO("Nguyen Van B", "0123456789", "email", "Nguyen Van B")
        ));
    }

}
