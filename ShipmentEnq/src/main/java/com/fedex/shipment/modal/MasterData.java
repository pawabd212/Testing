package com.fedex.shipment.modal;

import java.util.List;

public class MasterData {
	
	List<ProDetail> proList;
	List<String> locList;
	List<String> reasonList;

	public List<String> getLocList() {
		return locList;
	}

	public void setLocList(List<String> locList) {
		this.locList = locList;
	}

	

	public List<String> getReasonList() {
		return reasonList;
	}

	public void setReasonList(List<String> reasonList) {
		this.reasonList = reasonList;
	}

	public List<ProDetail> getProList() {
		return proList;
	}

	public void setProList(List<ProDetail> proList) {
		this.proList = proList;
	}
	

}
