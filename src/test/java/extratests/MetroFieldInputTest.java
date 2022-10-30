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
public class MetroFieldInputTest {

    private final String metro;

    private static WebDriver driver;

    public MetroFieldInputTest(String metro) {
        this.metro = metro;
    }

    @Parameterized.Parameters
    public static Object[] metroParameters() {
        return new Object[] {
                "Парк",
                "12345",
                "Улица, дом, квартира",
                "Сокольники",
                "!опятьгеннадий",
                "Эх......",
                "НормальныйОченьПриоченьДлинныйПридлинныйАдресНастолькоДлинныйЧтоЯДажеНеЗнаюПоВерсииСамоката",
        };
    }

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .clickAcceptCookieButton()
                .clickMakeOrderButton(true);
    }

    @Test
    public void metroFieldErrorTest() {

        ClientDetailsPage clientDetailsPage = new ClientDetailsPage(driver);

        assertTrue(clientDetailsPage.isListContainsText(metro));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}

