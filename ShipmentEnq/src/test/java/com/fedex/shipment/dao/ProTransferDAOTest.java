package com.fedex.shipment.dao;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fedex.shipment.modal.ProDetail;
import com.fedex.shipment.modal.ProTransferDeatils;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/dispatcher-servlet.xml"})
public class ProTransferDAOTest {

	@Autowired
	private ProTransferDAO proTransferDAO;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
		
	@Test
	public void testSetJdbcTemplate() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		proTransferDAO.setJdbcTemplate(jdbcTemplate);
		Field f = proTransferDAO.getClass().getDeclaredField("jdbcTemplate"); //NoSuchFieldException
		f.setAccessible(true);
		JdbcTemplate templateFromReflection = (JdbcTemplate) f.get(proTransferDAO);
		assertSame(jdbcTemplate, templateFromReflection);
	}
	
	@Test
	public void testSaveProTransfer() throws Exception{
		String proNumber = "1234567890";
		String toLoc = "10";
		String reason = "test";
		ProTransferDeatils dtsl = new ProTransferDeatils(proNumber, toLoc, reason);
		proTransferDAO.saveProTransfer(dtsl);
		List<Map<String, Object>> values = jdbcTemplate.queryForList("select pronumber,toLocation,reason from shipment where pronumber = '"+proNumber+"' and toLocation = '"+toLoc+"' and  reason = '"+reason+"'");
		assertFalse(values.isEmpty());
		
	}
	
	@Test
	public void testaddPro1(){
		ProDetail proDetail = new ProDetail();
		 proDetail.setId(1);
		 proDetail.setProName("PRONAME001");
		 proDetail.setProSuffix("R0");
		 proDetail.setTransferStatus("Transfer Successful");
//		 proDetail = proTransferService.addPro(proDetail); 
	}
	
	@Test
	public void testgetLocList(){
		System.out.println("testgetLocList tested");
		
	}
	
	@Test
	public void testgetReasonList(){
		System.out.println("testgetReasonList tested");
		
	}
}
