package com.nagp.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.nagp.driver.Driver.initializeDriver;
import static com.nagp.driver.Driver.quitDriver;
import static com.nagp.enums.ConfigProperties.BROWSER;
import static com.nagp.factory.LoggerFactory.initializeLogger;
import static com.nagp.utils.PropertyUtils.getValue;

public class BaseTest {
    protected BaseTest() {
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        initializeLogger();
        initializeDriver(getValue(BROWSER));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        quitDriver();
    }

}
