package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BrowserActions {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void initChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driverThreadLocal.set(new ChromeDriver(options));
    }

    public static void quitChromeDriver(){
        driverThreadLocal.get().quit();
    }

    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }


}
