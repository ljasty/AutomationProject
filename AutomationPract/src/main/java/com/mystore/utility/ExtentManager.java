package com.mystore.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
	
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String testRpt="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/target/"+testRpt);
				//new ExtentHtmlReporter("MyReport.html");
		htmlReporter.loadXMLConfig ("/Users/lakshmi/eclipse-workspace/AutomationPract/extent-config.xml");
		
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "MyAutomationProject");
		extent.setSystemInfo("Tester", "Lakshmi");
		extent.setSystemInfo("OS", "mac");
		extent.setSystemInfo("Browser", "Chrome");
	}
	public static void endReport() {
		extent.flush();
	}
}
