package com.openx.app;
import java.util.Random;

public class Structure {

    /*
        Structure ("Unsorted binary tree") is similar to binary tree.
        The main difference is that nodes with smaller keys than parent nodes can be both on the left and right side
     */

    Node root;
    int leafs = 0;

    private Node addNode (Node current, int value, int side){

        if (current == null){
            return new Node(value);
        }
        if (side == 0){
            current.left = addNode(current.left, value, side);
        }
        else if (side == 1){
            current.right = addNode(current.right, value, side);
        }
        else {
            System.out.println("Can't add node (number)");
        }
        return current;
    }

    public void add (int value, String side) {
        switch (side) {
            case "random":
                Random random = new Random();
                root = addNode(root, value, random.nextInt(2));
                break;
            case "left":
                root = addNode(root, value, 0);
                break;
            case "right":
                root = addNode(root, value, 1);
                break;
            default:
                System.out.println("Can't add node (Wrong String)");
                break;
        }
    }

    public static void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void countLeafs (Node node) {
        if (node!=null){
            if (!node.checkChildren()){
                leafs += 1;
            }
            countLeafs(node.left);
            countLeafs(node.right);
        }

    }

    public int getLeafs (){
        return leafs;
    }

    public void CalculateNumberLeafs(Node node){
        countLeafs(node);
        System.out.println("Number of leafs: " + getLeafs());
    }

    public int calculateRootToLeaf (Node node){
        if (node==null){
            return 0;
        }
        else {
            int leftDepth = calculateRootToLeaf(node.left);
            int rightDepth = calculateRootToLeaf(node.right);
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }


}
