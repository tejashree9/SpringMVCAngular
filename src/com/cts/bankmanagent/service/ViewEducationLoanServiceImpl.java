package com.cts.bankmanagement.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cts.bankmanagement.dao.UserDAO;
import com.cts.bankmanagement.dao.ViewEducationLoanDao;
import com.cts.bankmanagement.exception.BankManagementException;
import com.cts.bankmanagement.vo.EducationLoanVO;

@Service("viewEducationLoanService")
public class ViewEducationLoanServiceImpl implements ViewEducationLoanService {

	@Autowired
	private ViewEducationLoanDao viewEducationLoanDao;

	@Autowired
	private UserDAO userDao;

	List<EducationLoanVO> list = new ArrayList<EducationLoanVO>();

	@Override
	@Transactional
	public List<EducationLoanVO> retrieveEducationLoanDetails(
			String educationLoanId, Long accountNumber)
			throws BankManagementException {

		educationLoanId = StringUtils.trimWhitespace(educationLoanId);

		if (StringUtils.hasLength(educationLoanId) && accountNumber == null) {
			if (viewEducationLoanDao.isEducationLoanIdExist(educationLoanId)) {
				throw new BankManagementException(
						"Education Loan Id does not exists.");
			}
			return Arrays.asList(viewEducationLoanDao
					.retrieveEducationLoanDetails(educationLoanId));
		} else if (!StringUtils.hasLength(educationLoanId)
				&& accountNumber != null) {
			if (userDao.isAccountExist(accountNumber)) {
				throw new BankManagementException(
						"Account Number does not exists.");
			}
			return viewEducationLoanDao
					.retrieveEducationLoanDetail(accountNumber);
		} else if (educationLoanId != null && accountNumber != null) {
			if (viewEducationLoanDao.isEducationLoanIdExist(educationLoanId)) {
				throw new BankManagementException(
						"Education Loan Id does not exists.");
			}
			if (userDao.isAccountExist(accountNumber)) {
				throw new BankManagementException(
						"Account Number does not exists.");
			}
			return Arrays.asList(viewEducationLoanDao
					.retrieveEducationLoanDetails(educationLoanId,
							accountNumber));
		} else {
			return null;
		}

	}

}
