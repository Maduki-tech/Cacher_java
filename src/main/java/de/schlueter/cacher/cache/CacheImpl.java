package de.schlueter.cacher.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * CacheImpl
 */
public class CacheImpl implements Cache {
    private Map<String, String> cache;

    public CacheImpl() {
        cache = new HashMap<>();
    }

    @Override
    public String get(String key) {
        return cache.get(key);
    }

    @Override
    public void put(String key, String value) {
        cache.put(key, value);
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
    }

    // public boolean isExpired(St key){
    //     // is expired if the key is older than 5 minutes
    //     return key.getTime() < (System.currentTimeMillis() - 300000);
    // }
}
