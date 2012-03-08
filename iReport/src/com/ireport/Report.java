package com.ireport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Report {
	
	public static JasperPrint fillReport(Map<String, Object> param)
	{
		JasperPrint print = null;
		try {
//			JasperDesign jasperDesign = JRXmlLoader.load("wizardstep.jrxml");
//			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			
			Connection conn = null;		  
			// Load the database driver
		    Class.forName("org.postgresql.Driver") ;
		    // Get a connection to the database		      
		    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", 
		    	  "test",  
		    	  "test");
			
			print = JasperFillManager.fillReport("persons.jasper", param, conn);
//			JasperExportManager.exportReportToPdfFile(print, "pdf.pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return print;
	}

}
