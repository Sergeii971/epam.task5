package test.verbovskiy.task5.service;

import com.verbovskiy.task5.exception.TaskException;
import com.verbovskiy.task5.service.impl.StringDeleteTextElementImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringDeleteTextElementImplTest {
    StringDeleteTextElementImpl stringDeleteTextElement;

    @BeforeClass
    public void setUp() {
        stringDeleteTextElement = new StringDeleteTextElementImpl();
    }

    @Test
    public void deleteNotLetterCharactersPositiveTest() throws TaskException {
        String text = "As he walked along, he glanced around him in occasional puzzlement.";
        String actual = stringDeleteTextElement.deleteNotLetterCharacters(text);
        String expected = "As he walked along  he glanced around him in occasional puzzlement ";

        assertEquals(actual, expected);
    }

    @Test
    public void deleteNotLetterCharactersNegativeTest() throws TaskException {
        String text = "As he walked along, he glanced around him in occasional puzzlement.";
        String actual = stringDeleteTextElement.deleteNotLetterCharacters(text);
        String expected = "As he walked along,  he glanced around him in occasional puzzlement ";

        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = TaskException.class)
    public void splitTextOnWordExceptionTest() throws TaskException {
        stringDeleteTextElement.deleteNotLetterCharacters(null);
    }

    @Test
    public void deleteWordOfCertainLengthStartConsonantPositiveTest() throws TaskException {
        String text = "As he walked along, he glanced around him in occasional puzzlement.";
        String actual = stringDeleteTextElement.deleteWordOfCertainLengthStartConsonant(text,2);
        String expected = "As walked along, glanced around him in occasional puzzlement. ";

        assertEquals(actual, expected);
    }

    @Test
    public void deleteWordOfCertainLengthStartConsonantNegativeTest() throws TaskException {
        String text = "As he walked along, he glanced around him in occasional puzzlement.";
        String actual = stringDeleteTextElement.deleteWordOfCertainLengthStartConsonant(text,2);
        String expected = "walked along, glanced around occasional puzzlement. ";

        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = TaskException.class)
    public void deleteWordOfCertainLengthStartConsonantExceptionTest() throws TaskException {
        stringDeleteTextElement.deleteWordOfCertainLengthStartConsonant(null,-4);
    }
}