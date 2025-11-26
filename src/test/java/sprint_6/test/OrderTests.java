package sprint_6.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sprint_6.pages.HomePageScooter;
import sprint_6.pages.OrderPageScooter;

import java.util.stream.Stream;

// Класс с автотестами
public class OrderTests {
    private WebDriver driver;


    // Метод выполняется перед каждым тестом
    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // Метод выполняется после каждого теста
    @AfterEach
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }

    @ParameterizedTest
    @MethodSource("dataOrder")
    public void orderTest1(String name,
                          String surname,
                          String orderPlace,
                          String stationName,
                          String phoneNumber,
                          String day,
                          String period,
                          String color,
                          String comment) {
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);

        homePageScooter.clickCookieButton();
        homePageScooter.clickOrderButtonUp();
        orderPageScooter.createOrder(
                name,
                surname,
                orderPlace,
                stationName,
                phoneNumber,
                day,
                period,
                color,
                comment
        );
        orderPageScooter.isOrderModal();
    }

    @ParameterizedTest
    @MethodSource("dataOrder")
    public void orderTest2(String name,
                           String surname,
                           String orderPlace,
                           String stationName,
                           String phoneNumber,
                           String day,
                           String period,
                           String color,
                           String comment) {
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);

        homePageScooter.clickCookieButton();
        homePageScooter.clickOrderButtonDown();
        orderPageScooter.createOrder(
                name,
                surname,
                orderPlace,
                stationName,
                phoneNumber,
                day,
                period,
                color,
                comment
        );
        orderPageScooter.isOrderModal();
    }


    private static Stream<Arguments> dataOrder() {
        return Stream.of(
                Arguments.of("Иван", "Петров", "ул. Горького, 100", "Сокольники", "79001117890", "29", "трое суток", "чёрный жемчуг", "Комментарий к заказу1"),
                Arguments.of("Петр", "Иванов", "ул. Есенина, 17", "Измайлово", "81233218855", "2", "семеро суток", "серая безысходность", "Комментарий к заказу2")
        );
    }
}