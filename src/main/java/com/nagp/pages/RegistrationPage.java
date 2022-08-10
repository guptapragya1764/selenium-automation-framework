package com.nagp.pages;

import static com.nagp.enums.WaitStrategy.CLICKABLE;
import static com.nagp.enums.WaitStrategy.NONE;
import static com.nagp.enums.WaitStrategy.VISIBLE;
import static com.nagp.utils.JavaUtils.waitTill;

import org.openqa.selenium.By;

public final class RegistrationPage extends BasePage {

  private final By textboxFirstName = By.id("customer_firstname");
  private final By textboxLastName = By.id("customer_lastname");
  private final By textboxPassword = By.id("passwd");
  private final By textboxAddr1 = By.id("address1");
  private final By textboxCity = By.id("city");
  private final By selectState = By.id("id_state");
  private final By textboxPostcode = By.id("postcode");
  private final By textboxMobile = By.id("phone_mobile");
  private final By buttonRegister = By.id("submitAccount");
  private final By textErrorMessage = By.cssSelector(".alert.alert-danger li");

  public RegistrationPage enterFirstNameInTextBox(String firstName) {
    sendKeys(textboxFirstName, firstName, VISIBLE, "First Name field");
    return new RegistrationPage();
  }

  public RegistrationPage enterLastNameInTextBox(String lastName) {
    sendKeys(textboxLastName, lastName, VISIBLE, "Last Name field");
    return new RegistrationPage();
  }

  public RegistrationPage enterPasswordInTextBox(String password) {
    sendKeys(textboxPassword, password, VISIBLE, "Password field");
    return new RegistrationPage();
  }

  public RegistrationPage enterAddress1InTextBox(String addr1) {
    sendKeys(textboxAddr1, addr1, VISIBLE, "Address1 field");
    return new RegistrationPage();
  }

  public RegistrationPage enterCityInTextBox(String city) {
    sendKeys(textboxCity, city, VISIBLE, "City field");
    return new RegistrationPage();
  }

  public RegistrationPage selectStateFromDropdown(String state) {
    waitTill(11);
    select(selectState, NONE, state);
    return new RegistrationPage();
  }

  public RegistrationPage enterZipInTextBox(String zip) {
    sendKeys(textboxPostcode, zip, VISIBLE, "Postal Code field");
    return new RegistrationPage();
  }

  public RegistrationPage enterMobileNumberInTextBox(String mobileNumber) {
    sendKeys(textboxMobile, mobileNumber, VISIBLE, "Mobile Number field");
    return new RegistrationPage();
  }

  public MyAccountPage clickRegisterButton() {
    click(buttonRegister, CLICKABLE, "Register Button");
    return new MyAccountPage();
  }

  public String getErrorMessageText() {
    return getText(textErrorMessage, VISIBLE, "Error Message");
  }

}
