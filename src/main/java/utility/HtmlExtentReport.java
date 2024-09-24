package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class HtmlExtentReport {
	public static ExtentReports configureReports() {
	      ExtentReports reports = new ExtentReports();     //all methods of extentrepors are nonstatic hence methods are called with the help of object
	      ExtentSparkReporter htmlreport = new ExtentSparkReporter("ExtentReports.html");
	      reports.attachReporter(htmlreport);
	      reports.setSystemInfo("SuiteName", "Regression");
	      reports.setSystemInfo("createdBy", "Priyanka");
	      return reports;
	      
	      
	}
}
