package com.datcute.hello_spring_boot.dto.response;

public class ResponseError extends ResponseData {
   public ResponseError(int status, String message) {
        super(status, message);
    }
}
