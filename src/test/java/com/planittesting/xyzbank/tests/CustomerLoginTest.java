package com.planittesting.xyzbank.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.planittesting.xyzbank.model.pages.BasePage;

import org.junit.jupiter.api.Test;

public class CustomerLoginTest extends BaseTestSuite{
    
    @Test
    public void verifyCustomerDeposit()
    {
        var basePage= new BasePage(driver)
         .clickCustomerLoginButton()
         .selectYourName("Albus Dumbledore")
         .clickOnLogin()
         .selectAccountNo("1010");

         String balancebeforedep = basePage.getBalanceBeforeDeposit();

         basePage
         .clickOnDeposit()
         .setAmountToDeposit(1000)
         .clickToDeposit();
         
        assertEquals(Float.parseFloat(balancebeforedep) + 1000, Float.parseFloat(basePage.getBalanceAfterDeposit()));
        assertEquals("Deposit Successful", basePage.getTransactionSuccessMsg());

    }
    
    @Test
    public void verifyCustomerWithdrawal()
    {
        var basePage= new BasePage(driver)
         .clickCustomerLoginButton()
         .selectYourName("Neville Longbottom")
         .clickOnLogin()
         .selectAccountNo("1013");


         basePage
         .clickOnDeposit()
         .setAmountToDeposit(2000)
         .clickToDeposit()
         .clickOnWithdraw()
         .setAmountToWithdraw(1000)
         .clickToWithdraw();
         
    
         assertEquals(1000, Float.parseFloat(basePage.getBalanceAfterDeposit()));
         assertEquals("Transaction successful",basePage.getTransactionSuccessMsg());
        
    }

   
}