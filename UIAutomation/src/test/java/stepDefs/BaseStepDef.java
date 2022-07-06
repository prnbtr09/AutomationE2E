package stepDefs;

import driverManager.Configurations;
import driverManager.ConfigureDriver;
import driverManager.drivers.CreateDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseStepDef {
    private Configurations configurations;
    private ConfigureDriver configDriver;




    @Before(order = 1)
    public void setConfigurations(Scenario scenario) {
        configurations=new Configurations();
        configurations.onPrepare();
        configDriver=new ConfigureDriver();
    }

    @Before(value ="@ui",order=2)
    public void setUpUIRunner() throws Exception {
        configDriver.setUpDriver();
    }

    @After
    public void tearDown(){
        CreateDriver.getInstance().getDriver().quit();
    }










}
