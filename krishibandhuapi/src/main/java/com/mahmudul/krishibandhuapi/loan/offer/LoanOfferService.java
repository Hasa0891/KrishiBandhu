package com.mahmudul.krishibandhuapi.loan.offer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mahmudul.krishibandhuapi.exceptions.loan.LoanOfferNotFoundException;
import com.mahmudul.krishibandhuapi.exceptions.organization.OrganizationNotFoundException;
import com.mahmudul.krishibandhuapi.organization.Organization;
import com.mahmudul.krishibandhuapi.organization.OrganizationRepository;

@Service
public class LoanOfferService {
    
    private LoanOfferRepository loanOfferRepository;
    private OrganizationRepository organizationRepository;

    public LoanOfferService(LoanOfferRepository loanOfferRepository, OrganizationRepository organizationRepository) {
        this.loanOfferRepository = loanOfferRepository;
        this.organizationRepository = organizationRepository;
    }

    public LoanOffer createLoanOffer(LoanOffer loanOffer, Long orgId){
        Organization organization = organizationRepository.findById(orgId)
                                    .orElseThrow(() -> new OrganizationNotFoundException("Organization Not Found with Id : " + orgId));
        loanOffer.setOrganization(organization);
        return loanOfferRepository.save(loanOffer);
    }

    public LoanOffer getLoanOffer(Long loanId){
        return loanOfferRepository.findById(loanId)
                .orElseThrow(() -> new LoanOfferNotFoundException("Organization Not Found with Id : " + loanId));
    }

    public List<LoanOffer> getLoanOffers(){
        return loanOfferRepository.findAll();
    }

    public LoanOffer updateLoanOffer(Long loanId, LoanOffer nwLoanOffer){
        return loanOfferRepository.findById(loanId)
                .map(loanOffer -> {
                    loanOffer.setAmount(nwLoanOffer.getAmount());
                    loanOffer.setName(nwLoanOffer.getName());
                    loanOffer.setDescription(nwLoanOffer.getDescription());
                    loanOffer.setTerms(nwLoanOffer.getTerms());
                    return loanOfferRepository.save(loanOffer);
                }).orElseThrow(() -> new LoanOfferNotFoundException("Organization Not Found with Id : " + loanId));
    }

    public void deleteLoanOffer(Long loanId){
        if(!loanOfferRepository.existsById(loanId)){
            throw new LoanOfferNotFoundException("Organization Not Found with Id : " + loanId);
        }
        loanOfferRepository.deleteById(loanId);
    }
}
