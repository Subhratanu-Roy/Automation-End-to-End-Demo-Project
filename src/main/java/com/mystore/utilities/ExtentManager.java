package com.mystore.utilities;



import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	static String currentTime = new SimpleDateFormat("dd-MM-yyyy-hhmmss").format(new Date());
	static String filepath = System.getProperty("user.dir")+"\\Reports\\Mystore_Report_"+currentTime+".html";
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void setReport() {

		extent = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter(filepath);
		extentSparkReporter.config().setDocumentTitle("My Store Automation Testing");
		extentSparkReporter.config().setReportName("My Store Report");
		extent.attachReporter(extentSparkReporter);
		extent.setSystemInfo("Hostname", "My Host");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Project Name", "My Store Applicaton Testing");
		extent.setSystemInfo("Tester", "Subhratanu Roy");

	}

	public static void endReport() {

		extent.flush();
	}

}
