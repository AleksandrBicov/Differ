package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.nio.file.Files;


public class DifferTest {
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;

    private static String readExpectedResult(String filename) throws Exception {
        return new String(Files.readAllBytes(Paths.get("src/test/resources/fixtures/", filename)));
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readExpectedResult("json.expected");
        resultPlain = readExpectedResult("plain.expected");
        resultStylish = readExpectedResult("stylish.expected");
    }
    @Test
    public void testGenerateDiffDefaultJson() throws Exception {
        String filepath1 = "filepath1.json";
        String filepath2 = "filepath2.json";

        Differ differ = new Differ("stylish");
        String actual = differ.generate(filepath1, filepath2);

        assertEquals(resultStylish, actual);
    }

    @Test
    public void testGenerateDiffDefaultYml() throws Exception {
        String filepath1 = "filepath1.yml";
        String filepath2 = "filepath2.yml";

        Differ differ = new Differ("stylish");
        String actual = differ.generate(filepath1, filepath2);

        assertEquals(resultStylish, actual);
    }

    @Test
    public void testGenerateDiffStylishJson() throws Exception {
        String filepath1 = "filepath1.json";
        String filepath2 = "filepath2.json";

        Differ differ = new Differ("stylish");
        String actual = differ.generate(filepath1, filepath2, "stylish");

        assertEquals(resultStylish, actual);
    }

    @Test
    public void testGenerateDiffStylishYml() throws Exception {
        String filepath1 = "filepath1.yml";
        String filepath2 = "filepath2.yml";

        Differ differ = new Differ("stylish");
        String actual = differ.generate(filepath1, filepath2, "stylish");

        assertEquals(resultStylish, actual);
    }

    @Test
    public void testGenerateDiffPlainJson() throws Exception {
        String filepath1 = "filepath1.json";
        String filepath2 = "filepath2.json";

        Differ differ = new Differ("plain");
        String actual = differ.generate(filepath1, filepath2);

        assertEquals(resultPlain, actual);
    }

    @Test
    public void testGenerateDiffPlainYml() throws Exception {
        String filepath1 = "filepath1.yml";
        String filepath2 = "filepath2.yml";

        Differ differ = new Differ("plain");
        String actual = differ.generate(filepath1, filepath2);

        assertEquals(resultPlain, actual);
    }

    @Test
    public void testGenerateDiffJson() throws Exception {
        String filepath1 = "filepath1.json";
        String filepath2 = "filepath2.json";

        Differ differ = new Differ("json");
        String actual = differ.generate(filepath1, filepath2);

        assertEquals(resultJson, actual);
    }

    @Test
    public void testGenerateDiffYml() throws Exception {
        String filepath1 = "filepath1.yml";
        String filepath2 = "filepath2.yml";

        Differ differ = new Differ("json");
        String actual = differ.generate(filepath1, filepath2);

        assertEquals(resultJson, actual);
    }
}

