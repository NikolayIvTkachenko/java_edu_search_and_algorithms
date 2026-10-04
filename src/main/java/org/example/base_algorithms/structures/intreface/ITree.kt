package org.example.base_algorithms.structures.intreface

interface ITree<T> {
    /**
     * Add value to the tree. Tree can contain multiple equal values.
     *
     * @param value to add to the tree.
     * @return True if successfully added to tree.
     */
    fun add(value: T?): Boolean

    /**
     * Remove first occurrence of value in the tree.
     *
     * @param value to remove from the tree.
     * @return T value removed from tree.
     */
    fun remove(value: T?): T?

    /**
     * Clear the entire stack.
     */
    fun clear()

    /**
     * Does the tree contain the value.
     *
     * @param value to locate in the tree.
     * @return True if tree contains value.
     */
    fun contains(value: T?): Boolean

    /**
     * Get number of nodes in the tree.
     *
     * @return Number of nodes in the tree.
     */
    fun size(): Int

    /**
     * Validate the tree according to the invariants.
     *
     * @return True if the tree is valid.
     */
    fun validate(): Boolean

    /**
     * Get Tree as a Java compatible Collection
     *
     * @return Java compatible Collection
     */
    fun toCollection(): MutableCollection<T?>?
}