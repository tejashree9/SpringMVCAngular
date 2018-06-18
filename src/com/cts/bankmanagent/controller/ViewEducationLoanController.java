package com.cts.bankmanagement.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.bankmanagement.exception.BankManagementException;
import com.cts.bankmanagement.service.ViewEducationLoanService;
import com.cts.bankmanagement.vo.EducationLoanVO;

@Controller
public class ViewEducationLoanController {

	private static final Logger LOGGER = Logger
			.getLogger(ApplyEducationLoanController.class);

	@Autowired
	private ViewEducationLoanService viewEducationLoanService;

	/*
	 * @RequestMapping(value = "showeducationloan", method = RequestMethod.GET)
	 * public ModelAndView searchEducationLoanDetails(
	 * 
	 * @RequestParam("educationLoanId") String educationLoanId,
	 * 
	 * @RequestParam("accountNumber") Long accountNumber) {
	 * 
	 * List<EducationLoanVO> educationLoanVo = viewEducationLoanService
	 * .retrieveEducationLoanDetails(educationLoanId, accountNumber);
	 * 
	 * return new ModelAndView("/EducationLoan/viewEducationLoanResultScreen",
	 * "educationLoanVo", educationLoanVo); }
	 * 
	 * @RequestMapping(value = "/geteducationloansearchscreen", method =
	 * RequestMethod.GET) public String addTranactionForm() { return
	 * "EducationLoan/geteducationloansearchscreen"; }
	 */

	@RequestMapping(value = "/static/html/EducationLoan/showeducationloan", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EducationLoanVO> searchEducationLoanDetails(
			@RequestParam("educationLoanId") String educationLoanId,
			@RequestParam("accountNumber") Long accountNumber) {
		List<EducationLoanVO> educationLoanVo = null;
		try {
			educationLoanVo = viewEducationLoanService
					.retrieveEducationLoanDetails(educationLoanId,
							accountNumber);
		} catch (BankManagementException e) {
			LOGGER.error(e.getMessage());
		}
		return educationLoanVo;
	}

	/*
	 * @RequestMapping(value = "/geteducationloansearchscreen", method =
	 * RequestMethod.GET) public String addTranactionForm() { return
	 * "EducationLoan/geteducationloansearchscreen"; }
	 */
}
