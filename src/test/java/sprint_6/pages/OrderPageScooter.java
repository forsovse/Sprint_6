package sprint_6.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

// Класс страницы заказа
public class OrderPageScooter {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Локаторы полей формы заказа
    private final By name = By.cssSelector("input[placeholder='* Имя']");
    private final By surname = By.cssSelector("input[placeholder='* Фамилия']");
    private final By orderPlace = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private final By metroInput = By.cssSelector("input.select-search__input");
    private final By metroOptions = By.cssSelector("li.select-search__row .select-search__option");
    private final By metroStation = By.cssSelector(".Order_Text__2broi");
    private final By phoneNumber = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private final By orderDate = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    private final By orderDay = By.cssSelector(".react-datepicker__day:not(.react-datepicker__day--outside-month)");
    private final By orderPeriod = By.cssSelector(".Dropdown-control");
    private final By orderPeriodOptions = By.cssSelector(".Dropdown-option");
    private final By scooterColors = By.cssSelector(".Order_Checkboxes__3lWSI");
    private final By checkboxColor = By.cssSelector(".Checkbox_Label__3wxSf");
    private final By checkboxs = By.cssSelector("input[type='checkbox']");
    private final By comment = By.cssSelector("input[placeholder='Комментарий для курьера']");

    // локатор для кнопки Далее
    private final By ButtonNext = By.xpath(".//button[contains(@class,'Button_Middle')]");

    // локатор для кнопки Заказать
    private final By orderButton = By.xpath(".//button[contains(@class,'Button_Middle') and text()='Заказать']");

    // локатор для кнопки подтверждения заказа
    private final By orderButtonSubmit = By.xpath(".//button[contains(@class,'Button_Middle') and text()='Да']");

    // локатор для модального окна подтверждения заказа
    private final By orderModal = By.cssSelector(".Order_ModalHeader__3FDaJ");

    // методы для заполнения полей
    public void fieldName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    public void fieldSurname(String surname) {
        driver.findElement(this.surname).sendKeys(surname);
    }

    public void fieldAdress(String adress) {
        driver.findElement(this.orderPlace).sendKeys(adress);
    }

    public void fieldphoneNumber(String phoneNumber) {
        driver.findElement(this.phoneNumber).sendKeys(phoneNumber);
    }

    // Выбор станции метро
    public void selectMetroStation(String stationName) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(metroInput));
        assert input != null;
        input.click();
        input.clear();
        input.sendKeys(stationName);

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(metroOptions));

        assert options != null;
        for (WebElement option : options) {
            String text = option.findElement(metroStation).getText().trim();

            if (text.equalsIgnoreCase(stationName)) {
                option.click();
                return;
            }
        }

        throw new RuntimeException("Станция не найдена: " + stationName);
    }

    // Клик по кнопке Далее
    public void clickNextButton() {
        driver.findElement(ButtonNext).click();
    }

    // Выбор даты в календаре
    public void selectDate(String day) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(orderDate));
        assert input != null;
        input.click();
        input.clear();
        input.sendKeys(Keys.NULL);

        wait.until(ExpectedConditions.visibilityOfElementLocated(orderDay));

        for (WebElement d : driver.findElements(orderDay)) {
            if (d.getText().equals(day)) {
                d.click();
                return;
            }
        }

        throw new RuntimeException("Дата не найдена: " + day);
    }

    // Выбор срока аренды
    public void selectPeriod(String period) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(orderPeriod));
        assert dropdown != null;
        dropdown.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(orderPeriodOptions));

        List<WebElement> options = driver.findElements(orderPeriodOptions);
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(period)) {
                option.click();
                return;
            }
        }

        throw new RuntimeException("Опция не найдена: " + period);
    }

    // Выбор цвета
    public void selectColor(String colorText) {
        WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(scooterColors));

        assert container != null;
        List<WebElement> labels = container.findElements(checkboxColor);
        for (WebElement label : labels) {
            if (label.getText().trim().equalsIgnoreCase(colorText)) {
                WebElement checkbox = label.findElement(checkboxs);
                if (!checkbox.isSelected()) {
                    label.click();
                }
                return;
            }
        }

        throw new RuntimeException("Цвет не найден: " + colorText);
    }

    // Заполняем поле комментарий
    public void fieldComment(String comment) {
        driver.findElement(this.comment).sendKeys(comment);
    }

    // Метод для заполнения формы
    public void fillOrderForm(
            String name,
            String surname,
            String address,
            String stationName,
            String phone,
            String day,
            String period,
            String color,
            String comment
    ) {
        fieldName(name);
        fieldSurname(surname);
        fieldAdress(address);
        selectMetroStation(stationName);
        fieldphoneNumber(phone);
        clickNextButton();
        selectDate(day);
        selectPeriod(period);
        selectColor(color);
        fieldComment(comment);
    }

    // Метод создания заказа
    public void createOrder(
            String name,
            String surname,
            String address,
            String stationName,
            String phone,
            String day,
            String period,
            String color,
            String comment
    ) {
        fillOrderForm(
                name, surname, address, stationName, phone,
                day, period, color, comment
        );
        clickOrderButton();
        clickOrderButtonSubmit();
    }

    // Клик по кнопке Заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    // Клик по кнопке Да
    public void clickOrderButtonSubmit() {
        driver.findElement(orderButtonSubmit).click();
    }

    // Проверка модального окна при успешном оформлении заказа
    public void isOrderModal() {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(orderModal));
        assert header != null;
        String text = header.getText();
        Assertions.assertTrue(text.contains("Заказ оформлен"), "Модальное окно не содержит заголовок 'Заказ оформлен'");
    }
}
