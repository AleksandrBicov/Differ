package hexlet.code.formatters;



import hexlet.code.Status;

import java.util.Map;

public class Stylish {

    public static String stylish(Map<String, Status> diff) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n ");
        // Форматируем каждую пару ключ-значение
        for (var entry : diff.entrySet()) {
            String key = entry.getKey();
            Status status = entry.getValue();
            Object oldValue = status.getOldValue();
            Object newValue = status.getNewValue();
            String statusName = status.getStatusName();
            switch (statusName) {
                case Status.ADDED:
                    sb.append("  + ").append(key).append(": ").append(formatValue(newValue)).append("\n");
                    break;
                case Status.DELETED:
                    sb.append("  - ").append(key).append(": ").append(formatValue(oldValue)).append("\n");
                    break;
                case Status.UNCHANGED:
                    sb.append("   ").append(key).append(": ").append(formatValue(oldValue)).append("\n");
                    break;
                case Status.CHANGED:
                    sb.append("  - ").append(key).append(": ").append(formatValue(oldValue)).append("\n");
                    sb.append("  + ").append(key).append(": ").append(formatValue(newValue)).append("\n");
                    break;
                default:
                    throw new RuntimeException("Unknown status: " + statusName);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private static String formatValue(Object value) {

        if (value == null) {
            return "null";
        }
        return value.toString();
    }
}
