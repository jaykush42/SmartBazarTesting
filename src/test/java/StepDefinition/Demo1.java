package StepDefinition;

import Browser.Browser;
import Pages.HomePage;
import Pages.ProductsListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    List<String> productList;
    @Given("Open the browser")
    public void open_the_browser() throws Exception {
        Browser.openBrowser("Chrome");
    }
    @When("User enters the URL")
    public void user_enters_the_url() throws Exception {
       Browser.navigate("Smartbazaar - Home");
    }
    @Then("user verifies the {string} title")
    public void user_verifies_the_title(String string) {
        System.out.println("verifying the title");
    }

    @And("User enters the data {string} of the product")
    public void user_enters_the_data_of_the_product(String string) {
        HomePage homePage = new HomePage();

        // homePage.closePopUp();
        homePage.searchOnHomePage(string);

        ProductsListPage productsListPage = new ProductsListPage();
        productList = new ArrayList<>();
        productList = productsListPage.getProductList();
    }
    @Then("User verifies the result")
    public void user_verifies_the_result() {
      for(String product: productList)
          System.out.println(product);
    }


}
