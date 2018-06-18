package com.cts.bankmanagement.service;

import java.util.List;

import com.cts.bankmanagement.exception.BankManagementException;
import com.cts.bankmanagement.vo.EducationLoanVO;

public interface ViewEducationLoanService {
	List<EducationLoanVO> retrieveEducationLoanDetails(String educationLoanId,
			Long accountNumber) throws BankManagementException;
}
