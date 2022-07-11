Feature: Login 

@sanity
Scenario: Successful Login with Valid Credentials 
	Given User Launch Chrome browser 
	When User opens URL "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com" and Password as "admin" 
	And Click on Login 
	Then Page Title should be "Dashboard / nopCommerce administration" 
	When User click on Log out link 
	Then Page Title should be "Your store. Login" 
	And close browser
	
	WebDriverWait w=new WebDriverWait(ldriver, 0);
        try{
        w.until(ExpectedConditions.alertIsPresent());
        Alert alrt=ldriver.switchTo().alert();
        
        } 
      catch(Exception e)
        {
                  System.out.println("Alert is not present");
        }}
