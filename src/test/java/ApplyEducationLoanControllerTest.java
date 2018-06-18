package test.java;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.bankmanagement.controller.ApplyEducationLoanController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:bms-test-context.xml")
public class ApplyEducationLoanControllerTest {

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(
				new ApplyEducationLoanController()).build();
	}

	@Test
	public void getShouldResultApplyEducationLoan() throws Exception {
		this.mockMvc.perform(get("/applyeducationloan")).andExpect(
				view().name("EducationLoan/applyeducationloan"));
	}

	@Test(expected = Exception.class)
	public void isValidParameters() throws Exception {
		Date d1=new Date();
		String Pattern="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(Pattern);
		String date=sdf.format(d1);
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/addeducationloan")
						.param("accountNumber","1111222233334444")
						.param("loanAmount","20000")
						.param("loanApplyDate",date)
						.param("loanDuration","5")
						.param("annualIncome","25000")
						.param("courseFee","20000")
						.param("courseName","BCA")
						.param("fatherName","xyz")
						.param("idNumber","212344")
						).andExpect(
								status().is(200))
						.andExpect(
				view().name("/EducationLoan/getEducationLoanResultScreen"))
						.andDo(print());
	}
	
	@Test(expected = Exception.class)
	public void isNotValidAccountNumber() throws Exception {
		Date d1=new Date();
		String Pattern="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(Pattern);
		String date=sdf.format(d1);
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/addeducationloan")
						.param("accountNumber","-12")
						.param("loanAmount","20000")
						.param("loanApplyDate",date)
						.param("loanDuration","5")
						.param("annualIncome","25000")
						.param("courseFee","20000")
						.param("courseName","BCA")
						.param("fatherName","xyz")
						.param("idNumber","212344")
						).andExpect(
								status().is(200))
						.andExpect(
				view().name("/EducationLoan/getEducationLoanResultScreen"))
						.andDo(print());
	}
	
	@Test(expected = Exception.class)
	public void isNotValidLoanAmount() throws Exception {
		Date d1=new Date();
		String Pattern="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(Pattern);
		String date=sdf.format(d1);
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/addeducationloan")
						.param("accountNumber","1111222233334444")
						.param("loanAmount","-20000")
						.param("loanApplyDate",date)
						.param("loanDuration","5")
						.param("annualIncome","25000")
						.param("courseFee","20000")
						.param("courseName","BCA")
						.param("fatherName","xyz")
						.param("idNumber","212344")
						).andExpect(
								status().is(200))
						.andExpect(
				view().name("/EducationLoan/getEducationLoanResultScreen"))
						.andDo(print());
	}
	
	@Test(expected = Exception.class)
	public void isNotValidLoanApplyDate() throws Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/addeducationloan")
						.param("accountNumber","1111222233334444")
						.param("loanAmount","20000")
						.param("loanApplyDate","2017-06-07")
						.param("loanDuration","5")
						.param("annualIncome","25000")
						.param("courseFee","20000")
						.param("courseName","BCA")
						.param("fatherName","xyz")
						.param("idNumber","212344")
						).andExpect(
								status().is(200))
						.andExpect(
				view().name("/EducationLoan/getEducationLoanResultScreen"))
						.andDo(print());
	}
	
	@Test(expected = Exception.class)
	public void isNotValidLoanDuration() throws Exception {
		Date d1=new Date();
		String Pattern="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(Pattern);
		String date=sdf.format(d1);
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/addeducationloan")
						.param("accountNumber","1111222233334444")
						.param("loanAmount","20000")
						.param("loanApplyDate",date)
						.param("loanDuration","-5")
						.param("annualIncome","25000")
						.param("courseFee","20000")
						.param("courseName","BCA")
						.param("fatherName","xyz")
						.param("idNumber","212344")
						).andExpect(
								status().is(200))
						.andExpect(
				view().name("/EducationLoan/getEducationLoanResultScreen"))
						.andDo(print());
	}
	
	@Test(expected = Exception.class)
	public void isNotValidAnnualIncome() throws Exception {
		Date d1=new Date();
		String Pattern="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(Pattern);
		String date=sdf.format(d1);
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/addeducationloan")
						.param("accountNumber","1111222233334444")
						.param("loanAmount","20000")
						.param("loanApplyDate",date)
						.param("loanDuration","5")
						.param("annualIncome","-25000")
						.param("courseFee","20000")
						.param("courseName","BCA")
						.param("fatherName","xyz")
						.param("idNumber","212344")
						).andExpect(
								status().is(200))
						.andExpect(
				view().name("/EducationLoan/getEducationLoanResultScreen"))
						.andDo(print());
	}
	
	@Test(expected = Exception.class)
	public void isNotValidCourseFee() throws Exception {
		Date d1=new Date();
		String Pattern="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(Pattern);
		String date=sdf.format(d1);
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/addeducationloan")
						.param("accountNumber","1111222233334444")
						.param("loanAmount","20000")
						.param("loanApplyDate",date)
						.param("loanDuration","5")
						.param("annualIncome","25000")
						.param("courseFee","-20000")
						.param("courseName","BCA")
						.param("fatherName","xyz")
						.param("idNumber","212344")
						).andExpect(
								status().is(200))
						.andExpect(
				view().name("/EducationLoan/getEducationLoanResultScreen"))
						.andDo(print());
	}
	
	@Test(expected = Exception.class)
	public void isNotValidCourseName() throws Exception {
		Date d1=new Date();
		String Pattern="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(Pattern);
		String date=sdf.format(d1);
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/addeducationloan")
						.param("accountNumber","1111222233334444")
						.param("loanAmount","20000")
						.param("loanApplyDate",date)
						.param("loanDuration","5")
						.param("annualIncome","25000")
						.param("courseFee","20000")
						.param("courseName","123")
						.param("fatherName","xyz")
						.param("idNumber","212344")
						).andExpect(
								status().is(200))
						.andExpect(
				view().name("/EducationLoan/getEducationLoanResultScreen"))
						.andDo(print());
	}
	
	@Test(expected = Exception.class)
	public void isNotValidFatherName() throws Exception {
		Date d1=new Date();
		String Pattern="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(Pattern);
		String date=sdf.format(d1);
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/addeducationloan")
						.param("accountNumber","1111222233334444")
						.param("loanAmount","20000")
						.param("loanApplyDate",date)
						.param("loanDuration","5")
						.param("annualIncome","25000")
						.param("courseFee","20000")
						.param("courseName","BCA")
						.param("fatherName","123")
						.param("idNumber","212344")
						).andExpect(
								status().is(200))
						.andExpect(
				view().name("/EducationLoan/getEducationLoanResultScreen"))
						.andDo(print());
	}
	
	@Test(expected = Exception.class)
	public void isNotValidIdNumber() throws Exception {
		Date d1=new Date();
		String Pattern="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(Pattern);
		String date=sdf.format(d1);
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/addeducationloan")
						.param("accountNumber","1111222233334444")
						.param("loanAmount","20000")
						.param("loanApplyDate",date)
						.param("loanDuration","5")
						.param("annualIncome","25000")
						.param("courseFee","20000")
						.param("courseName","BCA")
						.param("fatherName","xyz")
						.param("idNumber","-212344")
						).andExpect(
								status().is(200))
						.andExpect(
				view().name("/EducationLoan/getEducationLoanResultScreen"))
						.andDo(print());
	}
	

	@Test
	public void checkShouldResultApplyEducationLoan() throws Exception {
		this.mockMvc.perform(
				get("/applyeducationloan").accept(MediaType.TEXT_HTML))
				.andExpect(status().is(200));
	}

}
