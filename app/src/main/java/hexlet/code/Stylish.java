package hexlet.code;

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
        sb.append("{\n");

        // Форматируем каждую пару ключ-значение
        for (var entry : diff.entrySet()) {
            String key = entry.getKey();
            Object[] values = entry.getValue();

            // Если значение было добавлено во второй Map
            if (values[0] == null) {
                sb.append("  + ").append(key).append(": ").append(formatValue(values[1])).append("\n");

            } else if (values[1] == null) { // Если значение было удалено из первого Map
                sb.append("  - ").append(key).append(": ").append(formatValue(values[0])).append("\n");

            } else if (values[0].equals(values[1])) { // Если значения не изменились
                sb.append("    ").append(key).append(": ").append(formatValue(values[0])).append("\n");

            } else { // Если значение было изменено
                sb.append("  - ").append(key).append(": ").append(formatValue(values[0])).append("\n");
                sb.append("  + ").append(key).append(": ").append(formatValue(values[1])).append("\n");
            }
        }

        sb.append("}");
        return sb.toString();
    }

    /**
     * Форматирует значение для вывода в стиле "stylish".
     * Если значение является числом с плавающей запятой, которое представляет целое число,
     * оно будет преобразовано в целое число.
     *
     * @param value Значение для форматирования.
     * @return Отформатированное значение.
     */
    private static String formatValue(Object value) {
        if (value instanceof Double) {
            double doubleValue = (double) value;
            if (doubleValue == Math.floor(doubleValue) && !Double.isInfinite(doubleValue)) {
                // Если значение является целым числом, форматируем его как целое число
                return String.format("%d", (long) doubleValue);
            } else {
                // Если значение является числом с плавающей запятой, оставляем его как double
                return value.toString();
            }
        } else if (value instanceof Integer) {
            // Если значение является целым числом, преобразуем его в целое и выводим как целое
            return value.toString();
        } else if (value instanceof Object[]) {
            // Если значение является массивом, рекурсивно форматируем его элементы
            Object[] arrayValue = (Object[]) value;
            StringBuilder arraySb = new StringBuilder("[");
            for (int i = 0; i < arrayValue.length; i++) {
                arraySb.append(formatValue(arrayValue[i]));
                if (i < arrayValue.length - 1) {
                    arraySb.append(", ");
                }
            }
            arraySb.append("]");
            return arraySb.toString();
        } else {
            // Если значение не является числом, оставляем его как строку
            return value.toString();
        }
    }
}