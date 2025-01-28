package com.mahmudul.krishibandhuapi.crops.price;

import java.time.LocalDateTime;

import com.mahmudul.krishibandhuapi.crops.info.Crop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CropPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime date;
    private Double price;
    private String unit;

    @ManyToOne()
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

    public CropPrice() {}

    public CropPrice(LocalDateTime date, Double price, String unit, Crop crop) {
        this.date = date;
        this.price = price;
        this.unit = unit;
        this.crop = crop;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

}
