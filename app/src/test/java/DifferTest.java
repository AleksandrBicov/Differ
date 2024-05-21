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
    public void testGenerateDiffDefaultJson() throws Exception {
        String filepath1 = "filepath1.json";
        String filepath2 = "filepath2.json";
        String expected = readExpectedResult("stylish.expected");

        Differ differ = new Differ("stylish");
        String actual = differ.generate(filepath1, filepath2);

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDiffDefaultYml() throws Exception {
        String filepath1 = "filepath1.yml";
        String filepath2 = "filepath2.yml";
        String expected = readExpectedResult("stylish.expected");

        Differ differ = new Differ("stylish");
        String actual = differ.generate(filepath1, filepath2);

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDiffStylishJson() throws Exception {
        String filepath1 = "filepath1.json";
        String filepath2 = "filepath2.json";
        String expected = readExpectedResult("stylish.expected");

        Differ differ = new Differ("stylish");
        String actual = differ.generate(filepath1, filepath2, "stylish");

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDiffStylishYml() throws Exception {
        String filepath1 = "filepath1.yml";
        String filepath2 = "filepath2.yml";
        String expected = readExpectedResult("stylish.expected");

        Differ differ = new Differ("stylish");
        String actual = differ.generate(filepath1, filepath2, "stylish");

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDiffPlainJson() throws Exception {
        String filepath1 = "filepath1.json";
        String filepath2 = "filepath2.json";
        String expected = readExpectedResult("plain.expected");

        Differ differ = new Differ("plain");
        String actual = differ.generate(filepath1, filepath2);

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDiffPlainYml() throws Exception {
        String filepath1 = "filepath1.yml";
        String filepath2 = "filepath2.yml";
        String expected = readExpectedResult("plain.expected");

        Differ differ = new Differ("plain");
        String actual = differ.generate(filepath1, filepath2);

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDiffJson() throws Exception {
        String filepath1 = "filepath1.json";
        String filepath2 = "filepath2.json";
        String expected = readExpectedResult("json.expected");

        Differ differ = new Differ("json");
        String actual = differ.generate(filepath1, filepath2);

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDiffYml() throws Exception {
        String filepath1 = "filepath1.yml";
        String filepath2 = "filepath2.yml";
        String expected = readExpectedResult("json.expected");

        Differ differ = new Differ("json");
        String actual = differ.generate(filepath1, filepath2);

        assertEquals(expected, actual);
    }
}

