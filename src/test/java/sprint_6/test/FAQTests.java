package sprint_6.test;

import sprint_6.pages.HomePageScooter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Класс с автотестами
public class FAQTests {
    private WebDriver driver;

    // Метод выполняется перед каждым тестом
    @BeforeEach
    void setup() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // Метод выполняется после каждого теста
    @AfterEach
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }

    // Проверка текста в выпадающих списках в разделе «Вопросы о важном»
    @ParameterizedTest
    @MethodSource("faqProvider")
    public void testHomeFaq(String Question, String Answer) {
        HomePageScooter homePageScooter = new HomePageScooter(driver);

        // Принять куки - клик по кнопке
        homePageScooter.clickCookieButton();

        // Проверка текста вопроса и клик
        String actualQuestion;
        switch (Question) {
            case "Сколько это стоит? И как оплатить?":actualQuestion = homePageScooter.findAndClickList1();
            break;
            case "Хочу сразу несколько самокатов! Так можно?":actualQuestion = homePageScooter.findAndClickList2();
            break;
            case "Как рассчитывается время аренды?":actualQuestion = homePageScooter.findAndClickList3();
            break;
            case "Можно ли заказать самокат прямо на сегодня?":actualQuestion = homePageScooter.findAndClickList4();
            break;
            case "Можно ли продлить заказ или вернуть самокат раньше?":actualQuestion = homePageScooter.findAndClickList5();
            break;
            case "Вы привозите зарядку вместе с самокатом?":actualQuestion = homePageScooter.findAndClickList6();
            break;
            case "Можно ли отменить заказ?":actualQuestion = homePageScooter.findAndClickList7();
            break;
            case "Я живу за МКАДом, привезёте?":actualQuestion = homePageScooter.findAndClickList8();
            break;
            default:
                throw new IllegalArgumentException("Текст вопроса не совпадает");
        }
        assertEquals(Question, actualQuestion, "Текст вопроса не совпадает");

        // Проверка текста ответа
        String actualAnswer;
                switch (Question) {
                    case "Сколько это стоит? И как оплатить?":actualAnswer = homePageScooter.getAccordionAnswerText1();
                    break;
                    case "Хочу сразу несколько самокатов! Так можно?":actualAnswer = homePageScooter.getAccordionAnswerText2();
                    break;
                    case "Как рассчитывается время аренды?":actualAnswer = homePageScooter.getAccordionAnswerText3();
                    break;
                    case "Можно ли заказать самокат прямо на сегодня?":actualAnswer = homePageScooter.getAccordionAnswerText4();
                    break;
                    case "Можно ли продлить заказ или вернуть самокат раньше?":actualAnswer = homePageScooter.getAccordionAnswerText5();
                    break;
                    case "Вы привозите зарядку вместе с самокатом?":actualAnswer = homePageScooter.getAccordionAnswerText6();
                    break;
                    case "Можно ли отменить заказ?":actualAnswer = homePageScooter.getAccordionAnswerText7();
                    break;
                    case "Я живу за МКАДом, привезёте?":actualAnswer = homePageScooter.getAccordionAnswerText8();
                    break;
                    default:
                        throw new IllegalArgumentException("Неизвестный ответ");
                }
                        assertEquals(Answer, actualAnswer, "Текст ответа не совпадает");
                }

    private static Stream<Arguments> faqProvider() {
        return Stream.of(
                Arguments.of("Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."),
                Arguments.of("Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."),
                Arguments.of("Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
                Arguments.of("Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."),
                Arguments.of("Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."),
                Arguments.of("Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."),
                Arguments.of("Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."),
                Arguments.of("Я живу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.")
        );
    }
        }