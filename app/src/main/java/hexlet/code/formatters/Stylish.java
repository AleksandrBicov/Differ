package hexlet.code.formatters;
import java.util.Map;

public class Stylish {

    /**
     * Форматирует диф в стиле "stylish".
     *
     * @param diff Диф между двумя Map, где ключ - это ключ из обоих Map, а значение - массив из двух элементов:
     *             - значение из первого Map
     *             - значение из второго Map
     * @return Отформатированный диф в виде строки.
     */
    public static String stylish(Map<String, Object[]> diff) {
        StringBuilder sb = new StringBuilder();

        // Форматируем каждую пару ключ-значение
        for (var entry : diff.entrySet()) {
            String key = entry.getKey();
            Object[] values = entry.getValue();
            Object value1 = values[0];
            Object value2 = values[1];
            // Если значение отсутствует в первом Map
            if (value1 == null) {
                sb.append("  + ").append(key).append(": ").append(value2).append("\n");
            } else if (value2 == null) { // Если значение отсутствует во втором Map
                sb.append("  - ").append(key).append(": ").append(value1).append("\n");
            } else if (value1.equals(value2)) { // Если значения совпадают
                sb.append("    ").append(key).append(": ").append(value1).append("\n");
            } else { // Если значения не совпадают
                sb.append("  - ").append(key).append(": ").append(value1).append("\n");
                sb.append("  + ").append(key).append(": ").append(value2).append("\n");
            }
        }
        return sb.toString();
    }
}
