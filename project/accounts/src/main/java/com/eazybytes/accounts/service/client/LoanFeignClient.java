package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.dto.CardDto;
import com.eazybytes.accounts.dto.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("loan")
public interface LoanFeignClient {

    @GetMapping(value = "/api/fetch" , consumes = "application/json")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam String mobileNumber);
}
