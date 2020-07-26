package TestngPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyTitle {

	
	    WebDriver driver;
	    
	    @BeforeMethod
	    public void beforeMethod() throws InterruptedException {
	        
	    	driver = new ChromeDriver();
	        Thread.sleep(10);
	        
	        
	        driver.get("https://www.training-support.net");
	    }

	    @Test
	    public void exampleTestCase() throws InterruptedException {
	      
	        String title = driver.getTitle();
	            
	        
	        System.out.println("Page title is: " + title);
	            
	        
	            //Assertion for page title
	        Assert.assertEquals("Training Support", title);
	                    
	       //click on ABout US and get new title of the page
	        driver.findElement(By.xpath("//*[@id=\"about-link\"]")).click();
	                    
	        //Print title of new page
	        System.out.println("New page title is: " + driver.getTitle());
	        
	        Assert.assertEquals(driver.getTitle(), "About Training Support");
	        Thread.sleep(10);
	    }

	   
	    @AfterMethod 
	    public void CloseBrowserTraining() throws InterruptedException
	    {
	    	Thread.sleep(10);
	    	driver.quit();
	    }
	}

