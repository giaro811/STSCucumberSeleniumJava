package StepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFailSteps {
	
	WebDriver driver = null;
	
	@Given("user2 is on login page")
	public void user2_is_on_login_page() {
		
	String projectPath = System.getProperty("user.dir");
			
			System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver");
			driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			//driver.manage().window().maximize();
			
			driver.navigate().to("http://the-internet.herokuapp.com/login");
	}

	@When("user2 enters username and password")
	public void user2_enters_username_and_password() {
		
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
	}

	@And("user2 clicks on login button")
	public void user2_clicks_on_login_button() {
		
		driver.findElement(By.xpath("//*[text()=' Login']")).click();
	}

	@Then("invalid password message displays")
	public void invalid_password_message_displays() {
		
		driver.findElement(By.id("flash"));
		
		driver.close();
		driver.quit();
	}

}
