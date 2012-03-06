package com.ireport;

import java.awt.Container;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import net.sf.jasperreports.view.JRViewer;

public class ReportTest extends JFrame {

	private static final long serialVersionUID = -3734367981799122886L;

	public static void main(String[] args) {
		Map<String, Object> param = new HashMap<String, Object>();		
		param.put("test", "Mój tytu³");
		ReportTest frame = new ReportTest();
		
		JRViewer viewer = new JRViewer(Report.fillReport(param));
		Container c = frame.getContentPane();
		c.add(viewer);
		
		frame.setBounds(10,10,600,500);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public ReportTest()
	{
		super("View Report");
	}

}
