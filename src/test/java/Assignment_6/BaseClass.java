package Assignment_6;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.iNeuron_Assignments_Selenium.utilities.BrowserFactory;

public class BaseClass {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		driver=BrowserFactory.browser("Chrome", driver, "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
	}

}
