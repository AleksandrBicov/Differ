package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    private String format;

    public Formatter(String format) {
        this.format = format;
    }

    public static String format(String format, Map<String, Object[]> diff) throws JsonProcessingException {
        switch (format) {
            case "plain":
                return Plain.format(diff);
            case "json":
                return JsonFormatter.format(diff);
            default:
                return Stylish.stylish(diff);
        }
    }
}
