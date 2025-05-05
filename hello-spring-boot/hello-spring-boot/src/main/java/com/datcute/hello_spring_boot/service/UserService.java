package com.datcute.hello_spring_boot.service;

import com.datcute.hello_spring_boot.dto.request.UserRequestDTO;

public interface UserService {

    int addUser(UserRequestDTO userRequestDTO);
}
