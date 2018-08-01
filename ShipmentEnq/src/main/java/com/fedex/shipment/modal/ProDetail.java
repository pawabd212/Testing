package com.fedex.shipment.modal;

public class ProDetail {
	
	int id;
	String proName;
	String proSuffix;
	String transferStatus;
	
	
	public String getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

	public ProDetail() {
		super();
	}
	
	public ProDetail(int i, String proName, String proSuffix) {
		super();
		this.id = i;
		this.proName = proName;
		this.proSuffix=proSuffix;
	}
	
	
	
	
	public String getProName() {
		return proName;
	}




	public void setProName(String proName) {
		this.proName = proName;
	}




	public String getProSuffix() {
		return proSuffix;
	}




	public void setProSuffix(String proSuffix) {
		this.proSuffix = proSuffix;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
