import Browser.Browser;
import Pages.HomePage;
import Browser.Utility;
import Pages.ProductDetailsPage;
import Pages.ProductsListPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetRicePriceTest {

    @BeforeTest
    public void beforeTest() throws Exception{
        String browserData = Utility.properties("browser");
        Browser.openBrowser(browserData);
        Browser.navigate(Utility.properties("title"));
    }
    @Test
    public void GetRicePriceTest(){

        HomePage homePage = new HomePage();

        homePage.closePopUp();
        homePage.searchOnHomePage("Rice");

        ProductsListPage productsListPage = new ProductsListPage();
        //String productName = "Clay Pongal Pot Pack (White Rice)";
        String productName = "Native Foods Poongar Rice (500g)";
        productsListPage.getProduct(productName);

        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        String foundName = productDetailsPage.getProductDetail("title");
        String foundPrice = productDetailsPage.getProductDetail("price");
        System.out.println(foundName);
        System.out.println(foundPrice);

        Assert.assertEquals(foundName,productName);
        Assert.assertEquals(foundPrice,"£1.89");
    }

    @AfterTest
    public void afterTest(){
        Browser.closeBrowser();
    }
}
