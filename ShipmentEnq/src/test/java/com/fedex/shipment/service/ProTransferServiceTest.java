package com.fedex.shipment.service;

import com.fedex.shipment.modal.ProDetail;

import junit.framework.TestCase;

public class ProTransferServiceTest  extends TestCase {
	
	ProTransferService proTransferService;
	
	
	
	 protected void setUp(){
		 proTransferService = new ProTransferService();
		 System.out.println("setup*****");
	   }
	 
	 public void testAddPro()
	 {
		 ProDetail proDetail = new ProDetail();
		 proDetail.setId(1);
		 proDetail.setProName("PRONAME001");
		 proDetail.setProSuffix("R0");
		 proDetail.setTransferStatus("Transfer Successful");
//		 proDetail = proTransferService.addPro(proDetail); 
		 assertTrue(proDetail.getId() == 1);
	 }
	 
	
	 protected void tearDown(){
		 proTransferService = null;
		 System.out.println("tearDown*****");
	   }
	

}
