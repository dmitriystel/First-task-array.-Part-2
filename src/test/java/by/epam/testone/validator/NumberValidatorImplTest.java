package by.epam.testone.validator;

import by.epam.taskone.validator.impl.NumberValidatorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorImplTest {
    private static final NumberValidatorImpl validator = NumberValidatorImpl.getInstance();

    @ParameterizedTest
    @ValueSource(strings = {"1;4d;5", "1; 4; 5;"})
    @DisplayName("validateValidLine")
    void validateValidLine(String input) {
        assertTrue(validator.validateLine(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1w;4d;5-", "2;we;643"})
    @DisplayName("validateInvalidLine")
    void validateInvalidLine(String input) {
        assertFalse(validator.validateLine(input));
    }

}
