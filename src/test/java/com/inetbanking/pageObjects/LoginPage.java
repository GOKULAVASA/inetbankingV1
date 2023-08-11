package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


public WebDriver driver;


public LoginPage(WebDriver d){
	driver=d;
	PageFactory.initElements(d,this);
}




@FindBy(name="uid")
WebElement txtUserName;
	
@FindBy(name="password")
WebElement txtPassword;


@FindBy(name="btnLogin")
WebElement btnLogin;


public void setUserName(String name)
{
	txtUserName.sendKeys(name);
}


public void setUserPassword(String pass)
{
	txtPassword.sendKeys(pass);
}



public void Clicksubmit()
{
	btnLogin.click();
}





}

