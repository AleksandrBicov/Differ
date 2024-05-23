package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;

import java.util.Map;


public class Parser {

    static Map<String, Object> parseJson(String content) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<>() { });
    }

    static Map<String, Object> parseYaml(String content) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(content, new TypeReference<>() { });
    }

    static Map<String, Object> getParser(String extension, String content) throws IOException {
        if (extension.equals("json")) {
            return parseJson(content);
        } else if (extension.equals("yml") || extension.equals("yaml")) {
            return parseYaml(content);
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + extension);
        }
    }
}

