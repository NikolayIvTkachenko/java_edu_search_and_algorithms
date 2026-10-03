package org.example.search_system_algorithms_v2;

public class Node<E> {
    public E data;
    public Node next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public Node(E data, Node next) {
        this.data = data;
        this.next = next;
    }
}
