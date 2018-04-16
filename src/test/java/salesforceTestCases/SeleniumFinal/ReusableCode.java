package salesforceTestCases.SeleniumFinal;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Iterator;
	import java.util.Set;

	import org.apache.poi.hssf.usermodel.HSSFSheet;
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class ReusableCode{
		

		public static boolean enterText(WebElement obj, String txtval, String objName) {
			if (obj.isDisplayed()) {
				obj.sendKeys(txtval);
				System.out.println("Pass: " + txtval + " is entered in " + objName + " the field");
				return true;
			} else {
				System.out.println("Fail: " + objName + "field doesnot exist please check your application");
				return false;
			}

		}
		public static boolean Clear(WebElement obj,String objName) {
			if (obj.isDisplayed()) {
				obj.clear();
				System.out.println("Pass: " + objName +" is displayed and the field  is cleared");
				return true;
			}
			else {
				System.out.println("Fail: " + objName +" field doesnot exist please check your application");
				return false;
			}

		}
		public static boolean clickObject(WebElement obj, String objName) {
			if (obj.isDisplayed()) {
				obj.click();
				System.out.println("Pass: " + objName + " is clicked");
				return true;
			} else {
				System.out.println("Fail: " + objName + "field doesnot exist please check your application");
				return false;
			}
			
		}

		public static boolean selectCheckBox(WebElement obj, String objName) {
			if (obj.isDisplayed()) {
				if(obj.isSelected())
				{
					System.out.println("Pass: " + objName + " is previously clicked");
					return true;
				}
				else
				obj.click();
				System.out.println("Pass: " + objName + " is now clicked");
				return true;
			}
				else {
				System.out.println("Fail: " + objName + "field doesnot exist please check your application");
				return false;
				}

		}

		public static boolean deSelectCheckBox(WebElement obj, String objName) {
			if (obj.isDisplayed())
			{
				if (obj.isSelected())
				{
					obj.click();
					System.out.println("Pass: " + objName + " is checked");
					return true;
				} else {
					System.out.println("Fail: " + objName + "field doesnot exist please check your application");
					return false;
				}
			}
			return false;

		}
		

		public static boolean validateTextBoxContent(WebElement obj, String expectedText, String objName){
			if(obj.isDisplayed())
			{
				String actualText = obj.getText();
				if(expectedText.equals(actualText)){
					System.out.println("Pass: " + " Expected text '" + expectedText + "' is matching with actual text: '" + actualText + "'.");
					return true;
				} else {
					System.out.println("Fail: "+" Expected text '" + expectedText + "' is not matching with actual text '"+ actualText + "'.");
					return false;
							}
				
			}else{
				System.out.println("Fail: " + objName + " is not diplayed, please check your application");
				return false;
			}
			
			
		}
		
		public static void switchBetweenWindows(WebDriver driver)
		{
			String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;

			Set<String> handles = driver.getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
			    subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler); // switch to popup window

			// Now you are in the popup window, perform necessary actions here

			// driver.switchTo().window(parentWindowHandler); 
		}
		

		public static String[][] readDataFromXl(String dataTablePath, String sheetName) throws IOException{
//			String cur_dir = System.getProperty("user.dir");
			FileInputStream fs = new FileInputStream (new File(dataTablePath));
			
			HSSFWorkbook wb= new HSSFWorkbook(fs);
			HSSFSheet sheet=wb.getSheet(sheetName);
			
			int trow= sheet.getLastRowNum()+1;
			int tcol=sheet.getRow(0).getLastCellNum();
			
			String [][]str=new String[trow][tcol];
			for(int i=0;i<trow;i++){
				for(int j=0;j<tcol;j++){
					str[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					
				}
			}
			for(int i=0;i<str.length;i++){
				for(int j=0;j<str[0].length;j++){
					System.out.print(str[i][j]+" ");
				}
				System.out.println();
				
			}
			System.out.println();
			return str;
		}
		
		public static WebDriver executeFirefoxMethod() throws InterruptedException
		{
			String driverpath = "C:\\Users\\theph\\eclipse-workspace\\Selenium\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverpath);
		
			WebDriver driver = new FirefoxDriver();
			driver.get("https://login.salesforce.com/");

			Thread.sleep(1000);

			WebElement un = driver.findElement(By.id("username"));
			enterText(un, "visishta@kiran.co", "username");

			Thread.sleep(1000);

			WebElement pwd = driver.findElement(By.id("password"));
			enterText(pwd, "asdfgh123", "password");

			Thread.sleep(1000);

			WebElement loginButton = driver.findElement(By.id("Login"));
			clickObject(loginButton, "Login");

			Thread.sleep(5000);

			WebElement userValidation = driver.findElement(By.xpath(".//*[@id='userNavButton']"));
			validateTextBoxContent(userValidation, "visishta vista", "Error");
			
			return driver;
		}

		
	}


