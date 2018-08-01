package com.fedex.shipment.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fedex.shipment.dao.ProTransferDAO;
import com.fedex.shipment.modal.ProDetail;
import com.fedex.shipment.modal.ProTransferDeatils;


@Service
public class ProTransferService {
     
	static HashMap<Integer,ProDetail> proIdMap=getProIdMap();
	
	@Autowired
	ProTransferDAO dao=new ProTransferDAO();

	public ProTransferService() {
		super();

		if(proIdMap==null)
		{
			proIdMap=new HashMap<Integer,ProDetail>();
		}
	}

	public List<ProDetail> getAllProList()
	{
		List<ProDetail> proList = new ArrayList<ProDetail>(proIdMap.values());
		return proList;
	}

	public ProDetail getProDetail(int id)
	{
		ProDetail proDetail= proIdMap.get(id);

		return proDetail;
	}
	
	public ProDetail addPro(ProDetail proDetail)
	{
		boolean isProAlreadyAdded = checkIfproAlreadyAdded(proDetail);
		if(!isProAlreadyAdded){
			int id = dao.addPro1(proDetail);
			proDetail.setId(id);
			if(id != 0){
				proIdMap.put(proDetail.getId(),proDetail);
			}
		}
		return proDetail;
	}

	private boolean checkIfproAlreadyAdded(ProDetail proDetail) {
		boolean isProAlreadyAdded = false;
		for (Map.Entry<Integer,ProDetail> entry : proIdMap.entrySet()) {
			ProDetail currentProDetail = entry.getValue();
			if(currentProDetail.getProName().equals(proDetail.getProName()) && currentProDetail.getProSuffix().equals(proDetail.getProSuffix())){
				isProAlreadyAdded = true;
				break;
			}
		}
		return isProAlreadyAdded;
	}

	public static HashMap<Integer, ProDetail> getProIdMap() {
		return proIdMap;
	}

	public List<String> getLocList() {
		List<String> locList = dao.getLocList();
		return locList;
	}

	public List<String> getReasonList() {
		List<String> reasonList = dao.getReasonList();
		return reasonList;
	}
	@Transactional
	public void saveProtranfer(ProTransferDeatils details){
		//dao.saveProtranfer(details);
		
		dao.saveProTransfer(details);
		
		//update transfer status based on id in proIdMap
		ProDetail proDetail = proIdMap.get(details.getId());
		proDetail.setTransferStatus("Transfer Successful");
		proIdMap.put(details.getId(), proDetail);
	}
}
