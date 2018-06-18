package com.cts.bankmanagement.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class EducationLoanVO {

	@Range(min = 1000000000000000l, max = 9999999999999999l, message = "Account number should have 16 digits")
	private Long accountNumber;

	@Range(min = 0, message = "Loan amount should be greater than zero")
	@NotNull(message = "Loan amount name can't be empty")
	private Long loanAmount;

	@NotNull(message = "Loan apply date name can't be empty")
	private Date loanApplyDate;

	@NotNull(message = "Loan duration name can't be empty")
	private Integer loanDuration;

	@Range(min = 0, message = "Fathers annual income should be greater than zero")
	@NotNull(message = "Fathers annual income  name can't be empty")
	private Long annualIncome;

	@Range(min = 0, message = "Course fee should be greater than zero")
	@NotNull(message = "Course fee name can't be empty")
	private Integer courseFee;

	@NotNull(message = "Course name can't be empty")
	@NotEmpty(message = "Course name can't be empty")
	private String courseName;

	@NotNull(message = "Father name can't be empty")
	@NotEmpty(message = "Father name can't be empty")
	private String fatherName;

	@Range(min = 0, message = "Id number should be greater than zero")
	@NotNull(message = "Id number name can't be empty")
	private Long idNumber;

	private String educationLoanId;

	private Long eduLoanAccountNumber;
	
	private UserVO userVO;

	public Long getEduLoanAccountNumber() {
		return eduLoanAccountNumber;
	}

	public void setEduLoanAccountNumber(Long eduLoanAccountNumber) {
		this.eduLoanAccountNumber = eduLoanAccountNumber;
	}

	public EducationLoanVO(Long accountNumber, Long loanAmount,
			Date loanApplyDate, Integer loanDuration, Long annualIncome,
			Integer courseFee, String courseName, String fatherName,
			Long idNumber) {
		super();
		this.accountNumber = accountNumber;
		this.loanAmount = loanAmount;
		this.loanApplyDate = loanApplyDate;
		this.loanDuration = loanDuration;
		this.annualIncome = annualIncome;
		this.courseFee = courseFee;
		this.courseName = courseName;
		this.fatherName = fatherName;
		this.idNumber = idNumber;
	}

	public EducationLoanVO() {
		super();
	}

	public Long getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getLoanApplyDate() {
		return loanApplyDate;
	}

	public void setLoanApplyDate(Date loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}

	public Integer getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(Integer loanDuration) {
		this.loanDuration = loanDuration;
	}

	public Long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Long annualIncome) {
		this.annualIncome = annualIncome;
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

	public Long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}

	public String getEducationLoanId() {
		return educationLoanId;
	}

	public void setEducationLoanId(String educationLoanId) {
		this.educationLoanId = educationLoanId;
	}

	public EducationLoanVO(Long accountNumber, Long loanAmount,
			Date loanApplyDate, Integer loanDuration, Long annualIncome,
			Integer courseFee, String courseName, String fatherName,
			Long idNumber, String educationLoanId, Long eduLoanAccountNumber) {
		super();
		this.userVO = new UserVO(accountNumber);
		this.accountNumber = accountNumber;
		this.loanAmount = loanAmount;
		this.loanApplyDate = loanApplyDate;
		this.loanDuration = loanDuration;
		this.annualIncome = annualIncome;
		this.courseFee = courseFee;
		this.courseName = courseName;
		this.fatherName = fatherName;
		this.idNumber = idNumber;
		this.educationLoanId = educationLoanId;
		this.eduLoanAccountNumber = eduLoanAccountNumber;
	}

	public EducationLoanVO(Long accountNumber, Long loanAmount,
			Date loanApplyDate, Integer loanDuration, Long annualIncome,
			Integer courseFee, String courseName, String fatherName,
			Long idNumber, String educationLoanId, Long eduLoanAccountNumber,
			UserVO userVO) {
		super();
		this.accountNumber =userVO.getAccountNumber();
		this.loanAmount = loanAmount;
		this.loanApplyDate = loanApplyDate;
		this.loanDuration = loanDuration;
		this.annualIncome = annualIncome;
		this.courseFee = courseFee;
		this.courseName = courseName;
		this.fatherName = fatherName;
		this.idNumber = idNumber;
		this.educationLoanId = educationLoanId;
		this.eduLoanAccountNumber = eduLoanAccountNumber;
		this.userVO = new UserVO(userVO.getAccountNumber(), userVO.getAccountType(), userVO.getAccountHolderName(),
				userVO.getAccountBalance());
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

}
