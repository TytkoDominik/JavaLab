package edu.agh.cs.jptlab;

import java.util.Random;

public class HelloWorld {

    public static void main(String[] args)
    {
        System.out.println("Initialization started");

        BinarySearchTreeEngine<Integer> bstInteger = createIntegerNodeTree(40);
        bstInteger.inorder();

        BinarySearchTreeEngine<String> bstString = createStringNodeTree(40);
        bstString.inorder();
    }

    private static BinarySearchTreeEngine<Integer> createIntegerNodeTree(int treePopulation)
    {
        Node<Integer> trunk = new Node(new Comparable<Integer>(new Random().nextInt()));

        System.out.println("Root: " + trunk.value.getValue().toString());

        BinarySearchTreeEngine<Integer> bst = new BinarySearchTreeEngine<>(trunk);

        for (int i = 1; i < treePopulation; ++i)
        {
            Node<Integer> newNode = new Node(new Comparable<Integer>(new Random().nextInt()));
            bst.insert(newNode);
        }
        return bst;
    }

    private static BinarySearchTreeEngine<String> createStringNodeTree(int treePopulation) {
        int stringLength = 8;

        Node<String> trunk = new Node(new Comparable<String>(new RandomString(stringLength).nextString()));

        System.out.println("Root: " + trunk.value.getValue().toString());

        BinarySearchTreeEngine<String> bst = new BinarySearchTreeEngine<>(trunk);

        for (int i = 1; i < treePopulation; ++i) {
            Node<String> newNode = new Node(new Comparable<String>(new RandomString(stringLength).nextString()));
            bst.insert(newNode);
        }
        return bst;
    }
}
