package com.mahmudul.krishibandhuapi.organization;

import java.util.ArrayList;
import java.util.List;

import com.mahmudul.krishibandhuapi.loan.offer.LoanOffer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "organizations")
public class Organization {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String address;
    private String contacts;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoanOffer> loanOffers = new ArrayList<>();

    public Organization(){}

    public Organization(String name, String description, String address, String contacts) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getContacts() {
        return contacts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public List<LoanOffer> getLoanOffers() {
        return loanOffers;
    }

    public void setLoanOffers(List<LoanOffer> loanOffers) {
        this.loanOffers = loanOffers;
    }

    public void addLoanOffer(LoanOffer loanOffer) {
        loanOffers.add(loanOffer);
        loanOffer.setOrganization(this);
    }

    public void removeLoanOffer(LoanOffer loanOffer) {
        loanOffers.remove(loanOffer);
        loanOffer.setOrganization(null);
    }
}
