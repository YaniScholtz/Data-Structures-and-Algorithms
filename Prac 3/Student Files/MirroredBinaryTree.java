public class MirroredBinaryTree<T extends Comparable<T>> extends BinaryTree<T> {
    public boolean containshelpter(Leaf<T> ptr, T data) {
        if (ptr == null)
            return false;
        else {
            if (ptr.data.equals(data)) {
                System.out.println(ptr.toString());
                return true;
            }

            else if (data.compareTo(ptr.data) < 0) {
                System.out.println(ptr.toString());
                return containshelpter(ptr.right, data);

            }

            else {
                System.out.println(ptr.toString());
                return containshelpter(ptr.left, data);
            }

        }

    }

    @Override
    public boolean contains(T data) {
        // TODO: Implement this function

        Leaf<T> ptr = root;

        return containshelpter(ptr, data);

    }

    public void depthfirsthelper(Leaf<T> ptr) {
        if (ptr != null) {
            depthfirsthelper(ptr.right);
            System.out.println(ptr.toString());

            depthfirsthelper(ptr.left);
        }
    }

    @Override
    public void depthFirstTraversal() {
        // TODO: Implement this function
        Leaf<T> p = root;
        depthfirsthelper(p);

    }

    public int numleavesintreehelper(Leaf<T> ptr) {
        if (ptr == null)
            return 0;

        int leftnode, rightnode;
        leftnode = numleavesintreehelper(ptr.left);
        rightnode = numleavesintreehelper(ptr.right);

        return leftnode + 1 + rightnode;

    }

    @Override
    public int numLeavesInTree() {
        // TODO: Implement this function
        Leaf<T> ptr = root;

        return numleavesintreehelper(ptr);
    }

    public int heighthelper(Leaf<T> p) {
        if (p == null)
            return -1;
        else {
            int heightofleft = heighthelper(p.left);
            int heightofright = heighthelper(p.right);

            if (heightofleft > heightofright)
                return heightofleft + 1;
            else
                return heightofright + 1;
        }
    }

    @Override
    public int height() {
        // TODO: Implement this function

        return heighthelper(root);

    }

    public Leaf<T> parenthelper(Leaf<T> ptr, Leaf<T> parentptr, T data) {
        if (ptr == null)
            return null;
        else {
            if (ptr.data.equals(data))
                return parentptr;
            else if (data.compareTo(ptr.data) < 0) {
                System.out.println(ptr.toString());
                parentptr = ptr;
                return parenthelper(ptr.right, parentptr, data);
            }

            else {
                System.out.println(ptr.toString());
                parentptr = ptr;
                return parenthelper(ptr.left, parentptr, data);
            }

        }

    }

    @Override
    public Leaf<T> findParent(T data) {
        // TODO: Implement this function

        if (root == null)
            return null;
        Leaf<T> ptr = root;
        Leaf<T> parentptr = null;
        if (root.data.equals(data)) {

            System.out.println(root.toString());
            return null;
        } else {
            return parenthelper(ptr, parentptr, data);

        }

    }

    @Override
    public void insert(T data) {
        super.insert(data, false);
    }

    public Leaf<T> findhelper(Leaf<T> ptr, T data) {
        if (ptr == null)
            return null;
        else {
            if (ptr.data.equals(data)) {
                System.out.println(ptr.toString());
                return ptr;
            }

            else if (data.compareTo(ptr.data) < 0)

            {
                System.out.println(ptr.toString());
                return findhelper(ptr.right, data);
            }

            else {
                System.out.println(ptr.toString());
                return findhelper(ptr.left, data);
            }

        }

    }

    @Override
    public Leaf<T> find(T data) {
        // TODO: Implement this function

        if (root == null)
            return null;

        if (root.data.equals(data)) {
            System.out.println(root.toString());
            return root;
        }

        Leaf<T> p = root;

        return findhelper(p, data);

    }

    public int perfectlybalancedhelper(Leaf<T> ptr) {

        if (ptr == null)
            return 0;

        return perfectlybalancedhelper(ptr.left) + perfectlybalancedhelper(ptr.right) + 1;

    }

    @Override
    public boolean perfectlyBalanced() {
        // TODO: Implement this function

        if (root == null)
            return true;

        Leaf<T> ptr = root;

        int leftcount = perfectlybalancedhelper(ptr.left);
        int rightcount = perfectlybalancedhelper(ptr.right);

        if (Math.abs(leftcount - rightcount) > 1)
            return false;
        else
            return true;

    }

    // public Leaf<T> converttreehelper(Leaf<T> p) {
    // if (p == null)
    // return null;

    // Leaf<T> newnode = new Leaf<T>(p.data);

    // newnode.left = converttreehelper(p.right);
    // newnode.right = converttreehelper(p.left);

    // return newnode;
    // }

    // @Override
    // public BinaryTree<T> convertTree() {
    // // TODO: Implement this function
    // Leaf<T> p = this.root;

    // BinaryTree<T> newtree = null;

    // if (root.left != null && root.right != null)
    // newtree = new MirroredBinaryTree<T>();
    // else
    // newtree = new StandardBinaryTree<T>();

    // newtree.root = converttreehelper(p);

    // // newtree.root = converttreehelper(this.root);

    // return newtree;

    // }

    public Leaf<T> converthelper(Leaf<T> p) {
        if (p == null)
            return null;

        Leaf<T> node = new Leaf<T>(p.data);
        node.left = converthelper(p.right);
        node.right = converthelper(p.left);

        return node;
    }

    public BinaryTree<T> convertTree() {
        BinaryTree<T> newtree = new StandardBinaryTree<T>();

        newtree.root = converthelper(root);
        return newtree;
    }
}
