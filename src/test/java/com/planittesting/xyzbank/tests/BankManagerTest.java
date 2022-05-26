package com.planittesting.xyzbank.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.planittesting.xyzbank.model.pages.BankManagerPage;

import org.junit.jupiter.api.Test;


public class BankManagerTest extends BaseTestSuite {
    
    @Test
    public void searchCustomer()
    {
         var managerPage = new BankManagerPage(driver)
         .clickOnManagerLogin()
         .clickOnCustomers()
         .setCharacterInSearch("a");


         assertEquals("a",managerPage.checkResult("a"));
    }
    
    @Test
    public void verifyOpenAccountforNewCustomer() throws InterruptedException
    {   
        //Verify if new customer id is created
        var managerPage = new BankManagerPage(driver)
            .clickOnManagerLogin()
            .clickOnAddCustomer()
            .setFirstName("Matthew")
            .setLastName("Tim")
            .setPostCode("2067")
            .clickOnAddCustomerButton();

        assertEquals("Customer added successfully with customer id", managerPage.getPopMessage());
 
        //Verify if account is created for the customer id created above.

          managerPage.clickOnAddAccount()
          .setCustomerName("Matthew Tim")
          .setCurrency("Dollar")
          .clickOnProcess();
                
        assertEquals("Account created successfully with account Number", managerPage.getPopMessage());
    }
        // @Test
    // public void verifyAddcustomer()
    // {
    //     var managerPage = new BankManagerPage(driver)
    //         .clickOnManagerLogin()
    //         .clickOnAddCustomer()
    //         .setFirstName("Matthew")
    //         .setLastName("Tim")
    //         .setPostCode("2067")
    //         .clickOnAddCustomerButton();

    //     assertEquals("Customer added successfully with customer id", managerPage.getPopMessage());
    // }
}