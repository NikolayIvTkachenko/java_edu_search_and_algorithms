package org.example.base_algorithms.structures.intreface

interface IHeap<T> {
    /**
     * Add value to the heap.
     *
     * @param value to add to the heap.
     * @return True if added to the heap.
     */
    fun add(value: T?): Boolean

    /**
     * Get the value of the head node from the heap.
     *
     * @return value of the head node.
     */
    val headValue: T?

    /**
     * Remove the head node from the heap.
     *
     * @return value of the head node.
     */
    fun removeHead(): T?

    /**
     * Remove the value from the heap.
     *
     * @param value to remove from heap.
     * @return True if value was removed form the heap;
     */
    fun remove(value: T?): T?

    /**
     * Clear the entire heap.
     */
    fun clear()

    /**
     * Does the value exist in the heap. Warning this is a O(n) operation.
     *
     * @param value to locate in the heap.
     * @return True if the value is in heap.
     */
    fun contains(value: T?): Boolean

    /**
     * Get size of the heap.
     *
     * @return size of the heap.
     */
    fun size(): Int

    /**
     * Validate the heap according to the invariants.
     *
     * @return True if the heap is valid.
     */
    fun validate(): Boolean

    /**
     * Get this Heap as a Java compatible Collection
     *
     * @return Java compatible Collection
     */
    fun toCollection(): MutableCollection<T?>?
}