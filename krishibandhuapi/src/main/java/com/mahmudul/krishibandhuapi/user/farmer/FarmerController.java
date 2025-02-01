package com.mahmudul.krishibandhuapi.user.farmer;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mahmudul.krishibandhuapi.dtos.FarmerDTO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import  org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users/farmers")
@Validated
public class FarmerController {

    private FarmerService farmerService;

    public FarmerController(FarmerService farmerService){
        this.farmerService = farmerService;
    }

    @PostMapping("/")
    public ResponseEntity<Farmer> createFarmer(@Valid @RequestBody FarmerDTO farmerDTO) {
        Farmer farmer = farmerService.createFarmer(farmerDTO.toFarmerEntity());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(farmer.getId())
                        .toUri();
        return ResponseEntity.created(location).body(farmer);
    }

    @GetMapping("/{farmerId}")
    public ResponseEntity<Farmer> getFarmer(@PathVariable Long farmerId) {
        Farmer farmer = farmerService.getFarmer(farmerId);
        return ResponseEntity.ok(farmer);
    }

    @PutMapping("/{farmerId}")
    public ResponseEntity<Farmer> updateFarmer(@Valid @RequestBody FarmerDTO farmerDTO, @PathVariable Long farmerId) {
        Farmer farmer = farmerService.modifyFarmer(farmerId, farmerDTO.toFarmerEntity());
        return ResponseEntity.ok(farmer);
    }
    
    @DeleteMapping("/{farmerId}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable Long farmerId) {
        farmerService.deleteFarmer(farmerId);
        return ResponseEntity.noContent().build();
    }
}
