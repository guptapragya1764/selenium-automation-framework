package com.nagp.tests;

import static com.nagp.constants.MessageConstants.EXPECTED_CREDIT_SLIP_ALERT;
import static com.nagp.enums.ConfigProperties.PASSWORD;
import static com.nagp.enums.ConfigProperties.USERNAME;
import static com.nagp.utils.PropertyUtils.getValue;
import static org.testng.AssertJUnit.assertEquals;

import com.nagp.factory.LoggerFactory;
import com.nagp.pages.HomePage;
import org.testng.annotations.Test;

public class CreditSlipPageTest extends BaseTest {

  @Test(description = "Validate the alert message for credit slip", groups = {
      "Sanity"},testName = "Credit Slip alert message validation")

  public void validateCreditSlipAlert() {
//    LoggerFactory.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
    String actualAlert = new HomePage().clickSignInLink()
        .enterUsernameInTextBox(getValue(USERNAME))
        .enterPasswordInTextBox(getValue(PASSWORD)).clickSignInButton().clickCreditSlipsLink()
        .getAlertText();
    assertEquals(actualAlert, EXPECTED_CREDIT_SLIP_ALERT);
  }

}
