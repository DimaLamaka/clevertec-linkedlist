package ru.clevertec.list;


public class Main {
    public static void main(String[] args) {
        MyList<String> myList = new MyLinkedList<String>();
        myList.add("aa");
        myList.add("bb");
        myList.add("cc");
        myList.add("dd");
        myList.add("ff");
        System.out.println(myList);
        System.out.println(myList.get(4));

        myList.remove("ff");
        System.out.println(myList);

        myList.remove("bb");
        System.out.println(myList);

        myList.set(1,"ff");
        System.out.println(myList);

        myList.add(3,"nn");
        System.out.println(myList);

        myList.add(3,"vv");
        System.out.println(myList);

        myList.add(0,"kk");
        System.out.println(myList);

        /*myList.add(-24342424,"kk");
        System.out.println(myList);*/

        myList.remove("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(myList);
    }
}
