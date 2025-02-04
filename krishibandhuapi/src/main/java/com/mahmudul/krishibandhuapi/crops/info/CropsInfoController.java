package com.mahmudul.krishibandhuapi.crops.info;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mahmudul.krishibandhuapi.dtos.CropDTO;
import com.mahmudul.krishibandhuapi.dtos.CropWithPrice;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/crops")
@Validated
public class CropsInfoController {

    private CropsInfoService cropsInfoService;

    public CropsInfoController(CropsInfoService cropsInfoService){
        this.cropsInfoService = cropsInfoService;
    }

    @PostMapping("/")
    public ResponseEntity<Crop> createCrop(@Valid @RequestBody CropDTO cropDTO) {
        Crop nwCrop = cropsInfoService.createCropInfo(cropDTO.toCropEntity());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(nwCrop.getId())
                        .toUri();
        return ResponseEntity.created(location).body(nwCrop);
    }

    @GetMapping("/{cropId}")
    public ResponseEntity<Crop> getCrop(@PathVariable Long cropId) {
        Crop crop = cropsInfoService.getCrop(cropId);
        return ResponseEntity.ok(crop);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<CropWithPrice>> getCrops(){
        List<CropWithPrice> crops = cropsInfoService.getCropsWithLatestPrice();
        return ResponseEntity.ok(crops);
    }
    
    @PutMapping("/{cropId}")
    public ResponseEntity<Crop> updateCrop(@PathVariable Long cropId, @Valid @RequestBody CropDTO cropDTO) {
        Crop crop = cropsInfoService.modifyCrop(cropDTO.toCropEntity(), cropId);        
        return ResponseEntity.ok(crop);
    }
    
    @DeleteMapping("/{cropId}")
    public ResponseEntity<Void> deleteCrop(@PathVariable Long cropId){
        cropsInfoService.deleteCrop(cropId);
        return ResponseEntity.noContent().build();
    }
}
