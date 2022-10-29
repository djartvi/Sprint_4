package makeorder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.MainPage;
import pom.ClientDetailsPage;
import pom.OrderConfirmationPage;
import pom.OrderDetailsPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class MakeOrderTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final int days;
    private final String color;
    private final String comment;
    private WebDriver driver;

    public MakeOrderTest(String name, String surname, String address, String metro, String phone, String date, int days, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.days = days;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] orderParameters() {
        return new Object[][] {
                {"Любитель", "Хачапури", "Грузия", "Нагорная", "89990000000", "1.11.22", 3, "чёрный жемчуг", "От всей души"},
                {"Васька", "Голый", "Парк Горького", "Октябрьская", "80000000000", "2.11.22", 1, "чёрный жемчуг", "желаю всех благ"},
                {"Лютый", "Замкадыш", "Москва", "Бунинская аллея", "88005553535", "3.10.23", 7, "серая безысходность", "Тебе, ревьюер!"},
        };
    }

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
                .inputName(name)
                .inputSurname(surname)
                .inputAddress(address)
                .inputMetro(metro)
                .inputPhoneNumber(phone)
                .clickNextButton();

        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);

        orderDetailsPage
                .inputDate(date)
                .inputDuration(days)
                .selectColor(color)
                .inputComment(comment)
                .clickMakeOrderBottomButton();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        orderConfirmationPage.clickConfirmOrderButton();

        assertTrue(orderConfirmationPage.isOrderConfirmed());
    }

    @Test
    public void orderFromBottomButton() {
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .clickAcceptCookieButton()
                .clickMakeOrderBottomButton();

        ClientDetailsPage clientDetailsPage = new ClientDetailsPage(driver);

        clientDetailsPage
                .inputName(name)
                .inputSurname(surname)
                .inputAddress(address)
                .inputMetro(metro)
                .inputPhoneNumber(phone)
                .clickNextButton();

        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);

        orderDetailsPage
                .inputDate(date)
                .inputDuration(days)
                .selectColor(color)
                .inputComment(comment)
                .clickMakeOrderBottomButton();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        orderConfirmationPage.clickConfirmOrderButton();

        assertTrue(orderConfirmationPage.isOrderConfirmed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}