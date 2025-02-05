package com.mahmudul.krishibandhuapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mahmudul.krishibandhuapi.exceptions.crops.CropNotFoundException;
import com.mahmudul.krishibandhuapi.exceptions.crops.CropsPriceNotFoundException;
import com.mahmudul.krishibandhuapi.exceptions.organization.OrganizationNotFoundException;
import com.mahmudul.krishibandhuapi.exceptions.posts.PostNotFoundException;
import com.mahmudul.krishibandhuapi.exceptions.user.admin.AdminNotFoundException;
import com.mahmudul.krishibandhuapi.exceptions.user.farmer.FarmerNotFoundException;

import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleAdminNotFoundException( AdminNotFoundException ex){
        Map<String,Object> errRS = new HashMap<>();
        errRS.put("timestamp", LocalDateTime.now());
        errRS.put("status", HttpStatus.NOT_FOUND.value());
        errRS.put("error", "Not Found");
        errRS.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errRS);
    }

    @ExceptionHandler(FarmerNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleFarmerNotFoundException( FarmerNotFoundException ex){
        Map<String,Object> errRS = new HashMap<>();
        errRS.put("timestamp", LocalDateTime.now());
        errRS.put("status", HttpStatus.NOT_FOUND.value());
        errRS.put("error", "Not Found");
        errRS.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errRS);
    }

    @ExceptionHandler(CropNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleCropNotFoundException(CropNotFoundException ex){
        Map<String,Object> errRS = new HashMap<>();
        errRS.put("timestamp", LocalDateTime.now());
        errRS.put("status", HttpStatus.NOT_FOUND.value());
        errRS.put("error", "Not Found");
        errRS.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errRS);
    }

    @ExceptionHandler(CropsPriceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCropsPriceNotFoundException(CropsPriceNotFoundException ex){
        Map<String,Object> errRS = new HashMap<>();
        errRS.put("timestamp", LocalDateTime.now());
        errRS.put("status", HttpStatus.NOT_FOUND.value());
        errRS.put("error", "Not Found");
        errRS.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errRS);
    }
    
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePostNotFoundException(PostNotFoundException ex){
        Map<String,Object> errRS = new HashMap<>();
        errRS.put("timestamp", LocalDateTime.now());
        errRS.put("status", HttpStatus.NOT_FOUND.value());
        errRS.put("error", "Not Found");
        errRS.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errRS);
    }

    @ExceptionHandler(OrganizationNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleOrganizationNotFoundException(OrganizationNotFoundException ex){
        Map<String,Object> errRS = new HashMap<>();
        errRS.put("timestamp", LocalDateTime.now());
        errRS.put("status", HttpStatus.NOT_FOUND.value());
        errRS.put("error", "Not Found");
        errRS.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errRS);
    }
}