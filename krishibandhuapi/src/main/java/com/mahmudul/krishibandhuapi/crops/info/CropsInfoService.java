package com.mahmudul.krishibandhuapi.crops.info;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mahmudul.krishibandhuapi.crops.price.CropPrice;
import com.mahmudul.krishibandhuapi.dtos.CropWithPrice;
import com.mahmudul.krishibandhuapi.exceptions.crops.CropNotFoundException;

@Service
public class CropsInfoService {

    private CropsInfoRepository cropsInfoRepository;

    public CropsInfoService(CropsInfoRepository cropsInfoRepository){
        this.cropsInfoRepository = cropsInfoRepository;
    }

    public Crop createCropInfo(Crop crop){
        return cropsInfoRepository.save(crop);
    }

    public Crop getCrop(Long cropId){
        return cropsInfoRepository.findById(cropId)
        .orElseThrow(() -> new CropNotFoundException("Crop Not Found With Id : " + cropId));
    }

    public List<CropWithPrice> getCropsWithLatestPrice(){
        List<Crop> crops = cropsInfoRepository.findAll();

        return crops.stream().map(crop -> {
            CropPrice latestPrice = crop.getPrices()
                                    .stream()
                                    .max(Comparator.comparing(CropPrice::getDate))
                                    .orElse(null);
            return new CropWithPrice(
                crop.getId(), 
                crop.getName(),
                latestPrice != null ? latestPrice.getPrice() : null,
                latestPrice != null ? latestPrice.getUnit() : null
            );
        }).toList();
    }

    public Crop modifyCrop(Crop nwCrop, Long cropId){
        return cropsInfoRepository.findById(cropId)
        .map(crop -> {
            crop.setType(nwCrop.getType());
            crop.setName(nwCrop.getName());
            crop.setDescription(nwCrop.getDescription());
            return cropsInfoRepository.save(crop);
        })
        .orElseThrow(() -> new CropNotFoundException("Crop Not Found With Id : " + cropId));
    }

    public void deleteCrop(Long cropId){
        if(!cropsInfoRepository.existsById(cropId)){
            throw new CropNotFoundException("Crop Not Found With Id : " + cropId);
        }
        cropsInfoRepository.deleteById(cropId);;
    }
}
