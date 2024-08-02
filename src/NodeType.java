// Purpose: Node type for a doubly linked list.
public class NodeType<T extends Comparable<T>> {
    public T info;
    public NodeType<T> next;
    public NodeType<T> back;
} 
