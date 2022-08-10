package com.nagp.pages;

import com.nagp.enums.WaitStrategy;
import java.util.List;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {

  private final By getDressName = By.xpath("//*[@itemprop='name']");

  public List<String> getSearchResult() {
    return getTextForElements(getDressName, WaitStrategy.VISIBLE, "Dress Name");

  }
}
