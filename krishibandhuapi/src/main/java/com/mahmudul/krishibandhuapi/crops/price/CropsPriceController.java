package com.mahmudul.krishibandhuapi.crops.price;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mahmudul.krishibandhuapi.dtos.CropPriceDTO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/crops/{cropId}/prices")
@Validated
public class CropsPriceController {

    private CropsPriceService cropsPriceService;

    public CropsPriceController(CropsPriceService cropsPriceService){
        this.cropsPriceService = cropsPriceService;
    }

    @PostMapping("/")
    public ResponseEntity<CropPrice> addCropPrice(@Valid @RequestBody CropPriceDTO cropPriceDTO, @PathVariable Long cropId) {
        CropPrice cropPrice = cropsPriceService.addCropPrice(cropId, cropPriceDTO.toCropPriceEntity());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(cropPrice.getId())
                        .toUri();
                        
        return ResponseEntity.created(location).body(cropPrice);
    }

    @GetMapping("/latest")
    public ResponseEntity<CropPrice> latestCropPrice(@PathVariable Long cropId){
        CropPrice latest = cropsPriceService.getLatestPrice(cropId);
        return ResponseEntity.ok(latest);
    }
    
}
