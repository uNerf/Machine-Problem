/*
 *  Java Program to Implement Binary Tree
 */

import java.util.Scanner;

/* Class BTNode */
class BTNode
{
    BTNode left, right;
    char data;

    /* Constructor */
    public BTNode()
    {
        left = null;
        right = null;
        data = 0;
    }
    /* Constructor */
    public BTNode(char n)
    {
        left = null;
        right = null;
        data = n;
    }
    public BTNode(char n, BTNode l, BTNode r){
        left = l;
        right = r;
        data = n;
    }
    /* Function to set left node */
    public void setLeft(BTNode n)
    {
        left = n;
    }
    /* Function to set right node */
    public void setRight(BTNode n)
    {
        right = n;
    }
    /* Function to get left node */
    public BTNode getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public BTNode getRight()
    {
        return right;
    }
    /* Function to set data to node */
    public void setData(char d)
    {
        data = d;
    }
    /* Function to get data from node */
    public char getData()
    {
        return data;
    }
}

/* Class BT */
class BT {
    private BTNode root;

    /* Constructor */
    public BT() {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    /* Functions to insert data */
    public void insert(char data) {
        root = insert(root, data);
    }

    /* Function to insert data recursively */
    private BTNode insert(BTNode node, char data) {
        if (node == null)
            node = new BTNode(data);
        else {
            if (node.getRight() == null)
                node.right = insert(node.right, data);
            else
                node.left = insert(node.left, data);
        }
        return node;
    }

    /* Function to count number of nodes */
    public char countNodes() {
        return countNodes(root);
    }

    /* Function to count number of nodes recursively */
    private char countNodes(BTNode r) {
        if (r == null)
            return 0;
        else {
            char l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    /* Function to search for an element */
    public boolean search(char val) {
        return search(root, val);
    }

    /* Function to search for an element recursively */
    private boolean search(BTNode r, char val) {
        if (r.getData() == val)
            return true;
        if (r.getLeft() != null)
            if (search(r.getLeft(), val))
                return true;
        if (r.getRight() != null)
            if (search(r.getRight(), val))
                return true;
        return false;
    }

    /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }

    private void inorder(BTNode r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    /* Function for preorder traversal */
    public void preorder() {
        preorder(root);
    }

    private void preorder(BTNode r) {
        if (r != null) {
            System.out.print(r.getData() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    /* Function for postorder traversal */
    public void postorder() {
        postorder(root);
    }

    private void postorder(BTNode r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() + " ");
        }
    }

    public BTNode setRoot(BT t, char n) {
        t.root = new BTNode(n);
        return t.root;
    }

    public BTNode setRoot(BT t, BTNode n) {
        t.root = n;
        return t.root;
    }

    public BTNode setLeft(BTNode t, char n) {
        t.left = new BTNode(n);
        return t.left;
    }

    public BTNode setRight(BTNode t, char n) {
        t.right = new BTNode(n);
        return t.right;
    }

}

/* Class BinaryTree */
public class MP6_20 {
    public static void main(String[] args) {

        BTNode n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12;
        BT bt = new BT();
        n1 = new BTNode('G');
        n2 = new BTNode('K');
        n3 = new BTNode('L');
        n4 = new BTNode('W');
        n5 = new BTNode('Z');
        n6 = new BTNode('H', null, n2);
        n7 = new BTNode('F', n1, n6);
        n8 = new BTNode('R', n4, null);
        n9 = new BTNode('D', n7, n3);
        n10 = new BTNode('Q', n8, null);
        n11 = new BTNode('P', n10, n5);
        n12 = new BTNode('A', n9, n11);
        n12 = bt.setRoot(bt, n12);



        /*  Display tree  */
        System.out.print("\nPost order : ");
        bt.postorder();
        System.out.print("\nPre order : ");
        bt.preorder();
        System.out.print("\nIn order : ");
        bt.inorder();
    }
}