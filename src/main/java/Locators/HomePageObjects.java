package Locators;

import Browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects extends Browser {

    public HomePageObjects(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//div[@class='brave_popup__close__button'])[1]")
   public WebElement popUp1;

    @FindBy(xpath = "//input[@type=\"search\"]")
   public WebElement searchBoxInput;

    @FindBy(xpath = "//span[@class=\"aws-search-btn_icon\"]")
   public WebElement searchButton;

}
