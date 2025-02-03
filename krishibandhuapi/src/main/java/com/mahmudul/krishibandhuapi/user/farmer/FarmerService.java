package com.mahmudul.krishibandhuapi.user.farmer;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mahmudul.krishibandhuapi.exceptions.user.farmer.FarmerNotFoundException;

@Service
public class FarmerService {
    private FarmerRepository farmerRepository;
    private PasswordEncoder passwordEncoder;

    public FarmerService(FarmerRepository farmerRepository, PasswordEncoder passwordEncoder){
        this.farmerRepository = farmerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Farmer createFarmer(Farmer farmer){
        farmer.setPassword(passwordEncoder.encode(farmer.getPassword()));
        return farmerRepository.save(farmer);
    }

    public Farmer getFarmer(Long farmerId){
        return farmerRepository.findById(farmerId)
        .orElseThrow(() -> new FarmerNotFoundException("Farmer Not Found with Id : " + farmerId));
    }

    public Farmer modifyFarmer(Long farmerId, Farmer nwFarmer){
        return farmerRepository.findById(farmerId)
        .map(farmer -> {
            farmer.setDob(nwFarmer.getDob());
            farmer.setPhone(nwFarmer.getPhone());
            farmer.setPresentAddress(nwFarmer.getPresentAddress());
            farmer.setPermanentAddress(nwFarmer.getPermanentAddress());
            farmer.setLandArea(nwFarmer.getLandArea());
            return farmerRepository.save(farmer);
        }).orElseThrow(() -> new FarmerNotFoundException("Farmer Not Found with Id : " + farmerId));
    }

    public void deleteFarmer(Long farmerId){
        if(!farmerRepository.existsById(farmerId)){
            throw new FarmerNotFoundException("Farmer Not Found with Id : " + farmerId);
        }
        farmerRepository.deleteById(farmerId);
    }
}
