package com.cts.bankmanagement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EDUCATION_LOAN_DETAILS")
public class EducationLoan implements Serializable {

	private static final long serialVersionUID = -78951415665453L;

	@Id
	@Column(name = "EDUCATION_LOAN_ID")
	private String educationLoanId;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_NUMBER")
	private User user;
	
	//private Long accountNumber;
	
	@Column(name = "EDU_LOAN_ACCOUNT_NUMBER")
	private Long eduLoanAccountNumber;

	@Column(name = "EDU_LOAN_AMOUNT")
	private Long eduLoanAmount;

	@Column(name = "EDU_LOAN_APPLY_DATE")
	private Date eduLoanApplyDate;

	@Column(name = "EDU_LOAN_DURATION")
	private Integer eduLoanDuration;

	@Column(name = "FATHER_ANNUAL_INCOME")
	private Long fatherAnnualIncome;

	@Column(name = "COURSE_FEE")
	private Integer courseFee;

	@Column(name = "COURSE_NAME")
	private String courseName;

	@Column(name = "FATHER_NAME")
	private String fatherName;

	@Column(name = "ID_CARD_NUMBER")
	private Long idCardNumber;

	public String getEducationLoanId() {
		return educationLoanId;
	}

	public void setEducationLoanId(String educationLoanId) {
		this.educationLoanId = educationLoanId;
	}

	/*public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}*/

	public Long getEduLoanAccountNumber() {
		return eduLoanAccountNumber;
	}

	public void setEduLoanAccountNumber(Long eduLoanAccountNumber) {
		this.eduLoanAccountNumber = eduLoanAccountNumber;
	}

	public Long getEduLoanAmount() {
		return eduLoanAmount;
	}

	public void setEduLoanAmount(Long eduLoanAmount) {
		this.eduLoanAmount = eduLoanAmount;
	}

	public Date getEduLoanApplyDate() {
		return eduLoanApplyDate;
	}

	public void setEduLoanApplyDate(Date eduLoanApplyDate) {
		this.eduLoanApplyDate = eduLoanApplyDate;
	}

	public Integer getEduLoanDuration() {
		return eduLoanDuration;
	}

	public void setEduLoanDuration(Integer eduLoanDuration) {
		this.eduLoanDuration = eduLoanDuration;
	}

	public Long getFatherAnnualIncome() {
		return fatherAnnualIncome;
	}

	public void setFatherAnnualIncome(Long fatherAnnualIncome) {
		this.fatherAnnualIncome = fatherAnnualIncome;
	}

	public Integer getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(Integer courseFee) {
		this.courseFee = courseFee;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Long getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(Long idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EducationLoan() {
		super();
	}

	public EducationLoan(String educationLoanId, Long accountNumber,
			Long eduLoanAccountNumber, Long eduLoanAmount,
			Date eduLoanApplyDate, Integer eduLoanDuration,
			Long fatherAnnualIncome, Integer courseFee, String courseName,
			String fatherName, Long idCardNumber) {
		super();
		this.educationLoanId = educationLoanId;
		this.user = new User(accountNumber);
		this.eduLoanAccountNumber = eduLoanAccountNumber;
		this.eduLoanAmount = eduLoanAmount;
		this.eduLoanApplyDate = eduLoanApplyDate;
		this.eduLoanDuration = eduLoanDuration;
		this.fatherAnnualIncome = fatherAnnualIncome;
		this.courseFee = courseFee;
		this.courseName = courseName;
		this.fatherName = fatherName;
		this.idCardNumber = idCardNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((courseFee == null) ? 0 : courseFee.hashCode());
		result = prime * result
				+ ((courseName == null) ? 0 : courseName.hashCode());
		result = prime
				* result
				+ ((eduLoanAccountNumber == null) ? 0 : eduLoanAccountNumber
						.hashCode());
		result = prime * result
				+ ((eduLoanAmount == null) ? 0 : eduLoanAmount.hashCode());
		result = prime
				* result
				+ ((eduLoanApplyDate == null) ? 0 : eduLoanApplyDate.hashCode());
		result = prime * result
				+ ((eduLoanDuration == null) ? 0 : eduLoanDuration.hashCode());
		result = prime * result
				+ ((educationLoanId == null) ? 0 : educationLoanId.hashCode());
		result = prime
				* result
				+ ((fatherAnnualIncome == null) ? 0 : fatherAnnualIncome
						.hashCode());
		result = prime * result
				+ ((fatherName == null) ? 0 : fatherName.hashCode());
		result = prime * result
				+ ((idCardNumber == null) ? 0 : idCardNumber.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EducationLoan other = (EducationLoan) obj;
		if (courseFee == null) {
			if (other.courseFee != null)
				return false;
		} else if (!courseFee.equals(other.courseFee))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (eduLoanAccountNumber == null) {
			if (other.eduLoanAccountNumber != null)
				return false;
		} else if (!eduLoanAccountNumber.equals(other.eduLoanAccountNumber))
			return false;
		if (eduLoanAmount == null) {
			if (other.eduLoanAmount != null)
				return false;
		} else if (!eduLoanAmount.equals(other.eduLoanAmount))
			return false;
		if (eduLoanApplyDate == null) {
			if (other.eduLoanApplyDate != null)
				return false;
		} else if (!eduLoanApplyDate.equals(other.eduLoanApplyDate))
			return false;
		if (eduLoanDuration == null) {
			if (other.eduLoanDuration != null)
				return false;
		} else if (!eduLoanDuration.equals(other.eduLoanDuration))
			return false;
		if (educationLoanId == null) {
			if (other.educationLoanId != null)
				return false;
		} else if (!educationLoanId.equals(other.educationLoanId))
			return false;
		if (fatherAnnualIncome == null) {
			if (other.fatherAnnualIncome != null)
				return false;
		} else if (!fatherAnnualIncome.equals(other.fatherAnnualIncome))
			return false;
		if (fatherName == null) {
			if (other.fatherName != null)
				return false;
		} else if (!fatherName.equals(other.fatherName))
			return false;
		if (idCardNumber == null) {
			if (other.idCardNumber != null)
				return false;
		} else if (!idCardNumber.equals(other.idCardNumber))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EducationLoan [educationLoanId=" + educationLoanId + ", user="
				+ user + ", eduLoanAccountNumber=" + eduLoanAccountNumber
				+ ", eduLoanAmount=" + eduLoanAmount + ", eduLoanApplyDate="
				+ eduLoanApplyDate + ", eduLoanDuration=" + eduLoanDuration
				+ ", fatherAnnualIncome=" + fatherAnnualIncome + ", courseFee="
				+ courseFee + ", courseName=" + courseName + ", fatherName="
				+ fatherName + ", idCardNumber=" + idCardNumber + "]";
	}
}
