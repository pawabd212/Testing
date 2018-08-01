
/**
 * @author SYNTEL
 */

var proTransferService = angular
		.module('proTransferService', [])
		.service(
				'ProTransferService',
				function() {
					this.saveProDetails = function(proSaveForm) {
						 
						var resultData = [];
						/**
						 * calling spring controller using AJAX
						 */
						$.ajax({
									url   : "http://localhost:9090/ShipmentEnq/rest/transfer/pro",	
									data  : JSON.stringify(proSaveForm),
									type  : "POST",									
									async : false,
									cache : false,
									processData : false,
									contentType : 'application/json',
									error : function() {
										$("#errorDiv").empty();
										$("#errorDiv")
												.append(
														"<b><font color='red'>Error in Transaction</font></b><br/>");
									},
									success : function(result) {											
											resultData = result;										
										}
									
								});
						
						return resultData;

					};
		});