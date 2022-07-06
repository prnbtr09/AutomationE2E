package driverManager.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetChromeDriver extends Driver {
    @Override
    WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = CreateDriver.getInstance().getDriver();
        this.driver = new ChromeDriver();
        return driver;

    }



}
