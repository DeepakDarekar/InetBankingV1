package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Identify the Elements

	@FindBy(name = "uid")
	WebElement txtUserName;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	WebElement btnLogin;

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[10]")
	//@FindBy(partialLinkText = "Log")
	WebElement lnkLogout;

	// For this Elements we have to Write Action Methods

	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickSubmit() {
		btnLogin.click();
	}

	public void clickLogout() {
		lnkLogout.click();
	}
}
