package com.mahmudul.krishibandhuapi.loan.request;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mahmudul.krishibandhuapi.dtos.LoanRequestDTO;
import com.mahmudul.krishibandhuapi.exceptions.loan.LoanOfferNotFoundException;
import com.mahmudul.krishibandhuapi.exceptions.loan.LoanRequestNotFoundException;
import com.mahmudul.krishibandhuapi.exceptions.user.farmer.FarmerNotFoundException;
import com.mahmudul.krishibandhuapi.loan.offer.LoanOffer;
import com.mahmudul.krishibandhuapi.loan.offer.LoanOfferRepository;
import com.mahmudul.krishibandhuapi.user.farmer.Farmer;
import com.mahmudul.krishibandhuapi.user.farmer.FarmerRepository;

@Service
public class LoanRequestService {
    
    private LoanRequestRepository loanRequestRepository;
    private LoanOfferRepository loanOfferRepository;
    private FarmerRepository farmerRepository;

    public LoanRequestService(
        LoanRequestRepository loanRequestRepository,
        LoanOfferRepository loanOfferRepository,
        FarmerRepository farmerRepository
    ){
        this.loanRequestRepository = loanRequestRepository;
        this.loanOfferRepository = loanOfferRepository;
        this.farmerRepository = farmerRepository;
    }

    public LoanRequest createLoanRequest(LoanRequestDTO loanRequestDTO){
        
        LoanOffer loanOffer = loanOfferRepository.findById(loanRequestDTO.getLoanOfferId())
            .orElseThrow(() -> new LoanOfferNotFoundException("Loan Offer Not Found with Id : " + loanRequestDTO.getLoanOfferId()));
        
        Farmer farmer = farmerRepository.findById(loanRequestDTO.getFarmerId())
            .orElseThrow(() -> new FarmerNotFoundException("Farmer Not Found with Id : " + loanRequestDTO.getFarmerId()));

        LoanRequest loanRequest = new LoanRequest(loanRequestDTO.getStatus(),loanOffer, farmer);

        return loanRequestRepository.save(loanRequest);
    }

    public List<LoanRequest> getLoanRequests(){
        return loanRequestRepository.findAll();
    }

    public LoanRequest getLoanRequest(Long loanReqId){
        return loanRequestRepository.findById(loanReqId)
            .orElseThrow(() -> new LoanRequestNotFoundException("Loan Request Not Found with Id : " + loanReqId));
    }

    public LoanRequest updateStatus(Long loanReqId, LoanRequestDTO loanRequestDTO){
        return loanRequestRepository.findById(loanReqId)
                .map(loanReq -> {
                    loanReq.setStatus(loanRequestDTO.getStatus());
                    return loanRequestRepository.save(loanReq);
                }).orElseThrow(() -> new LoanRequestNotFoundException("Loan Request Not Found with Id : " + loanReqId));
    }
}
