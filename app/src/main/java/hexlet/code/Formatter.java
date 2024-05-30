package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {

    public static String format(String format, Map<String, Status> diff) throws JsonProcessingException {
        return switch (format) {
            case "plain" -> Plain.format(diff);
            case "json" -> JsonFormatter.format(diff);
            default -> Stylish.stylish(diff);
        };
    }
}
