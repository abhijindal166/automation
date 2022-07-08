package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitHelper {

	WebDriver driver;
	 public waitHelper(WebDriver driver) {
		 this.driver=driver;
	 }
	 
	 public void waitforelement(WebElement element, long timeinsec) {
		 WebDriverWait wait= new WebDriverWait(driver , timeinsec);
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
}
