package com.nagp.utils;

import static com.nagp.factory.LoggerFactory.info;

import com.mifmif.common.regex.Generex;

/**
 * Utility to generate test data for Test, based on the provided regrex.
 */
public final class DataGeneratorUtils {

  /**
   * Private constructor to avoid external instantiation
   */
  private DataGeneratorUtils() {
  }

  private static final String REGREX_ZIP = "[4-9]{5}";
  private static final String REGREX_NAME = "([a-z]|[A-Z]){6}([a-z]|[A-Z]){3,12}";
  private static final String REGREX_EMAIL = "([a-z]){8}([0-9]){5,7}[@]{1}[t][e][s][t][.]" + "com";
  private static final String REGREX_PASSWORD = "[A-Z]{1}[a-z]{5}[!$@]{1}[0-9][3]";
  private static final String REGREX_ADDRESS = "([a-z]|[A-Z]){6}";
  private static final String REGREX_MOBILENUMBER = "([1-9]{10})";

  public static String usingRegrex(String pattern) {
    Generex generex = new Generex(pattern);
    generex.setSeed(System.nanoTime());
    return generex.random();
  }

  public static String email() {
    return usingRegrex(REGREX_EMAIL);
  }

  public static String firstName() {
    return usingRegrex(REGREX_NAME);
  }

  public static String lastName() {
    return usingRegrex(REGREX_NAME);
  }

  public static String password() {
    return usingRegrex(REGREX_PASSWORD);
  }

  public static String address() {
    return usingRegrex(REGREX_ADDRESS);
  }

  public static String zip() {
    return usingRegrex(REGREX_ZIP);
  }

  public static String mobileNumber() {
    return usingRegrex(REGREX_MOBILENUMBER);
  }
}
