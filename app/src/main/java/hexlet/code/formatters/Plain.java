package hexlet.code.formatters;

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
                sb.append("Property '").append(key).append("' was added with value: ").append(formatValue(value2)).append("\n");
            } else if (value2 == null) {
                sb.append("Property '").append(key).append("' was removed\n");
            } else if (!value1.equals(value2)) {
                sb.append("Property '").append(key).append("' was updated. From ").append(formatValue(value1)).append(" to ").append(formatValue(value2)).append("\n");
            }
        }

        return sb.toString().trim();
    }

    private static String formatValue(Object value) {
        if (value instanceof Map || value instanceof Iterable) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return String.valueOf(value);
        }
    }
}