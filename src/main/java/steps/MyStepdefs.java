package steps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import methods.AssertionMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyStepdefs {
    private WebDriver driver = new DriverFactory().getDriver();

    @Given("^user lands on \"([^\"]*)\"$")
    public void userLandsOn(String address) {
        driver.get(address);
    }

    @And("^user inputs \"([^\"]*)\" in \"([^\"]*)\"$")
    public void userInputsIn(String input, String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(input);
    }

    @When("^user click \"([^\"]*)\"$")
    public void userClick(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    @Then("^user should see \"([^\"]*)\" on the page$")
    public void userShouldSeeOnThePage(String text) {
        new AssertionMethods().waitForPageLoaded();
        Assert.assertTrue(driver.getPageSource().contains(text));
    }

    @After
    public void afterScenario () {
        new DriverFactory().destoryDriver();
    }
}
