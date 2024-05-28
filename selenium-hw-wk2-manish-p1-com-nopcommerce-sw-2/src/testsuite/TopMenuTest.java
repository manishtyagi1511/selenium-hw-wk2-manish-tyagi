package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //click on the ‘Computers’ Tab
        driver.findElement(By.linkText("Computers")).click();
        //Verify the text ‘Computers’
        String expectedComputer = "Computers";
        String actualComputer = driver.findElement(By.linkText("Computers")).getText();
        Assert.assertEquals("Verified computers hyperlink", expectedComputer, actualComputer);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {

        //click on the ‘Electronics’ Tab
        driver.findElement(By.linkText("Electronics")).click();
        //Verify the text ‘Electronics
        String expectedElectronics = "Electronics";
        String actualElectronics = driver.findElement(By.linkText("Electronics")).getText();
        Assert.assertEquals("Verified Electronics HyperLInk", expectedElectronics, actualElectronics);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        //click on the ‘Apparel’ Tab
        driver.findElement(By.linkText("Apparel")).click();
        //Verify the text ‘Apparel’
        String expectedApparel = "Apparel";
        String actualApprarel = driver.findElement(By.linkText("Apparel")).getText();
        Assert.assertEquals("Verified Apparel HyperLink", expectedApparel, actualApprarel);

    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        //click on the ‘Digital downloads’ Tab
        driver.findElement(By.linkText("Digital downloads")).click();
        //Verify the text ‘Digital downloads’

        String expectedDigitalDownloads = "Digital downloads";
        String actualDigitalDownloads = driver.findElement(By.linkText("Digital downloads")).getText();
        Assert.assertEquals("Verified Digital downloads hyperLink", expectedDigitalDownloads, actualDigitalDownloads);

    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        //click on the ‘Books’ Tab
        driver.findElement(By.linkText("Books")).click();
        //Verify the text ‘Books’

        String expectedBooks = "Books";
        String actualBooks = driver.findElement(By.linkText("Books")).getText();
        Assert.assertEquals("Verified text Books:", expectedBooks, actualBooks);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {

        driver.findElement(By.linkText("Jewelry")).click();
        //click on the ‘Jewelry’ Tab
        String expectedJewelry = "Jewelry";
        //Verify the text ‘Jewelry’
        String actualJewelry = driver.findElement(By.linkText("Jewelry")).getText();
        Assert.assertEquals("Verified text Jewelry:", expectedJewelry, actualJewelry);

    }

    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        //click on the ‘Gift Cards’ Tab
        driver.findElement(By.linkText("Gift Cards")).click();
        //Verify the text ‘Gift Cards’
        String expectedGiftCard = "Gift Cards";
        String actualGiftCards = driver.findElement(By.linkText("Gift Cards")).getText();


    }


    @After
    public void tearDown() {
         closeBrowser();
    }
}
