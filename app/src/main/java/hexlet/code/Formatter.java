package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    private String format;
    public Formatter() {
    this.format = "stylish";
    }

    public Formatter(String format,Map map1, Map map2) {
        this.format = format;
    }
    public static String format (String format, Map<String, Object[]> diff) {

        return switch (format) {
            case "plain" -> Plain.format(diff);
            default -> Stylish.stylish(diff);
        };
    }
}
