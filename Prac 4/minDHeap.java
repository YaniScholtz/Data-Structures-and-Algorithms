
@SuppressWarnings("unchecked")
public class minDHeap<T extends Comparable<T>> {
    private int d;
    private T[] nodes;

    @Override
    public String toString() {
        if (nodes.length == 0) {
            return "";
        }

        return "[" + nodes[0] + "]\n" + toStringRec(0, "");
    }

    public String toStringRec(int i, String pre) {
        if (i >= nodes.length) {
            return "";
        }
        String res = "";
        for (int k = 0; k < d; k++) {
            int c = d * i + k + 1;
            if (c < nodes.length) {
                if (k == d - 1 || c + 1 >= nodes.length) {
                    res += pre + "└── " + "[" + nodes[c] + "]\n" + toStringRec(c, pre + "    ");
                } else {
                    res += pre + "├── " + "[" + nodes[c] + "]\n" + toStringRec(c, pre + "│   ");
                }
            }
        }
        return res;
    }

    public T[] getNodes() {
        return nodes;
    }

    /*
     * Don't change anything above this line
     */

    public minDHeap(int d) {

        Comparable[] compareablearr = new Comparable[0];

        nodes = (T[]) compareablearr;
        this.d = d;

    }

    /// insert

    private int parent(int i) {
        return (i - 1) / d;
    }

    public void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void insert(T val) {

        T[] newNodes = (T[]) new Comparable[nodes.length + 1];

        for (int i = 0; i < nodes.length; i++) {
            newNodes[i] = nodes[i];
        }

        newNodes[newNodes.length - 1] = val;

        int i = newNodes.length - 1;
        while (i > 0 && newNodes[i].compareTo(newNodes[parent(i)]) < 0) {
            swap(newNodes, i, parent(i));
            i = parent(i);
        }

        nodes = newNodes;

    }

    ////// remove

    private int child(int i, int j) {
        return d * i + j;
    }

    private int leftChild(int i) {
        return child(i, 1);
    }

    public void heapify(T[] node, int nodesLength, int p) {
        int child = leftChild(p);

        while (child < nodesLength) {
            int minChild = child;

            for (int i = 1; i < d && (child + i) < nodesLength; i++) {
                if (node[child + i] != null &&
                        (node[minChild] == null || node[child + i].compareTo(node[minChild]) < 0)) {
                    minChild = child + i;
                }
            }
            if (node[p] == null || (node[minChild] != null && node[p].compareTo(node[minChild]) > 0)) {
                swap(p, minChild, node);
                p = minChild;
                child = leftChild(p);
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j, T[] arr) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void extractRoot() {
        int nodeslength = nodes.length;
        if (nodeslength == 0) {
            return;
        }

        T root = nodes[0];
        nodes[0] = nodes[nodeslength - 1];
        nodes[nodeslength - 1] = null;
        nodeslength--;

        heapify(nodes, nodeslength, 0);
    }

    public void remove(T val) {
        int index = -1;
        int nodesLength = nodes.length;

        for (int i = 0; i < nodesLength; i++) {
            if (nodes[i] != null && nodes[i].equals(val)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return;
        }
        nodes[index] = nodes[nodesLength - 1];
        nodes[nodesLength - 1] = null;
        nodesLength = nodesLength - 1;

        if (index == 0 || (nodes[index] != null && nodes[index].compareTo(nodes[parent(index)]) > 0)) {
            heapify(nodes, nodesLength, index);
        } else {
            while (index > 0 && nodes[index].compareTo(nodes[parent(index)]) < 0) {
                swap(index, parent(index), nodes);
                index = parent(index);
            }
        }

        // Resize the array to reflect the new size of the heap
        T[] newNodes = (T[]) new Comparable[nodesLength];
        System.arraycopy(nodes, 0, newNodes, 0, nodesLength);
        nodes = newNodes;
    }

    ////// change D

    public void changeD(int newD) {
        if (newD < 2) {
            return;
        }

        T[] newArr = (T[]) new Comparable[nodes.length];
        int oldD = d;
        d = newD;

        // Copy elements from old array to new array
        for (int i = 0; i < nodes.length; i++) {
            newArr[i] = nodes[i];
        }

        // Reorganize elements in new array to match new heap structure
        for (int i = parent(oldD); i >= 0; i--) {
            percolateDown(i, newArr);
        }

        nodes = newArr;
    }

    private void percolateDown(int i, T[] arr) {
        int smallest = i;
        int firstChild = i * d + 1;

        // Find the smallest child among all the children of the current node
        for (int j = 0; j < d; j++) {
            int child = firstChild + j;
            if (child < arr.length && arr[child].compareTo(arr[smallest]) < 0) {
                smallest = child;
            }
        }

        if (smallest != i) {
            // Swap the current node with the smallest child if necessary
            T temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            percolateDown(smallest, arr);
        }
    }

    public T min(int i) {
        if (nodes[0] == null)
            return null;

        if (i < 0 || i >= nodes.length)
            return null;

        T min = nodes[i];
        int lastChildIndex = i * d + d;

        if (lastChildIndex >= nodes.length)
            return min;

        for (int k = 1; k <= d; k++) {
            T childvals = min(i * d + k);
            if (childvals != null && childvals.compareTo(min) < 0)
                min = childvals;
        }

        return min;
    }

    public T max(int i) {
        if (i < 0 || i >= nodes.length) {
            return null;
        }
        T max = nodes[i];
        int numChildren = Math.min(d, nodes.length - (i * d + 1));
        for (int j = 1; j <= numChildren; j++) {
            T childvals = max(i * d + j);
            if (childvals != null && childvals.compareTo(max) > 0) {
                max = childvals;
            }
        }
        return max;
    }

    // public string pathroothelper(T val) {

    // }

    public String pathToRoot(T val) {
        int index = -1;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null && nodes[i].equals(val)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return "";
        }

        StringBuilder buidling = new StringBuilder();
        while (index != 0) {
            buidling.insert(0, "[" + nodes[index] + "]");
            index = (index - 1) / d;
        }
        buidling.insert(0, "[" + nodes[0] + "]");

        String[] nodesArray = buidling.toString().split("\\]\\[");
        buidling = new StringBuilder();
        for (int i = nodesArray.length - 1; i >= 0; i--) {
            buidling.append("[" + nodesArray[i] + "]");
        }

        return buidling.toString();
    }

    public void printNodesArray() {
        System.out.println("Index:\t");
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(i + " ");

        }
        System.out.println();
        System.out.println("Value:\t");
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(nodes[i] + " ");
        }
        System.out.println();
    }

}
