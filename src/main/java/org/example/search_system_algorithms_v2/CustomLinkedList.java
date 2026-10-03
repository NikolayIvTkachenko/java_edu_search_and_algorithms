package org.example.search_system_algorithms_v2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomLinkedList<E> implements List<E> {

    private int size;
    private Node head;

    public CustomLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node node = head;
            // проходим до последнего узла
            for ( ; node.next != null; node = node.next) {}
            node.next = new Node(element);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        if (index == 0) {
            head = new Node(element, head);
        } else {
            Node node = getNode(index-1);
            node.next = new Node(element, node.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        E element = get(index);
        if (index == 0) {
            head = head.next;
        } else {
            Node node = getNode(index - 1);
            node.next = node.next.next;
        }
        size--;
        return element;
    }

    @Override
    public int indexOf(Object target) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (equals(target, node.data)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    private Node getNode(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i=0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
