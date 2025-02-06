package com.mahmudul.krishibandhuapi.loan.request;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRequestRepository extends JpaRepository<LoanRequest,Long> {
    
}
