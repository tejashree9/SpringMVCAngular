package com.cts.bankmanagement.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cts.bankmanagement.entity.EducationLoan;
import com.cts.bankmanagement.vo.EducationLoanVO;

@Repository("applyEducationLoanDao")
public class ApplyEducationLoanDaoImpl implements ApplyEducationLoanDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String insertEduactionLoanDetails(EducationLoanVO educationloanvo) {

		EducationLoan educationloan = getEducationLoan(educationloanvo);
		sessionFactory.getCurrentSession().save(educationloan);
		return educationloanvo.getEducationLoanId();
	}

	@Override
	public Long getEducationLoanCount() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select count(educationLoanId) from EducationLoan");
		Long count = (Long) query.uniqueResult();
		return count;
	}

	private EducationLoan getEducationLoan(EducationLoanVO educationloanvo) {
		return new EducationLoan(educationloanvo.getEducationLoanId(),
				educationloanvo.getAccountNumber(),
				educationloanvo.getEduLoanAccountNumber(),
				educationloanvo.getLoanAmount(),
				educationloanvo.getLoanApplyDate(),
				educationloanvo.getLoanDuration(),
				educationloanvo.getAnnualIncome(),
				educationloanvo.getCourseFee(),
				educationloanvo.getCourseName(),
				educationloanvo.getFatherName(), educationloanvo.getIdNumber());

	}

}
