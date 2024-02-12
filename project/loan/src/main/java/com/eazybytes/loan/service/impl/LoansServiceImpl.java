package com.eazybytes.loan.service.impl;

import com.eazybytes.loan.constants.LoansConstants;
import com.eazybytes.loan.dto.LoansDto;
import com.eazybytes.loan.entity.Loans;
import com.eazybytes.loan.exception.LoanAlreadyExistsException;
import com.eazybytes.loan.exception.ResourceNotFoundException;
import com.eazybytes.loan.mapper.LoansMapper;
import com.eazybytes.loan.repository.LoansRepository;
import com.eazybytes.loan.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {


        private LoansRepository loansRepository;

        @Override
        public void createLoan(String mobileNumber) {
            Optional<Loans> optionalLoans= loansRepository.findByMobileNumber(mobileNumber);
            if(optionalLoans.isPresent()){
                throw new LoanAlreadyExistsException("Loan already registered with given mobileNumber "+mobileNumber);
            }
            loansRepository.save(createNewLoan(mobileNumber));
        }

        private Loans createNewLoan(String mobileNumber) {
            Loans newLoan = new Loans();
            long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
            newLoan.setLoanNumber(Long.toString(randomLoanNumber));
            newLoan.setMobileNumber(mobileNumber);
            newLoan.setLoanType(LoansConstants.HOME_LOAN);
            newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
            newLoan.setAmountPaid(0);
            newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
            return newLoan;
        }


        @Override
        public LoansDto fetchLoan(String mobileNumber) {
            Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                    () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
            );
            return LoansMapper.mapToLoansDto(loans, new LoansDto());
        }


        @Override
        public boolean updateLoan(LoansDto loansDto) {
            Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Loan", "LoanNumber", loansDto.getLoanNumber()));
            LoansMapper.mapToLoans(loansDto, loans);
            loansRepository.save(loans);
            return  true;
        }

        @Override
        public boolean deleteLoan(String mobileNumber) {
            Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                    () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
            );
            loansRepository.deleteById(loans.getLoanId());
            return true;
        }
}
