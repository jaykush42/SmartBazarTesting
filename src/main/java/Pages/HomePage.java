package Pages;

import Browser.Browser;
import Locators.HomePageObjects;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.beans.Visibility;

public class HomePage extends Browser {
    HomePageObjects homePageObjects;
    public HomePage(){
        homePageObjects = new HomePageObjects();
    }

    public void closePopUp(){
       try {
           wait.until(ExpectedConditions.visibilityOf(homePageObjects.popUp1));
           wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.popUp1));
           homePageObjects.popUp1.click();
       } catch (Exception e) {
           System.out.println("Error while closing the Pop Up" + e);
       }
    }

    public void searchOnHomePage(String value){
       try {
           wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.searchBoxInput));
           homePageObjects.searchBoxInput.sendKeys(value);

           wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.searchButton));
           homePageObjects.searchButton.click();
        //   Thread.sleep(5000);
       } catch (Exception e) {
           System.out.println("Error while Searching"+e);
       }
    }
}
