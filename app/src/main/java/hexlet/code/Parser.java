package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Map;


public class Parser {

    static Map<String, Object> readFile(String filepath) throws IOException {
        Path path = Paths.get("src", "main", "resources", filepath).toAbsolutePath();
        if (!Files.exists(path)) {
            throw new IOException("File not found: " + filepath);
        }

        String content = new String(Files.readAllBytes(path));

        String extension = getFileExtension(filepath);

        if (extension.equals("json")) {
            return parseJson(content);
        } else if (extension.equals("yml") || extension.equals("yaml")) {
            return parseYaml(content);
        } else {
            throw new IllegalArgumentException("Unsupported file format: " + extension);
        }
    }

    private static String getFileExtension(String filepath) {
        int lastDotIndex = filepath.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return "";
        } else {
            return filepath.substring(lastDotIndex + 1);
        }
    }

    private static Map<String, Object> parseJson(String content) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<>() { });
    }

    private static Map<String, Object> parseYaml(String content) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(content, new TypeReference<>() { });
    }

}
