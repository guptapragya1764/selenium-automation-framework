package com.nagp.tests;

import com.nagp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {

  @Test(description = "Validate all the the search result should have the keyword for which search "
      + "is performed", groups = {"Sanity"}, testName = "Search result validation")
  public void validateSearchResult() {
    new HomePage().enterQueryInSearchBox("Printed").clickSearchButton().getSearchResult()
        .forEach(element -> Assert.assertTrue(element.contains("Printed")));
  }
}
