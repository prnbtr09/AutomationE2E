package driverManager.drivers;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class CreateDriver {
    private static final ThreadLocal<CreateDriver> instance=new ThreadLocal<>();
    public WebDriver driver;
    Map<String, String> environmentBrowserMap = new HashMap<>();

    private CreateDriver() {
    }

    public final void setDriver(String browser, String environment) throws Exception {
        environmentBrowserMap.put(browser, environment);
        driver = new GetDriver().getDriver(browser,environment).getDriver();
        this.setDriver(driver);
    }

    public static CreateDriver createInstance() {
        if (null == instance.get()) {
            instance.set(new CreateDriver());
        }

        return instance.get();
    }

    public static CreateDriver getInstance() {
        return createInstance();
    }



    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
