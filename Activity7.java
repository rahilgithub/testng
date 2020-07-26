package TestngPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
	
	WebDriver driver;

    WebDriverWait wait;
 

    @BeforeClass

    public void beforeClass() {

    	driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 2);

        
        driver.manage().window().maximize();
		

        driver.get("https://www.training-support.net/selenium/login-form");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

    

    @DataProvider(name = "Authentication")

    public static Object[][] credentials() {

        return new Object[][] { { "admin", "password" }};

    }

    

    @Test (dataProvider = "Authentication")

    public void loginTestCase(String username, String password) throws InterruptedException {

        

        WebElement usernameField = driver.findElement(By.id("username"));

        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("admin");

        passwordField.sendKeys("password");

      

        driver.findElement(By.cssSelector("button[type='submit']")).click();

       

        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();

        Assert.assertEquals(loginMessage, "Welcome Back, admin");
        Thread.sleep(20);

    }

 

    @AfterClass

    public void afterClass() throws InterruptedException {

        Thread.sleep(20);
        driver.close();

    }

}
