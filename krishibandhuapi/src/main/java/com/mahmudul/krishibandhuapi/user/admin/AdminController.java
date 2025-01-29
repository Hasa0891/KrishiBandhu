package com.mahmudul.krishibandhuapi.user.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahmudul.krishibandhuapi.dtos.AdminDTO;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users/admins")
@Validated
public class AdminController {

    @PostMapping("/create")
    public ResponseEntity<String> createAdmin(@Valid @RequestBody AdminDTO admin) {
        return ResponseEntity.ok("{message : Admin Account Created}");
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("{message : Admin Account Found}");
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<String> updateAdmin() {
        return ResponseEntity.ok("{message : Admin Account Updated}");
    }
    
    @DeleteMapping("/{adminId}")
    public ResponseEntity<String> deleteAdmin() {
        return ResponseEntity.ok("{message : Admin Account Deleted}");
    }
}
