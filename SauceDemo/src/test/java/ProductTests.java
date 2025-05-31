import Actions.BrowserActions;
import POM.LoginPage;
import POM.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductTests {
    @BeforeMethod
    public void setup() {
        BrowserActions.initChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        BrowserActions.quitChromeDriver();
    }

    @Test(dataProvider = "productName")
    public void addProductsToCartStandardUser(String productName){
        String expectedURL = "https://www.saucedemo.com/v1/cart.html";
        LoginPage login = new LoginPage();
        login.navigateToLoginPage();
        login.setUsername("standard_user");
        login.setPassword("secret_sauce");
        ProductsPage product = login.clickLogin();

        product.addItemToCart(productName);
        Assert.assertEquals(product.getCartNumber(),"1","Item not added");
        product.clickOnCartButton();
        Assert.assertEquals(product.getPageURL(),expectedURL,"Cart button didn't click");
    }


    @DataProvider(name= "productName")
    public String[] getProductName(){
        return new String[] {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket",
        "Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"};

    }


}
