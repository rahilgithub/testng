package TestngPractice;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Activity6 {

	WebDriver driver;

    WebDriverWait wait;

 

    @BeforeClass

    public void beforeClass() {

    	driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 5);

        
        driver.manage().window().maximize();
		

        driver.get("https://www.training-support.net/selenium/login-form");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        

    }

    

    @Test
    @Parameters({"username","password"})

    public void loginTestCase(String username, String password) throws InterruptedException {
       
    	Thread.sleep(5);
        WebElement usernameField = driver.findElement(By.id("username"));

        WebElement passwordField = driver.findElement(By.id("password"));

       
        usernameField.sendKeys("admin");

        passwordField.sendKeys("password");

      
        driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();

     

        String loginMessage = driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]")).getText();

        AssertJUnit.assertEquals(loginMessage, "Welcome Back, admin");
        
        Thread.sleep(10);

    }

 

    @AfterClass

    public void afterClass() throws InterruptedException {

        Thread.sleep(10);

        driver.close();

    }
}
