app.controller(
		'traceByProTnblIlineCtrl',
		function($scope, $rootScope,$timeout) {			
			
			$("#navigationDiv").empty();
			$("#navigationDiv").append("<font size='1px' text-color='#eee'><b>TRACE BY PRO/TNBR/ILINE</b></font>");
			
			$timeout(function() {		
				
			$("#loadDiv").css("display", "none");	
			}, 1000);
			
			
});