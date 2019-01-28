package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

public class DoublyLinkedList<E> extends SinglyLinkedList<E> implements List<E> {

    public class Node<E> {

        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public Node(E e) {
            element = e;
        }

        public Node(){};

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() { return prev; }

        public void setNext(Node<E> n) { next = n; }

        public void setPrev(Node<E> p) {prev = p;}

        public void setElement(E e) {
            this.element = e;
        }


    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public DoublyLinkedList(){
        head = new Node<>(null,null,null);
        tail = new Node<>(null,head,null);
        head.setNext(tail);
    }

    SinglyLinkedList<E> singlyLinkedList = new SinglyLinkedList<E>();

    @Override
    public E first() {
        if(isEmpty() == true){
            return null;
        }else if(head != null){
            return head.getNext().getElement();
        }else if(head == null){
            return tail.getElement();
        }
        return null;
    }

    @Override
    public E last() {
        if(isEmpty() == true){
            return null;
        }else{
            return tail.getPrev().getElement();
        }
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if(element == null){
            return;
        }else{
            newNode.setPrev(tail.getPrev());
            newNode.setNext(tail);
            tail.getPrev().setNext(newNode);
            tail.setPrev(newNode);
            size++;

        }

    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (element == null) {
            return;
        } else {
                newNode.setPrev(head);
                newNode.setNext(head.getNext());
                head.setNext(newNode);
                newNode.getNext().setPrev(newNode);
                size++;
        }
    }
    @Override
    public E removeFirst() {
        if(isEmpty() == true && head == null){
            return null;
        }else{
            E result = head.getNext().getElement();
            size--;
            return result;
        }
    }

    @Override
    public E removeLast() {
        if(isEmpty() == true){
            return null;
        }else{
            Node<E> tailPrev = tail.getPrev();
            tail.setPrev(tailPrev.getPrev());
            tailPrev.getPrev().setNext(tail);
            tailPrev.setPrev(null);
            tailPrev.setNext(null);
            size--;
            return tailPrev.getElement();
        }
    }

    @Override
    public void insert(E element, int index) {
        if(index < 0 || element == null){
            return;
        }else if(index >= size()){
            addLast(element);
            return;
        }else if(index == 0){
            addFirst(element);
            return;
        }

        Node<E> temp = head.getNext();
        for(int i = 0; i < index-1; i++){
            temp = temp.getNext();
        }
        Node<E> newNode = new Node<E>(element);
        newNode.setNext(temp.getNext());
        newNode.setPrev(temp);
        newNode.getNext().setPrev(newNode);
        temp.setNext(newNode);
        size++;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size || isEmpty() == true){
            return null;
        }
        Node<E> toRemove = head.getNext();
        for(int i = 0; i < index ; i ++){
            toRemove = toRemove.getNext();
        }
        toRemove.setPrev(null);
        toRemove.setNext(null);
        size--;
        return toRemove.getElement();
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size()){
            return null;
        }else{
            Node<E> newNode = head.getNext();
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
        if(size() == 0){
            return true;
        }else{
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
