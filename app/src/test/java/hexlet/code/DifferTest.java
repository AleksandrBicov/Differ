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

    private static String readExpectedResult(String formatName) throws Exception {
        return new String(Files.readString(Paths.get("src/test/resources/fixtures/", formatName)));
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readExpectedResult("json.expected");
        resultPlain = readExpectedResult("plain.expected");
        resultStylish = readExpectedResult("stylish.expected");
    }
    @Test
    public void testGenerateDiffDefaultJson() throws Exception {
        String filepath1 = "src/test/resources/fixtures/file1.json";
        String filepath2 = "src/test/resources/fixtures/file2.json";

        String actual = Differ.generate(filepath1, filepath2);

        assertEquals(resultStylish, actual);
    }

    @Test
    public void testGenerateDiffDefaultYml() throws Exception {
        String filepath1 = "src/test/resources/fixtures/file1.yml";
        String filepath2 = "src/test/resources/fixtures/file2.yml";

        String actual = Differ.generate(filepath1, filepath2);

        assertEquals(resultStylish, actual);
    }

    @Test
    public void testGenerateDiffStylishJson() throws Exception {
        String filepath1 = "src/test/resources/fixtures/file1.json";
        String filepath2 = "src/test/resources/fixtures/file2.json";

        String actual = Differ.generate(filepath1, filepath2, "stylish");

        assertEquals(resultStylish, actual);
    }

    @Test
    public void testGenerateDiffStylishYml() throws Exception {
        String filepath1 = "src/test/resources/fixtures/file1.yml";
        String filepath2 = "src/test/resources/fixtures/file2.yml";

        String actual = Differ.generate(filepath1, filepath2, "stylish");

        assertEquals(resultStylish, actual);
    }

    @Test
    public void testGenerateDiffPlainJson() throws Exception {
        String filepath1 = "src/test/resources/fixtures/file1.json";
        String filepath2 = "src/test/resources/fixtures/file2.json";

        String actual = Differ.generate(filepath1, filepath2, "plain");

        assertEquals(resultPlain, actual);
    }

    @Test
    public void testGenerateDiffPlainYml() throws Exception {
        String filepath1 = "src/test/resources/fixtures/file1.yml";
        String filepath2 = "src/test/resources/fixtures/file2.yml";

        String actual = Differ.generate(filepath1, filepath2, "plain");

        assertEquals(resultPlain, actual);
    }

    @Test
    public void testGenerateDiffJson() throws Exception {
        String filepath1 = "src/test/resources/fixtures/file1.json";
        String filepath2 = "src/test/resources/fixtures/file2.json";

        String actual = Differ.generate(filepath1, filepath2, "json");

        assertEquals(resultJson, actual);
    }

    @Test
    public void testGenerateDiffYml() throws Exception {
        String filepath1 = "src/test/resources/fixtures/file1.yml";
        String filepath2 = "src/test/resources/fixtures/file2.yml";

        String actual = Differ.generate(filepath1, filepath2, "json");

        assertEquals(resultJson, actual);
    }
}

