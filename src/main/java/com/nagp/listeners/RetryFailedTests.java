package com.nagp.listeners;

import static com.nagp.constants.FrameworkConstants.getMaxRetries;
import static com.nagp.utils.PropertyUtils.getValue;

import com.nagp.enums.ConfigProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Implements {@link IRetryAnalyzer} to help in rerunning the failed tests.
 */
public class RetryFailedTests implements IRetryAnalyzer {

  private int count = 0;

  /**
   * Return true when needs to be retried and false otherwise.
   * <p>
   * Retry will happen if user desires to and set the value in the property file.
   */

  @Override
  public boolean retry(ITestResult result) {
    boolean flag = false;
    if (getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
      flag = count < getMaxRetries();
      count++;
    }
    return flag;
  }
}
