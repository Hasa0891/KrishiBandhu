package com.mahmudul.krishibandhuapi.user.farmer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import  org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users/farmers")
public class FarmerController {

    @PostMapping("/create")
    public ResponseEntity<String> createFarmer() {
        return ResponseEntity.ok("{message : Farmer Account Created}");
    }

    @GetMapping("/{farmerId}")
    public ResponseEntity<String> getFarmer() {
        return ResponseEntity.ok("{message : Farmer Account Found}");
    }

    @PutMapping("/{farmerId}")
    public ResponseEntity<String> updateFarmer() {
        return ResponseEntity.ok("{message : Farmer Account Updated}");
    }
    
    @DeleteMapping("/{farmerId}")
    public ResponseEntity<String> deleteFarmer() {
        return ResponseEntity.ok("{message : Farmer Account Deleted}");
    }
}
