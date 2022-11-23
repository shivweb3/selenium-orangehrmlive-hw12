package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
@Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        //Find username and enter Admin as a username in it
        driver.findElement(By.name("username")).sendKeys("Admin");

        //Find password and enter admin123 as a password in it
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Find login button and click it
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();

        //Verifying Dashboard Text
        String expectedMessage ="Dashboard";
        WebElement actualtxtMessage = driver.findElement(By.xpath("//span[text()='Dashboard']"));
        String actualMessage = actualtxtMessage.getText();

        Assert.assertEquals("You are not Logged in",expectedMessage,actualMessage);

    }

    @After
    public void teardown() {
        closeBrowser();
    }


}
