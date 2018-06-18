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
									<li><a href="performtransactionForm">Perform
											Transaction</a></li>
									<li><a href="/BaseCodeSlice_BankManagementSystem/static/html/Transaction/viewTransactionSearchScreen.html">View
											Transaction</a></li>
								</ul></li>
							<li><a href="#" class="icon fa-angle-down" >Home Loan</a>
								<ul>
									<li><a href="applyHomeLoan">Apply Home Loan </a></li>
									<li><a href="static/html/HomeLoan/getHomeLoanSearchScreen.html">Search Home
											Loan</a></li>

								</ul></li>
							<li><a href="#" class="icon fa-angle-down">Education Loan</a>
								<ul>
									<li><a href="applyeducationloan">Apply Education
											Loan </a></li>
									<li><a href="static/html/EducationLoan/geteducationloansearchscreen.html">Search Education Loan</a></li>
						</ul></li>
					
				</ul>
			</nav>
		</header>
		<br>
		<section class="box"><center>
		<div class="row uniform 50%">
			<div class="12u 12u(mobilep)">
				
					<h3>Education Loan Details</h3>
		<h4>You have successfully applied Education Loan.</h4>
		<h4>Your Education Loan Id is:</h4>
		<Strong><h2><c:out value="${educationLoanVo.educationLoanId}" /></h2></Strong>
					<div class="table-wrapper">
					</div>

				

			</div>
		</div>
		</center>
		</section>

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


</body>
</html>
		