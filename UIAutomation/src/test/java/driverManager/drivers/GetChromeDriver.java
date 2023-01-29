package driverManager.drivers;

import driverManager.Configurations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetChromeDriver extends Driver {
    @Override
    WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = CreateDriver.getInstance().getDriver();

        this.driver = new ChromeDriver(getChromeCapabilities());
        return driver;

    }



    private ChromeOptions getChromeCapabilities(){
        ChromeOptions options=new ChromeOptions();

        if(Boolean.parseBoolean(System.getProperty("isHeadless",Configurations.getConfigProp().getProperty("isHeadless")))){
            options.addArguments("--headless");
        }
        return options;
    }

}
