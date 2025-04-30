public class MoveToFrontList<T extends Comparable<T>> extends SelfOrderingList<T> {
    @Override
    public SelfOrderingList<T> getBlankList() {
        // TODO: Implement the function
        SelfOrderingList<T> newMovetofront = new MoveToFrontList<T>();
        return newMovetofront;
    }

    @Override
    public void access(T data) {
        // TODO: Implement the function

        if (head.data == data) {
            head = head;
        } else {
            Node<T> ptr = head;
            while (ptr.data != data) {
                ptr = ptr.next;
            }

            if (ptr.next == null) {
                ptr.prev.next = null;
                head.prev = ptr;
                ptr.next = head;
                ptr.prev = null;
                head = ptr;

            } else {
                ptr.prev.next = ptr.next;
                ptr.next.prev = ptr.prev;
                head.prev = ptr;
                ptr.next = head;
                ptr.prev = null;
                head = ptr;

            }

        }

    }
}
