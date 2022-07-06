package driverManager.drivers;

public class GetDriver {
Driver driver;
    public Driver getDriver(String driverName,String environment) {
        if(environment.equals("local")){
            switch (driverName.toLowerCase()) {
                case "chrome":
                    driver=new GetChromeDriver();
                    break;
                case "firefox":
                    driver=new GetFirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Driver name is incorrect");
            }
        }else if(environment.equals("remote")){
            driver=new RemoteDriver();
        }

        return driver;
    }

}
