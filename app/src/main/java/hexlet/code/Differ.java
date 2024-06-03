package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {

    /**
     * Генерирует отчет о различиях между двумя файлами.
     *
     * @param filePath1 Путь к первому файлу.
     * @param filepath2 Путь ко второму файлу.
     * @return Отчет о различиях в виде строки.
     * @throws IOException Если возникает ошибка при чтении файлов.
     */
    public static String generate(String filePath1, String filepath2) throws IOException {
        return generate(filePath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String format2) throws IOException {
        Map<String, Object> map1 = read(filepath1);
        Map<String, Object> map2 = read(filepath2);
        Map<String, Status> diff = Compare.compareMaps(map1, map2);
        return Formatter.format(format2, diff);
    }

    static Map<String, Object> read(String filepath) throws IOException {

        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new IOException("File not found: " + filepath);
        }


        String content = new String(Files.readString(path));

        String extension = getDataFormat(filepath);

        return Parser.getParser(extension, content);
    }

    private static String getDataFormat(String filepath) {
        int lastDotIndex = filepath.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return "";
        } else {
            return filepath.substring(lastDotIndex + 1);
        }
    }
}

