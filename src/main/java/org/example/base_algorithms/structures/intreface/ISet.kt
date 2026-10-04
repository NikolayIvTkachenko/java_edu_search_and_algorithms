package org.example.base_algorithms.structures.intreface

interface ISet<T> {
    /**
     * Add value to set.
     *
     * @param value to add.
     * @return True if added.
     */
    fun add(value: T?): Boolean

    /**
     * Remove value from set.
     *
     * @param value to remove.
     * @return True if removed.
     */
    fun remove(value: T?): Boolean

    /**
     * Clear the entire set.
     */
    fun clear()

    /**
     * Does the set contain value.
     *
     * @param value to search set for.
     * @return True if set contains value.
     */
    fun contains(value: T?): Boolean

    /**
     * Size of the set.
     *
     * @return size of the set.
     */
    fun size(): Int

    /**
     * Validate the set according to the invariants.
     *
     * @return True if the set is valid.
     */
    fun validate(): Boolean

    /**
     * Get this Set as a Java compatible Set
     *
     * @return Java compatible Set
     */
    fun toSet(): MutableSet<T?>?

    /**
     * Get this Set as a Java compatible Collection
     *
     * @return Java compatible Collection
     */
    fun toCollection(): MutableCollection<T?>?
}