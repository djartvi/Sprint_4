package accordionlist;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pom.BrowserSelect;
import pom.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccordionListTest {

    private WebDriver driver;

    private final String elementText;
    private final String dropDownText;
    private final boolean result;

    public AccordionListTest(String elementText, String dropDownText, boolean result) {
            this.elementText = elementText;
            this.dropDownText = dropDownText;
            this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] accordionElements() {
        String text1 = "Сколько это стоит? И как оплатить?";
        String dropDown1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String text2 = "Хочу сразу несколько самокатов! Так можно?";
        String dropDown2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String text3 = "Как рассчитывается время аренды?";
        String dropDown3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String text4 = "Можно ли заказать самокат прямо на сегодня?";
        String dropDown4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String text5 = "Можно ли продлить заказ или вернуть самокат раньше?";
        String dropDown5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String text6 = "Вы привозите зарядку вместе с самокатом?";
        String dropDown6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String text7 = "Можно ли отменить заказ?";
        String dropDown7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String text8 = "Я жизу за МКАДом, привезёте?";
        String dropDown8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

        return new Object[][] {
                { text1, dropDown1, true},
                { text2, dropDown2, true},
                { text3, dropDown3, true},
                { text4, dropDown4, true},
                { text5, dropDown5, true},
                { text6, dropDown6, true},
                { text7, dropDown7, true},
                { text8, dropDown8, true},
        };
    }

    @Rule
    public BrowserSelect browserSelect = new BrowserSelect();

    @Test
    public void AccordionListDropDownTest() {
        MainPage mainPage = new MainPage(browserSelect.getDriver());

        mainPage
                .open()
                .clickAcceptCookieButton()
                .scrollToElement(mainPage.getAccordionElement(elementText))
                .clickAccordionElement(elementText);

        assertEquals(result, mainPage.getAccordionDropDown(dropDownText).isDisplayed());
    }
}