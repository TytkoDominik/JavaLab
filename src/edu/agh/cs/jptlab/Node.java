package edu.agh.cs.jptlab;

public class Node<T>{

    public Node(IComparable<T> newValue)
    {
        value = newValue;
    }

    public IComparable<T> value;

    public Node<T> left;

    public Node<T> right;
}
