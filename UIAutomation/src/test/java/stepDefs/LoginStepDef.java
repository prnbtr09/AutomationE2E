package stepDefs;

import driverManager.drivers.CreateDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Map;

public class LoginStepDef {
    Logger logger= LogManager.getLogger(MethodHandles.lookup().getClass().getName());
    WebDriver driver= CreateDriver.getInstance().getDriver();
    LoginPage loginPageObjects;


    @Given("user has launched url {string}")
    public void launchApplication(String url){
        driver.get(url);
        System.out.println(Thread.currentThread().getId());
        System.out.println(driver.hashCode());
        logger.info("browser is launched");
    }

    @Given("user has logged in to application using following credentials")
    public void loginToApp(DataTable table) {
        loginPageObjects = new LoginPage(driver);
        List<Map<String, String>> credentials = table.asMaps(String.class, String.class);
        loginPageObjects.userName.sendKeys(credentials.get(0).get("UserName"));
        loginPageObjects.password.sendKeys(credentials.get(0).get("Password"));
        loginPageObjects.loginButton.click();
        logger.info("User has logged in to app");


    }


}
