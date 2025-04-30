abstract class SelfOrderingList<T extends Comparable<T>> {
    public Node<T> head = null;

    public void insert(T data) {
        // TODO: Implement the function

        Node<T> new_Node = new Node(data);

        Node<T> ptr = head;

        while (ptr.next != null) {
            ptr = ptr.next;
        }

        ptr.next = new_Node;

    }

    public void remove(T data) {
        // TODO: Implement the function

        Node<T> ptr = head;

        if (data == head) {
            head.next.prev = null;
            head.next = null;

            head = head.next;
        }

        while (ptr.next != null) {

            if (ptr.data == data) {
                ptr.prev.next = ptr.next;
                ptr.next.prev = ptr.prev;
                ptr.next = null;
                ptr.prev = null;
                break;
            } else
                ptr = ptr.next;
        }

        if (ptr.data == data) {
            ptr.prev.next = null;
            ptr.prev = null;
        }

    }

    public abstract void access(T data);

    public abstract SelfOrderingList<T> getBlankList();
}
