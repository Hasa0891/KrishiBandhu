package com.mahmudul.krishibandhuapi.loan.request;

import java.time.LocalDateTime;

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
    @JoinColumn(name = "loan_offer_id", nullable = false)
    private LoanOffer loanOffer;

    @ManyToOne()
    @JoinColumn(name = "farmer_id", referencedColumnName = "id")
    private Farmer farmer;
    
    private LocalDateTime requestDate;
    private LocalDateTime updateDate;
    private String status;

    public LoanRequest(LocalDateTime requestDate, LocalDateTime updateDate, String status, LoanOffer loanOffer, Farmer farmer) {
        this.requestDate = requestDate;
        this.updateDate = updateDate;
        this.status = status;
        this.loanOffer = loanOffer;
        this.farmer = farmer;
    }

}
