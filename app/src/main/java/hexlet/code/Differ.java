package hexlet.code;

import java.io.IOException;
import java.util.Map;

public class Differ {
    private static String format;

    public Differ(String format) {
        this.format = format;
    }

    /**
     * Генерирует отчет о различиях между двумя файлами.
     *
     * @param filePath1 Путь к первому файлу.
     * @param filepath2 Путь ко второму файлу.
     * @return Отчет о различиях в виде строки.
     * @throws IOException Если возникает ошибка при чтении файлов.
     */
    public static String generate(String filePath1, String filepath2) throws IOException {
        return generate(filePath1, filepath2, format);
    }

    public static String generate(String filepath1, String filepath2, String format2) throws IOException {
        Map<String, Object> map1 = Parser.readFile(filepath1);
        Map<String, Object> map2 = Parser.readFile(filepath2);
        Formatter.notNull(map1);
        Formatter.notNull(map2);
        Map<String, Object[]> diff = Compare.compareMaps(map1, map2);
        return Formatter.format(format2, diff);
    }

}
