package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexPage {
    private final WebDriver driver;

    private final By yandexPageTitle = By.xpath("//title[text()='Дзен']");

    public YandexPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayed() {
        return driver.findElements(yandexPageTitle).size() > 0;
    }
}
