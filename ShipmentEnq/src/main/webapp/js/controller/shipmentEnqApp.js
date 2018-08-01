/**
 * @author SJ5034754
 * 
 * Shipment Inquiry Application - Main Controller
 * 
 * It Contains all ng-Route information and along with all injected services.
 * 
 */
var app = angular.module('shipmentApp', [ 'ngRoute', 'proTransferService']);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'main1.html',
		controller : 'shipmentInqCntrl'	
	}).when('/proTransfer', {
		templateUrl : 'proTransfer.html',
		controller : 'proTransferCtrl'	
	}).when('/traceByProTnblIline', {
		templateUrl : 'traceByProTnblIline.html',
		controller : 'traceByProTnblIlineCtrl'	
	}).when('/customer', {
		templateUrl : 'customer.html',
		controller : 'customerCtrl'	
	}).when('/multiplePros', {
		templateUrl : 'multiplePros.html',
		controller : 'multipleProsCtrl'	
	}).otherwise({
		redirectTo : '/main'
	});

} ]).run(
		['$rootScope','$location',function($rootScope, $location) {
					var path = function() {						
						return $location.path();
					};
					$rootScope.$watch(path, function(newVal, oldVal) {
						$rootScope.activetab = newVal;						
					});

		} ]);

app.controller(
		'shipmentInqCntrl',
		function($scope, $rootScope,$timeout) {			
			
			$("#navigationDiv").empty();
			$("#navigationDiv").append("<font size='1px' text-color='#eee'><b>Shipment Inquiry Home</b></font>");

});