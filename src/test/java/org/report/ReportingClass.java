package org.report;

import java.io.File;
import java.util.LinkedList;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ReportingClass {
	
	public static void generateReport(String json) {
		
		File f = new File("target");
		
		Configuration con = new Configuration(f, "Luma E-Commerce");
		
		con.addClassifications("User", "Krishna");
		con.addClassifications("Tool", "Eclipse-IDE");
		con.addClassifications("Java-Version", "JDK-8");
		
		LinkedList<String> li = new LinkedList<String>();
		li.add(json);
		
		ReportBuilder r = new ReportBuilder(li, con);
		r.generateReports();
		
	}

}
