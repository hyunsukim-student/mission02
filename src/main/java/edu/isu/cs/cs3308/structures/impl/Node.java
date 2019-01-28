package edu.isu.cs.cs3308.structures.impl;

public class Node<E> {

        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }

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
