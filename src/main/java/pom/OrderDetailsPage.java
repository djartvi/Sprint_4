package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderDetailsPage {
    private final WebDriver driver;

    private final By dateField = By.xpath("//*[@placeholder='* Когда привезти самокат']");
    private final By durationField = By.xpath("//*[text()='* Срок аренды']");
    private final By commentField = By.xpath("//*[@placeholder='Комментарий для курьера']");
    private final By makeOrderBottomButton = By.xpath("(//button[text()='Заказать'])[2]");

    public OrderDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderDetailsPage inputDate(String text) {
        driver.findElement(dateField).sendKeys(text);
        driver.findElement(dateField).sendKeys(Keys.ENTER);
        return this;
    }

    public OrderDetailsPage inputDuration(int days) {
        driver.findElement(durationField).click();
        driver.findElement(By.xpath("//*[contains(@class, 'Dropdown-option')][" + days + "]")).click();
        return this;
    }

    public OrderDetailsPage selectColor(String color) { //"чёрный жемчуг" или "серая безысходность"
        driver.findElement(By.xpath("//*[text()='" + color +"']")).click();
        return this;
    }

    public OrderDetailsPage inputComment(String text) {
        driver.findElement(commentField).sendKeys(text);
        return this;
    }

    public OrderDetailsPage clickMakeOrderBottomButton() {
        driver.findElement(makeOrderBottomButton).click();
        return this;
    }

    public boolean isDateCorrect(String date) {
        String futureDate = "31.12.2022";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate d1 = LocalDate.now();
        LocalDate d2 = LocalDate.parse(date, formatter);
        LocalDate d3 = LocalDate.parse(futureDate, formatter);

        return (d1.isBefore(d2) && d2.isBefore(d3));
    }
}
