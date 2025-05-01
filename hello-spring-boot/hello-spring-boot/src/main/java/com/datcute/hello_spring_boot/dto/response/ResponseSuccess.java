package com.datcute.hello_spring_boot.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseSuccess extends ResponseEntity<ResponseSuccess.Payload> {

    // PUT PATCH DELETE
    public ResponseSuccess(HttpStatusCode statusCode, String message) {
        super(new Payload(statusCode.value(), message), HttpStatus.OK);
    }

    // POST GET
    public ResponseSuccess(HttpStatusCode statusCode, String message, Object data) {
        super(new Payload(statusCode.value(), message, data), HttpStatus.OK);
    }

    public static class Payload {

        private final int status;
        private final String message;
        private Object data;

        public Payload(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public Payload(int status, String message, Object data) {
            this.status = status;
            this.message = message;
            this.data = data;
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
