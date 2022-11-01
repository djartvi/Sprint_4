package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
    private final WebDriver driver;

    private final By confirmOrderButton = By.xpath("//button[text()='Да']");
    private final By orderConfirmed = By.xpath("//*[text()='Заказ оформлен']");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderConfirmationPage clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
        return this;
    }

    public boolean isOrderConfirmed() {
        return driver.findElements(orderConfirmed).size() > 0;
    }
}
