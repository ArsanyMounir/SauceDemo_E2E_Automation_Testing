package POM;

import Actions.BrowserActions;
import Actions.UiActions;


public class LoginPage {
    String loginURL = "https://www.saucedemo.com/v1/";
    BrowserActions browserAct;
    UiActions uiAct;

    String usernameLoc = "user-name";
    String passwordLoc = "password";
    String loginButtonLoc = "login-button";
    String errorMessage = "//h3[@data-test='error']";

    public LoginPage()
    {
        uiAct = new UiActions();
    }

    public void navigateToLoginPage()
    {

        uiAct.navigateTo(loginURL);
    }

    public void setUsername(String username)
    {
        uiAct.writeInTextField(UiActions.locatorsENUM.ID,usernameLoc,username);
    }

    public void setPassword(String password)
    {
        uiAct.writeInTextField(UiActions.locatorsENUM.ID,passwordLoc,password);
    }

    public ProductsPage clickLogin(){
        uiAct.clickElement(UiActions.locatorsENUM.ID,loginButtonLoc);
        return new ProductsPage();
    }

    public String getPageURL(){
        return uiAct.getPageURL();

    }
    public String getErrorMessage(){
        return uiAct.getText(UiActions.locatorsENUM.XPATH,errorMessage);
    }





}
