package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Status;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonFormatter {

    public static String format(Map<String, Status> diff) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        LinkedHashMap<String, Object> formattedDiff = new LinkedHashMap<>();

        for (Map.Entry<String, Status> entry : diff.entrySet()) {
            String key = entry.getKey();
            Status status = entry.getValue();

            if (status.getStatusName().equals("unchanged")) {
                formattedDiff.put(key, Arrays.asList(status.getOldValue(), status.getOldValue()));
            } else {
                formattedDiff.put(key, Arrays.asList(status.getOldValue(), status.getNewValue()));
            }
        }
        return mapper.writeValueAsString(formattedDiff);
    }
}
