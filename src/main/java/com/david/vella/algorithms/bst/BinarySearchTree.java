package com.david.vella.algorithms.bst;


public class BinarySearchTree {
    public int value;
    public BinarySearchTree left;
    public BinarySearchTree right;

    public BinarySearchTree(int value) {
        this.value = value;
    }

    public BinarySearchTree insert(int value) {
        if (this.value > value) {
            if(this.left != null){
                this.left.insert(value);
            }
            else{
                this.left = new BinarySearchTree(value);
            }
        } else {
            if(this.right != null){
                this.right.insert(value);
            }
            else{
                this.right = new BinarySearchTree(value);
            }
        }
        return this;
    }

    public boolean contains(int value) {
        if(this.value == value){
            return true;
        }
        else if (this.value > value) {
            if(this.left != null){
                return this.left.contains(value);
            }
        }
        else {
            if(this.right != null){
                return this.right.contains(value);
            }
        }
        return false;
    }

    public BinarySearchTree remove(int value) {
        return this.deleteNode(this, value);
    }

    public BinarySearchTree deleteNode(BinarySearchTree root, int key) {
        if (root == null) return null;
        if (root.value > key) root.left = deleteNode(root.left, key);
        else if (root.value < key) root.right = deleteNode(root.right, key);
        else { // found node to be deleted
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            // node with two children, replace with the inOrder successor(minVal) in the right subtree
            root.value = root.right.getMin();
            root.right = deleteNode(root.right, root.value);
        }
        return root;
    }

    public int getMin() {
        if(left == null){
            return this.value;
        }
       return this.left.getMin();
    }
}