import java.util.Random;

// This is used to remove the warnings which occur when using generics
@SuppressWarnings("unchecked")
public class SkipList<T extends Comparable<T>> {
    private int maxLevel;
    private SkipListNode<T>[] root;
    private int[] powers;
    // Do not change the seed. This is used to generate the same values every run
    private Random randomGenerator = new Random(123456);

    public SkipList(int maxLevel) {

        this.maxLevel = maxLevel;
        root = new SkipListNode[maxLevel];
        for (int i = 0; i < maxLevel; i++) {
            root[i] = null;
        }
        powers = new int[maxLevel];

        double boundries = Math.pow(2, maxLevel) - 1;
        for (int j = 0; j < maxLevel; j++) {

            if (j == 0) {

                powers[j] = 1;
            } else {

                powers[j] = powers[j - 1] + (int) (Math.ceil(boundries / (Math.pow(2, j))));
            }
        }

    }

    public int chooseLevel() {
        int i;
        int r = Math.abs(randomGenerator.nextInt()) % powers[maxLevel - 1] + 1;
        for (i = 1; i < maxLevel; i++)
            if (r < powers[i])
                return i - 1;
        return i - 1;

    }

    public boolean delete(T key) {
        SkipListNode<T> node = search(key);

        if (node == null)
            return false;

        SkipListNode<T>[] prev = new SkipListNode[node.next.length];
        SkipListNode<T> current;

        for (int i = node.next.length - 1; i >= 0; i--) {
            current = root[i];
            while (current.next[i] != node && current.next[i] != null && current != node) {
                current = current.next[i];
            }
            prev[i] = current;
        }

        for (int i = 0; i < node.next.length; i++)
            if (prev[i].next[i] != node && prev[i] == root[i])
                root[i] = prev[i].next[i];
            else
                prev[i].next[i] = node.next[i];

        return true;

    }

    public boolean isEmpty() {

        if (root[0] == null)
            return true;
        else
            return false;
    }

    public SkipListNode<T> search(T key) {

        SkipListNode<T> prev, curr;
        int currlevel;

        for (currlevel = maxLevel - 1; currlevel >= 0 && root[currlevel] == null; currlevel--)
            ;
        if (currlevel == -1)
            return null;

        if (root[0] == null)
            return null;
        prev = curr = root[currlevel];
        while (true) {
            if (key.equals(curr.key)) {
                return curr;
            } else if (key.compareTo(curr.key) < 0) {
                if (currlevel < 1)
                    return null;
                else if (curr == root[currlevel])
                    curr = root[--currlevel];
                else {
                    curr = prev.next[--currlevel];
                }
            } else {
                prev = curr;
                if (curr.next[currlevel] != null)
                    curr = curr.next[currlevel];
                else {
                    for (currlevel--; currlevel >= 0 && curr.next[currlevel] == null; currlevel--)
                        ;
                    if (currlevel >= 0)
                        curr = curr.next[currlevel];
                    else
                        return null;
                }

            }

        }

    }

    public void insert(T key) {

        SkipListNode<T>[] previous = new SkipListNode[maxLevel];
        SkipListNode<T>[] currentnode = new SkipListNode[maxLevel];

        int currlevel;
        currentnode[maxLevel - 1] = root[maxLevel - 1];
        previous[maxLevel - 1] = null;
        for (currlevel = maxLevel - 1; currlevel >= 0; currlevel--) {

            while (currentnode[currlevel] != null && currentnode[currlevel].key.compareTo(key) <= 0) {

                previous[currlevel] = currentnode[currlevel];
                currentnode[currlevel] = currentnode[currlevel].next[currlevel];

            }
            if (currentnode[currlevel] != null && currentnode[currlevel].key == key)
                currlevel = 0;
            if (currlevel > 0)

                if (previous[currlevel] == null) {

                    currentnode[currlevel - 1] = root[currlevel - 1];
                    previous[currlevel - 1] = null;
                }

                else {

                    currentnode[currlevel - 1] = previous[currlevel].next[currlevel - 1];
                    previous[currlevel - 1] = previous[currlevel];
                }
        }

        SkipListNode<T> nodeNew;

        currlevel = chooseLevel();

        nodeNew = new SkipListNode<T>(key, currlevel + 1);
        for (int k = 0; k <= currlevel; k++) {

            nodeNew.next[k] = currentnode[k];
            if (previous[k] == null)
                root[k] = nodeNew;
            else

                previous[k].next[k] = nodeNew;
        }
    }

    public void printSearchPath(T key) {
        // The same as the search algorithm and then add the sysout
        if (root[0] == null) {
            return;
        }
        int currlevel;

        SkipListNode<T> previous;

        SkipListNode<T> current;
        for (currlevel = maxLevel - 1; root[currlevel] == null && currlevel >= 0; currlevel--)
            ; // checking for null levels
        previous = root[currlevel];
        current = root[currlevel];
        while (true) {

            if (key.compareTo(current.key) < 0) {/////////

                if (current == root[currlevel]) {///

                    System.out.print(current);
                    current = root[--currlevel];
                } else {////

                    System.out.println(current);
                    current = previous.next[--currlevel];
                }
                if (currlevel == 0) {
                    return;

                } else {/////

                    previous = current;
                    if (current.next[currlevel] == null) {////
                        for (currlevel = (currlevel - 1); currlevel >= 0
                                && current.next[currlevel] == null; currlevel--)
                            ; // checking for non null levels again
                        if (currlevel >= 0) {////
                            System.out.print(current);
                            current = current.next[currlevel];
                        } else {////
                            return;// do nnothing
                        }
                    } else {///
                        System.out.print(current);
                        current = current.next[currlevel];
                    }
                }
                if (key.equals(current.key)) {
                    System.out.print(current);
                    break;
                }
            }
        }

    }

    @Override
    public String toString() {
        SkipListNode<T> current;
        String[] builder = new String[maxLevel];

        for (int k = 0; k < maxLevel; k++) {

            builder[k] = "[Lvl " + k + "]";
        }

        String buildingresult = ""; // later in the codee//
        SkipListNode<T> currentnode2; // outside if?
        ///// current root//
        current = root[0];

        if (current == null) {

            String result = ""; // check for in the if or not
            for (int j = maxLevel - 1; j > 0; j--) {

                result += builder[j] + "\n";////
            }
            result = result + builder[0];

            return result;
        } else {
            // //in else

            currentnode2 = root[0];
            while (currentnode2 != null) {

                for (int k = 0; k < maxLevel; k++) {
                    if (k < (currentnode2.next.length))

                        builder[k] = builder[k] + "->" + currentnode2.toString();
                    else

                        builder[k] = builder[k] + "--" + currentnode2.emptyString();// --

                }

                ///
                currentnode2 = currentnode2.next[0];
            }
            for (int j = maxLevel - 1; j >= 0; j--) {// for
                int m = builder[j].length() - 1;
                for (; m >= 0; m--) {

                    if (builder[j].charAt(m) == ']')
                        break;

                }

                //// m inc
                m++;
                builder[j] = builder[j].substring(0, m); // substirng ?
            }
        }

        for (int k = maxLevel - 1; k >= 0; k--) {
            if (k == 0)
                buildingresult += builder[k];
            else
                buildingresult = buildingresult + builder[k] + '\n';

        }
        return buildingresult;/// end

    }
}
