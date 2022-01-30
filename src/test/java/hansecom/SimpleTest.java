package hansecom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Класс с тестами для юниттеста")
public class SimpleTest {

    @Test
    @DisplayName("тест проверяет что 3 меньше 2")
    void test() {
        Assertions.assertTrue(3 < 2);
    }

    @Test
    @DisplayName("тест проверяет что 3 больше 2")
    void test1() {
        Assertions.assertTrue(3 > 2);
    }
}
