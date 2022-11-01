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
public class AddressFieldInputTest {

    private final String address;

    private static WebDriver driver;

    public AddressFieldInputTest(String address) {
        this.address = address;
    }

    @Parameterized.Parameters
    public static Object[] addressParameters() {
        return new Object[] {
                "Гусь-Хрустальный",
                "Ы",
                "SamaraGorodok",
                "12345",
                "Улица, дом, квартира",
                "!опятьгеннадий",
                "Эх......",
                "",
                "НормальныйОченьПриоченьДлинныйПридлинныйАдресНастолькоДлинныйЧтоЯДажеНеЗнаюПоВерсииСамоката",
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
    public void addressFieldErrorTest() {

        ClientDetailsPage clientDetailsPage = new ClientDetailsPage(driver);

        clientDetailsPage
                .inputAddress(address)
                .inputName("");

        assertTrue(clientDetailsPage.isAddressErrorDisplayed());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
