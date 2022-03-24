package Hooks;

import components.WebDriverUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.ConfigProperties;

public class Hooks {

    ConfigProperties configProperties=new ConfigProperties();
    WebDriverUtil webDriverUtil=new WebDriverUtil();;

    @Before()
    public void setup(){
        configProperties.initialize_properties();
        webDriverUtil.initializeDriver();
    }

    @After()
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            String screenShotName=scenario.getName().replaceAll(" ","_");
            byte[] sourcePath=((TakesScreenshot) WebDriverUtil.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",screenShotName);
        }
        webDriverUtil.quitDriver();
    }
}
