package com.fedex.shipment.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import static org.junit.Assert.*;

public class DBConnectionTest {
	
	@Test
	public void testGetConnection() throws SQLException{
		Connection conn = null;
		conn = DBConnection.getConnection();
		assertNotNull(conn);
		if(conn!=null){
			conn.close();
			System.out.println();
		}
	}
}
