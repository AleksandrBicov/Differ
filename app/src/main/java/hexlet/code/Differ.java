package hexlet.code;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    private String format;

    public Differ() {
        this.format = "stylish";
    }

    public Differ(String format) {
        this.format = format;
    }

    /**
     * Генерирует отчет о различиях между двумя файлами.
     *
     * @param filepath1 Путь к первому файлу.
     * @param filepath2 Путь ко второму файлу.
     * @return Отчет о различиях в виде строки.
     * @throws IOException Если возникает ошибка при чтении файлов.
     */
    public String generate(String filepath1, String filepath2) throws IOException {
        Map<String, Object> map1 = Parser.readFile(filepath1);
        Map<String, Object> map2 = Parser.readFile(filepath2);
        Map<String, Object[]> diff = compareMaps(map1, map2);
        return Formatter.format(format, diff);
    }

     /**
     * Сравнивает два Map и возвращает Map с различиями.
     *
     * @param map1 Первый Map для сравнения.
     * @param map2 Второй Map для сравнения.
     * @return Map с различиями, где ключ - это ключ из обоих Map, а значение - массив из двух элементов:
     *         - значение из первого Map
     *         - значение из второго Map
     */
    private Map<String, Object[]> compareMaps(Map<String, Object> map1, Map<String, Object> map2) {
        // Проверяем значения Map на null
        // и если таковые встречаются заменяем их на String "null"
        map1.forEach((key, value) -> {
            if (value == null) {
                map1.put(key, "null");
            }
        });
        map2.forEach((key, value) -> {
            if (value == null) {
                map2.put(key, "null");
            }
        });
        Map<String, Object[]> diff = new LinkedHashMap<>();
        // Объединяем ключи из обоих Map
        Set<String> allKeys = new TreeSet<>(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);

            // Если значение отсутствует в первом Map
            if (value1 == null) {
                diff.put(key, new Object[]{null, value2});

            } else if (value2 == null) { // Если значение отсутствует во втором Map
                diff.put(key, new Object[]{value1, null});

            } else if (value1.equals(value2)) { // Если значения совпадают
                diff.put(key, new Object[]{value1, value1});

            } else { // Если значения не совпадают
                diff.put(key, new Object[]{value1, value2});
            }
        }

        return diff;
    }

}
