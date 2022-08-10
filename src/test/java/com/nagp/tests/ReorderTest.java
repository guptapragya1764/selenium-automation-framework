package com.nagp.tests;

import static com.nagp.constants.MessageConstants.EXPECTED_ORDER_SUCCESS_ALERT;
import static com.nagp.enums.ConfigProperties.PASSWORD;
import static com.nagp.enums.ConfigProperties.USERNAME;
import static com.nagp.utils.PropertyUtils.getValue;
import static org.testng.AssertJUnit.assertEquals;

import com.nagp.constants.MessageConstants;
import com.nagp.pages.HomePage;
import org.testng.annotations.Test;

public class ReorderTest extends BaseTest {

  @Test(description = "Validate the user should be able to successfully reorder the product",groups = {
      "Sanity"}, testName = "Successful Reorder validation")
  public void validateSuccessfulReorder() {
    String actualSuccessAlert = new HomePage().clickSignInLink()
        .enterUsernameInTextBox(getValue(USERNAME))
        .enterPasswordInTextBox(getValue(PASSWORD))
        .clickSignInButton()
        .clickOrderDetailsLink()
        .clickReorderLink()
        .clickProceedToCheckoutLink()
        .clickProceedToCheckoutAddressButton()
        .clickTermsAndConditionsCheckbox()
        .clickProceedToCheckoutCarrierButton()
        .clickPaymentByChequeLink()
        .clickOrderConfirmationButton()
        .getOrderSuccessAlertText();

    assertEquals(actualSuccessAlert, EXPECTED_ORDER_SUCCESS_ALERT);
  }

}
