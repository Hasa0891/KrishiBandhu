package com.mahmudul.krishibandhuapi.user.farmer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import  org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user/farmer")
public class FarmerController {

    @GetMapping("/{farmerId}")
    private ResponseEntity<String> findById(){
        return ResponseEntity.ok("{id : 1, name : Rahim}");
    }

    @GetMapping("/create")
    private ResponseEntity<String> createFarmer(){
        return ResponseEntity.ok("{message : Farmer Account Created}");
    }
}
