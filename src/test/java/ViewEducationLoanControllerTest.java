package test.java;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.cts.bankmanagement.controller.ViewEducationLoanController;
import com.cts.bankmanagement.exception.BankManagementException;
import com.cts.bankmanagement.service.ViewEducationLoanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:bms-test-context.xml")
public class ViewEducationLoanControllerTest {
	
	@Autowired
	private ViewEducationLoanController viewEducationLoanController;
	
	@Autowired
	private ViewEducationLoanService viewEducationLoanService;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(
				viewEducationLoanController).build();
	}

	@Test
	public void postShouldResult() throws Exception {

				this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.get("/static/html/EducationLoan/showeducationloan")
								.accept(MediaType.APPLICATION_JSON)
								.param("educationLoanId", "EL-00001").param("accountNumber", "1111222233334444"))
								.andExpect(status().isOk()).andDo(print());	
	}
	
	@Test
	public void testByPassingLoanId() throws Exception {

				this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.get("/static/html/EducationLoan/showeducationloan")
								.accept(MediaType.APPLICATION_JSON)
								.param("educationLoanId", "EL-00001").param("accountNumber", ""))
								.andExpect(status().isOk()).andDo(print());	
	}
	
	@Test
	public void testByPassingAccountNumber() throws Exception {

				this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.get("/static/html/EducationLoan/showeducationloan")
								.accept(MediaType.APPLICATION_JSON)
								.param("educationLoanId", "").param("accountNumber", "1111222233334444"))
								.andExpect(status().isOk()).andDo(print());	
	}
	
	@Test
	public void invalidParameters() throws Exception {

				this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.get("/static/html/EducationLoan/showeducationloan")
								.accept(MediaType.APPLICATION_JSON)
								.param("educationLoanId", "EL-99999").param("accountNumber", "1111222233334446"))
								.andDo(print());	
	}
	
	
}
