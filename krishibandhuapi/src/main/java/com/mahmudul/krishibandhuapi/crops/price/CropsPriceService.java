package com.mahmudul.krishibandhuapi.crops.price;

import org.springframework.stereotype.Service;

import com.mahmudul.krishibandhuapi.crops.info.Crop;
import com.mahmudul.krishibandhuapi.crops.info.CropsInfoRepository;
import com.mahmudul.krishibandhuapi.exceptions.crops.CropNotFoundException;
import com.mahmudul.krishibandhuapi.exceptions.crops.CropsPriceNotFoundException;

@Service
public class CropsPriceService {
    private CropsPriceRepository cropsPriceRepository;
    private CropsInfoRepository cropsInfoRepository;

    public CropsPriceService(CropsPriceRepository cropsPriceRepository, CropsInfoRepository cropsInfoRepository){
        this.cropsPriceRepository = cropsPriceRepository;
        this.cropsInfoRepository = cropsInfoRepository;
    }

    public CropPrice addCropPrice(Long cropId, CropPrice nwCropPrice){
        Crop crop = cropsInfoRepository.findById(cropId)
                    .orElseThrow(() -> new CropNotFoundException("Crop Not Found with Id : " + cropId));
        nwCropPrice.setCrop(crop);
        return cropsPriceRepository.save(nwCropPrice);
    }

    public CropPrice getLatestPrice(Long cropId){
        Crop crop = cropsInfoRepository.findById(cropId)
                    .orElseThrow(() -> new CropNotFoundException("Crop Not Found with Id : " + cropId));
        return cropsPriceRepository.findTopByCropOrderByDateDesc(crop)
                .orElseThrow(() -> new CropsPriceNotFoundException("No Price Info Available for " + crop.getName()));
    }
}
