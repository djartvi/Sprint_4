package extratests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.ClientDetailsPage;
import pom.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class SurnameFieldInputTest {

    private final String surname;

    private static WebDriver driver;

    public SurnameFieldInputTest(String surname) {
        this.surname = surname;
    }

    @Parameterized.Parameters
    public static Object[] surnameParameters() {
        return new Object[] {
                "Мамин-Сибиряк",
                "Я",
                "123",
                "fffff",
                "Иван@",
                "!геннадий",
                "Эх......",
                " Ж А К ",
                "НормальнаяФамилияПоВерсииСамоката",
        };
    }

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .clickAcceptCookieButton()
                .clickMakeOrderButton(true);
    }

    @Test
    public void surnameFieldErrorTest() {

        ClientDetailsPage clientDetailsPage = new ClientDetailsPage(driver);

        clientDetailsPage
                .inputSurname(surname)
                .inputName("");

        assertTrue(clientDetailsPage.isSurnameErrorDisplayed());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
