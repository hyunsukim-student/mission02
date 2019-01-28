package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

import java.util.PrimitiveIterator;
import edu.isu.cs.cs3308.structures.impl.Node;

public class LinkedStack<E> extends DoublyLinkedList<E> implements Stack<E> {


    DoublyLinkedList<E> dou = new DoublyLinkedList<>();

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public LinkedStack(){
        head = new Node<E>(null,null,null);
        tail = new Node<E>(null,head,null);
        head.setNext(tail);
    }

    @Override
    public void push(E element) {
        dou.addLast(element);
    }

    @Override
    public E peek() {
        return dou.last();
    }

    @Override
    public E pop() {
        return dou.removeLast();
    }

    @Override
    public int size() {
        return dou.size();
    }

    @Override
    public boolean isEmpty() {
       return dou.isEmpty();
    }

    @Override
    public void transfer(Stack<E> to) {
        if(to == null){
            return;
        }
        while (!isEmpty()){
            E num = peek();
            pop();
            to.push(num);
        }
    }

    @Override
    public void reverse() {
        for(int i = 0; i < size(); i++){
            E num = peek();
            pop();
            dou.insert(num, i);
        }
    }

    @Override
    public void merge(Stack<E> other) {
        if(other == null){
            return;
        }
        int s = other.size();
        //Stack<E> other1 = other;
        for(int i = 0; i < s; i++){
            E num = dou.get(i);
            push(num);
        }
    }

    @Override
    public void printStack() {
        int s = dou.size();
        reverse();
        for (int i = 0; i < s; i++) {
            System.out.println(dou.get(i));
        }
    }
}
