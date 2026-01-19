package testCase;

import Browser.Browser;
import Pages.HomePage;
import Browser.Utility;
import Pages.ProductDetailsPage;
import Pages.ProductsListPage;
import Utils.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetRicePriceTest {

    @DataProvider(name = "riceData")
    public Object[][] getData() throws Exception {
        // Ensure the path and sheet name are correct
        return Utils.ExcelReader.readExcel("testData1.xlsx","Products");
    }

    @BeforeMethod
    public void beforeTest() throws Exception {
        String browserData = Utility.properties("browser");
        Browser.openBrowser(browserData);  // Assuming the Browser class is thread-safe
        Browser.navigate(Utility.properties("title"));
    }

    @Test(dataProvider = "riceData")
    public void getRicePriceTest(String testCase, String searchItem, String productName, String expectedPrice) {
        HomePage homePage = new HomePage();

       // homePage.closePopUp();
        homePage.searchOnHomePage(searchItem);

        ProductsListPage productsListPage = new ProductsListPage();
        productsListPage.getProduct(productName);

        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        String foundName = productDetailsPage.getProductDetail("title");
        String foundPrice = productDetailsPage.getProductDetail("price");

        System.out.println("TestCase: " + testCase);
        System.out.println("Product: " + foundName + " - Price: " + foundPrice);

        Assert.assertEquals(foundName, productName);
        Assert.assertEquals(foundPrice, expectedPrice);
    }

    @AfterMethod
    public void afterTest() {
        Browser.closeBrowser();  // Close the browser after each test method
    }
}
