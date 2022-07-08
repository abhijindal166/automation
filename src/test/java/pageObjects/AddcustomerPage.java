package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.waitHelper;

public class AddcustomerPage {

	public WebDriver ldriver;
	public waitHelper waithelper;
	public AddcustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper= new waitHelper(ldriver);
	}
	
	By lnkCustomers_menu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By lnkCustomers_menuitem=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a");
	
	By btnAddnew=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a"); //Add new
		
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	
	By txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	
	By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
	By rdMaleGender=By.id("Gender_Male");
	By rdFeMaleGender=By.id("Gender_Female");
	
	By txtFirstName=By.xpath("//input[@id='FirstName']");
	By txtLastName=By.xpath("//input[@id='LastName']");
	
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName=By.xpath("//input[@id='Company']");
		
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave=By.xpath("//button[@name='save']");
	By logoutbtn=By.xpath("//*[@id=\"navbarText\"]/ul/li[3]/a");
	By text=By.xpath("/html/body/div[3]/div[1]/div[1]");
	//Actions Methods
			
	public String getPageTitle()
	{
		return ldriver.getTitle(); 
	}
	
	public void clickOnCustomersMenu() {
	WebElement cust=	ldriver.findElement(lnkCustomers_menu);
		waithelper.waitforelement(cust, 30);
		
		ldriver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	
	public void setCustomerRoles(String role) throws InterruptedException 
		{
//			if(!role.equals("Vendors")) //If role is vendors should not delete Register as per req.
//			{
//			ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
//			}
			
			ldriver.findElement(txtcustomerRoles).click();
						
			WebElement listitem;
			
			Thread.sleep(3000);
						
			if(role.equals("Administrators"))
			{
				listitem=ldriver.findElement(lstitemAdministrators); 
			}
			else if(role.equals("Guests"))
			{
				listitem=ldriver.findElement(lstitemGuests);
			}
			else if(role.equals("Registered"))
			{
				listitem=ldriver.findElement(lstitemRegistered);
			}
			else if(role.equals("Vendor"))
			{
				listitem=ldriver.findElement(lstitemVendors);
			}
			else
			{
				listitem=ldriver.findElement(lstitemGuests);
			}
						
			//listitem.click();
			//Thread.sleep(3000);
			
			JavascriptExecutor js = (JavascriptExecutor)ldriver;
			js.executeScript("arguments[0].click();", listitem);
			
	}

	public void setManagerOfVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else
		{
			ldriver.findElement(rdFeMaleGender).click();
		}
		
		
	}
	
	public void setFirstName(String fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setDob(String dob)
	{
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyName(String comname)
	{
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}
	
	public void setAdminContent(String content)
	{
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}
	
	public void clickOnSave()
	{
		ldriver.findElement(btnSave).click();
		
	}
	public boolean check(String t)
	{WebElement te=	ldriver.findElement(lnkCustomers_menu);
		waithelper.waitforelement(te, 30);
		return ldriver.findElement(text).getText().contains(t);
		
	}
	public void clickOnLogout()
	{
		ldriver.findElement(logoutbtn).click();
		
	}
	
}
