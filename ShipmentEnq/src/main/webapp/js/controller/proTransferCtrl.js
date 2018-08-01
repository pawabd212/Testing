/*
 * @author SYNTEL
 * 
 * proTransferCtrl Page : proTransferCtrl
 */
app.controller('proTransferCtrl', function($scope, $http, $window,$timeout, ProTransferService) {

	$("#navigationDiv").empty();
	$("#navigationDiv").append("<font size='1px' text-color='#eee'><b>PRO TRANSFER</b></font>");
	
	$timeout(function() {		
		
	$("#loadDiv").css("display", "none");	
	}, 1000);
	$scope.disable=true;
	$scope.disable1=true;
	$scope.disable2=true;
	$scope.proDetails = [];
	$scope.cbsaNames = [];

	$scope.proDetailForm = {
			id : -1,
			proName : "",
			proSuffix : "",
			transferStatus : ""
	};

	$scope.proSaveForm = {
			id : -1,
			proNumber :"",
			toLoc : "",
			reason : "",
			transferStatus : ""
	};

	//Now load the data from server
	_refreshProDetailData();

	//HTTP POST methods for add proDetail 

	$scope.submitProDetail = function() {

		var method = "";
		var url = "";
		if ($scope.proDetailForm.id == -1) {
			//Id is absent in form data, it is create new proDetail operation
			method = "POST";
			url = 'http://localhost:8081/ShipmentEnq/rest/transfer';
		} 

		$http({
			method : method,
			url : url,
			data : angular.toJson($scope.proDetailForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then( _success, _error );
	};
	
	$scope.saveProDetails = function() {
		if($scope.proSaveForm.proNumber == "" || $scope.proSaveForm.transferStatus == "Transfer Successful") {
			$window.alert("This Pro has already been transferred");
		}else{
			ProTransferService.saveProDetails($scope.proSaveForm);
			_refreshProDetailData();  
			_clearTransferFormData();
		}
	};

	//Change color of selected Row in Table
	$scope.changeColor = function(row,disable,proDetail) {
		$scope.selectedRow = row;
		$scope.disable=false;//To enable dropDrown1
		$scope.proSaveForm.proNumber=proDetail.proName+"-"+proDetail.proSuffix;
		$scope.proSaveForm.id = proDetail.id;
		$scope.proSaveForm.transferStatus = proDetail.transferStatus;

	};
	
	//Enable dropDown2 on Selection of element in dropDown1
	$scope.enableDropDown2=function(){
		$scope.disable1=false;
	};

	//Enable button on Selection of element in dropDown2
	$scope.enableButton=function(){
		$scope.disable2=false;
	};
	
	//onClick of comment Button display Alert message
	$scope.commentBtn=function(){
		$window.alert("Work in Progress");
	};
	
	//onClick of mexicoTransfer Button display Alert message
	$scope.mexicoTransferBtn=function(){
		window.alert("Work in Progress");
	};

	//onClick of Exit Button display Alert message
	$scope.exitBtn=function(){
		$location.path('/test.html');
	};

	//check length of the table before adding data
	$scope.checkInitialLength=function(){
		$scope.intialLength=$scope.proDetails.length;

	};

	/* Private Methods */
	//HTTP GET- get all proDetails collection
	function _refreshProDetailData() {
		$http({
			method : 'GET',
			url : 'http://localhost:8081/ShipmentEnq/rest/transfer'
		}).then(function successCallback(response) {

			$scope.proDetails = response.data.proList;
			$scope.loc = response.data.locList;
			$scope.reason = response.data.reasonList;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}

	function _success(response) {
		_refreshProDetailData();
		_clearFormData()
		if(response.data.id == -1){
			$window.alert("Record is already added in list");
			return;
		}
		if(response.data.id == 0){
			$window.alert("Please enter valid data");
			return;
		}
	}

	function _error(response) {
		console.log(response.statusText);
	}

	//Clear the form
	function _clearFormData() {
		$scope.proDetailForm.id = -1;
		$scope.proDetailForm.proName = "";
		$scope.proDetailForm.proSuffix = "";

	};

	//Clear the form
	function _clearTransferFormData() {
		$scope.proSaveForm.id = -1;
		$scope.proSaveForm.proNumber = "";
		$scope.proSaveForm.transferStatus = "";

	};
});