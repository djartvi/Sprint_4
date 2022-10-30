package makeorder;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.*;

import java.time.Duration;

@RunWith(Parameterized.class)
public class MakeOrderTest {
    private WebDriver driver;

    private final boolean isButtonFromHeader;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final int days;
    private final String color;
    private final String comment;

    public MakeOrderTest(boolean isButtonFromHeader, String name, String surname, String address, String metro, String phone, String date, int days, String color, String comment) {
        this.isButtonFromHeader = isButtonFromHeader;
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
                {true, "Любитель", "Хачапури", "Грузия", "Нагорная", "89990000000", "1.11.22", 2, "чёрный жемчуг", "От всей души"},
                {true, "Васька", "Голый", "Парк Горького", "Октябрьская", "80000000000", "2.11.22", 1, "чёрный жемчуг", "желаю всех благ"},
                {false, "Лютый", "Замкадыш", "Москва", "Бунинская аллея", "88005553535", "3.10.23", 6, "серая безысходность", "тебе!"},
                {false, "Вот", "Такие", "Делишки", "Деловой центр", "88005553535", "4.09.24", 7, "серая безысходность", "ревьюер!"},
        };
    }

    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();

    @Test
    public void MakeOrderTest() {
        MainPage mainPage = new MainPage(browserSelect.getDriver());

        mainPage
                .open()
                .clickAcceptCookieButton()
                .clickMakeOrderButton(isButtonFromHeader);

        ClientDetailsPage clientDetailsPage = new ClientDetailsPage(browserSelect.getDriver());

        clientDetailsPage
                .inputName(name)
                .inputSurname(surname)
                .inputAddress(address)
                .inputMetro(metro)
                .inputPhoneNumber(phone)
                .clickNextButton();

        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(browserSelect.getDriver());

        orderDetailsPage
                .inputDate(date)
                .inputDuration(days)
                .selectColor(color)
                .inputComment(comment)
                .clickMakeOrderBottomButton();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(browserSelect.getDriver());

        orderConfirmationPage.clickConfirmOrderButton();

        assertTrue(orderConfirmationPage.isOrderConfirmed());
    }

}