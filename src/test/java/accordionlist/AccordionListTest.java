package accordionlist;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.MainPage;

import java.time.Duration;

public class AccordionListTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void orderFromHeaderButton() {
        MainPage mainPage = new MainPage(driver);

        String text = "Сколько это стоит? И как оплатить?";
        String text2 = "Некоторый текст";

        mainPage.open();
        mainPage.clickAcceptCookieButton();
        mainPage.scrollToElement(mainPage.getAccordionList());
        mainPage.clickAccordionButton(text);
        mainPage.clickAccordionButton(text2);
        System.out.println(mainPage.accordionButton.toString());

    }
}
