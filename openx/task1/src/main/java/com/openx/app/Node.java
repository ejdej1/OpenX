package com.openx.app;

public class Node {

    int value;
    Node left;
    Node right;

    Node (int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public boolean checkChildren (){
        if (left == null && right == null) {
            return false;
        }
        return true;
    }
}
