package makeorder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.MainPage;
import pom.ClientDetailsPage;
import pom.OrderConfirmedPage;
import pom.OrderDetailsPage;

import java.time.Duration;

public class MakeOrder {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @Test
    public void orderFromHeaderButton() {
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .clickAcceptCookieButton()
                .clickMakeOrderHeaderButton();

        ClientDetailsPage clientDetailsPage = new ClientDetailsPage(driver);

        clientDetailsPage
                .inputName("Любитель")
                .inputSurname("Хачапури")
                .inputAddress("Грузия")
                .inputMetro("Нагорная")
                .inputPhoneNumber("89999999999")
                .clickNextButton();

        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);

        orderDetailsPage
                .inputDate("1.11.22")
                .inputDuration(3)
                .selectColor("чёрный жемчуг")
                .inputComment("всех благ тебе, ревьюер!")
                .clickMakeOrderFooterButton()
                .clickConfirmOrderButton();

        OrderConfirmedPage orderConfirmedPage = new OrderConfirmedPage(driver);

        assertTrue(orderConfirmedPage.isOrderConfirmed());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}