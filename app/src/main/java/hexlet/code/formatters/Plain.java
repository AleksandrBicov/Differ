package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(Map<String, Object[]> diff) {
        StringBuilder sb = new StringBuilder();

        for (var entry : diff.entrySet()) {
            String key = entry.getKey();
            Object[] values = entry.getValue();
            Object value1 = values[0];
            Object value2 = values[1];

            if (value1 == null) {
                sb.append("Property '").append(key).
                        append("' was added with value: ").append(formatValue(value2)).append("\n");
            } else if (value2 == null) {
                sb.append("Property '").append(key).append("' was removed\n");
            } else if (!value1.equals(value2)) {
                sb.append("Property '").append(key).append("' was updated. From ").
                        append(formatValue(value1)).append(" to ").
                        append(formatValue(value2)).append("\n");
            }
        }

        return sb.toString().trim();
    }

    private static String formatValue(Object value) {
    // если убираю костыль тесты падают
        //expected
        //Property 'default' was updated. From 'null' to [complex value]
        //Property 'id' was updated. From 45 to 'null'
        //actual
        //Property 'default' was added with value: [complex value]
        //Property 'id' was removed
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }
        // Тип результата всегда должен быть строкой.
        return value.toString();
    }
}
