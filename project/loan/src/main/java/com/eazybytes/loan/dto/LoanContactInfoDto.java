package com.eazybytes.loan.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "loan")
public record LoanContactInfoDto(String message, Map<String,String> contactDetails, List<String> onCallSupport) {
}
