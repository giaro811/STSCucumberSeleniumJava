package StepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectRowSteps {
	
	WebDriver driver = null;
	
	@Given("user is at Large & Deep DOM page")
	public void user_is_at_large_deep_dom_page() {
		
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//driver.manage().window().maximize();
		
		driver.navigate().to("http://the-internet.herokuapp.com/large");
	}

	@When("user select row {string}")
	public void user_select_row_row(String line) {
		
		
		WebElement ele = driver.findElement(By.xpath("//*[text()='"+line+"']"));
		Actions dummy = new Actions(driver);
		dummy.doubleClick(ele).build().perform();
	}

	@Then("row {string} is selected")
	public void row_row_is_selected(String line) {
		
		driver.findElement(By.xpath("//*[text() = '"+line+"']")).isSelected();
		
		driver.close();
		driver.quit();
	}


}
