package com.nagp.pages;

import static com.nagp.enums.WaitStrategy.VISIBLE;

import org.openqa.selenium.By;

public class CreditSlipsPage extends BasePage {

  public final By textAlert = By.cssSelector(".alert.alert-warning");

  public String getAlertText() {
    return getText(textAlert, VISIBLE, "Credit Slip Alert");
  }
}
