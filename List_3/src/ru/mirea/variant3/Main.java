package ru.mirea.variant3;

public class Main {
    public static void main(String[] args){
        List list = new List();
        list.add(46);
        list.add(3);
        list.add(7);
        list.add(17);
        list.add(34);
        list.add(156);
        System.out.println("Original list:");
        System.out.println(list);
        list.remove(3);
        list.remove(3);
        list.remove(3);
        list.sorting();
        System.out.println("Sorted list:");
        System.out.println(list);
    }
}
