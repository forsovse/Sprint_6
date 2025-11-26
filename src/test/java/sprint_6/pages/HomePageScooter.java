package sprint_6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс главной страницы
public class HomePageScooter {
    private final WebDriver driver;

    // локатор для кнопки подтверждения кук
    private final By cookieButton = By.id("rcc-confirm-button");

    // локаторы для кнопок-стрелочек в разделе "Вопросы о важном"
    private final By accordionList1 = By.xpath(".//*[@id=\"accordion__heading-0\"]");
    private final By accordionList2 = By.xpath(".//*[@id=\"accordion__heading-1\"]");
    private final By accordionList3 = By.xpath(".//*[@id=\"accordion__heading-2\"]");
    private final By accordionList4 = By.xpath(".//*[@id=\"accordion__heading-3\"]");
    private final By accordionList5 = By.xpath(".//*[@id=\"accordion__heading-4\"]");
    private final By accordionList6 = By.xpath(".//*[@id=\"accordion__heading-5\"]");
    private final By accordionList7 = By.xpath(".//*[@id=\"accordion__heading-6\"]");
    private final By accordionList8 = By.xpath(".//*[@id=\"accordion__heading-7\"]");

    // локаторы для текста в разделе "Вопросы о важном"
    private final By accordionAnswerText1 = By.xpath(".//*[@id=\"accordion__panel-0\"]/p");
    private final By accordionAnswerText2 = By.xpath(".//*[@id=\"accordion__panel-1\"]/p");
    private final By accordionAnswerText3 = By.xpath(".//*[@id=\"accordion__panel-2\"]/p");
    private final By accordionAnswerText4 = By.xpath(".//*[@id=\"accordion__panel-3\"]/p");
    private final By accordionAnswerText5 = By.xpath(".//*[@id=\"accordion__panel-4\"]/p");
    private final By accordionAnswerText6 = By.xpath(".//*[@id=\"accordion__panel-5\"]/p");
    private final By accordionAnswerText7 = By.xpath(".//*[@id=\"accordion__panel-6\"]/p");
    private final By accordionAnswerText8 = By.xpath(".//*[@id=\"accordion__panel-7\"]/p");

    // локатор для верхней кнопки Заказать
    private final By OrderButtonUp = By.xpath(".//button[@class='Button_Button__ra12g']");

    // локатор для нижней кнопки Заказать
    private final By OrderButtonDown = By.cssSelector(".Home_FinishButton__1_cWm button");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // Принять куки - клик по кнопке
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    // Клик по верхней кнопке "Заказать"
    public void clickOrderButtonUp(){
        driver.findElement(OrderButtonUp).click();
    }

    // Клик по нижней кнопке "Заказать"
    public void clickOrderButtonDown(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(OrderButtonDown));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
        assert button != null;
        button.click();
    }

   // Получаем текста вопроса у кнопки-стрелочки и кликаем нему
    public String findAndClickList1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 10 секунд ожидания
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionList1));
        assert list != null;
        String listTextFromElement = list.getText();
        list.click();
        return listTextFromElement;
    }

    public String findAndClickList2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 секунд ожидания
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionList2));
        assert list != null;
        String listTextFromElement = list.getText();
        list.click();
        return listTextFromElement;
    }

    public String findAndClickList3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 10 секунд ожидания
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionList3));
        assert list != null;
        String listTextFromElement = list.getText();
        list.click();
        return listTextFromElement;
    }

    public String findAndClickList4() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 секунд ожидания
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionList4));
        assert list != null;
        String listTextFromElement = list.getText();
        list.click();
        return listTextFromElement;
    }

    public String findAndClickList5() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 10 секунд ожидания
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionList5));
        assert list != null;
        String listTextFromElement = list.getText();
        list.click();
        return listTextFromElement;
    }

    public String findAndClickList6() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 секунд ожидания
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionList6));
        assert list != null;
        String listTextFromElement = list.getText();
        list.click();
        return listTextFromElement;
    }

    public String findAndClickList7() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 10 секунд ожидания
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionList7));
        assert list != null;
        String listTextFromElement = list.getText();
        list.click();
        return listTextFromElement;
    }

    public String findAndClickList8() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 секунд ожидания
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionList8));
        assert list != null;
        String listTextFromElement = list.getText();
        list.click();
        return listTextFromElement;
    }

    // Получаем текст ответа
    public String getAccordionAnswerText1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 секунд ожидания
        WebElement resultTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionAnswerText1));
        assert resultTextElement != null;
        return resultTextElement.getText();
    }

    public String getAccordionAnswerText2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 секунд ожидания
        WebElement resultTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionAnswerText2));
        assert resultTextElement != null;
        return resultTextElement.getText();
    }

    public String getAccordionAnswerText3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 секунд ожидания
        WebElement resultTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionAnswerText3));
        assert resultTextElement != null;
        return resultTextElement.getText();
    }

    public String getAccordionAnswerText4() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 секунд ожидания
        WebElement resultTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionAnswerText4));
        assert resultTextElement != null;
        return resultTextElement.getText();
    }

    public String getAccordionAnswerText5() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 секунд ожидания
        WebElement resultTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionAnswerText5));
        assert resultTextElement != null;
        return resultTextElement.getText();
    }

    public String getAccordionAnswerText6() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 секунд ожидания
        WebElement resultTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionAnswerText6));
        assert resultTextElement != null;
        return resultTextElement.getText();
    }

    public String getAccordionAnswerText7() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 секунд ожидания
        WebElement resultTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionAnswerText7));
        assert resultTextElement != null;
        return resultTextElement.getText();
    }

    public String getAccordionAnswerText8() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 секунд ожидания
        WebElement resultTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionAnswerText8));
        assert resultTextElement != null;
        return resultTextElement.getText();
    }
}