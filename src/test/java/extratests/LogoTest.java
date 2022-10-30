package extratests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.ClientDetailsPage;
import pom.MainPage;
import pom.YandexPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LogoTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void scooterLogoTest() {
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .clickAcceptCookieButton()
                .clickMakeOrderButton(true);

        ClientDetailsPage clientDetailsPage = new ClientDetailsPage(driver);

        clientDetailsPage.clickScooterLogoButton();

        assertTrue(mainPage.getAccordionElement("Сколько это стоит? И как оплатить?").isDisplayed());
    }

    @Test
    public void yandexLogoTest() {
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .clickAcceptCookieButton()
                .clickYandexLogoButton();

        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));

        YandexPage yandexPage = new YandexPage(driver);

        assertTrue(yandexPage.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}