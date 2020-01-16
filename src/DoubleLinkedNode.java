import java.util.Iterator;

public class DoubleLinkedNode<T> extends  LinkedNode<T> {

    DoubleLinkedNode next;
    DoubleLinkedNode prev;

    public DoubleLinkedNode(T value) {
        super(value);
    }

    public void setPrev(DoubleLinkedNode<T> node) {
        this.prev = node;
    }

    @Override
    public DoubleLinkedNode<T> getNext() {
        return this.next;
    }
}
