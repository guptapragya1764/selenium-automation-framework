package com.nagp.reports;

import static com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String;
import static com.nagp.enums.ConfigProperties.*;
import static com.nagp.reports.ExtentReportManager.getExtentTest;
import static com.nagp.utils.PropertyUtils.getValue;
import static com.nagp.utils.TestResultUtils.getBase64Image;

/**
 * This class helps in setting logs in Extent Report.
 * <p>>
 * Also adds screenshots in the report on the basis configuration provided in config file.
 */
public final class ExtentReportLogger {

  /**
   * Private constructor to avoid external instantiation
   */
  private ExtentReportLogger() {
  }

  /**
   * Sets the message for the passed steps and adds the screenshot in the report based on config
   * parameter value.
   *
   * @param message message to appended to with passed step.
   */
  public static void pass(String message) {
    if (getValue(PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
      getExtentTest()
          .pass(message, createScreenCaptureFromBase64String(getBase64Image()).build());
//      getScreenshotfile(message.replace(" ", "_") + "_passed");
    } else {
      getExtentTest().pass(message);
    }
  }

  /**
   * Sets the message for the failed steps and adds the screenshot in the report based on config
   * parameter value.
   *
   * @param message message to appended to with failed step.
   */

  public static void fail(String message) {
    if (getValue(FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
      getExtentTest().fail(message,
          createScreenCaptureFromBase64String(getBase64Image()).build());
//      getScreenshotfile(message.replace(" ", "_") + "_failed");
    } else {
      getExtentTest().fail(message);
    }
  }

  /**
   * Sets the message for the skipped steps and adds the screenshot in the report bases on config
   * parameter value.
   *
   * @param message message to appended to with skipped step.
   */
  public static void skip(String message) {
    if (getValue(SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")) {
      getExtentTest().skip(message, createScreenCaptureFromBase64String(getBase64Image()).build());
//      getScreenshotfile(message.replace(" ", "_") + "_failed");
    } else {
      getExtentTest().skip(message);
    }
  }
}
