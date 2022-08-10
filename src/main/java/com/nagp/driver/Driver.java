package com.nagp.driver;

import static com.nagp.driver.DriverManager.getDriver;
import static com.nagp.driver.DriverManager.setDriver;
import static com.nagp.enums.ConfigProperties.URL;
import static com.nagp.factory.LoggerFactory.info;
import static com.nagp.utils.PropertyUtils.getValue;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.nagp.exceptions.InvalidBrowserNameException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
  public static void initializeDriver(String browser) {
    if (isNull(getDriver())) {
      if (browser.equalsIgnoreCase("chrome")) {
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
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
