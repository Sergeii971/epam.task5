package test.verbovskiy.task5.service;

import com.verbovskiy.task5.exception.TaskException;
import com.verbovskiy.task5.service.conversion.TextConversionService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TextConversionServiceTest {
    TextConversionService textConversionService;

    @BeforeClass
    public void setUp() {
        textConversionService = new TextConversionService();
    }

    @Test
    public void restoreTextPositiveTest() throws TaskException {
        List<String> words = new ArrayList<>();
        words.add("Grayson ");
        words.add("said ");
        words.add("earnestly");
        String actual = textConversionService.restoreText(words);
        String expected = "Grayson said earnestly";
        assertEquals(actual, expected);
    }

    @Test
    public void restoreTextNegativeTest() throws TaskException {
        List<String> words = new ArrayList<>();
        words.add("Grayson");
        words.add("said");
        words.add("earnestly");
        String actual = textConversionService.restoreText(words);
        String expected = "Grayson earnestly";
        assertNotEquals(actual,expected);
    }

    @Test(expectedExceptions = TaskException.class)
    public void restoreTextExceptionTest() throws TaskException {
        textConversionService.restoreText(null);
    }

    @Test
    public void splitTextOnWordPositiveTest() throws TaskException {
        String text = "four days";
        List<String> actual = textConversionService.splitTextOnWord(text);
        List<String> expected = new ArrayList<>();
        expected.add("four");
        expected.add(" ");
        expected.add("days");
        System.out.println(actual.toString());
        assertEquals(actual, expected);
    }

    @Test
    public void splitTextOnWordNegativeTest() throws TaskException {
        String text = "four days";
        List<String> actual = textConversionService.splitTextOnWord(text);
        List<String> expected = new ArrayList<>();
        expected.add("four");
        expected.add("days");

        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = TaskException.class)
    public void splitTextOnWordExceptionTest() throws TaskException {
        textConversionService.splitTextOnWord(null);
    }
}