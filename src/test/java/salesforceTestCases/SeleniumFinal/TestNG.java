/*package salesforceTestCases.SeleniumFinal;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG extends Modules {

	@Test
		public static void InitialDriver() throws NoSuchMethodException, SecurityException, InterruptedException,
			IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		String path = "C:/Users/theph/eclipse-workspace/SeleniumFinal/TestSuite.xls";

		String[][] recData = readDataFromXl(path, "Sheet1");
		String firefoxStatus, ChromeStatus, ieStatus;

		for (int i = 1; i < recData.length; i++) {
			if (recData[i][1].equalsIgnoreCase("Y")) {
				firefoxStatus = recData[i][2];
				ChromeStatus = recData[i][4];
				ieStatus = recData[i][6];

				if (firefoxStatus.equalsIgnoreCase("Y")) {

					String tc = recData[i][0];

					Method testcase = TestNG.class.getMethod(tc, String.class);
					if ((Boolean) testcase.invoke(new TestNG(), "Firefox")) {
						Modules.writeDataToXl(path, "Sheet1", i, 3, "pass");
						Modules.fillBackgroundColor(path, "Sheet1", i, 3, "pass");

					} else {
						System.out.println("you are in else");
						Modules.writeDataToXl(path, "Sheet1", i, 3, "fail");
						Modules.fillBackgroundColor(path, "Sheet1", i, 3, "fail");

					}
				}
			}
		}
	}


	public static boolean LoginErrorMessage_TC01(String BrowserName) throws InterruptedException {

		Modules.launchbrowser(BrowserName);
		Thread.sleep(2000);

		WebElement un = driver.findElement(By.id("username"));
		enterText(un, "user@gmail.com", "username");

		Thread.sleep(1000);

		WebElement pwd = driver.findElement(By.id("password"));
		Clear(pwd, "password");

		Thread.sleep(1000);

		WebElement login = driver.findElement(By.id("Login"));
		clickObject(login, "Login");

		Thread.sleep(2000);

		WebElement error = driver.findElement(By.xpath(".//*[@id='error']"));
		String expect = "Please enter password.";

		boolean status = validateTextBoxContent(error, expect, "Error");
		Modules.exitBrowser();
		return status;

	}

	@Test
	public static boolean LoginToSalesForce_TC02(String BrowserName) throws InterruptedException {

		Modules.launchbrowser(BrowserName);

		WebElement un = driver.findElement(By.id("username"));
		enterText(un, "visishta@kiran.co", "username");
		String actual_msg = un.getAttribute("value");

		Thread.sleep(1000);
		WebElement pwd = driver.findElement(By.id("password"));
		enterText(pwd, "asdfgh123", "password");

		WebElement login = driver.findElement(By.id("Login"));
		Thread.sleep(1000);
		boolean status = clickObject(login, "Login");

		Thread.sleep(5000);
		exitBrowser();
		return status;

	}

		public static void CheckRemeberMe_TC03(String BrowserName) throws InterruptedException {

		Modules.launchbrowser(BrowserName);

		Thread.sleep(1000);

		WebElement un = driver.findElement(By.id("username"));
		enterText(un, "visishta@kiran.co", "username");

		Thread.sleep(1000);

		WebElement pwd = driver.findElement(By.id("password"));
		enterText(pwd, "asdfgh123", "password");

		Thread.sleep(1000);

		WebElement check = driver.findElement(By.id("rememberUn"));
		selectCheckBox(check, "rememberUn");

		Thread.sleep(1000);

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickObject(loginButton, "Login");

		Thread.sleep(5000);

		WebElement selectMenu = driver.findElement(By.xpath(" .//*[@id='userNavButton']"));
		clickObject(selectMenu, " menu bar");

		Thread.sleep(5000);

		WebElement selectMenu1 = driver.findElement(By.xpath(" .//*[@id='userNav-menuItems']/a[5]"));
		clickObject(selectMenu1, " logout ");

		Thread.sleep(10000);

		WebElement msg = driver
				.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/div[1]/div/div/div/span"));

		String expect = driver
				.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/div[1]/div/div/div/span"))
				.getText();

		validateTextBoxContent(msg, expect, "username");

		Modules.exitBrowser();
	}


	public static void ForgotPassword_TC4B(String BrowserName) throws InterruptedException {

		Modules.launchbrowser(BrowserName);

		Thread.sleep(2000);

		WebElement un = driver.findElement(By.id("username"));
		enterText(un, "123", "username");

		Thread.sleep(1000);

		WebElement pwd = driver.findElement(By.id("password"));
		enterText(pwd, "123456", "password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickObject(loginButton, "Login");

		WebElement error = driver.findElement(By.xpath(".//*[@id='error']"));
		String expect = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";

		validateTextBoxContent(error, expect, "error");

		Thread.sleep(10000);

		driver.close();

	}


	public static void ForgotPassword_TC4A(String BrowserName) throws InterruptedException {

		Modules.launchbrowser(BrowserName);

		Thread.sleep(2000);

		WebElement pwd = driver.findElement(By.xpath(".//*[@id='forgot_password_link']"));
		clickObject(pwd, "forgot password");

		Thread.sleep(2000);

		WebElement un = driver.findElement(By.xpath(".//*[@id='un']"));
		enterText(un, "visishta@kiran.co", ".//*[@id='un']");

		Thread.sleep(2000);

		WebElement con = driver.findElement(By.xpath(".//*[@id='continue']"));
		clickObject(con, "continue");

		Thread.sleep(5000);

		WebElement error = driver.findElement(By.xpath(".//*[@id='forgotPassForm']/div/p[1]"));
		String expect = "We’ve sent you an email with a link to finish resetting your password.";

		validateTextBoxContent(error, expect, "error");
		Thread.sleep(5000);

		driver.close();

	}

	public static void TC05(String BrowserName) throws InterruptedException {

		Modules.launchbrowser(BrowserName);

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

		WebElement selectMenu = driver.findElement(By.xpath(" .//*[@id='userNavButton']"));
		clickObject(selectMenu, " menu bar");

		WebElement display1 = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[1]"));
		String expect = "My Profile";
		validateTextBoxContent(display1, expect, "error");

		WebElement display2 = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[2]"));
		String expect2 = "My Settings";
		validateTextBoxContent(display2, expect2, "error");

		WebElement display3 = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]"));
		String expect3 = "Developer Console";
		validateTextBoxContent(display3, expect3, "error");

		WebElement display4 = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[4]"));
		String expect4 = "Switch to Lightning Experience";
		validateTextBoxContent(display4, expect4, "error");

		WebElement display5 = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[5]"));
		String expect5 = "Logout";
		validateTextBoxContent(display5, expect5, "error");

		driver.close();
	}
}
*/