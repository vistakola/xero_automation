package salesforceTestCases.SeleniumFinal;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InitialDriver extends Modules {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InterruptedException,
			IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String path = "C:/Users/theph/eclipse-workspace/SeleniumFinal/TestSuite.xls";

		String[][] recData = readDataFromXl(path, "Sheet1");
		String firefoxStatus, ChromeStatus, ieStatus;

		for (int i = 1; i < recData.length; i++) {
			if (recData[i][1].equalsIgnoreCase("Y")) {
				firefoxStatus = recData[i][2];
				ChromeStatus = recData[i][4];
				ieStatus = recData[i][6];
				////Modules.extentReport();
				if (firefoxStatus.equalsIgnoreCase("Y")) {
					String tc = recData[i][0];

					Method testcase = AutomationTestScripts.class.getMethod(tc, String.class);
					try {
						if ((Boolean) testcase.invoke(new AutomationTestScripts(), "Firefox")) {
							Modules.writeDataToXl(path, "Sheet1", i, 3, "pass");
							Modules.fillBackgroundColor(path, "Sheet1", i, 3, "pass");
						} else {
							System.out.println("you are in else");
							Modules.writeDataToXl(path, "Sheet1", i, 3, "fail");
							Modules.fillBackgroundColor(path, "Sheet1", i, 3, "fail");
						}
					}
					catch (Exception ex) {
						System.out.println(ex.toString());
						Modules.writeDataToXl(path, "Sheet1", i, 3, "Exception: " + ex.toString());
						Modules.fillBackgroundColor(path, "Sheet1", i, 3, "fail");
					}
				}
				if (ChromeStatus.equalsIgnoreCase("Y")) {
					String tc = recData[i][0];

					Method testcase = AutomationTestScripts.class.getMethod(tc, String.class);
					try {
						if ((Boolean) testcase.invoke(new AutomationTestScripts(), "Chrome")) {
							Modules.writeDataToXl(path, "Sheet1", i, 5, "pass");
							Modules.fillBackgroundColor(path, "Sheet1", i, 5, "pass");
						} else {
							System.out.println("you are in else");
							Modules.writeDataToXl(path, "Sheet1", i, 5, "fail");
							Modules.fillBackgroundColor(path, "Sheet1", i, 5, "fail");
						}
					}
					catch (Exception ex) {
						Modules.writeDataToXl(path, "Sheet1", i, 5, "Exception: " + ex.toString());
						Modules.fillBackgroundColor(path, "Sheet1", i, 5, "fail");
					}
				}
			}
		}
	
	}
	
	
}
