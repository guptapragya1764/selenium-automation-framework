package com.nagp.pages;

import static com.nagp.constants.MessageConstants.CLICKED_MESSAGE;
import static com.nagp.constants.MessageConstants.DISPLAYED_MESSAGE;
import static com.nagp.constants.MessageConstants.DROPDOWN_SELECTION_INDEX_MESSAGE;
import static com.nagp.constants.MessageConstants.HOVERED_MESSAGE;
import static com.nagp.constants.MessageConstants.NOT_DISPLAYED_MESSAGE;
import static com.nagp.constants.MessageConstants.TEXT_RETRIEVED_MESSAGE;
import static com.nagp.constants.MessageConstants.TITLLE_VISIBILITY_INDEX_MESSAGE;
import static com.nagp.constants.MessageConstants.VALUE_ENTERED_MESSAGE;
import static com.nagp.driver.DriverManager.getDriver;
import static com.nagp.factory.LoggerFactory.info;
import static com.nagp.factory.WaitFactory.explicitWaitElement;
import static com.nagp.factory.WaitFactory.explicitWaitListOfElement;
import static com.nagp.reports.ExtentReportLogger.fail;
import static com.nagp.reports.ExtentReportLogger.pass;
import static java.lang.String.format;

import com.nagp.constants.MessageConstants;
import com.nagp.enums.WaitStrategy;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

  protected BasePage() {
  }

  /**
   * Locates element by given wait strategy, performs the select operation on {@link
   * org.openqa.selenium.WebElement} based on dropdown visible text and writes the pass to the
   * extent report and log info in logger.
   *
   * @param by           {@link org.openqa.selenium.By} instance, Locator of the webelement
   * @param waitStrategy Strategy to find webelement. Known  strategies {@link
   *                     com.nagp.enums.WaitStrategy}
   * @param visibleText  visible text of dropdown option to be selected
   */
  protected void select(By by, WaitStrategy waitStrategy, String visibleText) {
    new Select(scrollIntoElement(by, waitStrategy)).selectByVisibleText(visibleText);
    String message = visibleText + " is selected from dropdown";
    pass(message);
    info(message);
  }

  /**
   * Locates element by given wait strategy, performs the select operation on located {@link
   * org.openqa.selenium.WebElement} based on dropdown option index and writes the pass even to the
   * extent report and log info in logger
   *
   * @param by           {@link org.openqa.selenium.By} instance, Locator of the webelement.
   * @param waitStrategy Strategy to find webelement. Known  strategies {@link
   *                     com.nagp.enums.WaitStrategy}
   * @param index        index of dropdown option to be selected.
   */
  protected void select(By by, WaitStrategy waitStrategy, int index) {
    new Select(scrollIntoElement(by, waitStrategy)).selectByIndex(index);
    String message = format(DROPDOWN_SELECTION_INDEX_MESSAGE, index);
    pass(message);
    info(message);

  }

  /**
   * @return Page title of the webpage where the selenium is currently interacting.
   */
  public String getPageTitle() {
    String title = getDriver().getTitle();
    String message = format(TITLLE_VISIBILITY_INDEX_MESSAGE, title);
    pass(message);
    info(message);
    return title;
  }

  /**
   * Locates element by given wait strategy and scrolls to element into the visible area of the
   * browser window then writes the pass even to the extent report and log info in logger.
   *
   * @param by           {@link org.openqa.selenium.By} instance, Locator of the webelement.
   * @param waitStrategy Strategy to find webelement. Known  strategies {@link
   *                     com.nagp.enums.WaitStrategy}
   * @return {@link org.openqa.selenium.By} instance.
   */
  public WebElement scrollIntoElement(By by, WaitStrategy waitStrategy) {
    WebElement element = explicitWaitElement(by, waitStrategy);
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    return element;
  }

  /**
   * Locates element by given wait strategy and then hovers on element then writes the pass even to
   * the extent report and log info in logger.
   *
   * @param by           {@link org.openqa.selenium.By} instance, Locator of the webelement.
   * @param waitStrategy Strategy to find webelement. Known  strategies {@link
   *                     com.nagp.enums.WaitStrategy}
   */
  public void moveTElement(By by, WaitStrategy waitStrategy, String elementName) {
    new Actions(getDriver()).moveToElement(scrollIntoElement(by, waitStrategy)).build().perform();
    String message = format(HOVERED_MESSAGE, elementName);
    pass(message);
    info(message);
  }


  /**
   * Locates element by given wait strategy, performs the clicking operation on {@link
   * org.openqa.selenium.WebElement} and writes the pass to the extent report and log info in
   * logger.
   *
   * @param by           {@link org.openqa.selenium.By} instance, Locator of the webelement.
   * @param waitStrategy Strategy to find webelement. Known  strategies {@link
   *                     com.nagp.enums.WaitStrategy}
   * @param elementName  Name of the element that needs to be logged in the report.
   */
  protected void click(By by, WaitStrategy waitStrategy, String elementName) {
    scrollIntoElement(by, waitStrategy).click();
    String message = format(CLICKED_MESSAGE, elementName);
    pass(message);
    info(message);
  }

  /**
   * Locates element by given wait strategy, sends the value to located {@link
   * org.openqa.selenium.WebElement} and writes the pass even to the extent report and log info in
   * logger.
   *
   * @param by           {@link org.openqa.selenium.By} instance, Locator of the webelement.
   * @param value        value to be send the text box
   * @param waitStrategy Strategy to find webelement. Known  strategies {@link
   *                     com.nagp.enums.WaitStrategy}
   * @param elementName  Name of the element that needs to be logged in the report.
   */
  protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
    scrollIntoElement(by, waitStrategy).sendKeys(value);
    String message = format(VALUE_ENTERED_MESSAGE, value, elementName);
    pass(message);
    info(message);
  }

  /**
   * Locates element by given wait strategy, gives the text of located {@link
   * org.openqa.selenium.WebElement} and writes the pass even to the extent report and log info in
   * logger
   *
   * @param by           {@link org.openqa.selenium.By} instance, Locator of the webelement.
   * @param waitStrategy Strategy to find webelement. Known  strategies {@link
   *                     com.nagp.enums.WaitStrategy}
   * @param elementName  Name of the element that needs to be logged in the report
   */

  protected String getText(By by, WaitStrategy waitStrategy, String elementName) {
    String text = scrollIntoElement(by, waitStrategy).getText();
    String message = format(TEXT_RETRIEVED_MESSAGE, elementName);
    pass(message);
    info(message);
    return text;
  }

  /**
   * Locates element by given wait strategy, checks whether {@link org.openqa.selenium.WebElement}
   * is displayed or not and writes the pass even to the extent report
   *
   * @param by           {@link org.openqa.selenium.By} instance, Locator of the webelement.
   * @param waitStrategy Strategy to find webelement. Known  strategies {@link
   *                     com.nagp.enums.WaitStrategy}
   * @param elementName  Name of the element that needs to be logged in the report
   */
  protected boolean isDisplayed(By by, WaitStrategy waitStrategy, String elementName) {
    boolean result = scrollIntoElement(by, waitStrategy).isDisplayed();

    String message = format(DISPLAYED_MESSAGE, elementName);
    if (result) {
      pass(message);
      info(message);
    } else {
      fail(format(NOT_DISPLAYED_MESSAGE, elementName));
    }
    return result;
  }

  /**
   * Locates element by given wait strategy, gives the text list of located {@link
   * org.openqa.selenium.WebElement} and writes the pass even to the extent report and log info in
   * logger
   *
   * @param by           {@link org.openqa.selenium.By} instance, Locator of the webelement.
   * @param waitStrategy Strategy to find webelement. Known  strategies {@link
   *                     com.nagp.enums.WaitStrategy}
   * @param elementName  Name of the element that needs to be logged in the report
   */
  public List<String> getTextForElements(By by, WaitStrategy waitStrategy, String elementName) {
    List<String> elementsText = explicitWaitListOfElement(by, waitStrategy).stream()
        .map(webElement -> webElement.getText().trim())
        .collect(Collectors.toList());
    String message = format(TEXT_RETRIEVED_MESSAGE, elementName);
    pass(message);
    info(message);
    return elementsText;
  }


}
