package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MakeOrderPage {
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver driver;

    private final By acceptCookieButton = By.id("rcc-confirm-button");
    private final By makeOrderHeaderButton = By.xpath("(//button[text()='Заказать'])[1]");
    private final By orderStatusButton = By.xpath("//button[text()='Статус заказа']");
    private final By orderNumberField = By.xpath("//*[@placeholder='Введите номер заказа']");
    private final By goButton = By.xpath("(//button[contains(text(), 'Go')]");
    private final By makeOrderFooterButton = By.xpath("(//button[text()='Заказать'])[2]");

    public WebElement getAccordionElement(String elementText) {
        return driver.findElement(By.xpath("//*[text() = '" + elementText + "']"));
    }
    public WebElement getAccordionDropDown(String dropDownText) {
        return driver.findElement(By.xpath("//*[text() = '" + dropDownText + "']"));
    }

    public MakeOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public MakeOrderPage open() {
        driver.get(url);
        return this;
    }

    public MakeOrderPage clickAcceptCookieButton() {
        driver.findElement(acceptCookieButton).click();
        return this;
    }

    public MakeOrderPage clickMakeOrderHeaderButton() {
        driver.findElement(makeOrderHeaderButton).click();
        return this;
    }

    public MakeOrderPage clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
        return this;
    }

    public MakeOrderPage clickOrderNumberField() {
        driver.findElement(orderNumberField).click();
        return this;
    }

    public MakeOrderPage inputOrderNumber(String text) {
        driver.findElement(orderNumberField).sendKeys(text);
        return this;
    }

    public MakeOrderPage clickGoButton() {
        driver.findElement(goButton).click();
        return this;
    }

    public MakeOrderPage clickMakeOrderFooterButton() {
        driver.findElement(makeOrderFooterButton).click();
        return this;
    }

    public MakeOrderPage clickAccordionElement(String elementText) {
        getAccordionElement(elementText).click();
        return this;
    }

    public MakeOrderPage scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }
}
