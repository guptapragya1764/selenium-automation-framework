package com.nagp.tests;

import static com.nagp.constants.MessageConstants.EXPECTED_HOME_PAGE_PAGE_TITLE;
import static org.testng.AssertJUnit.assertEquals;

import com.nagp.pages.HomePage;
import org.testng.annotations.Test;

public final class HomePageTest extends BaseTest {

  private HomePageTest() {

  }

  @Test(description = "Validate the title of Home Page", groups = {
      "Smoke"}, testName = "Home Page title validation")
  public void validateHomePageTitle() {
    assertEquals(new HomePage().getPageTitle(), EXPECTED_HOME_PAGE_PAGE_TITLE);
  }


}
