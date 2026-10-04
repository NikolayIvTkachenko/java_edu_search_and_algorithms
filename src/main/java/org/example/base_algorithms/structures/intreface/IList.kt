package org.example.base_algorithms.structures.intreface

interface IList<T> {
    /**
     * Add value to list.
     *
     * @param value to add.
     * @return True if added.
     */
    fun add(value: T?): Boolean

    /**
     * Remove value from list.
     *
     * @param value to remove.
     * @return True if removed.
     */
    fun remove(value: T?): Boolean

    /**
     * Clear the entire list.
     */
    fun clear()

    /**
     * Does the list contain value.
     *
     * @param value to search list for.
     * @return True if list contains value.
     */
    fun contains(value: T?): Boolean

    /**
     * Size of the list.
     *
     * @return size of the list.
     */
    fun size(): Int

    /**
     * Validate the list according to the invariants.
     *
     * @return True if the list is valid.
     */
    fun validate(): Boolean

    /**
     * Get this List as a Java compatible List
     *
     * @return Java compatible List
     */
    fun toList(): MutableList<T?>?

    /**
     * Get this List as a Java compatible Collection
     *
     * @return Java compatible Collection
     */
    fun toCollection(): MutableCollection<T?>?
}