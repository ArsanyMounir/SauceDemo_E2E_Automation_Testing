package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UiActions {
    WebDriver driver;

    public enum locatorsENUM{
        ID,
        CLASSNAME,
        XPATH,
        CSS
    }
    private By getElementLocator(locatorsENUM locator , String selector)
    {
        switch (locator)
        {
            case ID:    return new By.ById(selector);
            case CLASSNAME: return new By.ByClassName(selector);
            case XPATH: return new By.ByXPath(selector);
            case CSS:   return new By.ByCssSelector(selector);
            default:    return null;
        }
    }

    public enum waitConditionENUM{
        VISIBLE,
        CLICKABLE
    }

    public UiActions()
    {
        this.driver = BrowserActions.getDriver();
    }

    public void navigateTo(String URL){
        driver.get(URL);
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }

    public WebElement getElement(locatorsENUM locator , String selector){
        return driver.findElement(getElementLocator(locator,selector));
    }

    public List<WebElement> getElements(locatorsENUM locator , String selector){
        return driver.findElements(getElementLocator(locator,selector));
    }

    public void clickElement(locatorsENUM locator , String selector){
       getElement(locator,selector).click();
    }

    public void writeInTextField(locatorsENUM locator , String selector ,String text){
        getElement(locator,selector).sendKeys(text);
    }

    public String getText(locatorsENUM locator , String selector){
        return getElement(locator ,selector).getText();
    }





    public List<String> getStringList(locatorsENUM locator , String selector)
    {
        List <WebElement> webList = getElements(locator,selector);

        List <String> returnList = new ArrayList<String>();

        for(int i =0;i<webList.size();i++)
        {
            returnList.add(webList.get(i).getText()) ;
        }

        return returnList;

    }

    public void clickElementDynamic(locatorsENUM locator , String selector,String dynamicLocatorString)
    {
        if(driver.findElement(getElementLocator(locator,String.format(selector,dynamicLocatorString))).getText().contains("ADD"))
            driver.findElement(getElementLocator(locator,String.format(selector,dynamicLocatorString))).click();
    }




    public String getText(String locator){
        return driver.findElement(By.xpath(locator)).getText();
    }

}
