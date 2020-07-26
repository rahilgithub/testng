package TestngPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Activity3 {
	
	WebDriver driver;
	
	
	  @BeforeMethod
	    public void OpenOrangeHRMBrowser() {
	      
	        driver = new ChromeDriver();
	        
	    
	        driver.get("https://www.training-support.net/selenium/login-form");
	        driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

 

    @Test

    public void loginTest() {

     
        WebElement username = driver.findElement(By.id("username"));

        WebElement password = driver.findElement(By.id("password"));
        

        username.sendKeys("admin");

        password.sendKeys("password");

   

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        

        //Read login message

        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();

        Assert.assertEquals("Welcome Back, admin", loginMessage);

    }

 

    @AfterClass

    public void afterClass() throws InterruptedException {

       Thread.sleep(10);
        driver.close();

    }

}
