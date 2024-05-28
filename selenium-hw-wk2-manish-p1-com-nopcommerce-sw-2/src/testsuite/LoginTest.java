package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        String expectedText = "Welcome, Please Sign In!";
        // WebElement expectedWelcomeMessage = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));

        //  String actualText = expectedWelcomeMessage.getText();
        // Assert.assertEquals("Not redirected to login page", expectedText, actualText);

        String actualText = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")).getText();
        Assert.assertEquals("Not redirected to login page", expectedText, actualText);


    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.xpath("//a[text()='Log in'] ")).click();
        //Enter valid username
        driver.findElement(By.className("email")).sendKeys("manishtyagi7683@gmail.com");
        //Enter valid password
        driver.findElement(By.className("password")).sendKeys("manish@123");
        //* Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class='button-1 login-button']  ")).click();
        //Verify the ‘Log out’ text is display
        String expectedLogOut= "Log out";
        String actualLogOut=driver.findElement(By.xpath(" //a[text()='Log out']")).getText();
        Assert.assertEquals("Log out",expectedLogOut,actualLogOut);

    }
@Test
    public void verifyTheErrorMessage(){
        //click on the ‘Login’ link
        driver.findElement(By.xpath("//a[text()='Log in'] ")).click();
        //* Enter invalid username
        driver.findElement(By.className("email")).sendKeys("manishtyagi768@gmail.com");
        //Enter invalid password
        driver.findElement(By.className("password")).sendKeys("manish@12");
        //Click on Login button
        driver.findElement(By.xpath("//button[@class='button-1 login-button']  ")).click();
        //Verify the error message ‘Login was unsuccessful.
        //Please correct the errors and try again. No customer account found

    String expectedLogin="Login was unsuccessful. Please correct the errors and try again.\n" +
            "No customer account found";
    String actualLogin=driver.findElement(By.xpath("//div[text()='Login was unsuccessful. Please correct the errors and try again.']")).getText();
    Assert.assertEquals("Login was successfull",expectedLogin,actualLogin);






    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
