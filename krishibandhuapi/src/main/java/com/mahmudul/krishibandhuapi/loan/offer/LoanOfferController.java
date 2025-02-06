package com.mahmudul.krishibandhuapi.loan.offer;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mahmudul.krishibandhuapi.dtos.LoanOfferDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/loans/offers")
@Validated
public class LoanOfferController {
    
    private LoanOfferService loanOfferService;

    public LoanOfferController(LoanOfferService loanOfferService){
        this.loanOfferService = loanOfferService;
    }

    @PostMapping("/")
    public ResponseEntity<LoanOffer> createLoanOffer(@Valid @RequestBody LoanOfferDTO loanOfferDTO){
        
        LoanOffer offer = loanOfferService.createLoanOffer(loanOfferDTO.toLoanOfferEntity(),loanOfferDTO.getOrgId());
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(offer.getId())
                        .toUri();
        
        return ResponseEntity.created(location).body(offer);
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<LoanOffer> getLoanOffer(@PathVariable Long loanId){
        LoanOffer loanOffer = loanOfferService.getLoanOffer(loanId);
        return ResponseEntity.ok(loanOffer);
    }

    @GetMapping("/")
    public ResponseEntity<List<LoanOffer>> getLoanOffers(){
        List<LoanOffer> loanOffers = loanOfferService.getLoanOffers();
        return ResponseEntity.ok(loanOffers);
    }

    @PutMapping("/{loanId}")
    public ResponseEntity<LoanOffer> updateLoanOffer(@PathVariable Long loanId, @Valid @RequestBody LoanOfferDTO loanOfferDTO){
        LoanOffer loanOffer = loanOfferService.updateLoanOffer(loanId, loanOfferDTO.toLoanOfferEntity());
        return ResponseEntity.ok(loanOffer);
    }

    @DeleteMapping("/{loanId}")
    public ResponseEntity<Void> deleteLoanOffer(@PathVariable Long loanId){
        loanOfferService.deleteLoanOffer(loanId);
        return ResponseEntity.noContent().build();
    }
}
