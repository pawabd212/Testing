app.controller(
		'multipleProsCtrl',
		function($scope, $rootScope,$timeout) {			
			
			$("#navigationDiv").empty();
			$("#navigationDiv").append("<font size='1px' text-color='#eee'><b>MULTIPLE PRO'S</b></font>");
			
			$timeout(function() {		
				
			$("#loadDiv").css("display", "none");	
			}, 1000);
			
			
});