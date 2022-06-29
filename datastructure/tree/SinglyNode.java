package datastructure.tree;

public class SinglyNode<T> {
    public T data;
    public SinglyNode<T> next;
    public SinglyNode(T data) {
        this.data = data;
        this.next = null;
    }
}