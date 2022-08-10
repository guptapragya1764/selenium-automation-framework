package com.nagp.tests;

import static com.nagp.driver.Driver.initializeDriver;
import static com.nagp.driver.Driver.quitDriver;
import static com.nagp.enums.ConfigProperties.BROWSER;
import static com.nagp.utils.PropertyUtils.getValue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  protected BaseTest() {
  }

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    initializeDriver(getValue(BROWSER));
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    quitDriver();
  }

}
