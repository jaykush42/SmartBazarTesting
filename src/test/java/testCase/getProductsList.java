package testCase;

import Browser.Browser;
import Pages.HomePage;
import Browser.Utility;
import Pages.ProductsListPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class getProductsList {

    @BeforeTest
    public void beforeTest() throws Exception{
        String browserData = Utility.properties("browser");
        Browser.openBrowser(browserData);
        Browser.navigate(Utility.properties("title"));
    }
    @Test
    public void getProductList(){

        HomePage homePage = new HomePage();

       // homePage.closePopUp();
        homePage.searchOnHomePage("Rice");

        ProductsListPage productsListPage = new ProductsListPage();
        productsListPage.getProductList();
    }

    @AfterTest
    public void afterTest(){
        Browser.closeBrowser();
    }
}
