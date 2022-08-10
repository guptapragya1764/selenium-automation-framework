package com.nagp.pages;

import static com.nagp.enums.WaitStrategy.CLICKABLE;
import static com.nagp.enums.WaitStrategy.NONE;
import static com.nagp.enums.WaitStrategy.PRESENCE;
import static com.nagp.enums.WaitStrategy.VISIBLE;
import static com.nagp.factory.WaitFactory.waitForAjax;
import static com.nagp.utils.JavaUtils.waitTill;
import static java.lang.Double.parseDouble;
import static java.util.stream.Collectors.toList;

import java.util.List;
import org.openqa.selenium.By;

public final class DressPage extends BasePage {

  private final By textAllDressPrices = By.xpath(
      "//div[@class='right-block']//span[@itemprop='price']");
  private final By dropdownSortBy = By.id("selectProductSort");
  private final By linkDressProduct = By.xpath("(//a[@class='product_img_link']//img)[1]");
  private final By linkDressProductAddToCart = By.xpath(
      "(//a[contains(@class,'button ajax_add_to_cart_button')]//span)[1]");
  private final By textSuccesfulAddToCartMessage = By.xpath("//i[@class='icon-ok']/parent::h2");

  public DressPage selectSortByCategory(String category) {
    waitTill(10);
    select(dropdownSortBy, NONE, category);
    return this;
  }

  public List<String> getPriceForAllDresses() {
    waitForAjax();
    return getTextForElements(textAllDressPrices, PRESENCE, "Dress Price");
  }

  public DressPage hoverDressProductLink() {
    moveTElement(linkDressProduct, CLICKABLE, "Dress Product");
    return this;
  }

  public DressPage clickDressProductAddToCartLink() {
    waitForAjax();
    click(linkDressProductAddToCart, CLICKABLE, "Add to Cart link Of Dress Product");
    return this;
  }

  public String getTextFromSuccessfulAddToCartMessage() {
    return getText(textSuccesfulAddToCartMessage, VISIBLE, "Successful Add To Cart");
  }

  public List<Double> getPricesSortByOption(String sortByOption) {
    return new HomePage().clickDressesLink()
        .selectSortByCategory(sortByOption).getPriceForAllDresses()
        .stream().map(price -> parseDouble(price.substring(1))).collect(toList());

  }
}
