package com.nagp.utils;

/**
 * Utility class for java helper method.
 */
public final class JavaUtils {

  /**
   * Private constructor to avoid external instantiation
   */
  private JavaUtils() {
  }

  /**
   * Convert class name into Class type.
   *
   * @param className Name of class that need to be converted.
   * @return Class instance
   */
  public static Class<?> getClassByString(String className) {
    try {
      return Class.forName(className);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Utility method for wait
   *
   * @param seconds milli seconds
   */
  public static void waitTill(long seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
       Thread.currentThread().interrupt();
    }
    catch (ExecutionException ee) {
    ee.printStackTrace();
}
  }
}


