package utilities;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static final Map<String, Object> contextData = new HashMap<>();

    public static void set(String key, Object value) {
        contextData.put(key, value);
    }

    public static <T> T get(String key) {
        return  (T) contextData.get(key);
    }

    public static void clear() {
        contextData.clear();
    }
}

