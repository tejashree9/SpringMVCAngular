package com.cts.bankmanagement.dao;

import com.cts.bankmanagement.vo.EducationLoanVO;

public interface ApplyEducationLoanDao {
	String insertEduactionLoanDetails(EducationLoanVO educationloanvo);

	Long getEducationLoanCount();
}
