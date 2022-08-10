package com.nagp.tests;

import static com.nagp.enums.ConfigProperties.PASSWORD;
import static com.nagp.enums.ConfigProperties.USERNAME;
import static com.nagp.utils.PropertyUtils.getValue;
import static org.testng.AssertJUnit.assertTrue;

import com.nagp.pages.HomePage;
import com.nagp.pages.MyAccountPage;
import org.testng.annotations.Test;

public final class SignInPageTest extends BaseTest {

  private SignInPageTest() {
  }

  @Test(description = "Validate user is able to login successfully", groups = {
      "Smoke"}, testName = "Successful login validation")
  public void validateSuccesfulSignIn() {

    MyAccountPage myAccountPage = new HomePage().clickSignInLink()
        .enterUsernameInTextBox(getValue(USERNAME)).enterPasswordInTextBox(getValue(PASSWORD))
        .clickSignInButton();
    assertTrue(myAccountPage.isOrderDetailsLinkDisplayed());
  }
}
