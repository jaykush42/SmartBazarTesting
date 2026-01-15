package Pages;

import Browser.Browser;
import Locators.ProductDetailsPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends Browser {

    ProductDetailsPageObjects productDetailsPageObjects;

    public ProductDetailsPage(){
        productDetailsPageObjects = new ProductDetailsPageObjects();
    }

    public String getProductDetail(String detail){
      //  System.out.println(driver.getCurrentUrl());
        String productDetail = "NULL";
        try{
            WebElement details = productDetailsPageObjects.productSummaryDetails;
            if(detail.equalsIgnoreCase("title"))
                productDetail = details.findElement(By.tagName("h1")).getText();
            else if (detail.equalsIgnoreCase("price")) {
                productDetail = details.findElement(By.className("price")).getText();
            }
        }
        catch (Exception e){
            System.out.println("Error while getting product details");
        }
        return productDetail;
    }

}
