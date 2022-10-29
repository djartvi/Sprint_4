package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmedPage {
    private final WebDriver driver;
    public OrderConfirmedPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By orderConfirmed = By.xpath("//*[text()='Заказ оформлен']");

    public boolean isOrderConfirmed() {
        return driver.findElements(orderConfirmed).size() > 0;
    }



    }
