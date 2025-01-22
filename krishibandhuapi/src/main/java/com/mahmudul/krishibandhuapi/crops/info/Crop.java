package com.mahmudul.krishibandhuapi.crops.info;

import java.util.ArrayList;
import java.util.List;

import com.mahmudul.krishibandhuapi.crops.price.CropPrice;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "crops")
public class Crop {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String type;
  private String name;
  private String description;

  @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CropPrice> prices = new ArrayList<>();

  public Crop(){}

  public Crop(String type, String name, String description) {
    this.type = type;
    this.name = name;
    this.description = description;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<CropPrice> getPrices() {
    return prices;
  }

  public void setPrices(List<CropPrice> prices) {
    this.prices = prices;
  }

  public void addPrice(CropPrice price){
    this.prices.add(price);
    price.setCrop(this);
  }

  public void removePrice(CropPrice price){
    this.prices.remove(price);
    price.setCrop(null);
  }

}
