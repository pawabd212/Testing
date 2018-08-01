package com.fedex.shipment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.fedex.shipment.modal.MasterData;
import com.fedex.shipment.modal.ProDetail;
import com.fedex.shipment.modal.ProTransferDeatils;
import com.fedex.shipment.service.ProTransferService;

@RestController
@RequestMapping("/transfer")
public class ProTransferController {
	
	@Autowired
	ProTransferService proTransferSvc=new ProTransferService();
	
	 @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public MasterData loadMasterData()
	{
		List<ProDetail> proList=proTransferSvc.getAllProList();
		MasterData masterData = new MasterData();
		masterData.setProList(proList);
		List<String> locList = proTransferSvc.getLocList();
		List<String> reasonList = proTransferSvc.getReasonList();
		masterData.setLocList(locList);
		masterData.setReasonList(reasonList);
		
		return masterData;
	}
    
   
	 @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProDetail addPro(@RequestBody ProDetail proDetail)
	{
		return proTransferSvc.addPro(proDetail);
	}

	@RequestMapping(value = "/pro", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveTransferDetails(@RequestBody ProTransferDeatils details)
    {
    	proTransferSvc.saveProtranfer(details);
    }
}
