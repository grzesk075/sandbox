package pl.grzesk075.sandbox.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class LruCacheTest {

    @Test
    public void lruCacheTest() {
        final LruCache lruCache = new LruCache(4);
        assertEquals(-1,lruCache.get(8));
        assertEquals(-1,lruCache.get(8));
        lruCache.put(8,123);
        assertEquals(123,lruCache.get(8));
        assertEquals(123,lruCache.get(8));
        lruCache.put(8,123);
        lruCache.put(8,123);
        lruCache.put(8,123);
        lruCache.put(8,123);
        assertEquals(123,lruCache.get(8));
        lruCache.put(1,333);
        lruCache.put(1,333);
        lruCache.put(1,333);
        lruCache.put(1,333);
        lruCache.put(1,333);
        assertEquals(123,lruCache.get(8));
        assertEquals(333,lruCache.get(1));
        lruCache.put(5,3);
        lruCache.put(6,3);
        lruCache.put(7,3);
        assertEquals(333,lruCache.get(1));
        lruCache.put(1,333);
        assertEquals(-1,lruCache.get(8));
        lruCache.put(10,22);
        assertEquals(-1,lruCache.get(5));
        assertEquals(333,lruCache.get(1));
        assertEquals(3,lruCache.get(6));
        assertEquals(3,lruCache.get(7));
    }
}