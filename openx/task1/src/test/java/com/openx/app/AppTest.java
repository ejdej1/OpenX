package com.openx.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest 
{

    Structure testingTree = new Structure();

    @Test
    public void addingNodeTest() {
        testingTree.add(3,"random");
        testingTree.add(1,"left");
        testingTree.add(2,"right");

        assertEquals(3, testingTree.root.value);
        assertEquals(1, testingTree.root.left.value);
        assertEquals(2,testingTree.root.right.value);

        String expectedOutput = "Can't add node (Wrong String)";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        testingTree.add(10,"wrongString");
        String actualOutput = outputStream.toString().trim();
        assertEquals(expectedOutput, actualOutput);
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
        testingTree.add(3, "random");
        assertFalse(testingTree.root.checkChildren());
        testingTree.add(1,"random");
        assertTrue(testingTree.root.checkChildren());
    }

    @Test
    public void countingLeafsTest(){
        testingTree.add(3,"random");
        testingTree.add(1,"left");
        testingTree.add(2,"right");
        testingTree.add(10, "right");
        testingTree.CalculateNumberLeafs(testingTree.root);

        assertEquals(2, testingTree.getLeafs() );
    }

    @Test
    public void CalculateRootToLeaf(){
        testingTree.add(3,"random");
        testingTree.add(1,"left");
        testingTree.add(2,"right");
        testingTree.add(10, "right");
        assertEquals(3,testingTree.calculateRootToLeaf(testingTree.root));
    }
}
