package hansecom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedWebTest {
    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach"); // создает разные независимые тесты
    }

    //@BeforeAll запустился бы один раз
    @DisplayName("Общий поиск тест")
    // @ValueSource(strings = {"Selenide","Junit"}) // оранжевой запятой отделяются запуски теста(количество раз с вх данными))
    @CsvSource(value = {
            "Selenide,Вышла Selenide",
            "JUnit,JUnit 5 is the next generation of"  //зеленая запятая означает два аргументы
    }
    )
    @ParameterizedTest(name = "Общий поиск тест с тестовыми данными: {0}")
    void searchTest(String testData, String expectedResult) {
        Selenide.open("https://ya.ru/");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item")
                .first()
                .shouldHave(Condition.text(expectedResult));
        //.shouldHave(Condition.text("Вышла Selenide"));
        //.shouldHave(Condition.text("JUnit 5 is the next generation of"));

    }
}
