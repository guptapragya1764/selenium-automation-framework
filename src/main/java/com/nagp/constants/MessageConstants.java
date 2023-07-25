package com.nagp.constants;

/**
 * MessageConstants holds the value of all the message constant values used within the framework.
 */
public final class MessageConstants {

  /**
   * Private constructor to avoid external instantiation.
   */
  private MessageConstants() {

  }

  public static final String ASSERT_MESSAGE = "Expected was %s but found is %s";
  public static final String EXPECTED_ADDTOCART_SUCCESS_MESSAGE = "Product successfully added to your shopping cart";
  public static final String ERROR_MESSAGE_PROPERTY_NOT_FOUND = "Property name %s is not found. Please check the config.properties";
  public static final String ERROR_MESSAGE_FILE_NOT_FOUND = "Provided path %s for file is not correct. Please enter the correct path";
  public static final String EXPECTED_MYACCOUNT_PAGE_TITLE = "My account - My Store";
  public static final String EXPECTED_HOME_PAGE_PAGE_TITLE = "My Store";
  public static final String EXPECTED_CREDIT_SLIP_ALERT = "You have not received any credit slips.";
  public static final String EXPECTED_ORDER_SUCCESS_ALERT = "Your order on My Store is complete.";
  public static final String ERROR_MESSAGE_METHOD_NAME_NOT_FOUND = "Method name %s is not available in DataGenerator class. Please correct the method name in excel file";
  public static final String ERROR_MESSAGE_COPYING_DIR_CONTENTS = "Unable to directory Content from %s to %s. Please check extent the contents of Directory or Directory itself";
  public static final String ERROR_MESSAGE_DELETING_DIR_CONTENTS = "Unable to delete %s from directory %s. Please check";
  public static final String TESTCASE_EXECUTION_START_MESSAGE = "\n\n***** Execution Started : %s *****\n";
  public static final String TESTCASE_EXECUTION_END_MESSAGE = "\n\n***** Execution End : %s is %s *****\n";
  public static final String DROPDOWN_SELECTION_INDEX_MESSAGE = "Element from index %s is selected from dropdown";
  public static final String TITLLE_VISIBILITY_INDEX_MESSAGE = "Title of the page is %s";
  public static final String HOVERED_MESSAGE = "Hovered on %s";
  public static final String CLICKED_MESSAGE = "%s is clicked";
  public static final String VALUE_ENTERED_MESSAGE = "%s entered successfully in %s";
  public static final String PASSWORD_ENTERED_MESSAGE = "****** entered successfully in %s";
  public static final String TEXT_RETRIEVED_MESSAGE = "Text for %s is retrieved";
  public static final String DISPLAYED_MESSAGE = "%s is displayed";
  public static final String NOT_DISPLAYED_MESSAGE = "%s is not displayed";
  public static final String SWITCHED_TO_FRAME_MESSAGE = "Switched to frame %s";


}
