<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Bank Management System</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="/BaseCodeSlice_BankManagementSystem/static/lib/bootstrap/css/main.css" />
<style>
.danger {
	color: red;
}

td {
	vertical-align: top;
}
</style>
</head>
<body class="landing">
	<div id="page-wrapper">

<header id="header" class="alt">
			<h1>
				<a href="/BaseCodeSlice_BankManagementSystem/">Bank Management System</a>
			</h1>
			<nav id="nav">
				<ul>
					<li><a href="/BaseCodeSlice_BankManagementSystem/">Home</a></li>


					<li><a href="#" class="icon fa-angle-down">Transaction</a>
						<ul>
							<li><a href="performtransactionForm">Perform Transaction</a></li>
							<li><a href="/BaseCodeSlice_BankManagementSystem/static/html/Transaction/viewTransactionSearchScreen.html">View
									Transaction</a></li>
						</ul></li>
					<li><a href="#" class="icon fa-angle-down">Home Loan</a>
						<ul>
							<li><a href="applyHomeLoan">Apply Home Loan </a></li>
							<li><a
								href="static/html/HomeLoan/getHomeLoanSearchScreen.html">Search
									Home Loan</a></li>
						
						</ul></li>
					<li><a href="#" class="icon fa-angle-down">Education Loan</a>
						<ul>
							<li><a href="applyeducationloan">Apply Education Loan </a></li>
							<li><a href="static/html/EducationLoan/geteducationloansearchscreen.html">Search
									Education Loan</a></li>
						</ul></li>

				</ul>
			</nav>
		</header>
		<!-- Form -->
		<br>
		<section class="box">
		<h3>Apply Education Loan</h3>
		<form method="post" action="addeducationloan">
			<div class="row uniform 50%">
				<div class="6u 12u(mobilep)">
					<input type="text" name="accountNumber" id="accountNumber"
						value="<%=request.getParameter("accountNumber") != null ? request
					.getParameter("accountNumber") : ""%>"
						placeholder="Account Number" onchange="isAccountNumberNumeric()"  maxlength=16 />
					<div class="danger">${errors.accountNumber}</div>
					<div class="danger">${error}</div>
					<div class="danger" id="accountNumberSpan"></div>
				</div>
				<div class="6u 12u(mobilep)">
					<input type="text" name="loanAmount" id="loanAmount"
						value="<%=request.getParameter("loanAmount") != null ? request
					.getParameter("loanAmount") : ""%>"
						placeholder="Loan Amount" onchange="isLoanAmountNumeric()" />
					<div class="danger">${errors.loanAmount}</div>
					<div class="danger" id="loanAmountSpan"></div>
				</div>
			</div>

			<div class="row uniform 50%">
				<div class="6u 12u(mobilep)">
					<input type="date" name="loanApplyDate" id="loanApplyDate"
						value="<%=request.getParameter("loanApplyDate") != null ? request
					.getParameter("loanApplyDate") : ""%>"
						placeholder="Loan Apply Date" />
							<div class="danger">${errors.loanApplyDate}</div>
							
				</div>
				<div class="6u 12u(mobilep)">
					<div class="select-wrapper">
						<select name="loanDuration" id="loanDuration">
							<option value="">-Loan Duration-</option>
							<option value="5"<%=("5".equals(request.getParameter("loanDuration"))) ? "selected='selected'" : ""%>>5</option>
							<option value="10"<%=("10".equals(request.getParameter("loanDuration"))) ? "selected='selected'" : ""%>>10</option>
						</select>
					</div>
					<div class="danger">${errors.loanDuration}</div>
					
				</div>
			</div>

			<div class="row uniform 50%">
				<div class="6u 12u(mobilep)">
					<input type="text" name="courseName" id="courseName"
						value="<%=request.getParameter("courseName") != null ? request
					.getParameter("courseName") : ""%>"
						placeholder="Course Name" onchange="isValidCourseName()" />
							<div class="danger">${errors.courseName}</div>
							<div class="danger" id="courseNameSpan"></div>
				</div>
				<div class="6u 12u(mobilep)">
					<input type="text" name="courseFee" id="courseFee"
						value="<%=request.getParameter("courseFee") != null ? request
					.getParameter("courseFee") : ""%>"
						placeholder="Course Fee" onchange="isCourseFeeNumeric()"/>
						<div class="danger">${errors.courseFee}</div>
						<div class="danger" id="courseFeeSpan"></div>
				</div>
			</div>

			<div class="row uniform 50%">
				<div class="6u 12u(mobilep)">
					<input type="text" name="fatherName" id="fatherName"
						value="<%=request.getParameter("fatherName") != null ? request
					.getParameter("fatherName") : ""%>"
						placeholder="Father Name" onchange="isValidFatherName()" />
						<div class="danger">${errors.fatherName}</div>
						<div class="danger" id="fatherNameSpan"></div>
				</div>
				<div class="6u 12u(mobilep)">
					<input type="text" name="idNumber" id="idNumber"
						value="<%=request.getParameter("idNumber") != null ? request
					.getParameter("idNumber") : ""%>"
						placeholder="Id Number" onchange="isIdNumericNumeric()" />
						<div class="danger">${errors.idNumber}</div>
						<div class="danger" id="idNumberSpan"></div>
				</div>
			</div>

			<div class="row uniform 50%">
				<div class="6u 12u(mobilep)">
					<input type="text" name="annualIncome" id="annualIncome"
						value="<%=request.getParameter("annualIncome") != null ? request
					.getParameter("annualIncome") : ""%>"
						placeholder="Fathers Annual Income" onchange="isAnnualIncomeNumeric()" />
						<div class="danger">${errors.annualIncome}</div>
						<div class="danger" id="annualIncomeSpan"></div>
				</div>
				<div class="6u 12u(mobilep)"></div>
			</div>

			<div class="row uniform">
				<div class="12u">
					<ul class="actions">
						<li><input type="submit" value="Submit" /></li>
						<li><input type="reset" value="Reset" class="alt" /></li>
					</ul>
				</div>
			</div>
		</form>


		</section>
	</div>

	<!-- Footer -->
	<footer id="footer">
	<ul class="copyright">
		<li>&copy; Untitled. All rights reserved.</li>
	</ul>
	</footer>

	</div>

	<!-- Scripts -->
	<script
		src="/BaseCodeSlice_BankManagementSystem/static/lib/bootstrap/js/jquery.min.js"></script>
	<script
		src="/BaseCodeSlice_BankManagementSystem/static/lib/bootstrap/js/jquery.dropotron.min.js"></script>
	<script
		src="/BaseCodeSlice_BankManagementSystem/static/lib/bootstrap/js/jquery.scrollgress.min.js"></script>
	<script
		src="/BaseCodeSlice_BankManagementSystem/static/lib/bootstrap/js/skel.min.js"></script>
	<script
		src="/BaseCodeSlice_BankManagementSystem/static/lib/bootstrap/js/util.js"></script>
	<script
		src="/BaseCodeSlice_BankManagementSystem/static/lib/bootstrap/js/main.js"></script>
		<script
		src="/BaseCodeSlice_BankManagementSystem/static/lib/bootstrap/js/validations.js"></script>

</body>
</html>