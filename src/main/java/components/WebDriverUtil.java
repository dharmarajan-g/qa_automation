package components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.ConfigProperties;

import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;

import static org.slf4j.LoggerFactory.getLogger;


public class WebDriverUtil extends ConfigProperties{
    protected final Logger LOG = getLogger(this.getClass());
    static WebDriver driver = null;

    @BeforeTest
    public void initializeDriver() {
        ConfigProperties configProperties=new ConfigProperties();
        String browserName = configProperties.getProperty("browserName").toLowerCase();
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().deleteAllCookies();
                driver.manage().window().maximize();
                break;
            default:
                Assert.fail(
                        "Invalid browser details provided, please check and provide anyone from chrome, firefox, edge or microsoft edge");
        }
    }


    @AfterTest
    public void quitDriver(){
        if(driver!=null) {
            driver.quit();
        }
    }

    public  static WebDriver getDriver(){
        return driver;
    }

}