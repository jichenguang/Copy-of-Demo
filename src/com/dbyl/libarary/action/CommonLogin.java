package com.dbyl.libarary.action;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.dbyl.libarary.pageAction.HomePage;
import com.dbyl.libarary.pageAction.LoginPage;
import com.dbyl.libarary.utils.PageFactory;

public class CommonLogin {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	static LoginPage loginPage;

	public static HomePage login(String email, String password)
			throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.waitForPageLoad();
		loginPage.typeEmailInputBox(email);
		loginPage.typePasswordInputBox(password);
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.isPrestentProfile(), "login failed");

		return (HomePage) PageFactory.getPage(HomePage.class, getDriver());
	}
/**
 * @author 700sfriend
 * 返回一个HomePage类型
 * @return
 * @throws Exception
 */
	public static HomePage login() throws Exception {
//		在本类调用本类方法，可以专注于传参数
		return CommonLogin.login("13282774643", "appium123");
	}
/**
 * @author 700sfriend
 *  传递driver
 * @param driver
 */
	public static void setDriver(WebDriver driver) {
		CommonLogin.driver = driver;
	}

}
