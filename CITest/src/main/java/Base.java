import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();
    public CapabilityFactory capabilityFactory=new CapabilityFactory();
String grid="false";
    @BeforeMethod
    @Parameters(value={"browser"})
    public void setupBrowser(String browser) throws MalformedURLException {

        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub "),
                capabilityFactory.getCapabilities(browser)));
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @AfterClass
    void terminate () {
        driver.remove();
    }
}
