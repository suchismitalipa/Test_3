package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.*;
import junit.framework.Assert;
import pageObjects.LoginPage;

public class Steps {
	
	public WebDriver driver;
	public LoginPage lp;
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_Browser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Java\\Test_1\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
	}
	@When("User opens URL {string}")
	public void user_Opens_URL(String url) {
		driver.get(url);
	}
	@When("User enters Email as {string} and Password as {string}")
	public void user_Enters_Email_as_and_password_as(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() {
		lp.clickLogin();
	}
	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
		
		if(driver.getPageSource().contains("login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}
	@When("User click on Log out link")
	public void user_Click_On_Logout_Link() throws InterruptedException {
		Thread.sleep(3000);
		lp.clickLogout();
		
	}
	@Then("close browser")
	public void close_the_Browser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();

	}

}
