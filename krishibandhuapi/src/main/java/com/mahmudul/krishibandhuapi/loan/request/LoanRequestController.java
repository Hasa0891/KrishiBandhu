package com.mahmudul.krishibandhuapi.loan.request;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mahmudul.krishibandhuapi.dtos.LoanRequestDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/loans/requests")
@Validated
public class LoanRequestController {
    
    private LoanRequestService loanRequestService;

    public LoanRequestController(LoanRequestService loanRequestService){
        this.loanRequestService = loanRequestService;
    }

    @PostMapping("/")
    public ResponseEntity<LoanRequest> createLoanRequest(@Valid @RequestBody LoanRequestDTO loanRequestDTO){
        LoanRequest loanRequest = loanRequestService.createLoanRequest(loanRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")                
                        .buildAndExpand(loanRequest.getId())
                        .toUri();

        return ResponseEntity.created(location).body(loanRequest);
    }

    @GetMapping("/")
    public ResponseEntity<List<LoanRequest>> getLoanRequests(){
        List<LoanRequest> requests = loanRequestService.getLoanRequests();
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/{loanReqId}")
    public ResponseEntity<LoanRequest> getLoanRequest(@PathVariable Long loanReqId){
        LoanRequest loanRequest = loanRequestService.getLoanRequest(loanReqId);
        return ResponseEntity.ok(loanRequest);
    }

    @PutMapping("/{loanReqId}")
    public ResponseEntity<LoanRequest> updateLoanRequest(
        @PathVariable Long loanReqId, 
        @Valid @RequestBody LoanRequestDTO loanRequestDTO
    ){
        LoanRequest loanRequest = loanRequestService.updateStatus(loanReqId, loanRequestDTO);
        return ResponseEntity.ok(loanRequest);
    }

}
