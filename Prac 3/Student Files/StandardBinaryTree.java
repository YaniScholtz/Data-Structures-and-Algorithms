
public class StandardBinaryTree<T extends Comparable<T>> extends BinaryTree<T> {

    // public void depthfirsthelperleft(Leaf<T> ptr) {

    // if (ptr == null)
    // return;
    // else {
    // System.out.println(ptr.toString());
    // depthfirsthelperleft(ptr.right);
    // depthfirsthelperleft(ptr.left);

    // }

    // }

    // public void depthfirsthelperright(Leaf<T> ptr) {
    // if (ptr == null)
    // return;
    // else {
    // System.out.println(ptr.toString());
    // depthfirsthelperright(ptr.left);
    // depthfirsthelperright(ptr.right);
    // }

    // }

    public void depthfirsthelper(Leaf<T> ptr) {
        if (ptr != null) {
            depthfirsthelper(ptr.left);
            System.out.println(ptr.toString());
            depthfirsthelper(ptr.right);

        } else
            return;
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

        return 1 + leftnode + rightnode;

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

        if (root == null)
            return 0;

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
                return parenthelper(ptr.left, parentptr, data);
            }

            else {
                System.out.println(ptr.toString());
                parentptr = ptr;
                return parenthelper(ptr.right, parentptr, data);
            }

        }

    }

    @Override
    public Leaf<T> findParent(T data) {
        // TODO: Implement this function

        if (root == null)
            return null;

        if (root.data.equals(data))

        {
            System.out.println(root.toString());
            return null;

        } else {
            Leaf<T> ptr = root;
            Leaf<T> parentptr = null;

            return parenthelper(ptr, parentptr, data);

        }

    }

    @Override
    public void insert(T data) {
        super.insert(data, true);

    }

    public Leaf<T> findhelper(Leaf<T> ptr, T data) {
        if (ptr == null)
            return null;
        else {
            if (ptr.data.equals(data)) {
                System.out.println(ptr.toString());
                return ptr;
            }

            else if (data.compareTo(ptr.data) < 0) {
                System.out.println(ptr.toString());
                return findhelper(ptr.left, data);
            }

            else {
                System.out.println(ptr.toString());
                return findhelper(ptr.right, data);
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
                return containshelpter(ptr.left, data);

            }

            else {
                System.out.println(ptr.toString());
                return containshelpter(ptr.right, data);
            }
        }

    }

    @Override
    public boolean contains(T data) {
        // TODO: Implement this function

        if (root == null)
            return false;

        return containshelpter(root, data);

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

    // if (root.left != null && root.right != null )
    // newtree = new StandardBinaryTree<T>();
    // else
    // newtree = new MirroredBinaryTree<T>();

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
        BinaryTree<T> newtree = new MirroredBinaryTree<T>();

        newtree.root = converthelper(root);

        return newtree;
    }

}


    

}
