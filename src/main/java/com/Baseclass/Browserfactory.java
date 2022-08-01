package com.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browserfactory {


    public static WebDriver driver;
    public Properties property;
    InputStream input;
    public void Launch() {
        property =new Properties();
        try {
            input = new FileInputStream("src/test/resources/ConfigProperty/travel.property");
            property.load(input);
        } catch (IOException e) {
            System.out.println("Error in reading the property file "+e);
        }

        if(property.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-gpu");
            options.addArguments("--force-device-scale-factor=1");

            WebDriverManager.chromedriver().forceDownload().setup();
            driver=new ChromeDriver(options);

        }

        else if (property.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public void openApplication() {
        driver.navigate().to(property.getProperty("url"));
    }

    public void closeapp() {
        driver.close();

    }


}
