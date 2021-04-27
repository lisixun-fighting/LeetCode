package utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int cap;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity);
        cap = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Integer value = map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        if(map.size() < cap) {
            map.put(key, value);
            return;
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> it = entries.iterator();
        it.next();
        it.remove();
        map.put(key, value);
    }
}
