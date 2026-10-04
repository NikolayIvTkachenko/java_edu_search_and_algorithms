package org.example.base_algorithms.structures.intreface

interface IMap<K, V> {
    /**
     * Put key->value pair in the map.
     *
     * @param key to be inserted.
     * @param value to be inserted.
     * @return V previous value or null if none.
     */
    fun put(key: K?, value: V?): V?

    /**
     * Get value for key.
     *
     * @param key to get value for.
     * @return value mapped to key.
     */
    fun get(key: K?): V?

    /**
     * Remove key and value from map.
     *
     * @param key to remove from the map.
     * @return True if removed or False if not found.
     */
    fun remove(key: K?): V?

    /**
     * Clear the entire map.
     */
    fun clear()

    /**
     * Does the map contain the key.
     *
     * @param key to locate in the map.
     * @return True if key is in the map.
     */
    fun contains(key: K?): Boolean

    /**
     * Number of key/value pairs in the hash map.
     *
     * @return number of key/value pairs.
     */
    fun size(): Int

    /**
     * Validate the map according to the invariants.
     *
     * @return True if the map is valid.
     */
    fun validate(): Boolean

    /**
     * Wraps this map in a Java compatible Map
     *
     * @return Java compatible Map
     */
    fun toMap(): MutableMap<K?, V?>?
}