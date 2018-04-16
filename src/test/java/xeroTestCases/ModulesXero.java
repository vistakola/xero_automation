package xeroTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

public class ModulesXero extends ReusableMethodsXero {

	public static  WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public static String[][] readDataFromXl(String filePath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheet(sheetName);

		int trow = sheet.getLastRowNum() + 1;
		int tcol = sheet.getRow(0).getLastCellNum();
		String[][] str = new String[trow][tcol];
		for (int i = 0; i < trow; i++) {
			for (int j = 0; j < tcol; j++) {
				str[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[0].length; j++) {

				System.out.print(str[i][j] + " ");
			}
			System.out.println(" ");

		}
		System.out.println(" ");
		return str;
	}

	public static boolean freeTrialPage() throws InterruptedException {
		WebElement freeTrial = driver
				.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
		if (!clickObject(freeTrial, "Free Trail"))
			return false;
		String title = driver.getTitle();
		DriverFileXero.logger.log(Status.INFO,title + " page is displayed");
		Thread.sleep(3000);
		return true;
	}

	public static boolean LoginToXero(String username, String password) throws InterruptedException {

		WebElement un = driver.findElement(By.xpath(".//*[@id='email']"));
		if (!enterText(un, username, "Username"))
			return false;
		Thread.sleep(1000);

		WebElement pwd = driver.findElement(By.xpath(".//*[@id='password']"));
		if (!enterText(pwd, password, "Password"))
			return false;
		Thread.sleep(1000);

		WebElement login = driver.findElement(By.xpath(".//*[@id='submitButton']"));
		if (!clickObject(login, "Login"))
			return false;
		Thread.sleep(2000);

		return true;

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
		DriverFileXero.logger.log(Status.INFO,"Exiting browser...");
		Thread.sleep(2000);
		driver.close();
		driver = null;
	}

	/*public static void extentReport(String tc) {
		

		htmlReporter = new ExtentHtmlReporter("C:/Users/theph/eclipse-workspace/SeleniumFinal/ExtentReport/NewReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "eclipse");
		extent.setSystemInfo("Environment", "xero");
		extent.setSystemInfo("User Name", "TestCase");

		htmlReporter.config().setDocumentTitle("extent reports");
		htmlReporter.config().setReportName("functional testing reports");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

		logger = extent.createTest(tc);
		

		extent.flush();
		DriverFileXero.logger.log(Status.INFO,"extent code completed");
	}*/

	
	public static ExtentReports startReport(String filePath){
		
		htmlReporter = new ExtentHtmlReporter("C:/Users/theph/eclipse-workspace/XeroSeleniumTest/ExtentReports/NewReport.html");
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Xero");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "vista");
		
		htmlReporter.config().setDocumentTitle("report status");
		htmlReporter.config().setReportName("customized report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		return extent;
	}
	
	public static ExtentTest createTestReport(String tc, ExtentReports extent){
		
		logger = extent.createTest(tc);
		return logger;
	}
	
	public static void endReport(ExtentReports extent){
		extent.flush();
	}
	
	public static boolean clickBuyNow() throws InterruptedException{
		
			WebElement buyNow = driver.findElement(By.xpath(".//*[@id='simplebutton-1036']"));
		if(!clickObject(buyNow,"Buy Now")) return false;
			Thread.sleep(6000);
			String actual = driver.getTitle();
			if(!actual.contains("Pricing Plan")) {
				System.out.println(actual + " page is verified");
				return false;
				}
			else
				DriverFileXero.logger.log(Status.INFO,"page is not verified");
			
		return true;
	}
	public static boolean testData() throws InterruptedException{
		
		WebElement continueButton = driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/div/main/div[10]/button"));
		if(!clickObject(continueButton," Continue Button")) return false;
			Thread.sleep(2000);
			WebElement street = driver.findElement(By.xpath(".//*[@id='POAddress']"));
			if(!enterText(street,"3450 granada ave","Billing Address")) return false;
				Thread.sleep(2000);
				WebElement city = driver.findElement(By.xpath(".//*[@id='POCity']"));
				if(!enterText(city,"santa clara","City")) return false;
					Thread.sleep(2000);
					WebElement state = driver.findElement(By.xpath(".//*[@id='PORegionDropdown']"));
					Select select = new Select(state);
					select.selectByVisibleText("California");
					Thread.sleep(2000);
					WebElement zipcode = driver.findElement(By.xpath(".//*[@id='POPostalCode']"));
					if(!enterText(zipcode,"95051","ZipCode")) return false;
						WebElement Continue = driver.findElement(By.xpath(".//*[@id='frmMain']/div/div/div/main/div[3]/div/div[2]/div/button"));
						if(!clickObject(Continue,"Continue To Pay")) return false;
							Thread.sleep(4000);
							String actualTitle = driver.getTitle();
							if(!actualTitle.contains("Confirm")) {
								DriverFileXero.logger.log(Status.INFO,actualTitle + " page is verified");
								return false;
								}		
							else
								DriverFileXero.logger.log(Status.INFO,"page is not verified");
							return true;
}


	public static boolean LoginPage(String UserName,String Password){
		WebElement username = driver.findElement(By.id("email"));
		 if(!enterText(username, UserName, "EmailAddress")) return false;

			WebElement password = driver.findElement(By.id("password"));
			 if(!enterText(password, Password, "Password")) return false;

				WebElement login = driver.findElement(By.id("submitButton"));
				if(clickObject(login, "Login")) return false;
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String actual = driver.getTitle();
				if(!actual.contains("Xero")){
					DriverFileXero.logger.log(Status.INFO,actual + " page is verified");
					return false;
				}
				else{
					DriverFileXero.logger.log(Status.INFO,"page is not verified");
				}
		return true;
		
	}	
	

	public static boolean AddAnOrganisation() throws InterruptedException{
			try{
			WebElement myXero = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2"));
			if (!clickObject(myXero, "My Xero")) return false;
				Thread.sleep(2000);
				WebElement xero = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div[1]/a"));
				if (!clickObject(xero, "Xero")) return false;
					Thread.sleep(3000);

					WebElement addOrganisation = driver.findElement(By.xpath(".//*[@id='ext-gen1042']"));
					if (!clickObject(addOrganisation, "Add an Organisation")) return false;
						Thread.sleep(3000);
						WebElement name = driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']"));
						if (!enterText(name, "self", "Name of an Organisation")) return false;
							Thread.sleep(3000);

							WebElement where = driver.findElement(By.xpath(".//*[@id='countryCmb-inputEl']"));
							Clear(where, "Country");
							Thread.sleep(1000);
							if (!enterText(where, "United States", "Country")) return false;
						WebElement country = driver.findElement(By.xpath("/html/body/div[8]/div/ul/li[1]"));
				
							if(!clickObject(country,"Country")) return false;

								WebElement timeZone = driver.findElement(By.xpath(".//*[@id='cmbTimeZone-inputEl']"));
								if(!clickObject(timeZone,"Time Zone")) return false;
								Clear(timeZone, "Time Zone");
								Thread.sleep(1000);
								if (!enterText(timeZone, "(UTC-08:00) Pacific Time (US & Canada)", "Time Zone")) return false;
									WebElement time = driver.findElement(By.xpath("/html/body/div[9]/div/ul/li"));
									if(!clickObject(time,"TimeZone")) return false;
									
									Thread.sleep(3000);

									WebElement what = driver
											.findElement(By.xpath("//*[@id=\"industrysearchcombofield-1025-inputEl\"]"));
									if(!clickObject(what,"What does Organisation do")) return false;
									Thread.sleep(1000);
									if (!enterText(what, "Accounting", "What does your organisation do"))  return false;
										WebElement organisation = driver.findElement(By.xpath("/html/body/div[10]/div/div/ul/li[3]"));
										if(!clickObject(organisation,"What does your Organisation do")) return false;
										
										Thread.sleep(3000);
	return true;						
} finally {
	exitBrowser();

}
}
	
	public static boolean launchbrowser(String BrowserName, String url) throws InterruptedException {
		if (BrowserName.equalsIgnoreCase("Firefox")) {
			DriverFileXero.logger.log(Status.INFO,"Launching browser: " + BrowserName);

			try {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\theph\\eclipse-workspace\\Selenium\\geckodriver.exe");
				driver = new FirefoxDriver();

			} catch (Exception ex) {
				DriverFileXero.logger.log(Status.INFO,ex.toString());
				return false;
			}

			driver.get(url);
			Thread.sleep(1000);
			DriverFileXero.logger.log(Status.INFO,"Xero application page is displayed");
			return true;
		}

		if (BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\theph\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			DriverFileXero.logger.log(Status.INFO,"chrome here");
			Thread.sleep(1000);
			DriverFileXero.logger.log(Status.INFO,"Xero application page is displayed");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			return true;
		}

		if (BrowserName.equalsIgnoreCase("Internet explorer")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\theph\\Downloads\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(url);
			Thread.sleep(1000);
			DriverFileXero.logger.log(Status.INFO,"Xero application page is displayed");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			return true;
		}
		return false;
	}


	
}
