package com.mahmudul.krishibandhuapi.loan.request;

import com.mahmudul.krishibandhuapi.loan.offer.LoanOffer;
import com.mahmudul.krishibandhuapi.user.farmer.Farmer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_requests")
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
    
    private String requestDate;
    private String updateDate;
    private String status;

    public LoanRequest() {}
    public LoanRequest(String requestDate, String updateDate, String status, LoanOffer loanOffer, Farmer farmer) {
        this.requestDate = requestDate;
        this.updateDate = updateDate;
        this.status = status;
        this.loanOffer = loanOffer;
        this.farmer = farmer;
    }

    public String getRequestDate(){
        return requestDate;
    }

    public void setRequestDate(String requestDate){
        this.requestDate = requestDate;
    }

    public String getUpdateDate(){
        return updateDate;
    }

    public void setUpdateDate(String updateDate){
        this.updateDate = updateDate;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public LoanOffer getLoanOffer(){
        return loanOffer;
    }

    public void setLoanOffer(LoanOffer loanOffer){
        this.loanOffer = loanOffer;
    }

    public Farmer getFarmer(){
        return farmer;
    }

    public void setFarmer(Farmer farmer){
        this.farmer = farmer;
    }

}
