package com.mahmudul.krishibandhuapi.crops.info;

import java.util.List;

import com.mahmudul.krishibandhuapi.crops.price.CropPrice;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "crops")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Crop {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String type;
  private String name;
  private String description;

  @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CropPrice> prices;

  public Crop(String type, String name, String description) {
    this.type = type;
    this.name = name;
    this.description = description;
  }

}
