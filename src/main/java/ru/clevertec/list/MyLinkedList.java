package ru.clevertec.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public T get(int index) {
        checkByIndex(index);
        return getNodeByIndex(index).currentElem;
    }

    @Override
    public void set(int index, T t) {
        checkByIndex(index);
        Node<T> currentNode = getNodeByIndex(index);
        currentNode.currentElem = t;
    }

    @Override
    public void add(T t) {
        Node<T> lastNode = last;
        Node<T> newNode = new Node<T>(lastNode, t, null);
        last = newNode;
        if (lastNode == null) {
            first = newNode;
        } else {
            lastNode.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T t) {
        if (index != size) {
            checkByIndex(index);
        } else {
            add(t);
            return;
        }
        if (index == 0 && first != null) {
            Node<T> currentNode = first;
            Node<T> newNode = new Node<T>(null, t, currentNode);
            currentNode.previous = newNode;
            first = newNode;
            size++;
        } else {
            Node<T> currentNode = getNodeByIndex(index);
            Node<T> previousNode = currentNode.previous;
            Node<T> newNode = new Node<>(previousNode, t, currentNode);
            currentNode.previous = newNode;
            previousNode.next = newNode;
            size++;
        }
    }

    @Override
    public void remove(T t) {
        Node<T> currentNode = first;
        for (int i = 0; i < size; i++) {
            if (currentNode.currentElem.equals(t) && currentNode.equals(first)) {
                Node<T> nextNode = currentNode.next;
                if (!Objects.isNull(nextNode)) {
                    nextNode.previous = null;
                }
                first = nextNode;
                size--;
                return;
            } else if (currentNode.currentElem.equals(t) && !currentNode.equals(first) && !currentNode.equals(last)) {
                Node<T> nextNode = currentNode.next;
                Node<T> prevNode = currentNode.previous;
                nextNode.previous = prevNode;
                prevNode.next = nextNode;
                size--;
                return;
            } else if (currentNode.currentElem.equals(t) && currentNode.equals(last)) {
                Node<T> prevNode = currentNode.previous;
                if (!Objects.isNull(prevNode)) {
                    prevNode.next = null;
                }
                last = prevNode;
                size--;
                return;
            }
            currentNode = currentNode.next;
        }
        throw new NoSuchElementException(t + " element not found");
    }

    @Override
    public void remove(int index) {
        checkByIndex(index);
        Node<T> currentNode = getNodeByIndex(index);
        if (index == 0 && currentNode.equals(first)) {
            Node<T> nextNode = currentNode.next;
            if (!Objects.isNull(nextNode)) {
                nextNode.previous = null;
            }
            first = nextNode;
            size--;
        } else if (index == (size - 1) && currentNode.equals(last)) {
            Node<T> prevNode = currentNode.previous;
            if (!Objects.isNull(prevNode)) {
                prevNode.next = null;
            }
            last = prevNode;
            size--;
        } else {
            Node<T> nextNode = currentNode.next;
            Node<T> previousNode = currentNode.previous;
            nextNode.previous = previousNode;
            previousNode.next = nextNode;
            size--;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> currentNode = first;
        for (int i = 0; i < size; i++) {
            result.append(i).append(")").append(currentNode.currentElem).append(" ");
            currentNode = currentNode.next;
        }
        return result.toString();
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    private void checkByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " does not exist");
        }
    }

    private static class Node<T> {
        Node<T> previous;
        T currentElem;
        Node<T> next;


        public Node(Node<T> previous, T currentElem, Node<T> next) {
            this.previous = previous;
            this.currentElem = currentElem;
            this.next = next;
        }
    }

}

