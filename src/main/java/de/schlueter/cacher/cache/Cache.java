package de.schlueter.cacher.cache;


/**
 * Cache
 */
public interface Cache {
    /**
     * Get the value from the cache
     *
     * @param key the key
     * @return the value
     */
    String get(String key);

    /**
     * Put the value into the cache
     *
     * @param key the key
     * @param value the value
     */
    void put(String key, String value);

    /**
     * Remove the value from the cache
     *
     * @param key the key
     */
    void remove(String key);
}
