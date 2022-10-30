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
import pom.OrderDetailsPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class DateFieldInputTest {

    private final String date;

    private static WebDriver driver;

    public DateFieldInputTest(String date) {
        this.date = date;
    }

    @Parameterized.Parameters
    public static Object[] dateParameters() {
        return new Object[] {
                "11.12.2022",
//                "Ы",
//                "SamaraGorodok",
//                "12345",
//                "Улица, дом, квартира",
//                "!опятьгеннадий",
//                "Эх......",
//                "",
//                "НормальныйОченьПриоченьДлинныйПридлинныйАдресНастолькоДлинныйЧтоЯДажеНеЗнаюПоВерсииСамоката",
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

        ClientDetailsPage clientDetailsPage = new ClientDetailsPage(driver);

        clientDetailsPage
                .inputName("Честно")
                .inputSurname("Говоря")
                .inputAddress("Натестировался от души")
                .inputMetro("Университет")
                .inputPhoneNumber("89990000000")
                .clickNextButton();
    }

    @Test
    public void dateFieldErrorTest() {

        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);

        orderDetailsPage
                .inputDate(date)
                .isDateCorrect(date);

//        assertTrue(clientDetailsPage.isAddressErrorDisplayed());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
