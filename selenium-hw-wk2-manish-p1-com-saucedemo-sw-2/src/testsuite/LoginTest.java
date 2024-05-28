package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@placeholder='Username'] ")).sendKeys("standard_user");


        //* Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");

        //* Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();

        //* Verify the text “PRODUCTS
        String expectedProductText = "Products";
        String actualProductText = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals("verified text Products :", expectedProductText, actualProductText);

    }

    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@placeholder='Username'] ")).sendKeys("standard_user");


        //* Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");

        //* Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        //Verify that six products are displayed on page

        List<WebElement> products =driver.findElements(By.className("inventory_item"));
        int expectedProducts =6;
        Assert.assertEquals("User can not see six products ",expectedProducts,products.size());

    }


    @After
    public void tearDown() {
        // closeBrowser();

    }

}
