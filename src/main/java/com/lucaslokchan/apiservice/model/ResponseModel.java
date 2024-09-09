package com.lucaslokchan.apiservice.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class ResponseModel {
    public ResponseEntity<Object> generalResponse(HttpStatus status, Object responseObj) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("status", status.value());
        responseMap.put("data", responseObj);
        responseMap.put("timestamp", Instant.now().getEpochSecond());
        return new ResponseEntity<>(responseMap, status);
    }

    public ResponseEntity<Object> errorResponse(HttpStatus status, String errorCode, String message, String detail) {
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("status", status.value());
        errorMap.put("errorCode", errorCode);
        errorMap.put("message", message);
        errorMap.put("detail", detail);
        errorMap.put("timestamp", Instant.now().getEpochSecond());
        return new ResponseEntity<>(errorMap, status);
    }
}
