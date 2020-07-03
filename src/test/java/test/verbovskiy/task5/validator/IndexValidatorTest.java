package test.verbovskiy.task5.validator;

import com.verbovskiy.task5.validator.IndexValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class IndexValidatorTest {
    IndexValidator indexValidator;

    @BeforeClass
    public void setUp() {
    indexValidator = new IndexValidator();
    }

    @Test
    public void validateSymbolIndexInWordPositiveTest() {
        boolean actual = indexValidator.validateSymbolIndexInWord(4);

        assertTrue(actual);
    }

    @Test
    public void validateSymbolIndexInWordNegativeTest() {
        boolean actual = indexValidator.validateSymbolIndexInWord(-2);

        assertFalse(actual);
    }
}