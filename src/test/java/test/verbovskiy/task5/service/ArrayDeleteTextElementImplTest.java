package test.verbovskiy.task5.service;

import com.verbovskiy.task5.exception.TaskException;
import com.verbovskiy.task5.service.DeleteTextElement;
import com.verbovskiy.task5.service.impl.ArrayDeleteTextElementImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ArrayDeleteTextElementImplTest {
    DeleteTextElement arrayDeleteTextElement;

    @BeforeClass
    public void setUp() {
        arrayDeleteTextElement = new ArrayDeleteTextElementImpl();
    }

    @Test
    public void deleteNotLetterCharactersPositiveTest() throws TaskException {
        String text = "As he walked along, he glanced around him in occasional puzzlement.";
        String actual = arrayDeleteTextElement.deleteNotLetterCharacters(text);
        String expected = "As he walked along  he glanced around him in occasional puzzlement ";

        assertEquals(actual, expected);
    }

    @Test
    public void deleteNotLetterCharactersNegativeTest() throws TaskException {
        String text = "As he walked along, he glanced around him in occasional puzzlement.";
        String actual = arrayDeleteTextElement.deleteNotLetterCharacters(text);
        String expected = "As he walked along,  he glanced around him in occasional puzzlement ";

        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = TaskException.class)
    public void splitTextOnWordExceptionTest() throws TaskException {
        arrayDeleteTextElement.deleteNotLetterCharacters(null);
    }

    @Test
    public void deleteWordOfCertainLengthStartConsonantPositiveTest() throws TaskException {
        String text = "As he walked along, he glanced around him in occasional puzzlement.";
        String actual = arrayDeleteTextElement.deleteWordOfCertainLengthStartConsonant(text,2);
        String expected = "As  walked along,   glanced around him in occasional puzzlement. ";

        assertEquals(actual, expected);
    }

    @Test
    public void deleteWordOfCertainLengthStartConsonantNegativeTest() throws TaskException {
        String text = "As he walked along, he glanced around him in occasional puzzlement.";
        String actual = arrayDeleteTextElement.deleteWordOfCertainLengthStartConsonant(text,2);
        String expected = "walked along, glanced around occasional puzzlement. ";

        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = TaskException.class)
    public void deleteWordOfCertainLengthStartConsonantExceptionTest() throws TaskException {
        arrayDeleteTextElement.deleteWordOfCertainLengthStartConsonant(null,-4);
    }
}