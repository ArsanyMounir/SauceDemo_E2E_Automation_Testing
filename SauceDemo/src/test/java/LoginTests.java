import Actions.BrowserActions;
import POM.LoginPage;

import org.testng.annotations.*;
import org.testng.Assert;


public class LoginTests {

    @BeforeMethod
    public void setup() {
        BrowserActions.initChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        BrowserActions.quitChromeDriver();
    }

    @Test(dataProvider = "userName")
    public void testValidLogin(String userName){
        String expectedURL = "https://www.saucedemo.com/v1/inventory.html";
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.setUsername(userName);
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        String actualURL = loginPage.getPageURL();
        Assert.assertEquals(actualURL,expectedURL,"Login failed");
    }

    @Test
    public void testLockedUserLogin(){
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.setUsername("locked_out_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(),expectedErrorMessage,"Wronge Error message");

    }

    @DataProvider(name = "userName",parallel = true)
    public String[] getUserNames(){
        return new String[]{"standard_user","problem_user","performance_glitch_user"};
    }






}
