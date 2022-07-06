package driverManager.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetFirefoxDriver extends Driver {
    @Override
    public WebDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();
        this.driver = CreateDriver.getInstance().getDriver();
        this.driver = new FirefoxDriver();
        return this.driver;
    }
}
