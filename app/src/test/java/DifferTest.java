import hexlet.code.Differ;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;


public class DifferTest {
    private static String resultJson;

    private static String read(String fileName) throws Exception {
        Path path = Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }
    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = read("result_json");
    }

    @Test
    public void testRightComparisonFormatJSON() throws Exception {
        Differ differ = new Differ();
        String result = differ.generateDiff("filepath1.json", "filepath2.json");
        assertEquals(resultJson, result);
    }
    @Test
    public void testInvalidJsonFormat() {
        Differ differ = new Differ();
        assertThrows(IOException.class, () -> differ.generateDiff("invalid_json1.json", "filepath2.json"));
        assertThrows(IOException.class, () -> differ.generateDiff("filepath1.json", "invalid_json2.json"));
    }
}