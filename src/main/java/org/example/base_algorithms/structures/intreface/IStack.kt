package org.example.base_algorithms.structures.intreface

import java.util.*

interface IStack<T> {
    /**
     * Push value on top of stack
     *
     * @param value to push on the stack.
     */
    fun push(value: T?): Boolean

    /**
     * Pop the value from the top of stack.
     *
     * @return value popped off the top of the stack.
     */
    fun pop(): T?

    /**
     * Peek the value from the top of stack.
     *
     * @return value popped off the top of the stack.
     */
    fun peek(): T?

    /**
     * Remove value from stack.
     *
     * @param value to remove from stack.
     * @return True if value was removed.
     */
    fun remove(value: T?): Boolean

    /**
     * Clear the entire stack.
     */
    fun clear()

    /**
     * Does stack contain object.
     *
     * @param value object to find in stack.
     * @return True is stack contains object.
     */
    fun contains(value: T?): Boolean

    /**
     * Size of the stack.
     *
     * @return size of the stack.
     */
    fun size(): Int

    /**
     * Validate the stack according to the invariants.
     *
     * @return True if the stack is valid.
     */
    fun validate(): Boolean

    /**
     * Get this Stack as a Java compatible Queue
     *
     * @return Java compatible Queue
     */
    fun toLifoQueue(): Queue<T?>?

    /**
     * Get this Stack as a Java compatible Collection
     *
     * @return Java compatible Collection
     */
    fun toCollection(): MutableCollection<T?>?
}