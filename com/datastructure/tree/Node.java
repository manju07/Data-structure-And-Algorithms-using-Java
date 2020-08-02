package com.datastructure.tree;

/**
 * Node
 */
public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
        this.data = data;
        this.left = this.right = null;
    }
}
