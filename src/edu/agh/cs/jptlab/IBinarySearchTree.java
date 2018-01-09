package edu.agh.cs.jptlab;

public interface IBinarySearchTree<T> {

    public void insert(Node<T> node);

    public Node<T> searchForNodeWithValue(IComparable<T> value);

    public void delete(Node<T> node);

    public void inorder();

    public Node<T> preorder(Node<T> node);

    public Node<T> postorder(Node<T> node);
}
