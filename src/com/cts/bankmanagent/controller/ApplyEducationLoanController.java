/*
 * ApplyEducationLoanController
 * Version
 * Copyright
 */

package com.cts.bankmanagement.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.bankmanagement.exception.BankManagementException;
import com.cts.bankmanagement.service.ApplyEducationLoanService;
import com.cts.bankmanagement.vo.EducationLoanVO;

@Controller
public class ApplyEducationLoanController {

	private static final Logger LOGGER = Logger
			.getLogger(ApplyEducationLoanController.class);

	@Autowired
	private ApplyEducationLoanService applyEducationLoanService;
	private final static Integer FIVE = 5;
	private final static Integer TEN = 10;

	@Autowired
	private Validator validator;

	@RequestMapping(value = "/addeducationloan", method = RequestMethod.POST)
	public String initateEducationLoanDetails(
			@RequestParam("accountNumber") Long accountNumber,
			@RequestParam("loanAmount") Long loanAmount,
			@RequestParam("loanApplyDate") String loanApplyDateStr,
			@RequestParam("loanDuration") Integer loanDuration,
			@RequestParam("annualIncome") Long annualIncome,
			@RequestParam("courseFee") Integer courseFee,
			@RequestParam("courseName") String courseName,
			@RequestParam("fatherName") String fatherName,
			@RequestParam("idNumber") Long idNumber,
			Model model) throws ParseException {

		boolean isLoanApplyDateError = false;
		boolean isValidDate = false;
		Calendar loanApplyDate = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			loanApplyDate = Calendar.getInstance();
			loanApplyDate.setTime(sdf.parse(loanApplyDateStr));

			Calendar today = Calendar.getInstance();
			int dayOfMonth = loanApplyDate.get(Calendar.DAY_OF_MONTH);
			int dayOfMonthToday = today.get(Calendar.DAY_OF_MONTH);
			int month = loanApplyDate.get(Calendar.MONTH);
			int monthToday = today.get(Calendar.MONTH);
			int year = loanApplyDate.get(Calendar.YEAR);
			int yearToday = today.get(Calendar.YEAR);
			if (dayOfMonth != dayOfMonthToday || month != monthToday
					|| year != yearToday) {
				throw new BankManagementException("Invalid date");
			}

		} catch (ParseException e) {
			LOGGER.error(e.getMessage());
			isLoanApplyDateError = true;
		} catch (BankManagementException e) {
			LOGGER.error(e.getMessage());
			isValidDate = true;
		}

		EducationLoanVO educationLoanVo = new EducationLoanVO(accountNumber,
				loanAmount, loanApplyDate.getTime(), loanDuration,
				annualIncome, courseFee, courseName, fatherName, idNumber);

		try{
		Set<ConstraintViolation<EducationLoanVO>> validationErrors = validator
				.validate(educationLoanVo);
		boolean isLoanDurationError = !FIVE.equals(educationLoanVo
				.getLoanDuration())
				&& !TEN.equals(educationLoanVo.getLoanDuration());
		if (!validationErrors.isEmpty() || isLoanDurationError
				|| isLoanApplyDateError || isValidDate) {

			Map<String, String> errors = getVallidationErrors(validationErrors);
			if (errors == null) {
				errors = new HashMap<String, String>(2);
			} else {
				System.out.println("Error found is " + errors);
			}
			if (isLoanDurationError) {
				errors.put("loanDuration", "Loan duration must be 5 or 10");
			}
			if (isLoanApplyDateError) {
				errors.put("loanApplyDate", "Loan apply date can't be empty");
			}
			if (isValidDate) {
				errors.put("loanApplyDate", "Select today's date");
			}

			/*return new ModelAndView("/EducationLoan/applyeducationloan",
					"errors", errors);*/
			
			model.addAttribute("errors", errors);
			return "/EducationLoan/applyeducationloan";
		}
		}catch(NullPointerException e){
			LOGGER.error(e.getMessage());
		}

		try {
			applyEducationLoanService
					.insertEducationLoanDetails(educationLoanVo);
		} catch (BankManagementException e) {
			/*LOGGER.error(e.getMessage());
			return new ModelAndView("/EducationLoan/applyeducationloan",
					"error", e.getMessage());*/
			LOGGER.error(e);
			model.addAttribute("error", e.getMessage());
			return "/EducationLoan/applyeducationloan";
		}

		/*return new ModelAndView("/EducationLoan/getEducationLoanResultScreen",
				"educationLoanVo", educationLoanVo);*/
		model.addAttribute("educationLoanVo", educationLoanVo);
		return "/EducationLoan/getEducationLoanResultScreen";

	}

	@RequestMapping(value = "/applyeducationloan", method = RequestMethod.GET)
	public String addTranactionForm() {
		return "EducationLoan/applyeducationloan";
	}

	private Map<String, String> getVallidationErrors(
			Set<ConstraintViolation<EducationLoanVO>> validationErrors) {
		if (validationErrors != null && !validationErrors.isEmpty()) {
			Map<String, String> errors = new HashMap<String, String>(
					validationErrors.size());
			for (ConstraintViolation<EducationLoanVO> constraintViolation : validationErrors) {
				errors.put(constraintViolation.getPropertyPath().toString(),
						constraintViolation.getMessage());
			}
			return errors;
		}
		return null;
	}
}
