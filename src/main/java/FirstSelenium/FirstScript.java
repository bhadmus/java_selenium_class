package FirstSelenium;

import ElementMappers.Selectors;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstScript {

    private WebDriver driver;
    Selectors sel;


    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(sel.homePage);
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(sel.loginButton)));

    }

    public void accessSauceDemo(String username, String password){
        driver.findElement(By.cssSelector(sel.usernameField)).sendKeys(username);
        driver.findElement(By.cssSelector(sel.passwordField)).sendKeys(password);
        driver.findElement(By.cssSelector(sel.loginButton)).click();
    }

    public void terminateSession(){

        driver.quit();
    }


}
