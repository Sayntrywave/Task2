package ru.vsu.cs.util;

import java.lang.reflect.Array;
import java.util.HashSet;

public class SimpleLinkedList <T> {

     private class SimpleLinkedListNode <T>{
        public T value;
        public SimpleLinkedListNode next;
        public SimpleLinkedListNode(T value, SimpleLinkedListNode next){
            this.value = value;
            this.next = next;
        }
        public SimpleLinkedListNode(T value){
            this(value,null);
        }
        public SimpleLinkedListNode(){
            this(null,null);
        }
    }

    private SimpleLinkedListNode head ;
    private SimpleLinkedListNode tail ;
    private int count;



/*    public SimpleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public SimpleLinkedList (int[] arr){
*//*        if(arr == null || arr.length == 0){
         //SimpleLinkedList();
            //this();
        }*//*
        this();
        if(arr == null || arr.length == 0) {
            return;
        }
        head = new
        for (int i = 0; i < arr.length; i++) {

        }
    }*/

    public void removeFirst() throws Exception {
        if(head == null){
            throw new Exception("List is empty");
        }
        else {
            head = head.next;
            count--;
        }
    }
    public int size(){
        return count;
    }

    public void remove(int index) throws Exception {
        if (index < 0 || index >= count){
            throw new Exception("Wrong index");
        }
        if(index == 0){
            removeFirst();
        }
        else {
            SimpleLinkedListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
        }

        count--;
    }

    public void insert(T value, int index) throws Exception {
        if (index < 0 || index > count){
            throw new Exception("Wrong index");
        }
        if (index ==0){
            addFirst(value);
        }
        if (index == count){
            addLast(value);
        }
        else {
            SimpleLinkedListNode prev = getNode(index - 1);
            prev.next = new SimpleLinkedListNode(value, prev.next);
            count++;
        }
    }

    public void set(T value, int index) throws Exception {
        SimpleLinkedListNode curr = getNode(index);
        curr.value = value;
    }
    private SimpleLinkedListNode<T> getNode(int index) throws Exception{
        if (index >= count){
            throw new Exception("Wrong index");
        }
        SimpleLinkedListNode currNode = head;

        for (int i = 0; i < index; i++) {
            currNode = currNode.next;
        }
         return currNode;
    }

    public T get(int index) throws Exception{
        return getNode(index).value;
    }

    public void addFirst(T value){
        if(head == null){
            tail = head = new SimpleLinkedListNode(value, null);
        }
        else {
            head = new SimpleLinkedListNode(value, head);
        }
        count++;
    }

    public void copyArray(T[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        addFirst(arr[0]);
        for (int i = 1; i < arr.length ; i++) {
            addLast(arr[i]);
        }
    }

/*    public void copyArray(int[] array){
        if(array == null || array.length == 0) {
            return;
        }
        if(array.length > )
        SimpleLinkedListNode currNode = new SimpleLinkedListNode<>(array[1], null);
        head = new SimpleLinkedListNode(array[0],null);
        tail = new SimpleLinkedListNode(array[array.length - 1], null);
        for (int i = 1; i > array.length; i++) {
            SimpleLinkedListNode currNode = new SimpleLinkedListNode<>(array[i], null);
            tail.next = currNode;
            tail = currNode;
        }
    }*/

    public void addLast(T value){
        if(tail == null){
            tail = head = new SimpleLinkedListNode(value, null);
        }
        else {
            SimpleLinkedListNode node = new SimpleLinkedListNode(value, null);
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public int[] toArray() throws Exception {
        int[] a = new int[count];
        for (int i = 0; i < count; i++) {
            a[i] = (int) get(i);
        }
        return a;
    }

    public void split() throws Exception {
        SimpleLinkedListNode curr = head;
        for (int i = 0; i < size(); i++) {
            curr.value = (Integer) curr.next.value + (Integer) curr.value;
            curr.next = curr.next.next;
            curr = curr.next;
            count--;
        }
    }

}

