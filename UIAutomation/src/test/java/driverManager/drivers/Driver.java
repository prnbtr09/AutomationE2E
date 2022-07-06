package driverManager.drivers;

import org.openqa.selenium.WebDriver;

abstract class Driver {
    WebDriver driver;

    abstract WebDriver getDriver();
}
