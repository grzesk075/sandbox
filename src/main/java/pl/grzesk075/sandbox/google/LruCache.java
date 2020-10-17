package pl.grzesk075.sandbox.google;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Implement a LRU cache.
 * <p>
 * Problem statement:
 * Least Recently Used (LRU) is a common caching strategy.
 * It defines the policy to evict elements from the cache to make room for new elements when the cache is full,
 * meaning it discards the least recently used items first.
 * <p>
 * Time complexity is O(n), due to list.remove() function.
 */
public class LruCache {

    private final Deque<Integer> lru = new LinkedList<>();
    private final Map<Integer, Integer> key2value = new HashMap<>();
    private final int capacity;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!contains(key)) {
            return -1;
        }
        lru.remove(key);
        lru.addFirst(key);
        return key2value.get(key);
    }

    public void put(int key, int value) {
        if (contains(key)) {
            lru.remove(key);
        } else if (lru.size() >= capacity) {
            key2value.remove(lru.getLast());
            lru.removeLast();
        }
        lru.addFirst(key);
        key2value.put(key, value);
    }

    private boolean contains(int key) {
        return key2value.containsKey(key);
    }
}
