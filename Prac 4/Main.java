public class Main {
    public static void main(String[] args) {
        minDHeap<Integer> heap = new minDHeap<>(3);

        for (int i = 10; i >= 0; i--) {
            heap.insert(i);
        }
        heap.printNodesArray();
        System.out.println(heap);

        for (int i = 0; i <= 10; i++) {
            System.out.println("Node be begin at: " + i + "\tPath to root: " + heap.pathToRoot(i));
        }
        System.out.println();

        for (int i = 0; i <= 10; i++) {
            System.out.println("Sub-tree index: " + i + "\tMin node: " + heap.min(i) + "\tMax node: " + heap.max(i));
        }
        System.out.println();

        for (int i = 0; i <= 10; i++) {
            System.out.println("Removing: " + i);
            heap.remove(i);

            heap.printNodesArray();
            System.out.println(heap);
        }

        System.out.println(
                "===========================================================================================================");
        System.out.println();

        for (int i = 10; i >= 0; i--) {
            heap.insert(i);
        }

        System.out.println(2 + " children:");
        heap.changeD(2);
        heap.printNodesArray();
        System.out.println(heap);

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " children:");
            heap.changeD(i);
            heap.printNodesArray();
            System.out.println(heap);
        }

        for (int i = 0; i <= 10; i++) {
            System.out.println("Node to begin at: " + i + "\tPath to root: " + heap.pathToRoot(i));
        }
        System.out.println();

        for (int i = 0; i <= 10; i++) {
            System.out.println("Sub-tree index: " + i + "\tMin node: " + heap.min(i) + "\tMax node: " + heap.max(i));
        }
        System.out.println();

        for (int i = 0; i <= 10; i++) {
            System.out.println("Removing: " + i);
            heap.remove(i);

            heap.printNodesArray();
            System.out.println(heap);
        }
    }
}