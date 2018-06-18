package com.cts.bankmanagement.dao;

import java.util.List;

import com.cts.bankmanagement.vo.EducationLoanVO;

public interface ViewEducationLoanDao {

	List<EducationLoanVO> retrieveEducationLoanDetail(Long loanAccountNumber);

	EducationLoanVO retrieveEducationLoanDetails(String educationLoanId);

	EducationLoanVO retrieveEducationLoanDetails(String educationLoanId,
			Long accountNumber);
	
	boolean isEducationLoanIdExist(String educationLoanId);

}
