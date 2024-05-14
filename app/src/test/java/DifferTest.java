import hexlet.code.Differ;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.nio.file.Files;


public class DifferTest {
    private String readExpectedResult(String filename) throws Exception {
        return new String(Files.readAllBytes(Paths.get("src/test/resources", filename)));
    }

    @Test
    public void testGenerateDiffStylish() throws Exception {
        String filepath1 = "filepath1.json";
        String filepath2 = "filepath2.json";
        String expected = readExpectedResult("stylish.expected");

        Differ differ = new Differ("stylish");
        String actual = differ.generateDiff(filepath1, filepath2);

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDiffPlain() throws Exception {
        String filepath1 = "filepath1.json";
        String filepath2 = "filepath2.json";
        String expected = readExpectedResult("plain.expected");

        Differ differ = new Differ("plain");
        String actual = differ.generateDiff(filepath1, filepath2);

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDiffJson() throws Exception {
        String filepath1 = "filepath1.json";
        String filepath2 = "filepath2.json";
        String expected = readExpectedResult("json.expected");

        Differ differ = new Differ("json");
        String actual = differ.generateDiff(filepath1, filepath2);

        assertEquals(expected, actual);
    }
}
