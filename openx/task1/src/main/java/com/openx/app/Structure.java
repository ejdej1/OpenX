package com.openx.app;

public class Structure {

    Node root;
    int leafs = 0;

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

    public static boolean isEqual(Node node1, Node node2){

        if (node1 == null && node2 == null){
            return true;
        }

        if (node1 == null || node2 == null){
            return false;
        }

        if (node1.value != node2.value){
            return false;
        }
        boolean leftEqual = isEqual(node1.left, node2.left);
        boolean rightEqual = isEqual(node1.right, node2.right);

        return leftEqual && rightEqual;
    }

}
