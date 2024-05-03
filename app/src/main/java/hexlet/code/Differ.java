package hexlet.code;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public String generateDiff(String filepath1, String filepath2) throws IOException {
        Map<String, String> map1 = Parser.readFile(filepath1);
        Map<String, String> map2 = Parser.readFile(filepath2);
        Map<String, String[]> diff = compareMaps(map1, map2);
        return formatDiff(diff);
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
    private Map<String, String[]> compareMaps(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String[]> diff = new LinkedHashMap<>();

        // Объединяем ключи из обоих Map
        Set<String> allKeys = new TreeSet<>(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            String value1 = map1.get(key);
            String value2 = map2.get(key);

            // Если значение отсутствует в первом Map
            if (value1 == null) {
                diff.put(key, new String[]{null, value2});

            } else if (value2 == null) { // Если значение отсутствует во втором Map
                diff.put(key, new String[]{value1, null});

            } else if (value1.equals(value2)) { // Если значения совпадают
                diff.put(key, new String[]{value1, value1});

            } else { // Если значения не совпадают
                diff.put(key, new String[]{value1, value2});
            }
        }

        return diff;
    }

    /**
     * Форматирует Map с различиями в виде строки.
     *
     * @param diff Map с различиями, где ключ - это ключ из обоих Map, а значение - массив из двух элементов:
     *             - значение из первого Map
     *             - значение из второго Map
     * @return Отформатированная строка с различиями.
     */
    private String formatDiff(Map<String, String[]> diff) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        for (var entry : diff.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();

            // Если значение было добавлено во второй Map
            if (values[0] == null) {
                sb.append("  + ").append(key).append(": ").append(values[1]).append("\n");

            } else if (values[1] == null) { // Если значение было удалено из первого Map
                sb.append("  - ").append(key).append(": ").append(values[0]).append("\n");

            } else if (values[0].equals(values[1])) { // Если значения не изменились
                sb.append("    ").append(key).append(": ").append(values[0]).append("\n");

            } else { // Если значение было изменено
                sb.append("  - ").append(key).append(": ").append(values[0]).append("\n");
                sb.append("  + ").append(key).append(": ").append(values[1]).append("\n");
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
