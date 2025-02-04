package com.mahmudul.krishibandhuapi.crops.price;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mahmudul.krishibandhuapi.crops.info.Crop;

public interface CropsPriceRepository extends CrudRepository<CropPrice,Long>{
    Optional<CropPrice> findTopByCropOrderByDateDesc(Crop crop);
}
