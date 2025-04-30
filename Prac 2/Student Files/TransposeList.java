public class TransposeList<T extends Comparable<T>> extends SelfOrderingList<T> {
    @Override
    public SelfOrderingList<T> getBlankList() {
        // TODO: Implement the function
        SelfOrderingList<T> newTranspose = new TransposeList<T>();
        return newTranspose;
    }

    @Override
    public void access(T data) {
        // TODO: Implement the function

        Node<T> ptr;
        Node<T> prev;

        if (head.data == data) {
            head = head;
        } else if (head.next.data == data) {
            ptr = head.next;
            head.next = ptr.next;
            head.prev = ptr;
            ptr.next.prev = head;
            ptr.next = head;
            ptr.prev = null;

        } else {
            ptr = head;
            while (ptr.data != data) {
                ptr = ptr.next;
            }

            if (ptr == null)
                return;

            if (ptr.next == null) {
                prev = ptr.prev;
                prev.next = ptr;
                ptr.prev = prev.prev;
                prev.next = null;
                prev.prev = ptr;

            } else {
                ptr.prev.next = ptr.next;
                ptr.next.prev = ptr.prev;
                ptr.prev = ptr.prev.prev;
                ptr.next = ptr.next.next;

            }

        }

    }
}
