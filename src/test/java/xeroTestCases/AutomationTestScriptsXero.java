package xeroTestCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class AutomationTestScriptsXero extends ModulesXero {


	private static final String url = null;
	public static boolean NavigateToTestId01_A(String BrowserName, String url, String username, String password)
			throws InterruptedException {

		try {
			DriverFileXero.logger.log(Status.INFO, "browser opened");
			
			if (!launchbrowser(BrowserName, url))
				
				return false;
			Thread.sleep(2000);

			if (!LoginToXero(username, password))
				
				return false;
			DriverFileXero.logger.log(Status.INFO, "Login page is displayed ");

			

			String userHomePage = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/a"))
					.getText();
			if (userHomePage.contains("Vista")) {
				DriverFileXero.logger.log(Status.INFO,"Pass");
				return true;
			} else {
				DriverFileXero.logger.log(Status.INFO,"Fail");
				return false;
			}
		} finally {
			exitBrowser();
		}
		
	}

	public static boolean NavigateToTestId01_B(String BrowserName, String url, String username, String password)
			throws InterruptedException {

		try {
			if (!launchbrowser(BrowserName, url))
				return false;
			DriverFileXero.logger.log(Status.INFO, "browser opened");
			Thread.sleep(2000);

			if (!LoginToXero(username, password))
				return false;
			DriverFileXero.logger.log(Status.INFO, "Login page is displayed ");

			String errorMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div[2]/p"))
					.getText();
			String expected = "Your email or password is incorrect";
			if (!errorMsg.equalsIgnoreCase(expected)) {
				DriverFileXero.logger.log(Status.INFO,"FAIL: " + errorMsg + " is same as " + expected);
				return false;
			} else {
				DriverFileXero.logger.log(Status.INFO,"Pass: " + errorMsg + " is same as " + expected);
				return true;
			}
		} finally {
			exitBrowser();

		}

	}

	public static boolean NavigateToTestId01_C(String BrowserName, String url, String username, String password)
			throws InterruptedException {
		try {
			if (!launchbrowser(BrowserName, url))
				return false;
			Thread.sleep(2000);

			if (!LoginToXero(username, password))
				return false;
			DriverFileXero.logger.log(Status.INFO, "Login page is displayed ");

			String errorMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div[2]/p"))
					.getText();
			String expected = "Your email or password is incorrect";
			if (!errorMsg.equalsIgnoreCase(expected)) {
				DriverFileXero.logger.log(Status.INFO,"FAIL: " + errorMsg + " is same as " + expected);
				return false;
			} else {
				DriverFileXero.logger.log(Status.INFO,"Pass: " + errorMsg + " is same as " + expected);
				return true;
			}
		} finally {
			exitBrowser();

		}
	}

	public static boolean NavigateToTestId01_D(String BrowserName, String url, String username, String password)
			throws InterruptedException {
		try {
			if (!launchbrowser(BrowserName, url))
				return false;
			Thread.sleep(2000);

			WebElement ForgotPassword = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/a"));
			if (!clickObject(ForgotPassword, "ForgotPassword"))
				return false;
			Thread.sleep(2000);
			
			

			WebElement un1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/fieldset/div/label"));
			if(!clickObject(un1, "Enter username"))
				return false;
			WebElement userName1 = driver.findElement(By.xpath("//*[@id=\"UserName\"]"));
			if (!enterText(userName1, "username@gmail.com", "User Name"))
				
				
			Thread.sleep(1000);
			WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"submitButton\"]"));
			if(!clickObject(submitButton, "submit button"));
			Thread.sleep(3000);

			String ResetPassword = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/h2")).getText();
			String E ="Please check your email";
			if (!ResetPassword.contains(E)) {
				DriverFileXero.logger.log(Status.INFO,ResetPassword + " is not same as " + E);
				return false;
			}
			else
				DriverFileXero.logger.log(Status.INFO,ResetPassword + " is same as " + E);
			
			return true;
		} finally {
			exitBrowser();

		}
	}

	public static boolean NavigateToTestId02_A(String BrowserName, String url, String username, String password)
			throws InterruptedException {
		try {
			launchbrowser(BrowserName, url);
			freeTrialPage();

			WebElement firstName = driver
					.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[2]/label/input"));
			if (!enterText(firstName, "viva", "First Name"))
				return false;
			Thread.sleep(1000);
			WebElement lastName = driver
					.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[3]/label/input"));
			if (!enterText(lastName, "ki", "Last Name"))
				return false;
			Thread.sleep(1000);
			WebElement emailAddress = driver
					.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input"));
			if (!enterText(emailAddress, "visishta@kiran.co", "Email Address"))
				return false;

			Thread.sleep(1000);

			WebElement phoneNumber = driver
					.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[5]/label/input"));
			if (!enterText(phoneNumber, "9000207357", "PhoneNumber"))
				return false;

			Thread.sleep(1000);

			WebElement country = driver
					.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[6]/label/span/select"));
			Select select = new Select(country);
			select.selectByVisibleText("India");

			Thread.sleep(1000);

			WebElement terms = driver
					.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/input"));
			if (!selectCheckBox(terms, "Terms and Conditions"))
				return false;
			return true;
		} finally {
			exitBrowser();
		}

	}

	public static boolean NavigateToTestId02_B(String BrowserName, String url, String username, String password)
			throws InterruptedException {
		try {
			if (!launchbrowser(BrowserName, url))
				return false;

			if (!freeTrialPage())
				return false;

			WebElement getStarted = driver
					.findElement(By.xpath("/html/body/div[6]/main/div[1]/div/div/form/div[9]/span"));
			if (!clickObject(getStarted, "GetStarted"))
				return false;

			WebElement errorMsg1 = driver.findElement(By.xpath(".//*[@id='signup-form-error-message-1']"));
			String actual1 = errorMsg1.getText();
			if (!actual1.contains("First name can't be empty")) {
				DriverFileXero.logger.log(Status.INFO,"Fail:" + actual1 + " message is verified");
				return false;
			} else {
				DriverFileXero.logger.log(Status.INFO,"Pass: Error message is not verified");
			}

			Thread.sleep(1000);

			WebElement errorMsg2 = driver.findElement(By.xpath(".//*[@id='signup-form-error-message-2']"));
			String actual2 = errorMsg2.getText();
			if (!actual2.contains("Last name can't be empty")) {
				DriverFileXero.logger.log(Status.INFO,"Fail:" + actual2 + " message is verified");
			} else {
				DriverFileXero.logger.log(Status.INFO,"Pass: Error message is not verified");
			}

			Thread.sleep(1000);

			WebElement errorMsg3 = driver.findElement(By.xpath(".//*[@id='signup-form-error-message-3']"));
			String actual3 = errorMsg3.getText();
			if (!actual3.contains("Email address can't be empty")) {
				DriverFileXero.logger.log(Status.INFO,"Fail:" + actual3 + " message is verified");
				return false;
			} else {
				DriverFileXero.logger.log(Status.INFO,"Pass: Error message is not verified");
			}
			Thread.sleep(1000);

			WebElement errorMsg4 = driver.findElement(By.xpath(".//*[@id='signup-form-error-message-4']"));
			String actual4 = errorMsg4.getText();
			if (!actual4.contains("Phone number")) {
				DriverFileXero.logger.log(Status.INFO,"Fail" + actual4 + " message is verified");
				return false;
			} else {
				DriverFileXero.logger.log(Status.INFO,"Pass: Error message is not verified");
			}
			Thread.sleep(1000);

			WebElement emailAddress = driver
					.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input"));
			if (!enterText(emailAddress, "apple", "Email Address"))
				return false;

			String actualMsg = driver.findElement(By.xpath(".//*[@id='signup-form-error-message-3']")).getText();
			if (!actualMsg.contains("Email address is invalid")) {
				DriverFileXero.logger.log(Status.INFO,"Fail:" + actualMsg + " message is verified");
				return false;
			} else {
				DriverFileXero.logger.log(Status.INFO,"Pass: message is not verified");
			}
			Thread.sleep(1000);

			return true;
		} finally {

			exitBrowser();
		}
	}

	public static boolean NavigateToTestId02_C(String BrowserName, String url, String username, String password)
			throws InterruptedException {
		try {
			launchbrowser(BrowserName, url);

			freeTrialPage();

			WebElement termsOfUse = driver
					.findElement(By.xpath("/html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/a[1]"));
			if (!clickObject(termsOfUse, "Terms Of Use")) return false;
				Thread.sleep(3000);
				String parentWindow = driver.getWindowHandle();
				Set<String> getAllWindows = driver.getWindowHandles();
				int count = getAllWindows.size();
				for (String child : getAllWindows) {
					if (parentWindow.equalsIgnoreCase(child)) return false;
					else {
						driver.switchTo().window(child);
						System.out.println("child window titile is :" + driver.getCurrentUrl());
					}
				}
				driver.switchTo().window(parentWindow);
				Thread.sleep(2000);
				System.out.println("parent window title is :" + driver.getTitle());
				Thread.sleep(2000);

				WebElement policyLink = driver
						.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/a[2]"));
				if (!clickObject(policyLink, "Privacy Policy")) return false;
					Thread.sleep(3000);
					String parentWindow1 = driver.getWindowHandle();
					Set<String> getAllWindows1 = driver.getWindowHandles();
					int count1 = getAllWindows1.size();
					for (String child1 : getAllWindows1) {
						if (parentWindow1.equalsIgnoreCase(child1)) 
							return false;
						else {
							driver.switchTo().window(child1);
							System.out.println("Child1 window title is:" + driver.getCurrentUrl());
						}
					}
					driver.switchTo().window(parentWindow1);
		return true;
	} finally {
		exitBrowser();
	}

}
	

	public boolean NavigateToTestId02_D(String BrowserName, String url, String username, String password)
			throws InterruptedException {
		try {
			launchbrowser(BrowserName, url);

			freeTrialPage();

			WebElement offerDetails = driver
					.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/a[3]"));
			if (clickObject(offerDetails, "Offer Details")) {
				Thread.sleep(3000);
				String parentWindow = driver.getWindowHandle();
				Set<String> getAllWindows = driver.getWindowHandles();
				int count = getAllWindows.size();
				for (String child : getAllWindows) {
					if (!parentWindow.equalsIgnoreCase(child)) {
						driver.switchTo().window(child);
						DriverFileXero.logger.log(Status.INFO,"Child Window title is:" + driver.getCurrentUrl());
					} else
						return false;
				}
				driver.switchTo().window(parentWindow);
			}
			return true;
		} finally {
			exitBrowser();
		}

	}

	public boolean NavigateToTestId02_E(String BrowserName, String url, String username, String password)
			throws InterruptedException {
		try {
			launchbrowser(BrowserName, url);

			freeTrialPage();

			WebElement clickAccount = driver.findElement(By.xpath("html/body/div[6]/main/div[2]/div/div/div/p/a"));
			if (clickObject(clickAccount, "Click Account")) {
				Thread.sleep(2000);

				String actualMsg = driver.findElement(By.xpath("html/body/div[6]/main/div/div[1]/div/div/h2"))
						.getText();

				if (!actualMsg.contains("Let’s get started")) {
					DriverFileXero.logger.log(Status.INFO,"Fail: " + actualMsg + " message is not verified ");
				} else {
					DriverFileXero.logger.log(Status.INFO,"Pass: " + actualMsg + " message is  verified");
				}
				String actualURL = driver.getCurrentUrl();
				DriverFileXero.logger.log(Status.INFO,actualURL);

				String actualTitle = driver.getTitle();
				DriverFileXero.logger.log(Status.INFO,actualTitle);

			}
			return true;
		} finally {

			exitBrowser();
		}
	}

	public static boolean NavigateToTestId03_A(String BrowserName, String url, String username, String password)
			throws InterruptedException {
		try {
			if (!launchbrowser(BrowserName, url))
				return false;
			Thread.sleep(2000);

			if (!LoginToXero(username, password))
				return false;

			String trial = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/p")).getText();
			String expect = "You are currently using a trial account.";
			if (!trial.contains(expect)) {
				DriverFileXero.logger.log(Status.INFO,"Fail: " + expect + " is diff from" + trial);
				return false;
			} else
				DriverFileXero.logger.log(Status.INFO,"Pass: " + expect + " is diff from" + trial);

			WebElement dashboard = driver.findElement(By.xpath("//*[@id=\"Dashboard\"]"));
			if (!clickObject(dashboard, "Dashboard"))
				return false;
			Thread.sleep(1000);
			String DashboardPage = driver.getTitle();
			String expected = "Dashboard";
			if (!DashboardPage.contains(expected)) {
				DriverFileXero.logger.log(Status.INFO,"Fail:" + DashboardPage + " is not same as expected result " + expected);
				return false;
			} else
				DriverFileXero.logger.log(Status.INFO,"Pass:" + DashboardPage + " is  same as expected result " + expected);

			WebElement account = driver.findElement(By.xpath("//*[@id=\"Accounts\"]"));
			if (!clickObject(account, "Accounts"))
				return false;
			Thread.sleep(1000);

			WebElement report = driver.findElement(By.xpath("//*[@id=\"Reports\"]"));
			if (!clickObject(report, "Reports"))
				return false;
			Thread.sleep(1000);

			WebElement contact = driver.findElement(By.xpath("//*[@id=\"Contacts\"]"));
			if (!clickObject(contact, "Contacts"))
				return false;
			Thread.sleep(1000);
			WebElement setting = driver.findElement(By.xpath("//*[@id=\"Settings\"]"));
			if (!clickObject(setting, "Settings"))
				return false;
			Thread.sleep(1000);

			WebElement plus = driver.findElement(By.xpath("//*[@id=\"quicklaunchTab\"]"));
			if (!clickObject(plus, "+/New"))
				return false;
			Thread.sleep(1000);

			WebElement file = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/ul/li[2]/a"));
			if (!clickObject(file, "File"))
				return false;
			Thread.sleep(1000);

			WebElement notification = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/ul/li[3]/a"));
			if (!clickObject(notification, "notification"))
				return false;
			Thread.sleep(2000);

			WebElement Search = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/ul/li[4]/a"));
			if (!clickObject(Search, "Search"))
				return false;
			Thread.sleep(3000);

			WebElement Searchbar = driver.findElement(By.xpath(".//*[@id='placeholder']"));
			if (!clickObject(Searchbar, "Searchbar"))
				return false;
			Thread.sleep(2000);

			WebElement help = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/ul/li[5]/a"));
			if (!clickObject(help, "Help"))
				return false;

			WebElement helpfield = driver.findElement(By.xpath("//*[@id=\"menu_help\"]"));
			if (!helpfield.isDisplayed()) {
				DriverFileXero.logger.log(Status.INFO,"Fail: help field  is not displayed");
				return false;
			} else
				DriverFileXero.logger.log(Status.INFO,"Pass: help field is displayed");

			WebElement helpcenter = driver.findElement(
					By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/ul/li[5]/div/div/div/ul/li[1]/a]"));
			if (!helpcenter.isDisplayed()) {
				DriverFileXero.logger.log(Status.INFO,"Fail: help center  is not displayed");
				return false;
			} else
				DriverFileXero.logger.log(Status.INFO,"Pass: help center is displayed");

			WebElement getHelp = driver.findElement(By.xpath("//*[@id=\"get_help\"]]"));
			if (!getHelp.isDisplayed()) {
				DriverFileXero.logger.log(Status.INFO,"Fail: get Help  is not displayed");
				return false;
			} else
				DriverFileXero.logger.log(Status.INFO,"Pass: get Help is displayed");

			WebElement advisor = driver.findElement(By.xpath("//*[@id=\"get_help\"]]"));
			if (!advisor.isDisplayed()) {
				DriverFileXero.logger.log(Status.INFO,"Fail:advisor  is not displayed");
				return false;
			} else
				DriverFileXero.logger.log(Status.INFO,"Pass: advisor is displayed");

			return true;
		}

		finally {
			exitBrowser();

		}
	}

	public static boolean NavigateToTestId04_A(String BrowserName, String url, String username, String password)
			throws InterruptedException {
		try {
			if (!launchbrowser(BrowserName, url))
				return false;
			Thread.sleep(2000);

			if (!LoginToXero(username, password))
				return false;

			WebElement userMenu = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/a"));
			if (!clickObject(userMenu, "User Menu Drop Down"))
				return false;
			Thread.sleep(2000);

			WebElement logout = driver
					.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/div/ul/li[3]/a"));
			if (!clickObject(logout, "Logout"))
				return false;
			Thread.sleep(2000);

			String logoutMessage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/h2")).getText();
			String exp = "Welcome to Xero";
			if (!logoutMessage.equals(exp)) {
				DriverFileXero.logger.log(Status.INFO,"Fail: " + logoutMessage + " is not displayed");
				return false;
			} else
				DriverFileXero.logger.log(Status.INFO,"Pass: " + logoutMessage + " is displayed");

			return true;
		} finally {
			exitBrowser();
		}
	}

	public static boolean NavigateToTestId06_A(String BrowserName, String url, String username, String password)
			throws InterruptedException {
		try {
			if (!launchbrowser(BrowserName, url))
				return false;
			Thread.sleep(2000);

			if (!LoginToXero(username, password))
				return false;

			String DashboardPage = driver.getTitle();
			String expected = "Dashboard";
			if (!DashboardPage.contains(expected)) {
				DriverFileXero.logger.log(Status.INFO,"Fail:" + DashboardPage + " is not same as expected result " + expected);
				return false;
			} else
				DriverFileXero.logger.log(Status.INFO,"Pass:" + DashboardPage + " is  same as expected result " + expected);

			WebElement user = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/a"));
			if (!clickObject(user, "User Nav Button"))
				return false;

			WebElement profile = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div/ul/li[1]/a"));
			if (!clickObject(profile, "Profile"))
				return false;
			Thread.sleep(5000);
			WebElement upload = driver.findElement(By.xpath("//*[@id=\"button-1041\"]"));
			if (!clickObject(upload, "Upload"))
				return false;
			Thread.sleep(3000);

			WebElement photoFrame = driver.findElement(By.xpath("//*[@class=\"x-form-file-input\"]"));
			if (photoFrame == null)
				return false;

			photoFrame.sendKeys("C:\\Users\\theph\\Downloads\\flower.jpg");
			Thread.sleep(3000);

			WebElement savePhoto = driver
					.findElement(By.xpath("//*[@class=\"x-btn-button\"]/span[text() = \"Upload\"]"));
			if (!clickObject(savePhoto, "Upload Photo"))
				return false;
			if (!savePhoto.isDisplayed()) {
				DriverFileXero.logger.log(Status.INFO,"Fail: Uploaded Photo is not displayed");
				return false;
			} else
				DriverFileXero.logger.log(Status.INFO,"Pass: Uploaded Photo is displayed");

			Thread.sleep(2000);
			return true;
		} catch (Exception ex) {
			DriverFileXero.logger.log(Status.INFO,ex.toString());
			return false;
		} finally {
			exitBrowser();
		}

	}

	public boolean NavigateToTestId08_A(String BrowserName, String url, String username, String password) throws InterruptedException {
		try {
			if (!launchbrowser(BrowserName, url))
				return false;
			Thread.sleep(2000);

			if (!LoginToXero(username, password))
				return false;
			Thread.sleep(2000);
			ModulesXero.AddAnOrganisation();
			Thread.sleep(2000);
		WebElement startTrial = driver.findElement(By.xpath(".//*[@id='simplebutton-1035']"));
		if (!clickObject(startTrial, "Start Trial")) {
			return false;
		}

		return true;
	}
		finally {
			exitBrowser();
		}
	}

	

	public static boolean NavigateToTestId08_B(String BrowserName, String url, String username, String password) throws InterruptedException {
		try {
			if (!launchbrowser(BrowserName, url))
				return false;
			Thread.sleep(2000);

			if (!LoginToXero(username, password))
				return false;
		AddAnOrganisation();
		clickBuyNow();
		
		return true;
		}
			finally {
				exitBrowser();
			}
	}

	public static boolean NavigateToTestId08_C(String BrowserName, String url, String username, String password) throws InterruptedException {
	
		try {
			if (!launchbrowser(BrowserName, url))
				return false;
			Thread.sleep(2000);

			if (!LoginToXero(username, password))
				return false;
			AddAnOrganisation();
			
			ModulesXero.clickBuyNow();

			WebElement starterPlan = driver.findElement(By.xpath(".//*[@id='PRODUCTOPTION/ORG/SOLO']/div[1]/label"));
			if (!clickObject(starterPlan, "Starter Plan")) return false;
				Thread.sleep(2000);

				testData();

				return true;	
			}	
		 finally {
		exitBrowser();
	}
	}

		public static boolean NavigateToTestId08_D(String BrowserName, String url, String username, String password) throws InterruptedException {
	
		try {
			if (!launchbrowser(BrowserName, url))
				return false;
			Thread.sleep(2000);

			if (!LoginToXero(username, password))
				return false;
			AddAnOrganisation();
			clickBuyNow();

			WebElement standardPlan = driver
					.findElement(By.xpath(".//*[@id='PRODUCTOPTION/ORG/STANDARD']/div[1]/label"));
			if (clickObject(standardPlan, " Standard Plan")) {
				Thread.sleep(2000);

				testData();

			}
			return true;
		}
			finally {
		exitBrowser();
	}
	}
	

	public static boolean NavigateToTestId08_E(String BrowserName, String url, String username, String password) throws InterruptedException {
		String status = "fail";
		try {
			launchbrowser(BrowserName, url);

			Thread.sleep(1000);

			LoginPage(username, password);
			Thread.sleep(4000);
			AddAnOrganisation();
			clickBuyNow();

			WebElement premium = driver.findElement(By.xpath(".//*[@id='PRODUCTOPTION/ORG/PRO']/div[1]/label"));
			if (clickObject(premium, "Premium")) {

				Thread.sleep(2000);

				testData();
				return false;

			}
			return true;	
	} finally {
		exitBrowser();
	}
	}
	
	public static  boolean NavigateToTestId08_F(String BrowserName, String url, String username, String password) throws InterruptedException{
		
		try {
			launchbrowser(BrowserName, url);

			Thread.sleep(1000);

			LoginPage(username, password);
			Thread.sleep(4000);
			AddAnOrganisation();
			
			WebElement convertData = driver.findElement(By.xpath(".//*[@id='conversionLink']"));
			if(!clickObject(convertData," Convert Data")) return false;
				Thread.sleep(2000);
				
				WebElement checkbox = driver.findElement(By.xpath(".//*[@id='conversionCheckbox-inputEl']"));
				if(!selectCheckBox(checkbox,"Want to convert Data")) return false;
					
					Thread.sleep(2000);
					
					ModulesXero.clickBuyNow();
					
					Thread.sleep(4000);
					WebElement text = driver.findElement(By.xpath(".//*[@id='tbtext-1045']"));
					String actualText = text.getText();
					if(!actualText.contains("QuickBooks file conversion")){
					DriverFileXero.logger.log(Status.INFO,actualText+ " text is verified");
					return false;
					}
					else
						DriverFileXero.logger.log(Status.INFO,"text is not verified");
							
		return true;
	} finally {
		exitBrowser();
	}
	}

	

	public static boolean NavigateToTestId10_A(String BrowserName, String url, String username, String password)
			throws InterruptedException {
		try {
			if (!launchbrowser(BrowserName, url))
				return false;
			Thread.sleep(2000);

			if (!LoginToXero(username, password))
				return false;

			String DashboardPage = driver.getTitle();
			String expected = "Dashboard";
			if (!DashboardPage.contains(expected)) {
				DriverFileXero.logger.log(Status.INFO,"Fail:" + DashboardPage + " is not same as expected result " + expected);
				return false;
			} else
				DriverFileXero.logger.log(Status.INFO,"Pass:" + DashboardPage + " is  same as expected result " + expected);

			WebElement Account = driver.findElement(By.xpath("//*[@id=\"Accounts\"]"));
			if (!clickObject(Account, "Accounts"))
				return false;
			Thread.sleep(3000);

			WebElement purchases = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[1]/ul/li[2]/ul/li[3]/a"));
			if (!clickObject(purchases, "Purchases"))
				Thread.sleep(2000);
			DriverFileXero.logger.log(Status.INFO,"purchases here");

			String PurchasesPage = driver.getTitle();
			String exp = "Purchases";
			if (!PurchasesPage.contains(exp)) {
				DriverFileXero.logger.log(Status.INFO,"Fail:" + PurchasesPage + " is not same as expected result " + exp);
				return false;
			} else
				DriverFileXero.logger.log(Status.INFO,"Pass:" + PurchasesPage + " is  same as expected result " + exp);

			return true;
		} finally {
			exitBrowser();

		}
	}

	
	}

