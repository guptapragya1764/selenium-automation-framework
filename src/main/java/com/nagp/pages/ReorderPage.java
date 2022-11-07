package com.nagp.pages;

import static com.nagp.enums.WaitStrategy.CLICKABLE;
import static com.nagp.enums.WaitStrategy.NONE;
import static com.nagp.enums.WaitStrategy.VISIBLE;
import static com.nagp.utils.JavaUtils.waitTill;

import org.openqa.selenium.By;

public class ReorderPage extends BasePage {

  private final By linkReorder = By.xpath("//*[@title='Reorder']");
  private final By linkProceedToCheckout = By.xpath(
      "//*[@class='cart_navigation clearfix']/*[@title='Proceed to checkout']");
  private final By buttonProceedToCheckoutAddress = By.name("processAddress");
  private final By checkboxTermsAndConditions = By.xpath("//input[@type='checkbox']");
  private final By buttonProceedToCheckoutCarrier = By.name("processCarrier");
  private final By linkPaymentByCheque = By.xpath("//*[@class='cheque']");
  private final By buttonForOrderConfirmation = By.xpath("//span[text()='I confirm my order']");
  private final By textOrderSuccesAlert = By.cssSelector(".alert.alert-success");

  public ReorderPage clickReorderLink() {
    click(linkReorder, CLICKABLE, "Reorder Link");
    return this;
  }

  public ReorderPage clickProceedToCheckoutLink() {
    click(linkProceedToCheckout, CLICKABLE, "Proceed To Checkout Link");
    return this;
  }

  public ReorderPage clickProceedToCheckoutAddressButton() {
    click(buttonProceedToCheckoutAddress, CLICKABLE, "Proceed To Checkout Address Button");
    return this;
  }

  public ReorderPage clickTermsAndConditionsCheckbox() {
    waitTill(8);
    click(checkboxTermsAndConditions, NONE, "Terms And Conditions Checkbox");
    return this;
  }

  public ReorderPage clickProceedToCheckoutCarrierButton() {
    click(buttonProceedToCheckoutCarrier, CLICKABLE, "Proceed To Checkout Carrier Button");
    return this;
  }

  public ReorderPage clickPaymentByChequeLink() {
    click(linkPaymentByCheque, CLICKABLE, "Payment By Cheque Link");
    return this;
  }

  public ReorderPage clickOrderConfirmationButton() {
    click(buttonForOrderConfirmation, CLICKABLE, "Order Confirmation Button");
    return this;
  }

  public String getOrderSuccessAlertText() {
    return getText(textOrderSuccesAlert, VISIBLE, "Order Success Alert");
  }
}
