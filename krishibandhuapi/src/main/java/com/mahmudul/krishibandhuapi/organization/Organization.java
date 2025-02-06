package com.mahmudul.krishibandhuapi.organization;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mahmudul.krishibandhuapi.loan.offer.LoanOffer;

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
@Table(name = "organizations")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Organization {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String address;
    private String contacts;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<LoanOffer> loanOffers;

    public Organization(String name, String description, String address, String contacts) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.contacts = contacts;
    }

}
