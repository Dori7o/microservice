package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.dto.CardDto;
import com.eazybytes.accounts.dto.LoansDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="loan", fallback = LoansFallback.class)
public interface LoanFeignClient {

    @GetMapping(value = "/api/fetch" , consumes = "application/json")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestHeader("bank-correlation-id") String correlationId,@RequestParam String mobileNumber);
}
