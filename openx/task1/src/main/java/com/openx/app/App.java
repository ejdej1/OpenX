package com.openx.app;

public class App 
{
    public static Structure createTree1(){
    Structure tree = new Structure();
    tree.root = new Node(5);
    tree.root.left = new Node(2);
    tree.root.left.left = new Node(2);
    tree.root.left.right = new Node(5);
    tree.root.right = new Node(7);
    tree.root.right.left = new Node(1);
    tree.root.right.right = new Node(0);
    tree.root.right.right.left = new Node(2);
    tree.root.right.right.right = new Node(8);
    tree.root.right.right.right.right = new Node(5);
    return tree;
    }

    public static Structure createTree2(){
        Structure tree = new Structure();
        tree.root = new Node(5);
        tree.root.left = new Node(7);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(11);
        tree.root.right = new Node(0);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(0);
        tree.root.right.right.left = new Node(2);
        tree.root.right.right.right = new Node(0);
        tree.root.right.right.right.right = new Node(5);
        return tree;
    }

    public static Structure createTree3(){
        Structure tree = new Structure();
        tree.root = new Node(4);
        tree.root.left = new Node(9);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(11);
        tree.root.right = new Node(0);
        tree.root.right.left = new Node(12);
        return tree;
    }
    public static void main( String[] args ) {
        Structure tree1 = new Structure();
        Structure tree2 = new Structure();
        Structure tree3 = new Structure();
        Structure tree1copy = new Structure();

        tree1 = createTree1();
        tree1copy = createTree1();
        tree2 = createTree2();
        tree3 = createTree3();

        System.out.print("Tree nr.1 (model from pdf.) |preorder|: ");
        Structure.traversePreOrder(tree1.root);
        System.out.println("");

        System.out.print("Tree nr.2 |preorder|: ");
        Structure.traversePreOrder(tree2.root);
        System.out.println("");

        System.out.print("Tree nr.3 |preorder|: ");
        Structure.traversePreOrder(tree3.root);
        System.out.println("");

        System.out.println("");
        System.out.println("_____Task1_____");
        System.out.print("(Tree nr.1) ");
        tree1.CalculateNumberLeafs(tree1.root);


        System.out.println("");
        System.out.println("_____Task2_____");
        System.out.println("(Tree nr.1)  Largest number of edges: " + tree1.calculateRootToLeaf(tree1.root));


        System.out.println("");
        System.out.println("_____Task3_____");
        System.out.println("Is tree1 equal to tree1Copy? " + Structure.isEqual(tree1.root, tree1copy.root));
        System.out.println("Is tree1 equal to tree2" + Structure.isEqual(tree1.root, tree2.root));
        System.out.println("Is tree1 equal to tree3" + Structure.isEqual(tree1.root, tree3.root));
    }
}
