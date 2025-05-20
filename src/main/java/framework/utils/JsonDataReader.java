package framework.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonDataReader {
    public static JSONObject getLoginData(String filePath) {
        try {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(filePath);
            return (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON data: " + e.getMessage());
        }
    }
}
