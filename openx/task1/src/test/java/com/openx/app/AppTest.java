package com.openx.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest 
{

    Structure testingTree = new Structure();
    Structure testingTree2 = new Structure();
    Structure testingTree3 = new Structure();

    @Test
    public void addingNodeTest() {
        testingTree = App.createTree1();

        assertEquals(5, testingTree.root.value);
        assertEquals(2, testingTree.root.left.value);
        assertEquals(2,testingTree.root.left.left.value);
        assertEquals(5,testingTree.root.left.right.value);
        assertEquals(7,testingTree.root.right.value);
        assertEquals(1,testingTree.root.right.left.value);
        assertEquals(0,testingTree.root.right.right.value);
        assertEquals(2,testingTree.root.right.right.left.value);
        assertEquals(8,testingTree.root.right.right.right.value);
        assertEquals(5,testingTree.root.right.right.right.right.value);
    }

    @Test
    public void traversePreOrderTest(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Perform pre-order traversal and compare with expected output
        String expectedOutput = "1 2 4 5 3 6 7";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Structure.traversePreOrder(root);
        String actualOutput = outputStream.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void hasChildrenTest(){
        testingTree.root = new Node(1);
        assertFalse(testingTree.root.checkChildren());
        testingTree.root.left = new Node(4);
        assertTrue(testingTree.root.checkChildren());
    }

    @Test
    public void countingLeafsTest(){
        testingTree.root = new Node(1);
        testingTree.root.left = new Node(2);
        testingTree.root.right = new Node(3);
        testingTree.root.right.left = new Node(4);
        testingTree.CalculateNumberLeafs(testingTree.root);

        assertEquals(2, testingTree.getLeafs() );
    }

    @Test
    public void CalculateRootToLeaf(){
        testingTree = App.createTree1();
        assertEquals(5,testingTree.calculateRootToLeaf(testingTree.root));
    }

    @Test
    public void isEqualTest(){
        testingTree = App.createTree1();
        testingTree2 = App.createTree2();
        testingTree3 = App.createTree3();

        assertTrue(Structure.isEqual(testingTree.root, testingTree.root));
        assertFalse(Structure.isEqual(testingTree.root, testingTree2.root));
        assertFalse(Structure.isEqual(testingTree.root,testingTree3.root));

    }
}
