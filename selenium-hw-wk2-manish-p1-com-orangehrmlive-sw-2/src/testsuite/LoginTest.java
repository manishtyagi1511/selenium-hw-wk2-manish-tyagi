package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “Admin” username
        driver.findElement(By.name("username")).sendKeys("Admin");
        //Enter “admin123 password
        driver.findElement(By.name("password")).sendKeys("admin123");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify the ‘Dashboard’ text is display
        driver.findElement(By.xpath("//h6[text()='Dashboard']")).click();

        String expectedDashBoard = "Dashboard";
        String actualDashBoard = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
        Assert.assertEquals("Verified text Dashboard :", expectedDashBoard, actualDashBoard);


    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
