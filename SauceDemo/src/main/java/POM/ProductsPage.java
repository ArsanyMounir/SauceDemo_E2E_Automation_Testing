package POM;

import Actions.UiActions;

import java.util.List;

public class ProductsPage {
    UiActions uiAct;

    String productPageURL = "https://www.saucedemo.com/v1/inventory.html";
    String itemsLoc = "inventory_item_name";
    String addToCartBtnLoc = "//div[contains(text(),'%s')]//ancestor::div[@class='inventory_item']//button";
    String cartButton = "//a[@class='shopping_cart_link fa-layers fa-fw']";
    String cartNumber = "//span[@class='fa-layers-counter shopping_cart_badge']";
    public ProductsPage() {
        uiAct = new UiActions();
    }

    public void navigateToProductsPage(){
        uiAct.navigateTo(productPageURL);
    }

    public String getPageURL(){
        return uiAct.getPageURL();
    }


    public boolean addItemToCart(String itemName)
    {
        int i;
        List<String> itemList = uiAct.getStringList(UiActions.locatorsENUM.CLASSNAME,itemsLoc);

        for(i = 0;i<itemList.size();i++)
        {
            if(itemList.get(i).equals(itemName))
            {
                uiAct.clickElementDynamic(UiActions.locatorsENUM.XPATH,addToCartBtnLoc,itemName);
                return true;
            }
        }
        return false;

    }

    public CartPage clickOnCartButton(){
        uiAct.clickElement(UiActions.locatorsENUM.XPATH,cartButton);
        return new CartPage();
    }

    public String getCartNumber(){
        return uiAct.getText(UiActions.locatorsENUM.XPATH,cartNumber);
    }

}
