package Pages;

import Browser.Browser;
import Locators.ProductsListPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ProductsListPage extends Browser {
    ProductsListPageObjects productsListPageObjects;

    public ProductsListPage(){
        productsListPageObjects = new ProductsListPageObjects();
    }

    public void getProduct(String name){

        try {
           wait.until(ExpectedConditions.visibilityOf(productsListPageObjects.mainContainerElement));
            wait.until(ExpectedConditions.visibilityOfAllElements(productsListPageObjects.productList));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);",productsListPageObjects.mainContainerElement);

            Thread.sleep(5000);
            List<WebElement> productsList = productsListPageObjects.productList;
            for(WebElement product: productsList){
           //     System.out.println(product.getText());
                if(product.getText().contains(name)){
                    wait.until(ExpectedConditions.visibilityOf(product));
                    js.executeScript("arguments[0].scrollIntoView(true);",product);
                    wait.until(ExpectedConditions.visibilityOf(product.findElement(By.tagName("img"))));
                    product.findElement(By.tagName("img")).click();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while getting product"+e);
        }
    }

    public List<String> getProductList(){
        List<String> productList = new ArrayList<>();
        for(WebElement product: productsListPageObjects.productList)
        productList.add(product.getText());

        return productList;
    }
}
