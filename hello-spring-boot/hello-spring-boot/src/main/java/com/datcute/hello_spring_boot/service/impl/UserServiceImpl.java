package com.datcute.hello_spring_boot.service.impl;

import com.datcute.hello_spring_boot.exception.ResourceNotFoundException;
import com.datcute.hello_spring_boot.service.UserService;
import org.springframework.stereotype.Service;
import com.datcute.hello_spring_boot.dto.request.UserRequestDTO;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public int addUser(UserRequestDTO userRequestDTO) {
        System.out.println("Save user to database");
        if (userRequestDTO.getFirstName().equals("Tay")) {
            throw new ResourceNotFoundException("User not found");
        }
        return 0;
    }
}
