package com.planittesting.xyzbank.model.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
      
    }
    
    public BasePage clickCustomerLoginButton(){    
        /*Customer login button and Bank Manager button had the same class so couldnt use css selector 
        or by classname*/

         driver.findElement(By.xpath("//*[text()='Customer Login']")).click();
         return this;
    }
    public BasePage clickBankManagerLoginButton(){    
         driver.findElement(By.xpath("//*[text()='Bank Manager Login']")).click();
         return this;
    }

	public BasePage selectYourName(String text) {

        new Select(driver.findElement(By.id("userSelect"))).selectByVisibleText(text);
        return this;
          
    }
    public BasePage clickOnLogin(){

        driver.findElement(By.cssSelector("button.btn-default")).click();
        return this;
    }

    public BasePage clickOnDeposit(){

        driver.findElement(By.xpath("//*[contains(text(),'Deposit')]")).click();
        return this;
    }

	public BasePage setAmountToDeposit(float amount) {
        driver.findElement(By.cssSelector(".form-control")).sendKeys(Float.toString(amount));
        return this;
	}

	public BasePage clickToDeposit() {
        driver.findElement(By.cssSelector("button.btn-default")).click();
        return this;
	}

	public String getBalanceBeforeDeposit() {
        String amt= driver.findElement(By.xpath("//*[@class='center']/strong[2]")).getText();
        System.out.print("balance before :  "+amt);
        return amt;
	
	}

	public String getBalanceAfterDeposit() {
		String amt= driver.findElement(By.xpath("//*[@class='center']/strong[2]")).getText();
        System.out.print("Balance after"+amt);
        return amt;
    }

	public BasePage selectAccountNo(String i) {
        new Select(driver.findElement(By.id("accountSelect"))).selectByVisibleText(i);
        return this;
	}

	public BasePage clickOnWithdraw() {
        driver.findElement(By.xpath("//*[contains(text(),'Withdrawl')]")).click();
        return this;
	}

	public BasePage setAmountToWithdraw(float amt) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label [contains(text(),'Withdrawn')]")));
        driver.findElement(By.cssSelector(".form-control")).sendKeys(Float.toString(amt));
        return this;
	}
    
    public BasePage clickToWithdraw(){
        driver.findElement(By.cssSelector("button.btn-default")).click();
        return this;
    }

	public String getTransactionSuccessMsg() {
		return driver.findElement(By.cssSelector(".ng-scope>.ng-binding")).getText();
	}

  
    }