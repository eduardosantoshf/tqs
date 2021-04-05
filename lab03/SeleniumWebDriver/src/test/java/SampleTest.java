import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SampleTest {

    WebDriver browser = new FirefoxDriver();

    @BeforeEach
    void setUp(){
        WebDriver browser;
    }
    @Test
    public void site_header_is_on_home_page() {
        browser.get("https://www.saucelabs.com");
        WebElement href = browser.findElement(By.xpath("//a[@href='https://accounts.saucelabs.com/']"));
        assertTrue((href.isDisplayed()));
    }

    @Test
    public void blazedemoTest() {
        browser.get("https://blazedemo.com/");
        browser.manage().window().setSize(new Dimension(1920, 1057));
        browser.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = browser.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'Paris']")).click();
        }
        browser.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = browser.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'Rome']")).click();
        }
        browser.findElement(By.cssSelector(".btn-primary")).click();
        browser.findElement(By.cssSelector("tr:nth-child(1) .btn")).click();
        browser.findElement(By.id("inputName")).click();
        browser.findElement(By.id("inputName")).sendKeys("Eduardo Santos");
        browser.findElement(By.id("address")).click();
        browser.findElement(By.id("address")).sendKeys("Aveiro");
        browser.findElement(By.id("city")).click();
        browser.findElement(By.id("city")).sendKeys("Aveiro");
        browser.findElement(By.cssSelector("body")).click();
        browser.findElement(By.id("state")).click();
        browser.findElement(By.id("state")).sendKeys("Aveiro");
        browser.findElement(By.id("zipCode")).click();
        browser.findElement(By.id("zipCode")).sendKeys("3800");
        browser.findElement(By.cssSelector("body")).click();
        browser.findElement(By.id("cardType")).click();
        {
            WebElement dropdown = browser.findElement(By.id("cardType"));
            dropdown.findElement(By.xpath("//option[. = 'Visa']")).click();
        }
        browser.findElement(By.id("creditCardNumber")).click();
        browser.findElement(By.id("creditCardNumber")).sendKeys("123456789");
        browser.findElement(By.id("creditCardMonth")).click();
        browser.findElement(By.id("creditCardMonth")).sendKeys("11");
        browser.findElement(By.id("creditCardYear")).click();
        browser.findElement(By.id("creditCardYear")).sendKeys("2017");
        browser.findElement(By.cssSelector(".control-group:nth-child(11)")).click();
        browser.findElement(By.id("nameOnCard")).click();
        browser.findElement(By.id("nameOnCard")).sendKeys("Edu");
        browser.findElement(By.cssSelector(".btn-primary")).click();
        assertEquals(browser.getTitle(), "BlazeDemo Confirmation");
    }

    @AfterEach
    void tearDown() {
        browser.close();
    }
}
