public class List<T> {
    public int length;
    public Node<T> head;

    public List() {
        head = null;
        length = 0;
    }

    public String toString() {
        Node<T> ptr = head;
        String result = "";

        if (ptr == null)
            return result;

        while (ptr.next != null) {

            result = result + ptr.data + ',';

            ptr = ptr.next;

        }
        return result + ptr.data;
    }

    public void append(T val) {
        length++;
        Node<T> newNode = new Node<T>(val);
        Node<T> ptr = head;
        if (head == null) {
            head = newNode;
        } else {
            while (ptr.next != null) {
                ptr = ptr.next;
            }

            ptr.next = newNode;
        }
    }

    public boolean remove(T val) {

        if (head == null)
            return false;

        Node<T> ptr = head;
        Node<T> prev = null;

        while (ptr != null) {

            if (ptr.data.equals(val))
                break;

            prev = ptr;

            ptr = ptr.next;
        }

        if (ptr == null)
            return false;

        if (prev == null) {
            head = ptr.next;

        } else
            prev.next = ptr.next;

        ptr.next = null;
        length--;
        return true;
    }

    public boolean remove(List<T> val) {
        int count = 0;
        boolean removed = false;
        Node<T> ptr = val.head;
        while (ptr != null) {
            Node<T> node = head;
            Node<T> prev = null;
            while (node != null) {
                if (node.data.equals(ptr.data)) {
                    if (prev == null) {
                        head = node.next;
                    } else {
                        prev.next = node.next;
                    }
                    length--;
                    count++;
                    removed = true;
                } else {
                    prev = node;
                }
                node = node.next;
            }
            ptr = ptr.next;
        }

        return removed;
    }

    public boolean contains(T search) {

        Node<T> ptr = head;

        while (ptr != null) {
            if (ptr.data.equals(search))
                return true;

            ptr = ptr.next;
        }

        return false;

    }

    public boolean equals(List<T> other) {

        if (other == null)
            return false;

        if (this.head == null && other.head == null)
            return true;

        Node<T> ptr = this.head;
        Node<T> otherPtr = other.head;

        if (other.length != length) {
            return false;
        }
        while (ptr != null && otherPtr != null) {
            {
                if (!otherPtr.data.equals(ptr.data)) {
                    return false;
                }
                ptr = ptr.next;
                otherPtr = otherPtr.next;
            }
        }

        if (ptr == null && otherPtr == null)
            return true;
        else
            return false;

    }
}
