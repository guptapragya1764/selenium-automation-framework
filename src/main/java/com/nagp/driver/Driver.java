package com.nagp.driver;

import com.nagp.exceptions.InvalidBrowserNameException;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

import static com.nagp.driver.DriverManager.getDriver;
import static com.nagp.driver.DriverManager.setDriver;
import static com.nagp.enums.ConfigProperties.*;
import static com.nagp.factory.LoggerFactory.info;
import static com.nagp.utils.PropertyUtils.getValue;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Driver class is responsible for invoking and closing the browser. It is also responsible for
 * setting the driver variable to DriverManager.
 */

public final class Driver {

    /**
     * Private constructor for avoiding external instantiation.
     */
    private Driver() {
    }

    /**
     * Get the browser value and initialise the browser based on that and throw {@link
     * com.nagp.exceptions.InvalidBrowserNameException} in case of invalid browser name.
     *
     * @param browser Value will be passed from com.nagp.tests.BaseTest
     */
    @SneakyThrows
    public static void initializeDriver(String browser) {
        if (isNull(getDriver())) {
            if (getValue(RUNMODE).equals("local")) {
                if (browser.equalsIgnoreCase("chrome")) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    setDriver(new ChromeDriver(options));
                } else if (browser.equalsIgnoreCase("firefox")) {
                    WebDriverManager.firefoxdriver().setup();
                    setDriver(new FirefoxDriver());
                } else if (browser.equalsIgnoreCase("edge")) {
                    WebDriverManager.edgedriver().setup();
                    setDriver(new EdgeDriver());
                } else {
                    throw new InvalidBrowserNameException(
                            "Invalid Browser Name. Please check config.properties");

                }
            } else if (getValue(RUNMODE).equals("remote")) {

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("chrome");
                setDriver(new RemoteWebDriver(new URL(getValue(HUBURL)), capabilities));
            }
//            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            getDriver().get(getValue(URL));
            getDriver().manage().window().maximize();

        }
    }

    /**
     * Terminates the browser instance.
     */
    public static void quitDriver() {
        if (nonNull(getDriver())) {
            getDriver().quit();
            info("Terminating browser instance");
            setDriver(null);
        }
    }

}
