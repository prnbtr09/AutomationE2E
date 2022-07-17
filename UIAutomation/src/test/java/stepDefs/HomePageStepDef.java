package stepDefs;

import driverManager.drivers.CreateDriver;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.lang.invoke.MethodHandles;


public class HomePageStepDef {
    WebDriver driver= CreateDriver.getInstance().getDriver();
    HomePage homePageObjects;
    Logger logger = LogManager.getLogger(MethodHandles.lookup().getClass().getName());

    @Given("user click on {string}")
    public void clickElement(String option){
        homePageObjects=new HomePage(driver);
        homePageObjects.addToCart.click();

    }
}
