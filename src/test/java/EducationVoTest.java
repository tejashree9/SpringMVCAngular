package test.java;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.bankmanagement.exception.BankManagementException;
import com.cts.bankmanagement.service.ApplyEducationLoanService;
import com.cts.bankmanagement.service.ViewEducationLoanService;
import com.cts.bankmanagement.vo.EducationLoanVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:bms-test-context.xml")
public class EducationVoTest {

	@Autowired
	private Validator validator;

	@Autowired
	private ApplyEducationLoanService applyEducationLoanService;

	@Autowired
	private ViewEducationLoanService viewEducationLoanService;

	@Test
	public void testInsertEducationLoanDetailsById()
			throws BankManagementException {
		assertThat(applyEducationLoanService,
				instanceOf(ApplyEducationLoanService.class));

		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);
		String educationLoanId = applyEducationLoanService
				.insertEducationLoanDetails(educationLoanVo);

		List<EducationLoanVO> addedEducationLoanVOs = viewEducationLoanService
				.retrieveEducationLoanDetails(educationLoanId, null);

		assertThat(addedEducationLoanVOs.size(), is(1));
		EducationLoanVO addedEducationLoanVO = addedEducationLoanVOs.get(0);
		assertThat(addedEducationLoanVO.getAccountNumber(),
				is(educationLoanVo.getAccountNumber()));
		assertThat(addedEducationLoanVO.getEduLoanAccountNumber(),
				is(educationLoanVo.getEduLoanAccountNumber()));
		assertThat(addedEducationLoanVO.getLoanApplyDate().getTime(),
				is(notNullValue()));
		assertThat(addedEducationLoanVO.getLoanDuration(),
				is(educationLoanVo.getLoanDuration()));
		assertThat(addedEducationLoanVO.getAnnualIncome(),
				is(educationLoanVo.getAnnualIncome()));
		assertThat(addedEducationLoanVO.getCourseFee(),
				is(educationLoanVo.getCourseFee()));
		assertThat(addedEducationLoanVO.getCourseName(),
				is(educationLoanVo.getCourseName()));
		assertThat(addedEducationLoanVO.getFatherName(),
				is(educationLoanVo.getFatherName()));
		assertThat(addedEducationLoanVO.getIdNumber(),
				is(educationLoanVo.getIdNumber()));

	}

	@Test
	public void testInsertEducationLoanDetails() throws BankManagementException {
		assertThat(applyEducationLoanService,
				instanceOf(ApplyEducationLoanService.class));

		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);
		String educationLoanId = applyEducationLoanService
				.insertEducationLoanDetails(educationLoanVo);

		List<EducationLoanVO> addedEducationLoanVOs = viewEducationLoanService
				.retrieveEducationLoanDetails(educationLoanId,
						educationLoanVo.getAccountNumber());

		assertThat(addedEducationLoanVOs.size(), is(1));
		EducationLoanVO addedEducationLoanVO = addedEducationLoanVOs.get(0);
		assertThat(addedEducationLoanVO.getAccountNumber(),
				is(educationLoanVo.getAccountNumber()));
		assertThat(addedEducationLoanVO.getEduLoanAccountNumber(),
				is(educationLoanVo.getEduLoanAccountNumber()));
		assertThat(addedEducationLoanVO.getLoanApplyDate().getTime(),
				is(notNullValue()));
		assertThat(addedEducationLoanVO.getLoanDuration(),
				is(educationLoanVo.getLoanDuration()));
		assertThat(addedEducationLoanVO.getAnnualIncome(),
				is(educationLoanVo.getAnnualIncome()));
		assertThat(addedEducationLoanVO.getCourseFee(),
				is(educationLoanVo.getCourseFee()));
		assertThat(addedEducationLoanVO.getCourseName(),
				is(educationLoanVo.getCourseName()));
		assertThat(addedEducationLoanVO.getFatherName(),
				is(educationLoanVo.getFatherName()));
		assertThat(addedEducationLoanVO.getIdNumber(),
				is(educationLoanVo.getIdNumber()));

	}

	@Test(expected = BankManagementException.class)
	public void testAccountNumberExists() throws BankManagementException {
		assertThat(applyEducationLoanService,
				instanceOf(ApplyEducationLoanService.class));

		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334445L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);
		applyEducationLoanService.insertEducationLoanDetails(educationLoanVo);
	}

	@Test
	public void isValidEducationLoanId() throws BankManagementException {
		assertThat(applyEducationLoanService,
				instanceOf(ApplyEducationLoanService.class));

		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);
		String educationLoanId = applyEducationLoanService
				.insertEducationLoanDetails(educationLoanVo);
		boolean pattern = educationLoanId.matches("EL-[0-9]{5}");
		assertThat(educationLoanId, pattern);
	}

	@Test
	public void testGetterSetterforAccountNumber() {
		Long accountNumber = 1111222233334444L;
		EducationLoanVO educationLoanVo = new EducationLoanVO(accountNumber,
				200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);
		educationLoanVo.setAccountNumber(accountNumber);
		assertEquals("error in getter/setter", accountNumber,
				educationLoanVo.getAccountNumber());
	}

	@Test(expected = BankManagementException.class)
	public void isNegativeFields() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334445L, 200L, new Date(), -5, 80000L, -1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);
		Set<ConstraintViolation<EducationLoanVO>> validationErrors = validator
				.validate(educationLoanVo);
		if (!validationErrors.isEmpty()) {
			throw new BankManagementException();
		}
	}

	@Test
	public void testGetterSetterforLoanAmount() {
		Long loanAmount = 200000L;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, loanAmount, new Date(), 5, 80000L, 1000,
				"BCA", "Santosh Laxman Dhope", 60627390L);
		educationLoanVo.setLoanAmount(loanAmount);
		assertEquals("error in getter/setter", loanAmount,
				educationLoanVo.getLoanAmount());
	}

	@Test
	public void testGetterSetterforLoanDuration() {
		Integer loanDuration = 5;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), loanDuration, 80000L,
				1000, "BCA", "Santosh Laxman Dhope", 60627390L);
		educationLoanVo.setLoanDuration(loanDuration);
		assertEquals("error in getter/setter", loanDuration,
				educationLoanVo.getLoanDuration());
	}

	@Test
	public void testGetterSetterforAnnualIncome() {
		Long annualIncome = 80000L;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, annualIncome, 1000,
				"BCA", "Santosh Laxman Dhope", 60627390L);
		educationLoanVo.setAnnualIncome(annualIncome);
		assertEquals("error in getter/setter", annualIncome,
				educationLoanVo.getAnnualIncome());
	}

	@Test
	public void testGetterSetterforCourseFee() {
		Integer courseFee = 200000;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, courseFee,
				"BCA", "Santosh Laxman Dhope", 60627390L);
		educationLoanVo.setCourseFee(courseFee);
		assertEquals("error in getter/setter", courseFee,
				educationLoanVo.getCourseFee());
	}

	@Test
	public void testGetterSetterforCourseName() {
		String courseName = "BCA";
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 200000,
				courseName, "Santosh Laxman Dhope", 60627390L);
		educationLoanVo.setCourseName(courseName);
		assertEquals("error in getter/setter", courseName,
				educationLoanVo.getCourseName());
	}

	@Test
	public void testGetterSetterforFatherName() {
		String fatherName = "Santosh Laxman Dhope";
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 200000, "BCA",
				fatherName, 60627390L);
		educationLoanVo.setFatherName(fatherName);
		assertEquals("error in getter/setter", fatherName,
				educationLoanVo.getFatherName());
	}

	@Test
	public void testGetterSetterforIdNumber() {
		Long idNumber = 60627390L;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 200000, "BCA",
				"Santosh Laxman Dhope", idNumber);
		educationLoanVo.setIdNumber(idNumber);
		assertEquals("error in getter/setter", idNumber,
				educationLoanVo.getIdNumber());
	}

	@Test
	public void testAccontNumberNotNull() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);

		assertThat(educationLoanVo.getAccountNumber(), is(notNullValue()));
	}

	@Test
	public void testLoanAmountNotNull() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);

		assertThat(educationLoanVo.getLoanAmount(), is(notNullValue()));
	}

	@Test
	public void testLoanDurationNotNull() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);

		assertThat(educationLoanVo.getLoanDuration(), is(notNullValue()));
	}

	@Test
	public void testAnnualIncomeNotNull() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);

		assertThat(educationLoanVo.getAnnualIncome(), is(notNullValue()));
	}

	@Test
	public void testCourseFeeNotNull() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);

		assertThat(educationLoanVo.getCourseFee(), is(notNullValue()));
	}

	@Test
	public void testCourseNameNotNull() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);

		assertThat(educationLoanVo.getCourseName(), is(notNullValue()));
	}

	@Test
	public void testFatherNameNotNull() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);

		assertThat(educationLoanVo.getFatherName(), is(notNullValue()));
	}

	@Test
	public void testIdNumberNotNull() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);

		assertThat(educationLoanVo.getIdNumber(), is(notNullValue()));
	}

	@Test
	public void isPositiveLoanDuration() throws BankManagementException {
		Integer loanDuration = 5;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), loanDuration, 80000L,
				1000, "BCA", "Santosh Laxman Dhope", 60627390L);
		assertTrue(educationLoanVo.getLoanDuration() > 0);
		assertFalse(educationLoanVo.getLoanDuration() < 0);
	}

	@Test
	public void isNegativeLoanDuration() throws BankManagementException {
		Integer loanDuration = -5;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), loanDuration, 80000L,
				1000, "BCA", "Santosh Laxman Dhope", 60627390L);
		assertTrue(educationLoanVo.getLoanDuration() < 0);
		assertFalse(educationLoanVo.getLoanDuration() > 0);
	}

	@Test
	public void isPositiveCourseFee() throws BankManagementException {
		Integer courseFee = 50000;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, courseFee,
				"BCA", "Santosh Laxman Dhope", 60627390L);
		assertTrue(educationLoanVo.getCourseFee() > 0);
		assertFalse(educationLoanVo.getCourseFee() < 0);
	}

	@Test
	public void isNegativeCourseFee() throws BankManagementException {
		Integer courseFee = -50000;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, courseFee,
				"BCA", "Santosh Laxman Dhope", 60627390L);
		assertTrue(educationLoanVo.getCourseFee() < 0);
		assertFalse(educationLoanVo.getCourseFee() > 0);
	}

	@Test
	public void isPositiveAccountNumber() throws BankManagementException {
		Long accountNumber = 1111222233334444L;
		EducationLoanVO educationLoanVo = new EducationLoanVO(accountNumber,
				200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);
		assertTrue(educationLoanVo.getAccountNumber() > 0L);
		assertFalse(educationLoanVo.getAccountNumber() < 0L);
	}

	@Test
	public void isPositiveLoanAmount() throws BankManagementException {
		Long loanAmount = 200000L;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, loanAmount, new Date(), 5, 80000L, 1000,
				"BCA", "Santosh Laxman Dhope", 60627390L);
		assertTrue(educationLoanVo.getLoanAmount() > 0L);
		assertFalse(educationLoanVo.getLoanAmount() < 0L);
	}

	@Test
	public void isPositiveAnnualIncome() throws BankManagementException {
		Long annualIncome = 100000L;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, annualIncome, 1000,
				"BCA", "Santosh Laxman Dhope", 60627390L);
		assertTrue(educationLoanVo.getAnnualIncome() > 0L);
		assertFalse(educationLoanVo.getAnnualIncome() < 0L);
	}

	@Test
	public void isPositiveIdNumber() throws BankManagementException {
		Long idNumber = 601785L;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", idNumber);
		assertTrue(educationLoanVo.getIdNumber() > 0L);
		assertFalse(educationLoanVo.getIdNumber() < 0L);
	}

	@Test
	public void isNegativeAccountNumber() throws BankManagementException {
		Long accountNumber = -1111L;
		EducationLoanVO educationLoanVo = new EducationLoanVO(accountNumber,
				200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);
		assertTrue(educationLoanVo.getAccountNumber() >> 63 != 0);
		assertFalse(educationLoanVo.getAccountNumber() >> 63 == 0);
	}

	@Test
	public void isNegativeLoanAmount() throws BankManagementException {
		Long loanAmount = -200000L;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, loanAmount, new Date(), 5, 80000L, 1000,
				"BCA", "Santosh Laxman Dhope", 60627390L);
		assertTrue(educationLoanVo.getLoanAmount() >> 63 != 0);
		assertFalse(educationLoanVo.getLoanAmount() >> 63 == 0);
	}

	@Test
	public void isNegativeAnnualIncome() throws BankManagementException {
		Long annualIncome = -100000L;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, annualIncome, 1000,
				"BCA", "Santosh Laxman Dhope", 60627390L);
		assertTrue(educationLoanVo.getAnnualIncome() >> 63 != 0);
		assertFalse(educationLoanVo.getAnnualIncome() >> 63 == 0);
	}

	@Test
	public void isNegativeIdNumber() throws BankManagementException {
		Long idNumber = -601785L;
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", idNumber);
		assertTrue(educationLoanVo.getIdNumber() >> 63 != 0);
		assertFalse(educationLoanVo.getIdNumber() >> 63 == 0);
	}

	@Test
	public void CheckCourseNameNotEmpty() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO();
		educationLoanVo.setCourseName("MCA");
		assertFalse(educationLoanVo.getCourseName().isEmpty());

	}

	@Test
	public void CheckCourseNameNotNull() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO();
		educationLoanVo.setCourseName("MCA");
		assertNotNull(educationLoanVo.getCourseName());

	}

	@Test
	public void CheckCourseNameEmpty() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO();
		educationLoanVo.setCourseName("");
		assertTrue(educationLoanVo.getCourseName().isEmpty());

	}

	@Test
	public void CheckFatherNameNotEmpty() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO();
		educationLoanVo.setFatherName("xyz");
		assertFalse(educationLoanVo.getFatherName().isEmpty());

	}

	@Test
	public void CheckFatherNameNotNull() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO();
		educationLoanVo.setFatherName("xyz");
		assertNotNull(educationLoanVo.getFatherName());

	}

	@Test
	public void CheckFatherNameEmpty() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO();
		educationLoanVo.setFatherName("");
		assertTrue(educationLoanVo.getFatherName().isEmpty());

	}
	
	@Test(expected = BankManagementException.class)
	public void test_AccountNumber() throws BankManagementException {
		assertThat(viewEducationLoanService,
				instanceOf(ViewEducationLoanService.class));
		String educationLoanId = "EL-00070";
		Long accountNumber = 1111222233334441L;
		List<EducationLoanVO> list = viewEducationLoanService
				.retrieveEducationLoanDetails(educationLoanId, accountNumber);
		assertTrue(list.isEmpty());
	}

	@Test(expected = BankManagementException.class)
	public void testByOnlyPassingEducationLoanId()
			throws BankManagementException {
		String educationLoanId = "EL-90175";
		List<EducationLoanVO> list = viewEducationLoanService
				.retrieveEducationLoanDetails(educationLoanId, null);
		assertTrue(list.isEmpty());
	}

	@Test(expected = BankManagementException.class)
	public void testByOnlyPassingAccountNumber() throws BankManagementException {
		assertThat(viewEducationLoanService,
				instanceOf(ViewEducationLoanService.class));
		Long accountNumber = 1111222233334441L;
		List<EducationLoanVO> list = viewEducationLoanService
				.retrieveEducationLoanDetails(null, accountNumber);
		assertTrue(list.isEmpty());

	}

	@Test
	public void ListIsEmpty() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);
		String educationLoanId = applyEducationLoanService
				.insertEducationLoanDetails(educationLoanVo);

		List<EducationLoanVO> addedEducationLoanVOs = viewEducationLoanService
				.retrieveEducationLoanDetails(educationLoanId, null);
		assertFalse(addedEducationLoanVOs.isEmpty());
	}

	@Test
	public void myArrayTest() throws BankManagementException {
		EducationLoanVO educationLoanVo = new EducationLoanVO(
				1111222233334444L, 200L, new Date(), 5, 80000L, 1000, "BCA",
				"Santosh Laxman Dhope", 60627390L);
		String educationLoanId = applyEducationLoanService
				.insertEducationLoanDetails(educationLoanVo);

		List<EducationLoanVO> addedEducationLoanVOs = viewEducationLoanService
				.retrieveEducationLoanDetails(educationLoanId, null);
		Assert.assertNotNull("List shouldn't be null", addedEducationLoanVOs);
		assertFalse(addedEducationLoanVOs.isEmpty());
	}


}
