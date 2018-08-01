package com.fedex.shipment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.fedex.shipment.modal.ProDetail;
import com.fedex.shipment.modal.ProTransferDeatils;
import com.fedex.shipment.util.Constants;
import com.fedex.shipment.util.DBConnection;
import com.fedex.shipment.util.QueriesTemplates;

@Repository
public class ProTransferDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public void saveProTransfer(ProTransferDeatils e) {
		try {

			Object[] args = new Object[] { e.getProNumber(), e.getToLoc(), e.getReason() };

			System.out.println("jdbc template" + jdbcTemplate);

			int out = jdbcTemplate.update(QueriesTemplates.PRO_TRANSFER, args);

			if (out != 0) {
				System.out.println("PRO saved with id=" + e.getProNumber());
			} else
				System.out.println("PRO save failed with id=" + e.getProNumber());
		} catch (DataAccessException e1) {

			e1.printStackTrace();
		}
	}
	
	/*public int addPro(ProDetail proDetail)
	{
		int proId = 0;
		 Connection conn= DBConnection.getConnection(); 
		 ResultSet rs = null;
		 PreparedStatement  pstmt = null;
		 try {
			 pstmt = conn.prepareStatement(QueriesTemplates.CHECK_PRONUMBER);
				{
					pstmt.setString(1, proDetail.getProName());
					pstmt.setString(2, proDetail.getProSuffix());
					
					rs= pstmt.executeQuery();
					if(rs.next()) {
						proId = rs.getInt(1);
					}
				}
		 } catch (SQLException e) {
			System.out.println("Error while inserting data into database"+e);
			e.printStackTrace();
		 }
		return proId;
	}*/

	
	public int addPro1(ProDetail pd){
		  int proId = 0;
		  Object[] args = new Object[] { pd.getProName() ,pd.getProSuffix() };
		    
		  SqlRowSet result=  jdbcTemplate.queryForRowSet(QueriesTemplates.CHECK_PRONUMBER, args);
		     System.out.println("add pro details");
		  if(result.next()){
			  proId= result.getInt(1);
		  }
		return proId;
	        
	  }
	
	public List<String> getLocList() {

		List<String> locList = new ArrayList<>();

		List<Map<String, Object>> locRows = jdbcTemplate.queryForList(QueriesTemplates.FETCH_LOC_LIST_QUERY);
		System.out.println("  Enter   getLOC");
		for (Map<String, Object> rowList : locRows) {
			locList.add((String) rowList.get(Constants.LOC));
		}

		return locList;
	}

	public List<String> getReasonList() {

		List<String> reasonList = new ArrayList<>();
		System.out.println("Enter intop Reason List");
		List<Map<String, Object>> reasonRows = jdbcTemplate.queryForList(QueriesTemplates.FETCH_REASON_LIST_QUERY);
		for (Map<String, Object> rowList : reasonRows) {
			reasonList.add(rowList.get(Constants.TYPE_DESCRIPTION) + "_" + rowList.get(Constants.TYPE_VALUE_1));
		}

		return reasonList;
	}
}
