package Assignment_6;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_AddUser extends BaseClass {
	
	@Test
	public void addUser() throws InterruptedException {
		driver.findElement(By.xpath("//input[contains(@name,'name')]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement addButton=driver.findElement(By.xpath("//button[text()=' Add ']"));
		Assert.assertEquals(addButton.isEnabled(), true);
		addButton.click();
		Thread.sleep(3000);
		WebElement user_role=driver.findElement(By.xpath("//*[text()='User Role']//parent::div//following-sibling::div//div[contains(text(),'Select')][@tabindex='0']"));
		/*Select s=new Select(user_role);
		s.selectByVisibleText("Admin");*/
		user_role.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option']//span[text()='Admin']")));
		e1.click();
		WebElement status=driver.findElement(By.xpath("//label[text()='Status']//parent::div//following-sibling::div//div[contains(text(),'Select')]"));
		/*Select s1=new Select(status);
		s1.selectByVisibleText("Enabled");*/
		status.click();
		WebElement e2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option']//span[text()='Enabled']")));
		e2.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p user-password-hint']//preceding::input[@type='password']")).sendKeys("A@dmin123");
		driver.findElement(By.xpath("//input[contains(@placeholder,'hints')]")).sendKeys("PT_user 78");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//span[contains(text(),'PT')]")).click();
		driver.findElement(By.xpath("//*[text()='Username']//parent::div//following-sibling::div//input")).sendKeys("admin5");
		driver.findElement(By.xpath("//label[text()='Confirm Password']//following::input[@type='password']")).sendKeys("A@dmin123");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@type='submit']")).submit();
		List<WebElement>empDetails=driver.findElements(By.xpath("//*[@role='cell']"));
		boolean empAdded=false;
		for(WebElement i:empDetails) {
			if(i.getText().equals("admin5")) {
				empAdded=true;
				break;
			}
		}
		Assert.assertEquals(empAdded, true);
	}
	

}
