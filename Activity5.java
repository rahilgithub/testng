package TestngPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity5 {

	WebDriver driver;


	    @BeforeTest(alwaysRun = true)

	    public void beforeMethod() {	       

	    	  driver = new ChromeDriver();	       

	        driver.get("https://www.training-support.net/selenium/target-practice");
	        driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

	    }

	    

	    @Test (groups = {"HeaderTests", "ButtonTests"})

	    public void pageTitleTest() {

	        String title = driver.getTitle();

	        System.out.println("Title is: " + title);

	        Assert.assertEquals(title, "Target Practice");

	    }

	    

	    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})

	    public void HeaderTest1() {

	        WebElement header3 = driver.findElement(By.cssSelector("h3#third-header"));

	        Assert.assertEquals(header3.getText(), "Third header");

	    }

	    

	    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})

	    public void HeaderTest2() {

	        WebElement header5 = driver.findElement(By.cssSelector("h3#third-header"));

	        Assert.assertEquals(header5.getCssValue("color"), "rgba(251, 189, 8, 1)");

	    }

	    

	    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})

	    public void ButtonTest1() {

	        WebElement button1 = driver.findElement(By.cssSelector("button.olive"));

	        Assert.assertEquals(button1.getText(), "Olive");

	    }

	    

	    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})

	    public void ButtonTest2() throws InterruptedException {

	        WebElement button2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[1]"));

	        Assert.assertEquals(button2.getCssValue("color"), "rgba(255, 255, 255, 1)");
	        Thread.sleep(10);

	    }

	 


	    @AfterTest(alwaysRun = true)

	    public void afterMethod() throws InterruptedException {

	      Thread.sleep(10);

	        driver.close();

	    }
	
}
