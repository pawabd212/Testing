package com.fedex.shipment.modal;

public class ProTransferDeatils {
	
	private int id;
	
	private String proNumber;
	private String toLoc;
	private String reason;
	String transferStatus;
	
	public String getTransferStatus() {
		return transferStatus;
	}


	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}


	public ProTransferDeatils() {
	}
	
	
	public ProTransferDeatils(String proNumber, String toLoc, String reason) {
		this.proNumber = proNumber;
		this.toLoc = toLoc;
		this.reason = reason;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProNumber() {
		return proNumber;
	}
	public void setProNumber(String proNumber) {
		this.proNumber = proNumber;
	}
	public String getToLoc() {
		return toLoc;
	}
	public void setToLoc(String toLoc) {
		this.toLoc = toLoc;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

}
