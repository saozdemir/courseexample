package com.sao.abstractclass;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());

        //String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String stringData = "5 7 3 9 8 2 1 0 4 6";

        String[] data = stringData.split(" ");
        for (String s : data) {
            list.addItem(new Node(s));
        }

        list.traverse(list.getRoot());
        System.out.println("---------------------------");
        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());

        String stringDataTree = "5 7 3 9 8 2 1 0 4 6";
        String[] dataTree = stringDataTree.split(" ");

        for (String s : dataTree) {
            tree.addItem(new Node(s));
        }

        tree.traverse(tree.getRoot());
    }


}
