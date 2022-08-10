package com.nagp.pages;

import static com.nagp.enums.WaitStrategy.CLICKABLE;
import static com.nagp.enums.WaitStrategy.VISIBLE;

import com.nagp.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class MyAccountPage extends BasePage {

  public final By linkCreditSlips = By.xpath("//a[@title='Credit slips']");
  public final By linkOrderHistory = By.xpath("//a[@title='Orders']");

  public CreditSlipsPage clickCreditSlipsLink() {
    click(linkCreditSlips, CLICKABLE, "Credit Slip Link");
    return new CreditSlipsPage();
  }

  public ReorderPage clickOrderDetailsLink() {
    click(linkOrderHistory, CLICKABLE, "Order Details Link");
    return new ReorderPage();
  }

  public boolean isOrderDetailsLinkDisplayed() {
    return isDisplayed(linkOrderHistory, VISIBLE, "Order Details Link");
  }
}
