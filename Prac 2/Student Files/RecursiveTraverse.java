import javax.lang.model.util.ElementScanner14;

public class RecursiveTraverse<T extends Comparable<T>> extends Traverser<T> {
    public RecursiveTraverse() {

        list = null;
    }

    public RecursiveTraverse(SelfOrderingList<T> list) {

        this.list = clone(list);

    }

    public Node<T> Treaverser(Node<T> ptr) {
        if (ptr.next == null)
            return ptr;
        else
            return Treaverser(ptr.next);
    }

    public void reversehelper(Node<T> ptr, SelfOrderingList<T> newList) {

        if (ptr == null)
            return;
        else {
            newList.insert(ptr.data);
            reversehelper(ptr.prev, newList);
        }

    }

    @Override
    public SelfOrderingList<T> reverseList() {

        SelfOrderingList<T> newlist = list.getBlankList();

        Node<T> lastptr = Treaverser(list.head);

        reversehelper(lastptr, newlist);
        return newlist;

    }

    public boolean containhelper(Node<T> ptr, T data) {
        if (ptr == null)
            return false;
        else {
            if (ptr.data.equals(data))
                return true;
        }

        return containhelper(ptr.next, data);
    }

    @Override
    public boolean contains(T data) {

        return containhelper(list.head, data);
    }

    public String tostringhelper(Node<T> ptr, String output) {
        if (ptr == null) {
            return output;
        } else {
            output += "->" + ptr.toString();
            return tostringhelper(ptr.next, output);
        }
    }

    @Override
    public String toString() {
        String output = "";
        if (list.head == null)
            return "";
        else {

            String last = tostringhelper(list.head, output);
            return last;
        }

    }

    public Node<T> gethelper(int pos, Node<T> ptr) {
        if (ptr == null) {
            return null;

        } else if (pos == 0) {

            return ptr;
        }

        else {

            return gethelper(pos - 1, ptr.next);

        }

    }

    @Override
    public Node<T> get(int pos) {

        if (list.head == null)
            return null;

        return gethelper(pos, list.head);

    }

    public Node<T> findhelper(Node<T> ptr, T data) {
        if (ptr == null)
            return null;
        else if (ptr.data.equals(data)) {
            return ptr;
        } else {
            return findhelper(ptr.next, data);
        }

    }

    @Override
    public Node<T> find(T data) {

        return findhelper(list.head, data);

    }

    public int sizehelper(Node<T> ptr) {

        if (ptr == null)
            return 0;
        else {
            return 1 + sizehelper(ptr.next);

        }
    }

    @Override
    public int size() {

        return sizehelper(list.head);

    }

    public void clonehelper(Node<T> ptr, SelfOrderingList<T> newList) {
        if (ptr == null)
            return;
        else {
            newList.insert(ptr.data);
            clonehelper(ptr.next, newList);
        }
    }

    @Override
    public SelfOrderingList<T> clone(SelfOrderingList<T> otherList) {
        // if list == null??
        // if list.head == null

        SelfOrderingList<T> newList = otherList.getBlankList();

        clonehelper(otherList.head, newList);
        return newList;

    }
}
