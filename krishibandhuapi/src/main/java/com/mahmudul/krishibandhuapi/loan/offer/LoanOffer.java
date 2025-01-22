package com.mahmudul.krishibandhuapi.loan.offer;

import com.mahmudul.krishibandhuapi.organization.Organization;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_offers")
public class LoanOffer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String terms;
    private Double amount;

    @ManyToOne()
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    public LoanOffer() {}
    public LoanOffer(String name, String description, String terms, Double amount, Organization organization) {
        this.name = name;
        this.description = description;
        this.terms = terms;
        this.amount = amount;
        this.organization = organization;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getTerms(){
        return terms;
    }

    public void setTerms(String terms){
        this.terms = terms;
    }

    public Double getAmount(){
        return amount;
    }

    public void setAmount(Double amount){
        this.amount = amount;
    }

    public Organization getOrganization(){
        return organization;
    }

    public void setOrganization(Organization organization){
        this.organization = organization;
    }
}
