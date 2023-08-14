package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {


	WebDriver driver;
	public AddCustomerPage(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how=How.XPATH,using="//a[contains(text(),'New Customer')]")
	WebElement NewCustomer;

	@FindBy(how=How.NAME,using="name")
	WebElement cusName;

	@FindBy(how=How.XPATH,using="//input[@value='m']")
	WebElement radiobtn;

	@FindBy(how=How.NAME,using="dob")
	WebElement dobEle;

	@FindBy(how=How.XPATH,using="//textarea[@name='addr']")
	WebElement cusAdd;

	@FindBy(how=How.NAME,using="city")
	WebElement Cityadd;

	@FindBy(how=How.NAME,using="state")
	WebElement StateAdd;

	@FindBy(how=How.NAME,using="pinno")
	WebElement pincode;

	@FindBy(how=How.NAME,using="telephoneno")
	WebElement phnum;


	@FindBy(how=How.NAME,using="emailid")
	WebElement email;


	@FindBy(how=How.NAME,using="password")
	WebElement emailPass;

	@FindBy(how=How.NAME,using="sub")
	WebElement submit;

	public void ClickNewCustomer() {
		NewCustomer.click();
	}
	public void EnterCusName(String cname) {
		cusName.sendKeys(cname);

	}

	public void ClickGenderBtn() {
		radiobtn.click();


	}


	public void dateOfBirth(String dd,String mm,String yy) {
		dobEle.sendKeys(dd);
		dobEle.sendKeys(mm);
		dobEle.sendKeys(yy);
	}
	public void EnterAddress(String address)
	{cusAdd.sendKeys(address);

	}
	
	public void EnterCity(String city)
	{Cityadd.sendKeys(city);

	}
	
	public void EnterState(String state)
	{StateAdd.sendKeys(state);

	}
	
	public void EnterPincode(int code)
	{pincode.sendKeys(String.valueOf(code));// converts int to string

	}
	
	public void EnterPHnum(int number)
	{phnum.sendKeys(String.valueOf(number));
	
	}   
	public void Enteremail(String emailid)
	{email.sendKeys(emailid);
	
	}
	
	public void Enterpassword(String pass)
	{emailPass.sendKeys(pass);
}
	public void clicksubmit()
	{submit.click();
	
}
}

