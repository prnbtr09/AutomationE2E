package driverManager;

import driverManager.drivers.CreateDriver;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigureDriver {
    public WebDriver driver;
    Properties configProp=this.configProp;
    private FileInputStream fileInputStream;
    private String browserName=Configurations.getConfigProp().getProperty("browser");
    private String env = Configurations.getConfigProp().getProperty("env");

    public void setUpDriver() throws Exception {
        CreateDriver.getInstance().setDriver(this.browserName, this.env.toString());
        this.driver = CreateDriver.createInstance().getDriver();
    }




}
