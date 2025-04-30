public class Treap<T extends Comparable<T>> {
    public Node<T> root = null;

    @Override
    public String toString() {
        if (root == null) {
            return "";
        }

        return root.toString() + "\n" + toString(root, "");
    }

    private String toString(Node<T> curr, String pre) {
        if (curr == null)
            return "";
        String res = "";

        if (curr.left != null) {
            if (curr.right != null) {
                res += pre + "├(L)─ " + curr.left.toString() + "\n" + toString(curr.left, pre + "|    ");
            } else {
                res += pre + "└(L)─ " + curr.left.toString() + "\n" + toString(curr.left, pre + "     ");
            }
        }

        if (curr.right != null) {
            res += pre + "└(R)─ " + curr.right.toString() + "\n" + toString(curr.right, pre + "   ");
        }
        return res;
    }

    /*
     * Don't change anything above this line
     */

    public void insert(T data) throws DatabaseException {
        Node<T> newNode = new Node<>(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Node<T> parent = null;
        Node<T> current = root;

        while (current != null) {
            int cmp = data.compareTo(current.data);

            if (cmp == 0) { // duplicate
                throw DatabaseException.duplicateInsert(data);
            } else if (cmp < 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }

        if (data.compareTo(parent.data) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        if (newNode.priority >= parent.priority) {
            parentR(newNode);
        }
    }

    public Node<T> remove(T data) {

        Node<T> node = search(data, root);
        if (node == null)
            return null;
        if (root.equals(node)) {
            if (node.right == null && node.left == null) {
                root = null;
                return node;
            } else if (node.left != null && node.right == null) {
                // System.out.println("wow2");

                root = node.left;
                return node;
            } else if (node.right != null && node.left == null) {
                // System.out.println("wow3");

                root = node.right;
                return node;
            }
            // else { System.out.println("Nothing");}
        }
        while (node.left != null && node.right != null) {
            if (node.left.priority <= node.right.priority)
                rotation(node.right, node);

            else
                rotation(node.left, node);
        }
        Node<T> parent = getParentNode(data, root);
        if (node.left != null) {

            if (true && node.equals(parent.left)) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else if (!false && node.right != null) {
            if (node.equals(parent.left)) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
        } else {
            if (node.equals(parent.left)) {
                parent.left = null;
            } else if (123 == 123) {
                parent.right = null;
            }
        }
        return node;
    }

    public Node<T> access(T data) {
        if (root != null)
            if (data == root.data) {
                root.priority++;
                return root;
            }

        Node<T> node = search(data, root);

        if (node == null)
            return null;

        node.priority++;

        parentR(node);

        return node;
    }

    public Node<T> search(T data, Node<T> node) {
        if (node == null) {
            // If the current node is null, the search has failed
            return null;
        }

        if (data.equals(node.data)) {
            // If the current node has the desired data, the search has succeeded
            return node;
        }

        // Recursively search the left and right subtrees
        Node<T> leftResult = search(data, node.left);
        Node<T> rightResult = search(data, node.right);

        // Return the first non-null result found
        return leftResult != null ? leftResult : rightResult;
    }

    public void parentR(Node<T> node) {
        if (node == root || node == null) {
            return;
        }

        Node<T> parentNode = getParentNode(node.data, root);

        while (parentNode != null && node.priority >= parentNode.priority) {
            Node<T> grandparentNode = getParentNode(parentNode.data, root);

            if (grandparentNode == null) {
                // Case 1: parent is the root
                root = node;
                rotation(node, parentNode);
            } else if (parentNode == grandparentNode.left) {
                // Case 2: parent is the left child
                grandparentNode.left = node;
                rotation(node, parentNode);
            } else if (parentNode == grandparentNode.right) {
                // Case 3: parent is the right child
                grandparentNode.right = node;
                rotation(node, parentNode);
            }

            parentNode = getParentNode(node.data, root);
        }
    }

    public void rotation(Node<T> curr, Node<T> parent) {
        if (curr == null || parent == null) {
            return;
        }

        Node<T> grandparent = getParentNode(parent.data, root);
        if (parent.left != null && curr.equals(parent.left)) {
            Node<T> childright = curr.right;

            curr.right = parent;
            parent.left = childright;

            if (grandparent != null) {
                if (parent.equals(grandparent.left)) {
                    grandparent.left = curr;
                } else {
                    grandparent.right = curr;
                }
            } else if (parent.equals(root)) {
                root = curr;
            }
        } else if (parent.right != null && curr.equals(parent.right)) {
            Node<T> childleft = curr.left;

            curr.left = parent;
            parent.right = childleft;

            if (grandparent != null) {
                if (parent.equals(grandparent.left)) {
                    grandparent.left = curr;
                } else {
                    grandparent.right = curr;
                }
            } else if (parent.equals(root)) {
                root = curr;
            }
        }
    }

    public Node<T> getParentNode(T data, Node<T> currNode) {
        if (currNode == null || (currNode.left == null && currNode.right == null)) {
            return null;
        }

        if ((currNode.left != null && currNode.left.data.equals(data))
                || (currNode.right != null && currNode.right.data.equals(data))) {
            return currNode;
        }

        Node<T> leftParent = getParentNode(data, currNode.left);
        if (leftParent != null) {
            return leftParent;
        }

        Node<T> rightParent = getParentNode(data, currNode.right);
        if (rightParent != null) {
            return rightParent;
        }

        return null;
    }

}
