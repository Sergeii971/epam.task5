package test.verbovskiy.task5.service;

import com.verbovskiy.task5.exception.TaskException;
import com.verbovskiy.task5.service.impl.StringChangeTextImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringChangeTextImplTest {
    StringChangeTextImpl stringChangeText;

    @BeforeClass
    public void setUp() {
    stringChangeText = new StringChangeTextImpl();
    }

    @Test
    public void replaceCharacterPositiveTest() throws TaskException {
        String text = "As he walked along, he glanced around him in occasional puzzlement.";
        String actual = stringChangeText.replaceCharacter(text,3,"&");
        String expected = "As he wal&ed alo&g, he gla&ced aro&nd him in occ&sional puz&lement.";

        assertEquals(actual, expected);
    }

    @Test
    public void replaceCharacterNegativeTest() throws TaskException {
        String text = "As he walked along, he glanced around him in occasional puzzlement.";
        String actual = stringChangeText.replaceCharacter(text,3,"&");
        String expected = "As he walked along, he glanced aro&nd him in occ&sional puz&lement.";

        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = TaskException.class)
    public void splitTextOnWordExceptionTest() throws TaskException {
        stringChangeText.replaceCharacter(null,-1,null);
    }

    @Test
    public void correctMistakePositiveTest() throws TaskException {
        String text = "PA PA PA PA";
        String actual = stringChangeText.correctMistake(text,"PA","PO");
        String expected = "PO PO PO PO";

        assertEquals(actual, expected);
    }

    @Test
    public void correctMistakeNegativeTest() throws TaskException {
        String text = "PA PA PA PA";
        String actual = stringChangeText.correctMistake(text,"PA","PO");
        String expected = "PO PE PE PO";

        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = TaskException.class)
    public void correctMistakeExceptionTest() throws TaskException {
        stringChangeText.correctMistake(null,null,null);
    }

    @Test
    public void replaceSubstringCertainLengthPositiveTest() throws TaskException {
        String text = "As he walked along, he glanced around him in occasional puzzlement.";
        String actual = stringChangeText.replaceSubstringCertainLength(text,"&&&&",2);
        String expected = "&&&& &&&& walked along, &&&& glanced around him &&&& occasional puzzlement. ";

        assertEquals(actual, expected);
    }

    @Test
    public void replaceSubstringCertainLengthNegativeTest() throws TaskException {
        String text = "As he walked along, he glanced around him in occasional puzzlement.";
        String actual = stringChangeText.replaceSubstringCertainLength(text,"&&&&",2);
        String expected = "As he walked along, he glanced around him in occasional puzzlement.";

        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = TaskException.class)
    public void replaceSubstringCertainLengthExceptionTest() throws TaskException {
        stringChangeText.replaceSubstringCertainLength(null,null,-1);
    }
}