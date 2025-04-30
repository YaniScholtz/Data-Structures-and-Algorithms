public class CountList<T extends Comparable<T>> extends SelfOrderingList<T> {
    @Override
    public SelfOrderingList<T> getBlankList() {
        // TODO: Implement the function

        SelfOrderingList<T> newCountList = new CountList<T>();

        return newCountList;
    }

    @Override
    public void access(T data) {
        // Find the node with the specified data

        Node<T> ptr = head;

        while (ptr.data != data) {
            ptr = ptr.next;

        }

        ptr.accessCount = ptr.accessCount + 1;

    }

}
