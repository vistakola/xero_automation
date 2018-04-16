package salesforceTestCases.SeleniumFinal;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomationTestScripts extends Modules {

	static boolean status;

	public static boolean LoginErrorMessage_TC01_K(String BrowserName) throws InterruptedException {
		boolean status = false;
		Modules.launchbrowser(BrowserName);
		Thread.sleep(5000);

		WebElement un = driver.findElement(By.id("username"));
		if (enterText(un, "user@gmail.com", "username")) {

			Thread.sleep(1000);

			WebElement pwd = driver.findElement(By.id("password"));
			if (Clear(pwd, "password")) {

				Thread.sleep(1000);

				WebElement login = driver.findElement(By.id("Login"));
				if (clickObject(login, "Login")) {

					Thread.sleep(3000);

					WebElement error = driver.findElement(By.xpath(".//*[@id='error']"));
					String expect = "Please enter password.";
					if (validateTextBoxContent(error, expect, "Error")) {
						status = true;
						exitBrowser();

					}
				}
			}
		}
		return status;
	}

	public static boolean LoginErrorMessage_TC01(String BrowserName) throws InterruptedException {
		Modules.launchbrowser(BrowserName);

		try {	
			WebElement un = driver.findElement(By.id("username"));
			if (!enterText(un, "user@gmail.com", "username")) return false;
			Thread.sleep(1000);

			WebElement pwd = driver.findElement(By.id("password"));
			if (!Clear(pwd, "password")) return false;
			Thread.sleep(1000);

			WebElement login = driver.findElement(By.id("Login"));
			if (!clickObject(login, "Login")) return false;
			Thread.sleep(3000);

			WebElement error = driver.findElement(By.xpath(".//*[@id='error']"));
			String expect = "Please enter password.";
			if (!validateTextBoxContent(error, expect, "Error")) return false;
			System.out.println("tc01 is completed");

			return true;
		}
		finally {
			
			System.out.println("tc01 is close");
			exitBrowser();
		}
	}
	
	public static boolean LoginToSalesForce_TC02(String BrowserName) throws InterruptedException {
		status = false;
		Modules.launchbrowser(BrowserName);

		WebElement un = driver.findElement(By.id("username"));
		if (enterText(un, "visishta@kiran.co", "username")) {
			String actual_msg = un.getAttribute("value");
			Thread.sleep(1000);
			WebElement pwd = driver.findElement(By.id("password"));
			if (enterText(pwd, "asdfgh123", "password")) {

				WebElement login = driver.findElement(By.id("Login"));
				if (clickObject(login, "Login")) {
					status = true;
				}
				Thread.sleep(1000);
				exitBrowser();
			}
		}
		return status;

	}

	public static boolean CheckRemeberMe_TC03(String BrowserName) throws InterruptedException {
		status = false;
		Modules.launchbrowser(BrowserName);

		Thread.sleep(1000);

		WebElement un = driver.findElement(By.id("username"));
		if (enterText(un, "visishta@kiran.co", "username")) {

			Thread.sleep(1000);

			WebElement pwd = driver.findElement(By.id("password"));
			if (enterText(pwd, "asdfgh123", "password")) {

				Thread.sleep(1000);

				WebElement check = driver.findElement(By.id("rememberUn"));
				if (selectCheckBox(check, "rememberUn")) {

					Thread.sleep(1000);

					WebElement loginButton = driver.findElement(By.id("Login"));
					if (clickObject(loginButton, "Login")) {

						Thread.sleep(5000);

						WebElement selectMenu = driver.findElement(By.xpath(" .//*[@id='userNavButton']"));
						if (clickObject(selectMenu, " menu bar")) {

							Thread.sleep(5000);

							WebElement selectMenu1 = driver
									.findElement(By.xpath(" .//*[@id='userNav-menuItems']/a[5]"));
							if (clickObject(selectMenu1, " logout ")) {

								Thread.sleep(10000);

								WebElement msg = driver.findElement(By.xpath(
										"html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/div[1]/div/div/div/span"));

								String expect = driver.findElement(By.xpath(
										"html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/div[1]/div/div/div/span"))
										.getText();

								if (validateTextBoxContent(msg, expect, "username")) {
									status = true;
								}
							}
						}
					}
				}
			}
		}

		driver.close();
		return status;

	}

	public static boolean ForgotPassword_TC4B(String BrowserName) throws InterruptedException {
		status = false;
		Modules.launchbrowser(BrowserName);

		Thread.sleep(2000);

		WebElement un = driver.findElement(By.id("username"));
		if (enterText(un, "123", "username")) {

			Thread.sleep(1000);

			WebElement pwd = driver.findElement(By.id("password"));
			if (enterText(pwd, "123456", "password")) {

				WebElement loginButton = driver.findElement(By.id("Login"));
				if (clickObject(loginButton, "Login")) {

					WebElement error = driver.findElement(By.xpath(".//*[@id='error']"));
					String expect = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";

					if (validateTextBoxContent(error, expect, "error")) {
						status = true;
					}
				}
			}
		}
		Thread.sleep(10000);

		driver.close();
		return status;

	}

	public static boolean ForgotPassword_TC4A(String BrowserName) throws InterruptedException {
		status = false;
		Modules.launchbrowser(BrowserName);

		Thread.sleep(2000);

		WebElement pwd = driver.findElement(By.xpath(".//*[@id='forgot_password_link']"));
		if (clickObject(pwd, "forgot password")) {

			Thread.sleep(2000);

			WebElement un = driver.findElement(By.xpath(".//*[@id='un']"));
			if (enterText(un, "visishta@kiran.co", ".//*[@id='un']")) {

				Thread.sleep(2000);

				WebElement con = driver.findElement(By.xpath(".//*[@id='continue']"));
				if (clickObject(con, "continue")) {

					Thread.sleep(2000);

					WebElement error = driver.findElement(By.xpath(".//*[@id='forgotPassForm']/div/p[1]"));
					String expect = "We’ve sent you an email with a link to finish resetting your password.";

					if (validateTextBoxContent(error, expect, "error")) {
						status = true;
					}
				}
			}
		}
		Thread.sleep(2000);

		driver.close();

		return status;

	}

	public static boolean TC05(String BrowserName) throws InterruptedException {
		status = false;
		Modules.launchbrowser(BrowserName);

		Thread.sleep(1000);

		WebElement un = driver.findElement(By.id("username"));
		if (enterText(un, "visishta@kiran.co", "username")) {

			Thread.sleep(1000);

			WebElement pwd = driver.findElement(By.id("password"));
			if (enterText(pwd, "asdfgh123", "password")) {

				Thread.sleep(1000);

				WebElement loginButton = driver.findElement(By.id("Login"));
				if (clickObject(loginButton, "Login")) {

					Thread.sleep(5000);

					WebElement selectMenu = driver.findElement(By.xpath(" .//*[@id='userNavButton']"));
					if (clickObject(selectMenu, " menu bar")) {

						WebElement display1 = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[1]"));
						String expect = "My Profile";
						if (validateTextBoxContent(display1, expect, "error")) {

							WebElement display2 = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[2]"));
							String expect2 = "My Settings";
							if (validateTextBoxContent(display2, expect2, "error")) {

								WebElement display3 = driver
										.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]"));
								String expect3 = "Developer Console";
								if (validateTextBoxContent(display3, expect3, "error")) {

									WebElement display4 = driver
											.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[4]"));
									String expect4 = "Switch to Lightning Experience";
									if (validateTextBoxContent(display4, expect4, "error")) {

										WebElement display5 = driver
												.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[5]"));
										String expect5 = "Logout";
										if (validateTextBoxContent(display5, expect5, "error")) {
											status = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		driver.close();
		return status;
	}

	public static boolean TC06(String BrowserName) throws InterruptedException {
		status = false;
		Modules.launchbrowser(BrowserName);

		Thread.sleep(1000);

		WebElement un = driver.findElement(By.id("username"));
		if (enterText(un, "visishta@kiran.co", "username")) {

			Thread.sleep(1000);

			WebElement pwd = driver.findElement(By.id("password"));
			if (enterText(pwd, "asdfgh123", "password")) {

				Thread.sleep(1000);

				/*
				 * WebElement loginButton = driver.findElement(By.id("Login"));
				 * clickObject(loginButton, "Login");
				 * 
				 * Thread.sleep(5000);
				 * 
				 * WebElement selectMenu =
				 * driver.findElement(By.xpath(" .//*[@id='userNavButton']"));
				 * clickObject(selectMenu, " menu bar");
				 * 
				 * WebElement display1 =
				 * driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[1]")); String
				 * expect = "My Profile"; validateTextBoxContent(display1, expect,
				 * "My Profile");
				 * 
				 * WebElement display2 =
				 * driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[2]")); String
				 * expect2 = "My Settings"; validateTextBoxContent(display2, expect2,
				 * "My Settings");
				 * 
				 * WebElement display3 =
				 * driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]")); String
				 * expect3 = "Developer Console"; validateTextBoxContent(display3, expect3,
				 * "Developer Console");
				 * 
				 * WebElement display4 =
				 * driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[4]")); String
				 * expect4 = "Switch to Lightning Experience"; validateTextBoxContent(display4,
				 * expect4, "Switch to Lightning Experience");
				 * 
				 * WebElement display5 =
				 * driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[5]")); String
				 * expect5 = "Logout"; validateTextBoxContent(display5, expect5, "Logout");
				 * 
				 * clickObject(display1, "My Profile");
				 * 
				 * WebElement edit = driver.findElement(By.xpath(
				 * ".//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img"));
				 * clickObject(edit, "Edit"); Thread.sleep(5000);
				 * 
				 * driver.switchTo().frame("contactInfoContentId");
				 * 
				 * WebElement about = driver.findElement(By.xpath(".//*[@id='aboutTab']/a"));
				 * clickObject(about, "about");
				 * 
				 * WebElement lastName = driver.findElement(By.xpath(".//*[@id='lastName']"));
				 * lastName.clear(); enterText(lastName, "atsiv", "Last Name");
				 * 
				 * WebElement saveAll = driver.findElement(By.
				 * xpath(" .//*[@id='TabPanel']/div/div[2]/form/div/input[1]"));
				 * clickObject(saveAll, " Save All Button");
				 * 
				 * driver.switchTo().defaultContent();
				 * 
				 * WebElement last =
				 * driver.findElement(By.xpath(".//*[@id='tailBreadcrumbNode']"));
				 * validateTextBoxContent(last, "visishta atsiv ", " LastName");
				 * 
				 * Thread.sleep(2000);
				 * 
				 * WebElement post =
				 * driver.findElement(By.xpath(" .//*[@id='publisherAttachTextPost']/span[1]"));
				 * clickObject(post, " post "); Thread.sleep(2000);
				 * 
				 * WebElement frame =
				 * driver.findElement(By.xpath(".//iFrame[@class='cke_wysiwyg_frame cke_reset']"
				 * )); driver.switchTo().frame(frame);
				 * 
				 * Thread.sleep(2000);
				 * 
				 * WebElement text = driver.findElement(By.xpath(".//*['html/body']"));
				 * 
				 * Thread.sleep(3000); enterText(text, "Salesforce application login page test",
				 * "textbox");
				 * 
				 * Thread.sleep(2000);
				 * 
				 * driver.switchTo().defaultContent(); WebElement share =
				 * driver.findElement(By.xpath(".//*[@id='publishersharebutton']"));
				 * 
				 * clickObject(share, "share");
				 * 
				 * driver.close();
				 */

				WebElement login = driver.findElement(By.id("Login"));
				if (clickObject(login, "Login")) {
					Thread.sleep(5000);

					WebElement menu = driver.findElement(By.xpath(".//*[@id='userNavButton']"));
					if (clickObject(menu, "menu bar")) {
						Thread.sleep(3000);

						WebElement profile = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[1]"));
						if (clickObject(profile, "My profile")) {
							Thread.sleep(5000);

							/*
							 * WebElement edit = driver.findElement(By.xpath(
							 * ".//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img"));
							 * clickObject(edit,"editButton"); Thread.sleep(5000);
							 * 
							 * driver.switchTo().frame("contactInfoContentId"); WebElement about =
							 * driver.findElement(By.xpath(".//*[@id='aboutTab']/a"));
							 * clickObject(about,"About");
							 * 
							 * WebElement lastname = driver.findElement(By.id("lastName"));
							 * lastname.clear(); enterText(lastname,"vista","Last Name");
							 * Thread.sleep(1000);
							 * 
							 * WebElement save = driver.findElement(By.xpath(
							 * ".//*[@id='TabPanel']/div/div[2]/form/div/input[1]"));
							 * clickObject(save,"SaveAll"); Thread.sleep(2000);
							 * 
							 * driver.switchTo().defaultContent();
							 * 
							 * WebElement msg =
							 * driver.findElement(By.xpath(".//*[@id='tailBreadcrumbNode']")); String
							 * expected=
							 * driver.findElement(By.xpath(".//*[@id='tailBreadcrumbNode']")).getText();
							 * validateTextBoxContent(msg,expected,"Last Name"); Thread.sleep(2000);
							 * 
							 * WebElement post =
							 * driver.findElement(By.xpath(".//*[@id='publisherAttachTextPost']/span[1]"));
							 * clickObject(post,"Post"); Thread.sleep(2000);
							 * 
							 * WebElement frame =
							 * driver.findElement(By.xpath("//iFrame[@class='cke_wysiwyg_frame cke_reset']")
							 * );
							 * 
							 * driver.switchTo().frame(frame);
							 * 
							 * WebElement write = driver.findElement(By.xpath("html/body"));
							 * Thread.sleep(2000); enterText(write,"Hello World","post");
							 * 
							 * Thread.sleep(2000);
							 * 
							 * driver.switchTo().defaultContent();
							 * 
							 * WebElement share =
							 * driver.findElement(By.xpath(".//*[@id='publishersharebutton']"));
							 * clickObject(share,"Share");
							 * 
							 * 
							 * WebElement check = driver.findElement(By.xpath(
							 * ".//*[@id='0D56A00000MMwYE']/div/div[1]/div[1]/div[2]/div[1]/span/p"));
							 * String expect = "Hello World";
							 * validateTextBoxContent(check,expect,"Last Name"); Thread.sleep(2000);
							 * 
							 * WebElement file =
							 * driver.findElement(By.xpath(".//*[@id='publisherAttachContentPost']/span[1]")
							 * ); clickObject(file,"File");
							 * 
							 * WebElement upload =
							 * driver.findElement(By.xpath(".//*[@id='chatterUploadFileAction']"));
							 * clickObject(upload,"upload"); Thread.sleep(2000);
							 */

							/*
							 * WebElement browse = driver.findElement(By.xpath(".//*[@id='chatterFile']"));
							 * 
							 * enterText(browse,"C:\\Users\\theph\\Desktop\\text.txt","browse");
							 * Thread.sleep(2000);
							 */

							WebElement Moderator = driver.findElement(By.xpath("//*[text()='Moderator']"));
							Actions action = new Actions(driver);
							action.moveToElement(Moderator).build().perform();
							Thread.sleep(2000);

							WebElement addPhoto = driver.findElement(By.xpath(".//*[@id='uploadLink']"));
							addPhoto.click();

							Thread.sleep(3000);

							WebElement photoFrame = driver.findElement(By.id("uploadPhotoContentId"));
							driver.switchTo().frame(photoFrame);

							WebElement uploadPhoto = driver
									.findElement(By.xpath(".//*[@id='j_id0:uploadFileForm:uploadInputFile']"));
							if (enterText(uploadPhoto, "C:\\Users\\KANISHKA\\Downloads\\Ava-Cake-Smash.JPG",
									"Upload File")) {
								Thread.sleep(5000);

								WebElement savePhoto = driver
										.findElement(By.xpath(".//*[@id='j_id0:uploadFileForm:save']"));
								if (clickObject(savePhoto, "Save")) {
									status = true;
								}
							}
						}
					}
				}
			}
		}
		driver.close();
		return status;

	}

	public static boolean TC07(String BrowserName) throws InterruptedException {

		Modules.launchbrowser(BrowserName);

		Thread.sleep(1000);

		WebElement un = driver.findElement(By.id("username"));
		if (enterText(un, "visishta@kiran.co", "username")) {

			Thread.sleep(1000);

			WebElement pwd = driver.findElement(By.id("password"));
			if (enterText(pwd, "asdfgh123", "password")) {

				Thread.sleep(1000);

				WebElement loginButton = driver.findElement(By.id("Login"));
				if (clickObject(loginButton, "Login")) {

					Thread.sleep(5000);

					WebElement userNav = driver.findElement(By.xpath(" .//*[@id='userNavButton']"));
					if (clickObject(userNav, " menu bar")) {

						Thread.sleep(1000);

						WebElement mySettings = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[2]"));
						if (clickObject(mySettings, "My Settings")) {

							Thread.sleep(1000);

							WebElement personal = driver.findElement(By.xpath(".//*[@id='PersonalInfo']/a"));
							if (clickObject(personal, "Personal")) {

								Thread.sleep(1000);

								WebElement loginHistory = driver.findElement(By.xpath(".//*[@id='LoginHistory_font']"));
								if (clickObject(loginHistory, "Login History")) {

									WebElement relatedUserLoginHistory = driver.findElement(
											By.xpath(".//*[@id='RelatedUserLoginHistoryList_body']/div/a"));
									if (clickObject(relatedUserLoginHistory, "Related User Login History List")) {
										// doubt abt the pop up not mentioned in xl file and also how to check if the
										// file is stored in csv format.
										status = true;
									}
								}
							}
						}
					}
				}
			}
		}
		driver.close();
		return status;
	}

	public static boolean TC08(String BrowserName) throws InterruptedException {
		status = false;
		Modules.launchbrowser(BrowserName);

		Thread.sleep(1000);

		WebElement un = driver.findElement(By.id("username"));
		if (enterText(un, "visishta@kiran.co", "username")) {

			Thread.sleep(1000);

			WebElement pwd = driver.findElement(By.id("password"));
			if (enterText(pwd, "asdfgh123", "password")) {

				Thread.sleep(1000);

				WebElement loginButton = driver.findElement(By.id("Login"));
				if (clickObject(loginButton, "Login")) {

					Thread.sleep(5000);

					WebElement selectMenu = driver.findElement(By.xpath(" .//*[@id='userNavButton']"));
					if (clickObject(selectMenu, " menu bar")) {

						Thread.sleep(1000);

						WebElement display1 = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[1]"));
						String expect = "My Profile";
						if (validateTextBoxContent(display1, expect, "My Profile")) {

							Thread.sleep(1000);

							WebElement display2 = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[2]"));
							String expect2 = "My Settings";
							if (validateTextBoxContent(display2, expect2, "My Settings")) {

								Thread.sleep(1000);

								WebElement display3 = driver
										.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]"));
								String expect3 = "Developer Console";
								if (validateTextBoxContent(display3, expect3, "Developer Console")) {

									Thread.sleep(1000);

									WebElement display4 = driver
											.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[4]"));
									String expect4 = "Switch to Lightning Experience";
									if (validateTextBoxContent(display4, expect4, "Switch to Lightning Experience")) {

										Thread.sleep(1000);

										WebElement display5 = driver
												.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[5]"));
										String expect5 = "Logout";
										if (validateTextBoxContent(display5, expect5, "Logout")) {

											Thread.sleep(1000);

											// Test if the popup has opened.
											String parentWindowHandler = driver.getWindowHandle(); // Store your parent
																									// window
											String subWindowHandler = null;

											Set<String> handles = driver.getWindowHandles(); // get all window handles
											int windowCount = handles.size();

											System.out.println("Number of windows: " + windowCount);

											if (clickObject(display3, "Developer Console")) {

												Thread.sleep(5000);

												handles = driver.getWindowHandles(); // get all window handles
												windowCount = handles.size();

												System.out.println("Number of windows: " + windowCount);

												Iterator<String> iterator = handles.iterator();
												while (iterator.hasNext()) {
													subWindowHandler = iterator.next();
												}

												driver.switchTo().window(subWindowHandler); // switch to popup window

												String title = driver.getTitle();
												System.out.println("Popup window title: " + title);
												if (title.equals("Developer Console")) {
													System.out.println(
															"Pass:  Expected text Developer Console is matching with actual text "
																	+ title);
												} else {
													System.out.println(
															"Pass:  Expected text Developer Console is not matching with actual text "
																	+ title);
												}

												driver.close();

												driver.switchTo().window(parentWindowHandler);

												handles = driver.getWindowHandles(); // get all window handles
												windowCount = handles.size();

												System.out.println("Number of windows: " + windowCount);

												if (windowCount == 1) {
													System.out.println(
															"Pass: Developer Console window is successfully closed");
												} else {
													System.out.println("Fail: Developer Console window is not closed");
												}
												status = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		Thread.sleep(2000);

		driver.close();
		return status;
	}

	public static boolean TC09(String BrowserName) throws InterruptedException {
		status = false;

		Modules.launchbrowser(BrowserName);

		Thread.sleep(1000);

		WebElement un = driver.findElement(By.id("username"));
		if (enterText(un, "visishta@kiran.co", "username")) {

			Thread.sleep(1000);

			WebElement pwd = driver.findElement(By.id("password"));
			if (enterText(pwd, "asdfgh123", "password")) {

				Thread.sleep(1000);

				WebElement loginButton = driver.findElement(By.id("Login"));
				if (clickObject(loginButton, "Login")) {

					Thread.sleep(5000);

					WebElement selectMenu = driver.findElement(By.xpath(" .//*[@id='userNavButton']"));
					if (clickObject(selectMenu, " menu bar")) {

						WebElement display1 = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[1]"));
						String expect = "My Profile";
						if (validateTextBoxContent(display1, expect, "error")) {

							WebElement display2 = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[2]"));
							String expect2 = "My Settings";
							if (validateTextBoxContent(display2, expect2, "error")) {

								WebElement display3 = driver
										.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]"));
								String expect3 = "Developer Console";
								if (validateTextBoxContent(display3, expect3, "error")) {

									WebElement display4 = driver
											.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[4]"));
									String expect4 = "Switch to Lightning Experience";
									if (validateTextBoxContent(display4, expect4, "error")) {

										WebElement display5 = driver
												.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[5]"));
										String expect5 = "Logout";
										if (validateTextBoxContent(display5, expect5, "error")) {

											WebElement selectMenu1 = driver
													.findElement(By.xpath(" .//*[@id='userNav-menuItems']/a[5]"));
											if (clickObject(selectMenu1, " logout ")) {

												Thread.sleep(3000);
												String Displayed = driver.getCurrentUrl();
												String expected = "https://login.salesforce.com/";

												if (expected.equals(Displayed)) {
													System.out.println(Displayed + " is same as " + expected);
												}
												status = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		driver.close();
		return status;

	}

	public static boolean TC10CreateAccount(String BrowserName) throws InterruptedException {

		Modules.launchbrowser(BrowserName);

		Thread.sleep(1000);

		WebElement un = driver.findElement(By.id("username"));
		if (enterText(un, "visishta@kiran.co", "username")) {

			Thread.sleep(1000);

			WebElement pwd = driver.findElement(By.id("password"));
			if (enterText(pwd, "asdfgh123", "password")) {

				Thread.sleep(1000);

				WebElement loginButton = driver.findElement(By.id("Login"));
				if (clickObject(loginButton, "Login")) {

					Thread.sleep(5000);

					// correcct username (visishta.k@gmail.com) visishta atsiv

					WebElement Account = driver.findElement(By.xpath(".//*[@id='Account_Tab']"));
					if (clickObject(Account, "Account Tab")) {

						driver.switchTo().alert().dismiss();

						WebElement newAccount = driver
								.findElement(By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input"));
						if (clickObject(newAccount, "new")) {

							WebElement accountName = driver
									.findElement(By.xpath(".//*[@id='ep']/div[2]/div[3]/table/tbody/tr[2]/td[2]/div"));
							if (enterText(accountName, "Vista's Account", "Account Name")) {
								status = true;
							}
						}
					}
				}
			}
		}
		driver.close();
		return status;
	}

	public static boolean TC11Createnewview(String BrowserName) throws InterruptedException {
		status = false;
		Modules.launchbrowser(BrowserName);

		Thread.sleep(1000);

		WebElement un = driver.findElement(By.id("username"));
		if (enterText(un, "visishta@kiran.co", "username")) {

			Thread.sleep(1000);

			WebElement pwd = driver.findElement(By.id("password"));
			if (enterText(pwd, "asdfgh123", "password")) {

				Thread.sleep(1000);

				WebElement loginButton = driver.findElement(By.id("Login"));
				if (clickObject(loginButton, "Login")) {

					Thread.sleep(5000);

					Alert alert = driver.switchTo().alert();
					// update is executed
					alert.dismiss();

					WebElement Account = driver.findElement(By.xpath(".//*[@id='Account_Tab']"));
					if (clickObject(Account, "Account Tab")) {

						WebElement createNewView = driver
								.findElement(By.xpath(".//*[@id='filter_element']/div/span/span[2]/a[2]"));
						if (clickObject(createNewView, "Create New View")) {

							WebElement viewName = driver.findElement(By
									.xpath(".//*[@id='editPage']/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/label"));
							if (enterText(viewName, "Vista's Page", "View Name")) {

								WebElement viewUniqueName = driver.findElement(By
										.id(".//*[@id='editPage']/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[1]/label"));
								if (enterText(viewUniqueName, "Unique Name", "View Unique Name")) {
									status = true;
								}
							}
						}
					}
				}
			}
		}
		return status;
	}

}
