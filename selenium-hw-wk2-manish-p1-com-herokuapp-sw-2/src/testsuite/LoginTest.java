package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[text()=' Login']")).click();
        //Verify the text “Secure Area”
        driver.findElement(By.xpath("//h2[text()=' Secure Area']"));

        String expectedSecureAreaText = "Secure Area";
        String actualSecureAreaText = driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText();
        Assert.assertEquals("verified Secure Area Text :", expectedSecureAreaText, actualSecureAreaText);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[text()=' Login']")).click();
        // Verify the error message “Your username is invalid!”

        String expectedYourUsernameIsInvalid="Your username is invalid!\n×";
        String actualYourUsernameIsInvalid=driver.findElement(By.xpath("//div[@id='flash-messages']")).getText();
        Assert.assertEquals("verified Your username is invalid! text :",expectedYourUsernameIsInvalid,actualYourUsernameIsInvalid);


    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //* Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //* Enter “SuperSecretPassword” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

        //* Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[text()=' Login']")).click();

        //* Verify the error message “Your password is invalid!”

         String expectedPasswordIsInvalid = "Your password is invalid!\n" + "×";
         String actualPasswordIsInvalid=driver.findElement(By.xpath("//div[@id='flash-messages']")).getText();
         Assert.assertEquals("Verified your password is invalid text :",expectedPasswordIsInvalid,actualPasswordIsInvalid);


    }

    @After
    public void tearDown() {
        //  closeBrowser();
    }
}
