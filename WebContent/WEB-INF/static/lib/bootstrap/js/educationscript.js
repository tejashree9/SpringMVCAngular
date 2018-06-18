var app = angular.module("myApp", ['ngRoute', 'pascalprecht.translate' ]);

app.service("EducationLoanService", function(){
	var educationLoanDetails = {data: []};
	return educationLoanDetails;
});


	app
			.controller(
					"ctrl",
					function($scope, $http, $translate,$location,EducationLoanService) {
						$scope.educationLoanDetails = EducationLoanService;
						$scope.sort=function(result){
							if($scope.order==result){
								 $scope.order ='-'+ result;
							}
							else{
								 $scope.order = result;
							}
						}
						$translate.use('en_US');
						$scope.changeLang = function(lang) {
							$translate.use(lang);
						}
						$scope.viewData = function() {
							if ($scope.educationLoanId == null) {
								$scope.educationLoanId = "";
							}
							if ($scope.accountNumber == null) {
								$scope.accountNumber = "";
							}
		$http(
				{
					url : "/BaseCodeSlice_BankManagementSystem/static/html/EducationLoan/showeducationloan?educationLoanId="
							+ $scope.educationLoanId
							+ "&accountNumber="
							+ $scope.accountNumber,
					method : "get"
				})
				.success(
						function(res) {
							console.log(res);
							$scope.educationLoanDetails.data = res;
							console.log($scope.educationLoanDetails)
							if ($scope.educationLoanDetails.data == "" || $scope.educationLoanDetails.data == null) {
								if ($scope.educationLoanId == "" || $scope.educationLoanId == null) {
									$scope.error = "Account number does not exists";
								} else if ($scope.accountNumber == "" || $scope.accountNumber == null) {
									$scope.educationLoanIdError = "Education loan Id does not exists";
								} else {
									$scope.error = "Account number does not exists";
									$scope.educationLoanIdError = "Education loan Id does not exists";
								}
							} else {
								$scope.flag = true;
								
								//valid
								$location.path("/view");
							}

						})
				.error(
						function() {
							console
									.log("error in fetching the data");
						})
	}
});
	
	app.controller("viewCtrl", function($scope, EducationLoanService){
		console.log("in viewCtrl");
		
		$scope.educationLoanDetails = EducationLoanService;
		
		console.log($scope.educationLoanDetails.data);

	});
	
	
	app.config(function($routeProvider){
		$routeProvider.when("/", {
			templateUrl: './templates/getSearchScreen.html',
			controller: 'ctrl'
		}).when("/view", {
			templateUrl: './templates/getEducationLoanResultScreen.html',
			controller: 'viewCtrl'
		});
	});
	
	

	app.config(function($translateProvider) {
		$translateProvider.useSanitizeValueStrategy('escapeParameters');
		$translateProvider.translations('en_US', {
			SearchEducationLoan : 'Search Education Loan',
			Identificationcardnumber : 'Identification Card Number',
			Loanaccountnumber : 'Loan Account Number',
			GetLoanDetails : 'Get Loan Details',
			Reset : 'Reset',
			LoanId : 'Loan Id',
			Accountholdername : 'Account holder name',
			LoanAmount : 'Loan Amount',
			CourseName : 'Course Name',
			FatherName : 'Father Name',
			English : 'English',
			Hindi : 'Hindi',
			French : 'French',
			PROJECT_HEADING:'Bank Management System',
			HOME:'Home',
			TRANSACTION:'Transaction',
			PERFORM_TRANSACTION:'Perform Transaction',
			VIEW_TRANSACTION:'View Transaction',
			HOME_LOAN:'Home Loan',
			APPLY_HOME_LOAN:'Apply Home Loan',
			SEARCH_HOME_LOAN:'Search Home Loan',
			EDUCATION_LOAN:'Education Loan',
			APPLY_EDUCATION_LOAN:'Apply Education Loan',
			SEARCH_EDUCATION_LOAN:'Search Education Loan',
			Account_length_error:'Account Number must be numeric and must be of 16 digits.',
			LOANIDERROR:'Education loan id should be in format EL-XXXXX. XXXXX numeric of 5 digits.',
			ERRORLOANID:'Education loan Id does not exists',
			ERROR:'Account number does not exists',
			RESULT_PAGE_TITLE:'Result Screen'
		});
		$translateProvider.translations('fr_CA', {
			SearchEducationLoan : 'Rechercher un prêt d éducation',
			Identificationcardnumber : 'numéro de carte d dentité',
			Loanaccountnumber : 'Mot de passe',
			GetLoanDetails : 'Obtenir des détails sur le prêt',
			Reset : 'Réinitialiser',
			LoanId : 'ID de prêt',
			Accountholdername : 'Nom du titulaire du compte',
			LoanAmount : 'Montant du prêt',
			CourseName : 'Nom du cours',
			FatherName : 'Nom du père',
			English : 'Anglais',
			Hindi : 'hindi',
			French : 'français',
			PROJECT_HEADING:'Système de gestion bancaire',
			HOME:'maison',
			TRANSACTION:'Transaction',
			PERFORM_TRANSACTION:'Effectuer une transaction',
			VIEW_TRANSACTION:'Afficher la transaction',
			HOME_LOAN:'Prêt immobilier',
			APPLY_HOME_LOAN:'Appliquer un prêt immobilier',
			SEARCH_HOME_LOAN:'Chercher un prêt immobilier',
			EDUCATION_LOAN:'Prêt d\'éducation',
			APPLY_EDUCATION_LOAN:'Appliquez un prêt d\'éducation',
			SEARCH_EDUCATION_LOAN:'Rechercher un prêt d\'éducation',
			Account_length_error:'Le numéro de compte doit être numérique et doit comporter 16 chiffres.',
			LOANIDERROR:'L\'ID de crédit d\'éducation devrait être au format EL-XXXXX. XXXXX numérique de 5 chiffres.',
			ERRORLOANID:'L\'ID de crédit d\'éducation n\'existe pas',
			ERROR:'Le numéro de compte n\'existe pas',
			RESULT_PAGE_TITLE:'Écran de résultat'

		});
		$translateProvider.translations('hi_IN', {
			SearchEducationLoan : 'शिक्षा ऋण खोजें',
			Identificationcardnumber : 'पहचान कार्ड नंबर',
			Loanaccountnumber : 'ऋण खाता संख्या',
			GetLoanDetails : 'ऋण विवरण प्राप्त करें',
			Reset : 'रीसेट',
			LoanId : 'ऋण आईडी',
			Accountholdername : 'खाताधारक का नाम',
			LoanAmount : 'उधार की राशि',
			CourseName : 'कोर्स का नाम',
			FatherName : 'पिता का नाम',
			English : 'अंग्रेज़ी',
			Hindi : 'हिंदी',
			French : 'फ्रेंच',
			PROJECT_HEADING:'बैंक प्रबंधन प्रणाली',
			HOME:'मुख्य पृष्ठ',
			TRANSACTION:'लेन-देन',
			PERFORM_TRANSACTION:'लेनदेन करना',
			VIEW_TRANSACTION:'लेनदेन देखें',
			HOME_LOAN:'गृह ऋण',
			APPLY_HOME_LOAN:'गृह ऋण लागू करें',
			SEARCH_HOME_LOAN:'होम लोन खोजें',
			EDUCATION_LOAN:'शिक्षा ऋण',
			APPLY_EDUCATION_LOAN:'शिक्षा ऋण लागू करें',
			SEARCH_EDUCATION_LOAN:'शिक्षा ऋण खोजें',
			Account_length_error:'खाता संख्या अंकीय होना चाहिए और 16 अंकों की होनी चाहिए।',
			LOANIDERROR:'शिक्षा ऋण आईडी प्रारूप में होना चाहिए EL-XXXXX 5 अंकों के संख्यात्मक xxxxx',
			ERRORLOANID:'शिक्षा ऋण आईडी मौजूद नहीं है',
			ERROR:'खाता संख्या मौजूद नहीं है',
			RESULT_PAGE_TITLE:'परिणाम स्क्रीन'
		});
		//    $translateProvider.determinePreferredLanguage();
		$translateProvider.determinePreferredLanguage('en_US');
	});