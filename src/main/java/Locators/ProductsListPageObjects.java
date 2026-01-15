package Locators;
import Browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsListPageObjects extends Browser {

    public ProductsListPageObjects(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//main[@role='main']")
    public WebElement mainContainerElement;

    @FindAll(@FindBy(xpath = "//main[@role='main']/ul/li"))
    public List<WebElement> productList;
}
