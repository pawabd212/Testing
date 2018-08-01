package com.fedex.shipment.util;


/**
 * 
 * @author PS5018866
 *
 */
public class QueriesTemplates {

	public static final String FETCH_LOC_LIST_QUERY = "SELECT LOC  FROM shipmentenq.LOC";
	public static final String FETCH_REASON_LIST_QUERY = "SELECT TYPE_DESCRIPTION,TYPE_VALUE_1  FROM shipmentenq.CENT_ATOP_SYS_CODE";
	
	public static final String PRO_TRANSFER="insert into shipment (pronumber,toLocation,reason)" + "values(?,?,?)";
	public static final String CHECK_PRONUMBER="SELECT ID FROM shipmentenq.pro_detail WHERE pronumber = ? AND SUFFIX = ?";
	public static final String SHIPMENT_INSERT_QUERY = "insert into shipment values(?,?,?)";
	
}
