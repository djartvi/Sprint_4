package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver driver;

    private final By acceptCookieButton = By.id("rcc-confirm-button");
    private final By makeOrderHeaderButton = By.xpath("(//button[text()='Заказать'])[1]");
    private final By orderStatusButton = By.xpath("//button[text()='Статус заказа']");
    private final By orderNumberField = By.xpath("//*[@placeholder='Введите номер заказа']");
    private final By goButton = By.xpath("(//button[contains(text(), 'Go')]");
    private final By makeOrderFooterButton = By.xpath("(//button[text()='Заказать'])[2]");

    private final By accordionList = By.className("accordion");

    public String text;
    public String textDropDown;
    public By accordionButton = By.xpath("//*[contains(text(), " + text + ")]");
    private By accordionDropDown = By.xpath("//*[contains(text(), '" + textDropDown + "')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void clickAcceptCookieButton() {
        driver.findElement(acceptCookieButton).click();
    }

    public void clickMakeOrderHeaderButton() {
        driver.findElement(makeOrderHeaderButton).click();
    }

    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }

    public void clickOrderNumberField() {
        driver.findElement(orderNumberField).click();
    }

    public void inputOrderNumber(String text) {
        driver.findElement(orderNumberField).sendKeys(text);
    }

    public void clickGoButton() {
        driver.findElement(goButton).click();
    }

    public void clickMakeOrderFooterButton() {
        driver.findElement(makeOrderFooterButton).click();
    }

    public WebElement getAccordionList() {
        return driver.findElement(accordionList);
    }

    public void clickAccordionButton(String text) {
        this.text = text;
        driver.findElement(accordionButton).click();
    }

    public boolean isDisplayedAccordionDropDown(String text) {
        this.textDropDown = text;
        return driver.findElement(accordionDropDown).isDisplayed();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
