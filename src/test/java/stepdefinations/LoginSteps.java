package stepdefinations;



import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;


public class LoginSteps {

    WebDriver driver;

    @Given("User is on Home Page")
    public void user_is_on_home_page() {
        System.setProperty("webdriver.chrome.driver", "/Users/vaishnavi/Downloads/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.coursera.org/");
    }

    @When("User navigate to Login Page")
    public void user_navigate_to_login_page() {
        WebElement loginLink = driver.findElement(By.linkText("Log In"));
        loginLink.click();
    }

    @Then("User enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @Then("Keeping case as {string}")
    public void keeping_case_as(String caseType) {
        // You can add additional logic here if needed
    }

    @Then("User should get logged in")
    public void user_should_get_logged_in() {
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        loginButton.click();
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Then("Message displayed Login Successfully")
    public void message_displayed_login_successfully() {
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='text-xs-center']"));
        assertTrue(successMessage.getText().contains("Login Successfully"));
    }

    @Then("user will be asked to go back to login page")
    public void user_will_be_asked_to_go_back_to_login_page() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        assertTrue(errorMessage.getText().contains("Invalid username or password."));
    }

    @Then("Provide correct credentials")
    public void provide_correct_credentials() {
        WebElement usernameField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys("abc@gmail.com");
        passwordField.sendKeys("12345");
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        loginButton.click();
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
    
    


    
}
