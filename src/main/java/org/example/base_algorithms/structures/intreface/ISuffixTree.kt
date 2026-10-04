package org.example.base_algorithms.structures.intreface

import java.util.Set;

interface ISuffixTree<C : CharSequence?> {
    /**
     * Does the sub-sequence exist in the suffix tree.
     *
     * @param sub-sequence to locate in the tree.
     * @return True if the sub-sequence exist in the tree.
     */
    fun doesSubStringExist(sub: C?): Boolean

    /**
     * Get all the suffixes in the tree.
     *
     * @return set of suffixes in the tree.
     */
    val suffixes: MutableSet<String?>?
}