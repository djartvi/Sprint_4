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
public class PhoneNumberFieldInputTest {

    private final String phone;

    private static WebDriver driver;

    public PhoneNumberFieldInputTest(String phone) {
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[] phoneNumberParameters() {
        return new Object[] {
                "",
                "1",
                "+7",
                "12345",
                "123456",
                "1234567",
                "12345678",
                "123456789",
                "1234567890",
                "12345678901",
                "Эх",
                "@@@%$@%@%",
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
    public void phoneNumberFieldErrorTest() {

        ClientDetailsPage clientDetailsPage = new ClientDetailsPage(driver);

        clientDetailsPage
                .inputPhoneNumber(phone)
                .inputName("");

        assertTrue(clientDetailsPage.isPhoneNumberDisplayed());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}