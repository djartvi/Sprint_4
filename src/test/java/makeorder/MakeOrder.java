package makeorder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.MainPage;

import java.time.Duration;

public class MakeOrder {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void orderFromHeaderButton() {
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open();




//        WebElement select = driver.findElement(By.className("select-search__input"));
//        select.sendKeys("Кунцевская");
//        select.sendKeys(Keys.DOWN);
//        select.sendKeys(Keys.ENTER);

    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}