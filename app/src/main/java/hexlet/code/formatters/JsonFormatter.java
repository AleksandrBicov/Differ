package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonFormatter {
    public static String format(Map<String, Object[]> diff) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> formattedDiff = new ArrayList<>();

        for (Map.Entry<String, Object[]> entry : diff.entrySet()) {
            String key = entry.getKey();
            Object[] values = entry.getValue();
            Object oldValue = values[0];
            Object newValue = values[1];
            String status = getStatus(oldValue, newValue);

            Map<String, Object> change = new HashMap<>();
            change.put("key", key);
            change.put("oldvalue", oldValue);
            change.put("newvalue", newValue);
            change.put("status", status);

            formattedDiff.add(change);
        }

        return mapper.writeValueAsString(formattedDiff);
    }

    private static String getStatus(Object oldValue, Object newValue) {
        if (oldValue == null && newValue != null) {
            return "added";
        } else if (oldValue != null && newValue == null) {
            return "removed";
        } else if (!oldValue.equals(newValue)) {
            return "updated";
        } else {
            return "unmodified";
        }
    }
}