package com.mahmudul.krishibandhuapi.loan.request;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.mahmudul.krishibandhuapi.loan.offer.LoanOffer;
import com.mahmudul.krishibandhuapi.user.farmer.Farmer;

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
@Table(name = "loan_requests")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoanRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "loan_offer_id", referencedColumnName = "id")
    private LoanOffer loanOffer;

    @ManyToOne()
    @JoinColumn(name = "farmer_id", referencedColumnName = "id")
    private Farmer farmer;
    
    @CreationTimestamp
    private LocalDateTime requestDate;
    
    @UpdateTimestamp
    private LocalDateTime updateDate;
    
    private String status;

    public LoanRequest(String status, LoanOffer loanOffer, Farmer farmer) {
        this.status = status;
        this.loanOffer = loanOffer;
        this.farmer = farmer;
    }

}
