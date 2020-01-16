public class LinkedNode<T> {

    T value;
    LinkedNode next;

    public LinkedNode(T value) {
        this.value = value;
    }


    public void setNext(LinkedNode<T> node) {
        this.next = node;
    }

    public LinkedNode<T> getNext() {
        return this.next;
    }
}
