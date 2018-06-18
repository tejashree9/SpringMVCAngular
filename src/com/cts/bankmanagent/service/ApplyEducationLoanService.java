package com.cts.bankmanagement.service;

import com.cts.bankmanagement.exception.BankManagementException;
import com.cts.bankmanagement.vo.EducationLoanVO;

public interface ApplyEducationLoanService {
	String insertEducationLoanDetails(EducationLoanVO educationloanvo)
			throws BankManagementException;

	void setLoanId(EducationLoanVO educationloanvo);
}
