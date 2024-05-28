package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {

    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
@Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        //click on the ‘Register’ link
        driver.findElement(By.linkText("Register")).click();
        //Verify the text ‘Register’
        String expectedRegister= "Register";
        String actualRegister=driver.findElement(By.linkText("Register")).getText();
        Assert.assertEquals("Verified text Register:",expectedRegister,actualRegister);

    }
@Test
    public void userShouldRegisterAccountSuccessfully(){
        //click on the ‘Register’ link
        driver.findElement(By.linkText("Register")).click();
        //Select gender radio button
        driver.findElement(By.id("gender-male")).click();
        //Enter First name
        driver.findElement(By.id("FirstName")).sendKeys("Manish");
        //Enter Last name
        driver.findElement(By.id("LastName")).sendKeys("Tyagi");
        //Select Day Month and Year
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).sendKeys("15");
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("November");
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1988");
        //Enter Email address
        driver.findElement(By.id("Email")).sendKeys("manishtyagi1512@gmail.com");
        //Enter Password
        driver.findElement(By.id("Password")).sendKeys("manish@123");
        //Enter Confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("manish@123");
        //Click on REGISTER button
        driver.findElement(By.id("register-button")).click();
        //Verify the text 'Your registration completed’

    String expectedYourRegistrationCompleted="Your registration completed";
    String actualYourRegistrationCompleted=driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText();
    Assert.assertEquals("Verified text Your registration completed",expectedYourRegistrationCompleted,actualYourRegistrationCompleted);

    }

    @After
    public void tearDown(){
       closeBrowser();


    }




}
