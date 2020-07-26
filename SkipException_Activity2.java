package TestngPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SkipException_Activity2 {

			WebDriver driver;
   

			@BeforeTest

			public void beforeMethod() throws InterruptedException  {					
       
				driver = new ChromeDriver();
				Thread.sleep(5);

                
        driver.get("https://www.training-support.net/selenium/target-practice");
        Thread.sleep(5);
        
        driver.manage().window().maximize();
		 
		  

    }    

    @Test

    public void testCase1() {

        String title = driver.getTitle();

        System.out.println("Title is: " + title);

        Assert.assertEquals(title, "Target Practice");

    }

    

    @Test

    public void testCase2() {

        //This test case will Fail

        WebElement blackButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]"));

        Assert.assertTrue(blackButton.isDisplayed());

        Assert.assertEquals(blackButton.getText(), "Black");

    }

    

    @Test(enabled = false)

    public void testCase3() {

        //This test will be skipped and not counted

        String subHeading = driver.findElement(By.className("sub")).getText();

        Assert.assertTrue(subHeading.contains("Practice"));

    }

    

    @Test

    public void testCase4() {

        //This test will be skipped and will be be shown as skipped

        throw new SkipException("Skipping test case");      

    }

 
    @AfterMethod
    public void closebrowser() throws InterruptedException
    {
    	Thread.sleep(5);
    	driver.quit();
    }
 
	
}
