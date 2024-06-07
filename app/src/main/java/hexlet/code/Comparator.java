package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class Comparator {
    /**
     * Сравнивает два Map и возвращает Map с различиями.
     *
     * @param map1 Первый Map для сравнения.
     * @param map2 Второй Map для сравнения.
     * @return Map с различиями, где ключ - это ключ из обоих Map, а значение - массив из двух элементов:
     *         - значение из первого Map
     *         - значение из второго Map
     */
    static Map<String, Status> compareMaps(Map<String, Object> map1, Map<String, Object> map2) {

        Map<String, Status> diff = new LinkedHashMap<>();
        // Объединяем ключи из обоих Map
        Set<String> allKeys = new TreeSet<>(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);

            // Если значение отсутствует в первом Map
            if (!map1.containsKey(key)) {
                diff.put(key, new Status(Status.ADDED, null, value2));

            } else if (!map2.containsKey(key)) { // Если значение отсутствует во втором Map
                diff.put(key, new Status(Status.DELETED, value1, null));

            } else if (Objects.equals(value1, value2)) { // Если значения совпадают
                diff.put(key, new Status(Status.UNCHANGED, value1, value1));

            } else if (!Objects.equals(value1, value2)) { // Если значения не совпадают
                diff.put(key, new Status(Status.CHANGED, value1, value2));
            } else {
                throw new RuntimeException("Unknown status: " + key);
            }
        }
        return diff;
    }

}
