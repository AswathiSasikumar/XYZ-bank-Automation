# XYZ-bank-Automation

Website selected for Automation is banking site- https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
Automation tool:Selenium

The site has 2 logins -Customer Login and Branch Manager Login

Branch Manager can do the following actions:
* Add customer
* Open Account
* Search customer

<p>When a Branch Manager creates a customer Id using Add Customer option the customer gets login access.Only when the Branch Manager
opens account for the particular customer,the customer can transact in his account.</p>

<p>Branch manager can search for a customer and delete the customer after verifying the customer details displayed.Once deleted the 
customer looses login access.</p>

A customer with login access can do the following actions:
* Deposit
* Withdraw
* View transactions of a particular day

A major shortfall i reckon which the site has is the branch manager can delete a customer even when there is balance in the account.
