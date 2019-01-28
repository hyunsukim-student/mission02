package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
import edu.isu.cs.cs3308.structures.impl.Node;
import java.io.*;

public class SinglyLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;


    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        } else if (head == null) {
            head = tail;
            return head.getElement();
        } else if (head != null) {
            return head.getElement();
        }
        //First

        return null;
    }

    @Override
    public E last() {
        if (isEmpty() == true) {
            return null;
        } else {
            if (tail != null) {
                return tail.getElement();
            }
            return null;
        }
    }

    @Override
    public void addLast(E element) {

        if (element == null) {
            return;
        } else {
            Node<E> newNode = new Node<>(element, null);
            if(isEmpty() == true){
                head = newNode;
            }else{
                tail.setNext(newNode);
            }

            tail = newNode;
            size++;
        }

    }

    @Override
    public void addFirst(E element) {
        if (element == null) {
            return;
        } else {
            Node<E> newNode = new Node<E>(element);
            newNode.setNext(head);
            head = newNode;
            if (size == 0) {
                tail = head;
            }
            size++;
        }

    }

    @Override
    public E removeFirst() {
        if (isEmpty() == true) {
            return null;
        } else if (head == null) {
            return null;
        } else if (head != null) {
            Node<E> newNode = head;
            head = newNode.getNext();
            E data = newNode.getElement();
            newNode = null;
            if (head == null) {
                tail = null;
            }
            size--;
            return data;
        }
        return null;
    }

    @Override
    public E removeLast() {
        if (isEmpty() == true) {
            return null;
        } else {
            E result = tail.getElement();
            size--;
            return result;
        }
    }

    @Override
    public void insert(E element, int index) {
        if (index < 0 || element == null) {
            return;
        } else {
            if (index >= size) {
                addLast(element);
                return;
            } else if (index == 0) {
                addFirst(element);
                return;
            }

            Node<E> firstOne = head;
            for (int i = 0; i < index - 1; i++) {
                firstOne = firstOne.getNext();
            }

            Node<E> secondOne = firstOne.getNext();
            Node<E> result = new Node<E>(element);
            result.setNext(secondOne);
            firstOne.setNext(result);
            size++;
            if (result.getNext() == null) {
                tail = result;
            }
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size || isEmpty() == true)
            return null;
        else if (size == 1 && head != null) {
            removeFirst();
        } else if (size == 1 && tail != null) {
            removeLast();
        }
        Node<E> firstOne = head;
        for (int i = 0; i < index - 1; i++) {
            firstOne = firstOne.getNext();
        }
        Node<E> toRemove = firstOne.getNext();
        Node<E> secondOne = toRemove.getNext();
        firstOne.setNext(secondOne);
        size--;
        return toRemove.getElement();

    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            return null;
        } else {
            Node<E> newNode = head;
            for (int i = 0; i < index; i++) {
                newNode = newNode.getNext();
            }
            return newNode.getElement();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void printList() {
        for (int i = 0; i < size(); i++) {
            System.out.println(get(i));
        }
    }
}
