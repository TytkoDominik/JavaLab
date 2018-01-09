package edu.agh.cs.jptlab;

public class BinarySearchTreeEngine<T> implements IBinarySearchTree<T> {

    public BinarySearchTreeEngine(Node<T> newTrunk)
    {
        trunk = newTrunk;
    }

    private Node<T> trunk;

    public void insert(Node<T> newNode)
    {
        insert(newNode, trunk);
    }

    private void insert(Node<T> newNode, Node<T> currentNode)
    {
        if (!currentNode.value.isGreaterThan(newNode.value))
        {
            if (currentNode.right == null)
            {
                currentNode.right = newNode;
                return;
            }

            insert(newNode, currentNode.right);
        }
        else
        {
            if (currentNode.left == null)
            {
                currentNode.left = newNode;
                return;
            }

            insert(newNode, currentNode.left);
        }
    }


    public Node<T> searchForNodeWithValue(IComparable<T> value)
    {
        return searchForNodeWithValue(value, trunk);
    }

    private Node<T> searchForNodeWithValue(IComparable<T> value, Node<T> currentNode)
    {
        if (currentNode == null)
            return null;

        if (currentNode.value.isEqual(value))
        {
            return currentNode;
        }

        if (currentNode.value.isGreaterThan(value))
        {
            return searchForNodeWithValue(value, currentNode.left);
        }
        else
            return searchForNodeWithValue(value, currentNode.right);
    }

    public void delete(Node<T> node)
    {
        if (node.left == null && node.right == null) {
            node = null;
            return;
        }

        if (node.left != null && node.right != null) {
            Node<T> inorderSuccessor = inorderSuccessor(node, trunk);
            node.value = inorderSuccessor.value;
            delete(inorderSuccessor);
            return;
        }

        Node<T> tempNode;
        if (node.left != null)
        {
            tempNode = node.left;
        }
        else
            {
            tempNode = node.right;
        }

        node.value = tempNode.value;
        node.right = tempNode.right;
        node.left = tempNode.left;
        delete(tempNode);
    }

    public void inorder()
    {
        Node<T> currentNode = minimumKeyValueNodeFromRoot(trunk);
        int counter = 0;
        while(currentNode != null)
        {
            String log = String.format("Node %d: %s, next is %s", counter, currentNode.value.getValue().toString(), inorderSuccessor(currentNode, trunk).value.getValue().toString());
            System.out.println(log);
            counter++;
            currentNode = inorderSuccessor(currentNode, trunk);
        }

        if (counter == 0)
        {
            System.out.println("Empty tree!");
        }
    }

    private Node<T> inorderSuccessor(Node<T> node, Node<T> root)
    {
        if (node.right != null)
            return minimumKeyValueNodeFromRoot(node.right);

        Node<T> successor = null;

        while(root != null)
        {
            if (node.value.isLessThan(root.value))
                {
                    successor = root;
                    root = root.left;
                }
            if (node.value.isGreaterThan(root.value))
               {
                   root = root.right;
               }
            else
               {
                   return successor;
               }
        }
        return null;
    }

    private Node<T> minimumKeyValueNodeFromRoot(Node<T> root)
    {
        if (root.left == null)
            return root;
        else
            return minimumKeyValueNodeFromRoot(root.left);
    }

    public Node<T> preorder(Node<T> node)
    {
        return null;
    }

    public Node<T> postorder(Node<T> node)
    {
        return null;
    }
}
