package com.nagp.pages;

import static com.nagp.enums.WaitStrategy.CLICKABLE;
import static com.nagp.enums.WaitStrategy.VISIBLE;

import org.openqa.selenium.By;

public final class SignInPage extends BasePage {

  public final By textboxUsername = By.id("email");
  public final By textboxPassword = By.id("passwd");
  public final By buttonSignIn = By.id("SubmitLogin");
  public final By textboxEmail = By.id("email_create");
  public final By buttonCreateAnAccount = By.id("SubmitCreate");

  public SignInPage enterUsernameInTextBox(String username) {
    sendKeys(textboxUsername, username, VISIBLE, "Username field");
    return this;
  }

  public SignInPage enterPasswordInTextBox(String password) {
    sendKeys(textboxPassword, password, VISIBLE, "Password field");
    return this;
  }

  public MyAccountPage clickSignInButton() {
    click(buttonSignIn, CLICKABLE, "Sign in button");
    return new MyAccountPage();
  }

  public SignInPage enterEmailInTextBox(String email) {
    sendKeys(textboxEmail, email, VISIBLE, "Email field");
    return this;
  }

  public RegistrationPage clickCreateAnAccountButton() {
    click(buttonCreateAnAccount, CLICKABLE, "Create An Account button");
    return new RegistrationPage();
  }
}
