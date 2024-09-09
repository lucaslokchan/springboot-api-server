package com.lucaslokchan.apiservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.lucaslokchan.apiservice.model.ResponseModel;


@RestController
public class GameController {
    private final ResponseModel responseModel = new ResponseModel();

    @GetMapping("/")
    public ResponseEntity<Object> helloworld() {
        HttpStatus status = HttpStatus.OK;
        String data = "Hello World";
        return responseModel.generalResponse(status, data);
    }

    @GetMapping("/gg")
    public ResponseEntity<Object> error() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String errorCode = "G0001";
        String message = "Incorrect username and password";
        String detail = "Ensure that the username and password included in the request are correct";
        return responseModel.errorResponse(status, errorCode, message, detail);
    }

}
