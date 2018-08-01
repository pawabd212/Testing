app.controller(
		'customerCtrl',
		function($scope, $rootScope,$timeout) {			
			
			$("#navigationDiv").empty();
			$("#navigationDiv").append("<font size='1px' text-color='#eee'><b>TRACE BY COSTUMER</b></font>");
			
			$timeout(function() {		
				
			$("#loadDiv").css("display", "none");	
			}, 1000);
			
			
});