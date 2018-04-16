package xeroTestCases;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DriverFileXero extends ModulesXero {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InterruptedException,
			IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String path = "C:/Users/theph/eclipse-workspace/XeroSeleniumTest/TestScriptsXero.xls";

		String[][] recData = readDataFromXl(path, "Sheet1");
		extent = ModulesXero
				.startReport("C:/Users/theph/eclipse-workspace/XeroSeleniumTest/ExtentReports/NewReport.html");

		String firefoxStatus, ChromeStatus, ieStatus;

		for (int i = 1; i < recData.length; i++) {
			if (recData[i][1].equalsIgnoreCase("Y")) {
 
				firefoxStatus = recData[i][2];
				ChromeStatus = recData[i][4];
				ieStatus = recData[i][6];
				String username = recData[i][8];
				String password = recData[i][9];
				String url = recData[i][10];

				if (firefoxStatus.equalsIgnoreCase("Y")) {
					String tc = recData[i][0];

					try {
						logger = createTestReport(tc, extent);
						Method testcase = AutomationTestScriptsXero.class.getMethod(tc, String.class, String.class,
								String.class, String.class);

						if ((Boolean) testcase.invoke(new AutomationTestScriptsXero(), "Firefox", url, username,
								password)) {
							ModulesXero.writeDataToXl(path, "Sheet1", i, 3, "pass");
							ModulesXero.fillBackgroundColor(path, "Sheet1", i, 3, "pass");
						} else {
							System.out.println("you are in else");
							ModulesXero.writeDataToXl(path, "Sheet1", i, 3, "fail");
							ModulesXero.fillBackgroundColor(path, "Sheet1", i, 3, "fail");
						}
					} catch (Exception ex) {
						System.out.println(ex.toString());
						ex.printStackTrace();
						ModulesXero.writeDataToXl(path, "Sheet1", i, 3, "Exception: " + ex.toString());
						ModulesXero.fillBackgroundColor(path, "Sheet1", i, 3, "fail");
					}
				}
				endReport(extent);
				extent.flush();

				if (ChromeStatus.equalsIgnoreCase("Y")) {
					String tc = recData[i][0];

					Method testcase = AutomationTestScriptsXero.class.getMethod(tc, String.class, String.class,
							String.class, String.class);
					try {
						if ((Boolean) testcase.invoke(new AutomationTestScriptsXero(), "Chrome", url, username,
								password)) {
							ModulesXero.writeDataToXl(path, "Sheet1", i, 5, "pass");
							ModulesXero.fillBackgroundColor(path, "Sheet1", i, 5, "pass");
						} else {
							System.out.println("you are in else");
							ModulesXero.writeDataToXl(path, "Sheet1", i, 5, "fail");
							ModulesXero.fillBackgroundColor(path, "Sheet1", i, 5, "fail");
						}
					} catch (Exception ex) {
						System.out.println(ex.toString());
						ModulesXero.writeDataToXl(path, "Sheet1", i, 5, "Exception: " + ex.toString());
						ModulesXero.fillBackgroundColor(path, "Sheet1", i, 5, "fail");
					}
				}
			}
		}

	}

}
