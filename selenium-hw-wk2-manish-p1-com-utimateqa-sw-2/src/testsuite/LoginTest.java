package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        //Verify the text ‘Welcome Back!’
        String expectedWelcomeBack = "Welcome Back!";
        String actualWelcomeBack = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("verified Welcome back! Text :", expectedWelcomeBack, actualWelcomeBack);

    }

    @Test
    public void verifyTheErrorMessage() {
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("manish@gmail.com");
        //Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("manish123");
        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify the error message ‘Invalid email or password

        String expectedInvalidEmailOrPassword = "Invalid email or password.";
        String actualInvalidEmailOrPassword = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("verified invalid email or password text :",expectedInvalidEmailOrPassword,actualInvalidEmailOrPassword);

    }

    @After
    public void tearDown() {
         closeBrowser();


    }
}
