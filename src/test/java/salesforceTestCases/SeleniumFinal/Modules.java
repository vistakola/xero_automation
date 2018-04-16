package salesforceTestCases.SeleniumFinal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Modules extends ReusableCode {

	public static WebDriver driver;

	public static void launchbrowser(String BrowserName) throws InterruptedException {
		if (BrowserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\theph\\eclipse-workspace\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("https://login.salesforce.com");
			
			Thread.sleep(2000);
		}

		if (BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\theph\\Downloads\\chromedriver.exe");
			 driver = new ChromeDriver();
			driver.get("https://login.salesforce.com");
			System.out.println("chrome here");
			Thread.sleep(1000);
		}

		if (BrowserName.equalsIgnoreCase("Internet explorer")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\theph\\Downloads\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			driver.get("https://login.salesforce.com");
			Thread.sleep(1000);
		}
	}

	public static String[][] readDataFromXl(String filePath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheet(sheetName);

		int trow = sheet.getLastRowNum();
		int tcol = sheet.getRow(0).getLastCellNum();
		String[][] str = new String[trow][tcol];
		System.out.println(" Total rows= " + trow + " Total col= " + tcol);
		for (int i = 0; i < trow; i++) {
			for (int j = 0; j < tcol; j++) {
				str[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[0].length; j++) {

				System.out.print(str[i][j] + " ");
			}
			System.out.println();

		}
		System.out.println();
		return str;
	}

	public static void writeDataToXl(String filePath, String sheetName, int row, int col, String text)
			throws IOException {
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheet(sheetName);
		sheet.getRow(row).getCell(col).setCellValue(text);
		FileOutputStream outputStream = new FileOutputStream(new File(filePath));
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}

	public static void fillBackgroundColor(String filePath, String sheetName, int row, int col, String status)
			throws FileNotFoundException, IOException {

		FileInputStream inputStream = new FileInputStream(new File(filePath));
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheet(sheetName);

		HSSFRow row1 = sheet.getRow(row);
		HSSFCell cell = row1.getCell(col);

		if (status.equalsIgnoreCase("pass")) {
			HSSFCellStyle style = (HSSFCellStyle) workbook.createCellStyle();

			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(style);

		} else if (status.equalsIgnoreCase("Fail")) {
			HSSFCellStyle style = (HSSFCellStyle) workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(style);

		}
		FileOutputStream outputStream = new FileOutputStream(new File(filePath));
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}

	public static void exitBrowser() throws InterruptedException {
		System.out.println("Exiting browser...");
		Thread.sleep(2000);
		driver.quit();
		driver = null;
	}

	public static void extentReport() {
		ExtentHtmlReporter htmlReporter;
		ExtentReports extent;
		ExtentTest logger;

		htmlReporter = new ExtentHtmlReporter(
				"C://Users//theph//eclipse-workspace//SeleniumFinal//ExtentReport//NewReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "eclipse");
		extent.setSystemInfo("Environment", "SalesForce");
		extent.setSystemInfo("User Name", "TestCase");

		htmlReporter.config().setDocumentTitle("extent reports");
		htmlReporter.config().setReportName("functional testing reports");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

		logger = extent.createTest("Pass Test");
		logger.log(Status.INFO, "started report for pass test");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));

		logger = extent.createTest("Fail Test");
		logger.log(Status.FAIL, "Test Case (failTest) Status is passed");
		logger.log(Status.FAIL, MarkupHelper.createLabel("Fail Test" + " - Test Case Failed", ExtentColor.RED));

		logger = extent.createTest("Skip Test");
		logger.log(Status.SKIP, MarkupHelper.createLabel("Fail Test" + " - Test Case Skipped", ExtentColor.ORANGE));

		extent.flush();
		System.out.println("extent code completed");
	}

	/*
	 * public static void InitialDriver() throws NoSuchMethodException,
	 * SecurityException, InterruptedException, IOException, IllegalAccessException,
	 * IllegalArgumentException, InvocationTargetException { String path =
	 * "C:/Users/theph/eclipse-workspace/SeleniumFinal/TestSuite.xls";
	 * 
	 * String[][] recData = readDataFromXl(path, "Sheet1"); String
	 * firefoxStatus,ChromeStatus,ieStatus;
	 * 
	 * for(int i=2;i<recData.length;i++){ if(recData[i][1].equalsIgnoreCase("Y")){
	 * firefoxStatus=recData[i][2]; ChromeStatus=recData[i][4];
	 * ieStatus=recData[i][6];
	 * 
	 * if(firefoxStatus.equalsIgnoreCase("Y")){
	 * 
	 * String tc = recData[i][0];
	 * 
	 * Method testcase =TestNG.class.getMethod(tc,String.class); if((Boolean)
	 * testcase.invoke(new TestNG(),"Firefox")){
	 * Modules.writeDataToXl(path,"Sheet1",i,3,"pass");
	 * Modules.fillBackgroundColor(path,"Sheet1",i,3,"pass");
	 * 
	 * } else{ System.out.println("you are in else");
	 * Modules.writeDataToXl(path,"Sheet1",i,3,"fail");
	 * Modules.fillBackgroundColor(path,"Sheet1",i,3,"fail");
	 * 
	 * } } } } }
	 */
}
