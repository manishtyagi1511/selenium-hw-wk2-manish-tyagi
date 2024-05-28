package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {

        //click on the ‘Forgot your password’ link
        driver.findElement(By.xpath("//p[text()='Forgot your password? ']")).click();
        //Verify the text ‘Reset Password’
        String expectedResetPassword = "Reset Password";
        String actualResetPassword = driver.findElement(By.xpath("//h6[text()='Reset Password']")).getText();
        Assert.assertEquals("Verified reset password text:", expectedResetPassword, actualResetPassword);

    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}
