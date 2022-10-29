package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ClientDetailsPage {
    private final WebDriver driver;
    public ClientDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By nameField = By.xpath("//*[@placeholder='* Имя']");
    private final By surnameField = By.xpath("//*[@placeholder='* Фамилия']");
    private final By addressField = By.xpath("//*[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.xpath("//*[@placeholder='* Станция метро']");
    private final By phoneNumberField = By.xpath("//*[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//button[text()='Далее']");

    public ClientDetailsPage inputName(String text) {
        driver.findElement(nameField).sendKeys(text);
        return this;
    }

    public ClientDetailsPage inputSurname(String text) {
        driver.findElement(surnameField).sendKeys(text);
        return this;
    }

    public ClientDetailsPage inputAddress(String text) {
        driver.findElement(addressField).sendKeys(text);
        return this;
    }

    public ClientDetailsPage inputMetro(String text) {
        driver.findElement(metroField).sendKeys(text);
        driver.findElement(metroField).sendKeys(Keys.DOWN);
        driver.findElement(metroField).sendKeys(Keys.ENTER);
        return this;
    }

    public ClientDetailsPage inputPhoneNumber(String text) {
        driver.findElement(phoneNumberField).sendKeys(text);
        return this;
    }

    public ClientDetailsPage clickNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }
}