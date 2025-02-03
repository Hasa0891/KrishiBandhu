package com.mahmudul.krishibandhuapi.loan.offer;

import com.mahmudul.krishibandhuapi.organization.Organization;

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
@Table(name = "loan_offers")
@Getter
@Setter
@NoArgsConstructor
@ToString
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

    public LoanOffer(String name, String description, String terms, Double amount, Organization organization) {
        this.name = name;
        this.description = description;
        this.terms = terms;
        this.amount = amount;
        this.organization = organization;
    }

}
