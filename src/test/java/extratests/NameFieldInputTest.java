package extratests;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.ClientDetailsPage;
import pom.MainPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class NameFieldInputTest {

    private final String name;

    private static WebDriver driver;

    public NameFieldInputTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[] nameParameters() {
        return new Object[] {
                "Иннокентий Петрович",
                "Я",
                "123",
                "fffff",
                "Иван@",
                "!геннадий",
                "Эх......",
                " Ж А К ",
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
    public void nameFieldErrorTest() {

        ClientDetailsPage clientDetailsPage = new ClientDetailsPage(driver);

        clientDetailsPage
                .inputName(name)
                .inputSurname("");

        assertTrue(clientDetailsPage.isNameErrorDisplayed());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}