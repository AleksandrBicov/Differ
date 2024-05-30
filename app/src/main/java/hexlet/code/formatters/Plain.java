package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(Map<String, Status> diff) {
        StringBuilder sb = new StringBuilder();

        for (var entry : diff.entrySet()) {
            String key = entry.getKey();
            Status status = entry.getValue();
            Object oldValue = status.getOldValue();
            Object newValue = status.getNewValue();
            String statusName = status.getStatusName();
            switch (statusName) {
                case Status.ADDED:
                    sb.append("Property '").append(key).
                            append("' was added with value: ").append(formatValue(newValue)).append("\n");
                    break;
                case Status.DELETED:
                    sb.append("Property '").append(key).append("' was removed\n");
                    break;
                case Status.CHANGED:
                    sb.append("Property '").append(key).append("' was updated. From ").
                            append(formatValue(oldValue)).append(" to ").
                            append(formatValue(newValue)).append("\n");
                    break;
                case Status.UNCHANGED:
                    break;
                default:
                    throw new RuntimeException("Unknown status: " + statusName);
            }
        }

        return sb.toString().trim();
    }

    private static String formatValue(Object value) {
        
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }
        return value.toString();
    }
}
