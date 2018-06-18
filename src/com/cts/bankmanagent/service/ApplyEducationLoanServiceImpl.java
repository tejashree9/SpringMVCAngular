package com.cts.bankmanagement.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.bankmanagement.dao.ApplyEducationLoanDao;
import com.cts.bankmanagement.dao.UserDAO;
import com.cts.bankmanagement.exception.BankManagementException;
import com.cts.bankmanagement.vo.EducationLoanVO;

@Service("applyEducationLoanService")
public class ApplyEducationLoanServiceImpl implements ApplyEducationLoanService {

	static Logger LOGGER = Logger
			.getLogger(ApplyEducationLoanServiceImpl.class);

	@Autowired
	private UserDAO userDao;

	@Autowired
	private ApplyEducationLoanDao applyEducationLoanDao;

	@Transactional
	@Override
	public String insertEducationLoanDetails(EducationLoanVO educationloanvo)
			throws BankManagementException {
		Long accountNumber = educationloanvo.getAccountNumber();
		if (userDao.isAccountExist(accountNumber)) {
			throw new BankManagementException("Account number does not exist.");
		} else {
			setLoanId(educationloanvo);
		}
		return applyEducationLoanDao
				.insertEduactionLoanDetails(educationloanvo);
	}

	@Override
	public void setLoanId(EducationLoanVO educationloanvo) {
		Long count = applyEducationLoanDao.getEducationLoanCount();
		String educationLoanId = String.format("EL-%05d", ++count);
		educationloanvo.setEducationLoanId(educationLoanId);
	}

}
