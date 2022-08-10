package com.nagp.tests;

import static com.nagp.constants.MessageConstants.ASSERT_MESSAGE;
import static com.nagp.constants.MessageConstants.EXPECTED_ADDTOCART_SUCCESS_MESSAGE;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import com.nagp.pages.DressPage;
import com.nagp.pages.HomePage;
import java.util.List;
import org.testng.annotations.Test;

public final class DressPageTest extends BaseTest {

  private DressPageTest() {
  }

  @Test(description = "Validate the SortBy Filter option 'Price: Lowest first' for Dresses", groups = {
      "Sanity"}, testName = "SortBy Filter validation for Dress")
  public void validateSortByPriceLowestFirst() {
    List<Double> actualPriceList = new DressPage().getPricesSortByOption("Price: Lowest first");
    List<Double> expectedPriceList = actualPriceList.stream().sorted().collect(toList());
    boolean result = expectedPriceList.equals(actualPriceList);
    assertTrue(result, format(ASSERT_MESSAGE, expectedPriceList, actualPriceList));
  }

  @Test(description = "Validate user is able to add the dress to the cart successfully", groups = {
      "Sanity"}, testName = "Validation for Add To Cart Success")
  public void verifySuccessfulAddToCart() {
    String actualMessage = new HomePage().clickDressesLink().hoverDressProductLink()
        .clickDressProductAddToCartLink()
        .getTextFromSuccessfulAddToCartMessage().trim();
    assertEquals(actualMessage, EXPECTED_ADDTOCART_SUCCESS_MESSAGE);

  }

}
