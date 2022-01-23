package com.nguyentai;

public class DynamicArrayCheck {
    public static void main(String[] args) {
        DynamicArray<String> myDynamicArr = new DynamicArray<>(0);
        myDynamicArr.add("T");
        myDynamicArr.add("a");
        myDynamicArr.add("f");
        myDynamicArr.add("i");

        System.out.println(myDynamicArr);
        System.out.println("capacity");
        System.out.println(myDynamicArr.capacity());
        System.out.println("size");
        System.out.println(myDynamicArr.size());

        System.out.println("Test remove at");
        myDynamicArr.removeAt(0);
        System.out.println(myDynamicArr);
        System.out.println("capacity");
        System.out.println(myDynamicArr.capacity());
        System.out.println("size");
        System.out.println(myDynamicArr.size());

        System.out.println("Test remove");
        myDynamicArr.remove("a");
        System.out.println(myDynamicArr);
        System.out.println("capacity");
        System.out.println(myDynamicArr.capacity());
        System.out.println("size");
        System.out.println(myDynamicArr.size());

        System.out.println("Test remove");
        System.out.println(myDynamicArr);
        System.out.println("Contains f: " + myDynamicArr.contains("f"));
        System.out.println("Contains T: " + myDynamicArr.contains("T"));
    }
}
