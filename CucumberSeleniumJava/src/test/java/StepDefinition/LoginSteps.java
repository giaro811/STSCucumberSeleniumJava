package StepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver = null;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//driver.manage().window().maximize();
		
		driver.navigate().to("http://the-internet.herokuapp.com/login");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		
		driver.findElement(By.xpath("//*[text()=' Login']")).click();
		}

	@Then("success message displays")
	public void success_message_displays() {
		
		driver.getPageSource().contains("Welcome to the Secure Area. When you are done click logout below.");
		
		driver.close();
		driver.quit();
	}

}
