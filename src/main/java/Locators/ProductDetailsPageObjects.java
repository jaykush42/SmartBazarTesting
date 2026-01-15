package Locators;

import Browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPageObjects extends Browser {

    public ProductDetailsPageObjects()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class=\"row m-0 add-shadow\"]")
    public WebElement productContainerElement;

    @FindBy(xpath = "//div[@class=\"product-summary\"]")
    public WebElement productSummaryDetails;

}
