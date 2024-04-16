package org.training.bdd.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Memory {
    public static Map<String, Object> memory = new ConcurrentHashMap<>();

    public static synchronized void set(String key, Object value) {
        memory.put(key, value);
    }

    public static synchronized Object get(String key) {
        return memory.get(key);
    }
}
