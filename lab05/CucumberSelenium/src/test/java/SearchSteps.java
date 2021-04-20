import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SearchSteps {
    private WebDriver webDriver;
    WebDriver browser = new FirefoxDriver();

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        WebDriverManager.firefoxdriver().setup();
        browser.get(url);
    }

    @And("I type {string}")
    public void iType(String searchQuery) {
        browser.findElement(By.name("q")).sendKeys(searchQuery);
        browser.findElement(By.id("zV9nZe")).click();
    }

    @And("I press Enter")
    public void iPressEnter() throws InterruptedException {
        browser.findElement(By.name("q")).sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(1);
    }

    @Then("I should enter the BlazeDemo website and register my flight")
    public void iShouldEnterBlazeDemoWebsite() throws InterruptedException {
        //System.out.println(browser.getCurrentUrl());
        {
            WebElement element = browser.findElement(By.cssSelector("div:nth-child(2) > div > .tF2Cxc .LC20lb"));
            Actions builder = new Actions(browser);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = browser.findElement(By.tagName("body"));
            Actions builder = new Actions(browser);
            builder.moveToElement(element, 0, 0).perform();
        }
        browser.findElement(By.cssSelector("div:nth-child(2) > div > .tF2Cxc .LC20lb")).click();
        browser.findElement(By.cssSelector(".form-inline:nth-child(1) > option:nth-child(1)")).click();
        {
            WebElement dropdown = browser.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
        }
        browser.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(5)")).click();
        browser.findElement(By.cssSelector(".btn-primary")).click();
        browser.findElement(By.cssSelector("tr:nth-child(3) .btn")).click();
        browser.findElement(By.id("inputName")).click();
        browser.findElement(By.id("inputName")).sendKeys("Edu");
        browser.findElement(By.id("address")).click();
        browser.findElement(By.id("address")).sendKeys("Aveiro");
        browser.findElement(By.id("city")).click();
        browser.findElement(By.id("city")).sendKeys("Aveiro");
        browser.findElement(By.id("state")).click();
        browser.findElement(By.id("state")).sendKeys("Aveiro");
        browser.findElement(By.id("zipCode")).click();
        browser.findElement(By.id("zipCode")).sendKeys("3800");
        browser.findElement(By.id("creditCardNumber")).click();
        browser.findElement(By.id("creditCardNumber")).sendKeys("123789456");
        browser.findElement(By.id("creditCardMonth")).click();
        browser.findElement(By.id("creditCardMonth")).sendKeys("07");
        browser.findElement(By.cssSelector("form")).click();
        browser.findElement(By.id("creditCardYear")).click();
        browser.findElement(By.id("creditCardYear")).sendKeys("2021");
        browser.findElement(By.id("nameOnCard")).click();
        browser.findElement(By.id("nameOnCard")).sendKeys("Eduardo Santos");
        browser.findElement(By.cssSelector(".btn-primary")).click();
        browser.close();
    }
}