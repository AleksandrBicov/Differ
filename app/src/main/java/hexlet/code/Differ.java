package hexlet.code;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    private Gson gson = new Gson();

    private Map<String, Object> readJsonFile(String filepath) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(filepath)) {
            if (inputStream == null) {
                throw new IOException("File not found: " + filepath);
            }
            String content = new String(inputStream.readAllBytes());
            return gson.fromJson(content, new TypeToken<Map<String, Object>>() { } .getType());
        }
    }

    public String generateDiff(String filepath1, String filepath2) throws IOException {
        Map<String, Object> map1 = readJsonFile(filepath1);
        Map<String, Object> map2 = readJsonFile(filepath2);
        Map<String, Object[]> diff = compareMaps(map1, map2);
        return formatDiff(diff);
    }

    private Map<String, Object[]> compareMaps(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Object[]> diff = new LinkedHashMap<>();

        Set<String> allKeys = new TreeSet<>(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);

            if (value1 == null || value2 == null) {
                // Если значение отсутствует в одном из файлов, добавляем его в diff
                diff.put(key, new Object[]{value1, value2});
            } else if (value1.equals(value2)) {
                // Если значения совпадают, добавляем ключ без изменений
                diff.put(key, new Object[]{value1, value1});
            } else {
                // Если значения не совпадают, добавляем их в diff
                diff.put(key, new Object[]{value1, value2});
            }
        }

        return diff;
    }

    private String formatDiff(Map<String, Object[]> diff) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (Map.Entry<String, Object[]> entry : diff.entrySet()) {
            String key = entry.getKey();
            Object[] values = entry.getValue();
            if (values[0] == null) {
                sb.append("  + ").append(key).append(": ").append(values[1]).append("\n");
            } else if (values[1] == null) {
                sb.append("  - ").append(key).append(": ").append(values[0]).append("\n");
            } else if (values[0].equals(values[1])) {
                sb.append("    ").append(key).append(": ").append(values[0]).append("\n");
            } else {
                sb.append("  - ").append(key).append(": ").append(values[0]).append("\n");
                sb.append("  + ").append(key).append(": ").append(values[1]).append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
