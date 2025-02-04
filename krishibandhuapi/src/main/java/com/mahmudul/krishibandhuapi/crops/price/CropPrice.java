package com.mahmudul.krishibandhuapi.crops.price;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import com.mahmudul.krishibandhuapi.crops.info.Crop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "crop_price")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CropPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    private LocalDateTime date;

    private Double price;
    private String unit;

    @ManyToOne()
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

    public CropPrice(LocalDateTime date, Double price, String unit, Crop crop) {
        this.date = date;
        this.price = price;
        this.unit = unit;
        this.crop = crop;
    }

}
