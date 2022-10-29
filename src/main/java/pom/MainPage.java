package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    private final WebDriver driver;

    private final By acceptCookieButton = By.id("rcc-confirm-button");
    private final By makeOrderHeaderButton = By.xpath("(//button[text()='Заказать'])[1]");
    private final By makeOrderBottomButton = By.xpath("(//button[text()='Заказать'])[2]");

    public WebElement getAccordionElement(String elementText) {
        return driver.findElement(By.xpath("//*[text() = '" + elementText + "']"));
    }
    public WebElement getAccordionDropDown(String dropDownText) {
        return driver.findElement(By.xpath("//*[text() = '" + dropDownText + "']"));
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(url);
        return this;
    }

    public MainPage clickAcceptCookieButton() {
        driver.findElement(acceptCookieButton).click();
        return this;
    }

    public MainPage clickMakeOrderHeaderButton() {
        driver.findElement(makeOrderHeaderButton).click();
        return this;
    }

    public MainPage clickMakeOrderBottomButton() {
        WebElement element = driver.findElement(makeOrderBottomButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        return this;
    }

    public MainPage clickAccordionElement(String elementText) {
        getAccordionElement(elementText).click();
        return this;
    }

    public MainPage scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }
}
