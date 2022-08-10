package com.nagp.tests;

import static com.nagp.constants.MessageConstants.EXPECTED_MYACCOUNT_PAGE_TITLE;
import static com.nagp.factory.LoggerFactory.startTestCase;
import static com.nagp.reports.ExtentReport.createTest;
import static org.testng.AssertJUnit.assertEquals;

import com.nagp.annotations.DataProviderAnnotation;
import com.nagp.pages.HomePage;
import com.nagp.pages.MyAccountPage;
import com.nagp.pages.RegistrationPage;
import com.nagp.utils.DataProviderUtil;
import java.util.Map;
import org.testng.annotations.Test;

public final class RegistrationPageTest extends BaseTest {

  private RegistrationPageTest() {
  }

  @Test(dataProvider = "excelDataProviderParallel", dataProviderClass = DataProviderUtil.class,
      description = "Validate the error message and success registration on Register Page for "
          + "various date flowing from Excel File", groups = {
      "Smoke", "DataDriven"}, testName = "Perform data validation testing on registration")
  @DataProviderAnnotation(file = "testdata/Register.xlsx", sheetIndex = 0)
  public void validateRegistration(Map<String, String> mp) {
    createTest(mp.get("description"));
    startTestCase(mp.get("description"));

    MyAccountPage accountPage = new HomePage().clickSignInLink()
        .enterEmailInTextBox(mp.get("email"))
        .clickCreateAnAccountButton()
        .enterFirstNameInTextBox(mp.get("firstName"))
        .enterLastNameInTextBox(mp.get("lastName"))
        .enterPasswordInTextBox(mp.get("password"))
        .enterAddress1InTextBox(mp.get("address1"))
        .enterCityInTextBox(mp.get("city"))
        .selectStateFromDropdown(mp.get("state"))
        .enterZipInTextBox(mp.get("zip"))
        .enterMobileNumberInTextBox(mp.get("mobile"))
        .clickRegisterButton();
    if (!mp.get("Expected").equalsIgnoreCase("Success")) {
      assertEquals(new RegistrationPage().getErrorMessageText(), mp.get("Expected"));
    } else {
      assertEquals(accountPage.getPageTitle(), EXPECTED_MYACCOUNT_PAGE_TITLE);
    }
  }
}
