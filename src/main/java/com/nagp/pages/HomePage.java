package com.nagp.pages;

import static com.nagp.enums.WaitStrategy.CLICKABLE;
import static com.nagp.enums.WaitStrategy.VISIBLE;

import org.openqa.selenium.By;

public final class HomePage extends BasePage {

  public final By linkSignIn = By.linkText("Sign in");
  public final By linkDresses = By.linkText("DRESSES");
  public final By textboxSearch = By.id("search_query_top");
  public final By buttonSearch = By.name("submit_search");

  public boolean isSignInLinkDisplayed() {
    return isDisplayed(linkSignIn, VISIBLE, "Sign in Link");
  }

  public SignInPage clickSignInLink() {
    click(linkSignIn, CLICKABLE, "Sign in Link");
    return new SignInPage();
  }

  public DressPage clickDressesLink() {
    click(linkDresses, VISIBLE, "Dresses link");
    return new DressPage();
  }

  public HomePage enterQueryInSearchBox(String searchQuery) {
    sendKeys(textboxSearch, searchQuery, VISIBLE, "Search Box");
    return this;
  }

  public SearchPage clickSearchButton() {
    click(buttonSearch, CLICKABLE, "Search Button");
    return new SearchPage();
  }
}
