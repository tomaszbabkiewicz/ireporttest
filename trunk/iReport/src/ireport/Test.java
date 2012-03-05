package ireport;

import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

public class Test extends JFrame {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) {
		Map<String, Object> param = new HashMap<String, Object>();		
		param.put("test", "Mój tytu³");
		Test viewer = new Test("Report File Name With Extension", param);
		viewer.setVisible(true);
	}
	
	public Test(String fileName, Map<String, Object> param)
	{
		super("View Report");
		try{
			//JasperDesign jasperDesign = JRXmlLoader.load("wizardstep.jrxml");
			//JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			
			
			  Connection conn = null;		  
			  // Load the database driver
		      Class.forName("org.postgresql.Driver") ;
		      // Get a connection to the database		      
		      conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quamasoft", 
		    		  "root",  
		    		  "kom#34ala");
			
			JasperPrint print = JasperFillManager.fillReport("wizardstep.jasper", param, conn);
//			JasperExportManager.exportReportToPdfFile(print, "pdf.pdf");
			JRViewer viewer = new JRViewer(print);
			Container c = getContentPane();
			c.add(viewer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setBounds(10,10,600,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
