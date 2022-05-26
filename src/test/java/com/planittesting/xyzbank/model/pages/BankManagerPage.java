package com.planittesting.xyzbank.model.pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BankManagerPage {
    protected WebDriver driver;

    public BankManagerPage(final WebDriver driver) {
        this.driver = driver;
      
    }

    public BankManagerPage clickOnManagerLogin(){    
        driver.findElement(By.xpath("//*[text()='Bank Manager Login']")).click();
        return this;
   }

	public BankManagerPage clickOnAddCustomer() {
        driver.findElement(By.xpath("//*[contains(text(),'Add Customer')]")).click();
        return this;
	}

	public BankManagerPage setFirstName(String fname) {
        driver.findElement(By.cssSelector("input[ng-model='fName']")).sendKeys(fname);
		return this;
    }
    public BankManagerPage setLastName(String lname) {
        driver.findElement(By.cssSelector("input[ng-model='lName']")).sendKeys(lname);
		return this;
    }
    public BankManagerPage setPostCode(String postcode) {
        driver.findElement(By.cssSelector("input[ng-model='postCd']")).sendKeys(postcode);
		return this;
    }
    public BankManagerPage clickOnAddCustomerButton() {
        driver.findElement(By.cssSelector(".btn-default")).click();
		return this;
	}

	public String getPopMessage() {
        String successMsg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return successMsg.split(":")[0].trim();
	}
    
    public BankManagerPage clickOnCustomers() {
        driver.findElement(By.xpath("//*[contains(text(),'Customers')]")).click();
        return this;
	}

	public BankManagerPage setCharacterInSearch( String search) {
        driver.findElement(By.cssSelector("input.form-control")).sendKeys(search);
        return this;
	}

	public String checkResult(String searchKey) {

        List<String> myID = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("td.ng-binding"))).stream().map(element->element.getText()).collect(Collectors.toList());
        System.out.println(myID);
        for(int i=0;i<myID.size();i++)
        {
            if(myID.get(i).contains(searchKey))
            {
                return searchKey;
            }
            
        }
        return null;
       
        
	}

	public BankManagerPage setCustomerName(String custName) {
        new Select(driver.findElement(By.cssSelector("#userSelect"))).selectByVisibleText(custName);
        return this;
    }
    public BankManagerPage setCurrency(String currency) {
        new Select(driver.findElement(By.cssSelector("#currency"))).selectByVisibleText(currency);
        return this;
	}

	public BankManagerPage clickOnAddAccount() {
        driver.findElement(By.xpath("//*[contains(text(),'Open Account')]")).click();
        return this;
	}

	public BankManagerPage clickOnProcess() {
       // WebElement element =driver.findElement(By.cssSelector("div.marTop"));
       // driver.findElement(with(By.tagName("button")).below(element)).click();
        driver.findElement(By.xpath("//*[contains(text(),'Process')]")).click();
        return this;
	}

   

}