package extratests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.NoSuchElementException;
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
                "29.06.1990",
                "121212",
                "09.12.2022",
                "99999999999",
                "29.06.8888888",
                "строка",
        };
    }

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void dateFieldErrorTest() {
        MainPage mainPage = new MainPage(driver);

        mainPage.open();

        try {
            mainPage.clickAcceptCookieButton();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } finally {
            mainPage.clickMakeOrderButton(true);

            ClientDetailsPage clientDetailsPage = new ClientDetailsPage(driver);

            clientDetailsPage
                    .inputName("Честно")
                    .inputSurname("Говоря")
                    .inputAddress("Натестировался от души")
                    .inputMetro("Университет")
                    .inputPhoneNumber("89990000000")
                    .clickNextButton();

            OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);

            orderDetailsPage.inputDate(date);

            assertTrue(orderDetailsPage.isDateCorrect());

        }
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
