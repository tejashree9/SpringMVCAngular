
function isAccountNumberNumeric() {
	accountNumber =parseInt(document.getElementById("accountNumber").value);
     if (isNaN(accountNumber)) {
            var msg =  "Account Number must be numeric.\n";
        	document.getElementById("accountNumberSpan").innerHTML = msg;  
     }
 }
function isLoanAmountNumeric() {
	loanAmount =parseInt(document.getElementById("loanAmount").value);
    if (isNaN(loanAmount)) {
           var msg =  "Loan amount must be numeric.\n";
       	document.getElementById("loanAmountSpan").innerHTML = msg;  
    }
}

function isValidCourseName(){
	 courseName = document.getElementById("courseName").value;
     if (!courseName.match("[A-Za-z ]")) {
    	 var msg = "Course name should have only alphabets.\n";
            document.getElementById("courseNameSpan").innerHTML = msg;
     }
}

function isCourseFeeNumeric(){
	courseFee = parseInt(document.getElementById("courseFee").value);
    if (isNaN(courseFee)) {
    	 var msg = "Course fee must be numeric.\n";
           document.getElementById("courseFeeSpan").innerHTML = msg;
    }
}

function isValidFatherName(){
	fatherName = document.getElementById("fatherName").value;
     if (!fatherName.match("[A-Za-z ]")) {
    	 var msg = "Father name should have only alphabets.\n";
            document.getElementById("fatherNameSpan").innerHTML = msg;
     }
}

function isIdNumericNumeric(){
	idNumber = parseInt(document.getElementById("idNumber").value);
    if (isNaN(idNumber)) {
    	var msg = "Id number must be numeric.\n";
           document.getElementById("idNumberSpan").innerHTML = msg;
    }
}

function isAnnualIncomeNumeric() {
	annualIncome =parseInt(document.getElementById("annualIncome").value);
    if (isNaN(annualIncome)) {
           var msg =  "Annual income must be numeric.\n";
       	document.getElementById("annualIncomeSpan").innerHTML = msg;  
    }
}

function isEducationLoanIdValid() {
	educationLoanId=document.getElementById("educationLoanId").value;
    var pattern = /EL-[0-9]{5}/g;
    var result = pattern.test(educationLoanId);
    if(!result){
    	 var msg = "Education loan id should be in format EL-XXXXX. XXXXX numeric of 5 digits.\n";
    }
    else{
    	 msg="";
    }
    document.getElementById("educationLoanIdSpan").innerHTML = msg;
}
