package com.cts.bankmanagement.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.cts.bankmanagement.entity.EducationLoan;
import com.cts.bankmanagement.vo.EducationLoanVO;
import com.cts.bankmanagement.vo.UserVO;

@Repository("viewEducationLoanDao")
public class ViewEducationLoanDaoImpl implements ViewEducationLoanDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public EducationLoanVO retrieveEducationLoanDetails(String educationLoanId) {
		return getEducationLoanVo((EducationLoan) sessionFactory
				.getCurrentSession().get(EducationLoan.class, educationLoanId));

	}
	
	@Override
	public boolean isEducationLoanIdExist(String educationLoanId) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from EducationLoan where educationLoanId=:educationLoanId");
		query.setParameter("educationLoanId", educationLoanId);
		return CollectionUtils.isEmpty(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EducationLoanVO> retrieveEducationLoanDetail(Long accountNumber) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from EducationLoan e inner join fetch e.user as u where u.accountNumber = :number");
		query.setParameter("number", accountNumber);
		return getEducationLoanVOs((List<EducationLoan>) query.list());
	}

	private List<EducationLoanVO> getEducationLoanVOs(List<EducationLoan> list) {
		if (CollectionUtils.isEmpty(list)) {
			return Collections.emptyList();
		}

		List<EducationLoanVO> educationLoanVOs = new ArrayList<EducationLoanVO>(
				list.size());
		for (EducationLoan educationLoan : list) {
			educationLoanVOs.add(getEducationLoanVo(educationLoan));
		}
		return educationLoanVOs;
	}

	private EducationLoanVO getEducationLoanVo(EducationLoan educationLoan) {
		if (educationLoan != null) {
			UserVO userVO = UserDAOImpl.getUserVO(educationLoan.getUser());
			return new EducationLoanVO(educationLoan.getUser()
					.getAccountNumber(), educationLoan.getEduLoanAmount(),
					educationLoan.getEduLoanApplyDate(),
					educationLoan.getEduLoanDuration(),
					educationLoan.getFatherAnnualIncome(),
					educationLoan.getCourseFee(),
					educationLoan.getCourseName(),
					educationLoan.getFatherName(),
					educationLoan.getIdCardNumber(),
					educationLoan.getEducationLoanId(),
					educationLoan.getEduLoanAccountNumber(),
					userVO);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public EducationLoanVO retrieveEducationLoanDetails(String educationLoanId,
			Long accountNumber) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from EducationLoan e inner join fetch e.user as u where e.educationLoanId = :id and u.accountNumber = :number");
		query.setParameter("id", educationLoanId);
		query.setParameter("number", accountNumber);

		List<EducationLoan> educationLoan = query.list();
		if (!CollectionUtils.isEmpty(educationLoan)) {
			// System.out.println(educationLoan);
			return getEducationLoanVo(educationLoan.get(0));
		}
		return null;
	}

	

}
