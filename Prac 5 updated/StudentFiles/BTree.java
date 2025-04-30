
public class BTree<T extends Comparable<T>> {

	private int m;
	public Node<T> root;

	/**
	 * 
	 * @param m
	 */

	public Node<T> getRoot() {
		return root;
	}

	public BTree(int m) {
		// TODO - implement BTree.BTree
		// throw new UnsupportedOperationException();

		this.m = m;
		root = null;
	}

	/**
	 * 
	 * @param data
	 */
	// public Node<T> insert(T data) {
	// if (root == null) {
	// root = new Node<T>(m);
	// root.getkeys()[0] = data;
	// return root;
	// }

	// Node<T> ptr = findLeafNode(data);

	// if (ptr == null) // no leaf node exists
	// return null;

	// if (!isFull(ptr)) {
	// int i = 0;
	// while (i < ptr.getKeynumber() && ptr.getkeys()[i].compareTo(data) < 0) {
	// i++;
	// }

	// for (int j = ptr.getKeynumber(); j > i; j--) {
	// ptr.getkeys()[j] = ptr.getkeys()[j - 1];
	// }

	// ptr.getkeys()[i] = data;
	// ptr.setKeynumber(ptr.getKeynumber() + 1);
	// } else {
	// Node<T> newNode = split(ptr);

	// if (newNode.getParent() == null) {
	// root = newNode.getParent();
	// }

	// ptr = ptr.getParent();

	// int i = 0;
	// while (i < ptr.getKeynumber() && ptr.getkeys()[i].compareTo(data) < 0) {
	// i++;
	// }

	// for (int j = ptr.getKeynumber(); j > i; j--) {
	// ptr.getkeys()[j] = ptr.getkeys()[j - 1];
	// }

	// ptr.getkeys()[i] = data;
	// ptr.setKeynumber(ptr.getKeynumber() + 1);
	// }

	// return ptr;
	// }

	// public Node<T> split(Node<T> node) {
	// int mid = node.getKeynumber() / 2;
	// Node<T> newNode = new Node<>(m);
	// int j = 0;

	// for (int i = mid + 1; i <= node.getKeynumber(); i++) {
	// newNode.getkeys()[j] = node.getkeys()[i];
	// newNode.getchildren()[j] = node.getchildren()[i];
	// if (newNode.getchildren()[j] != null) {
	// newNode.getchildren()[j].setParent(newNode);
	// }
	// node.setChild(i, null);
	// j++;
	// }

	// node.setKeynumber(mid);

	// if (node.getParent() == null) {
	// Node<T> parent = new Node<>(m);
	// parent.setChild(0, node);
	// node.setParent(parent);
	// parent.setChild(1, newNode);
	// parent.setKey(0, newNode.getkeys()[0]);
	// parent.setKeynumber(1);
	// newNode.setParent(parent);
	// root = parent;
	// } else {
	// Node<T> parent = node.getParent();
	// int index = parent.addChild(node);
	// parent.addChild(index + 1, newNode);
	// parent.addKey(index, newNode.getkeys()[0]);
	// if (isFull(parent)) {
	// split(parent);
	// }
	// }
	// return newNode;
	// }

	// public boolean isFull(Node<T> node) {
	// if (node.getkeys().length == m - 1)
	// return true;
	// else
	// return false;
	// }

	// private Node<T> findLeafNode(T data) {
	// Node<T> ptr = root;

	// while (ptr != null) {
	// int i = 0;
	// while (i < ptr.getkeys().length && ptr.getkeys()[i] != null &&
	// ptr.getkeys()[i].compareTo(data) < 0) {
	// i++;
	// }

	// if (i < ptr.getkeys().length && ptr.getkeys()[i] != null &&
	// ptr.getkeys()[i].equals(data)) {
	// return ptr;
	// }

	// if (isLeaf(ptr)) {
	// return ptr;
	// } else {
	// ptr = ptr.getchildren()[i];
	// }
	// }
	// return null;
	// }

	// private boolean isLeaf(Node<T> node) {
	// return node.getchildren() == null;

	// }

	// /**
	// *
	// * @param
	// */

	public void insert(T data) {
		if (root == null) {
			root = new Node<T>(m);
			root.addKey(0, data);
			return;
		}
		Node<T> node = findLeafNode(data);
		if (node.getKeynumber() < m - 1) {
			node.addKey(m, data);
			return;
		}
		Node<T> newRoot = new Node<T>(m);
		newRoot.setChild(0, root);
		Node<T> newNode = split(node);
		int i = 0;
		if (newNode.getkeys()[0].compareTo(data) < 0) {
			i++;
		}
		newRoot.setChild(i, newNode);
		newRoot.addKey(i, newNode.getkeys()[0]);
		root = newRoot;
	}

	private Node<T> findLeafNode(T data) {
		Node<T> node = root;

		// Traverse down the tree until a leaf node is reached
		while (!node.isLeaf()) {
			// Find the index i of the child that could possibly contain the data
			int i = 0;
			while (i < node.getKeynumber() && node.getkeys()[i].compareTo(data) > 0) {
				i++;
			}

			// Descend to the appropriate child
			node = node.getchildren()[i];
		}

		return node;
	}

	private Node<T> split(Node<T> node) {
		int mid = node.getKeynumber() / 2;
		Comparable midValue = node.getkeys()[mid];
		System.out.println("1");

		Node<T> left = new Node<>(m);
		System.out.println("2");
		for (int i = 0; i < mid; i++) {
			left.addKey(i, node.getkeys()[i]);
			left.setChild(i, node.getchildren()[i]);
		}
		System.out.println("3");
		left.setChild(mid, node.getchildren()[mid]);

		Node<T> right = new Node<>(m);
		System.out.println("4");
		for (int i = mid + 1; i < node.getKeynumber(); i++) {
			right.addKey(i - mid - 1, node.getkeys()[i]);
			right.setChild(i - mid - 1, node.getchildren()[i]);
		}
		System.out.println("5");
		right.setChild(node.getKeynumber() - mid - 1,
				node.getchildren()[node.getKeynumber()]);

		Node<T> parent = node.getParent();
		System.out.println("6");
		if (parent == null) {
			parent = new Node<>(m);
			parent.setChild(0, left);
			node.setParent(parent);
		}
		System.out.println("7");

		int index = parent.indexOfChild(node);
		System.out.println(index);
		System.out.println("7.1");
		parent.addKey(index, midValue);
		System.out.println(index);
		System.out.println("7.2");
		System.out.println(index);
		parent.setChild(index, left);
		System.out.println("7.3");

		System.out.println("8");

		if (index == parent.getKeynumber()) {
			parent.setChild(index + 1, right);
		} else {
			System.out.println("9");
			parent.setChild(index + 1, parent.getchildren()[index]);
			parent.setChild(index, right);
		}
		left.setParent(parent);
		right.setParent(parent);
		System.out.println("10");

		return parent;
	}

	public Node<T> find(T data) {
		Node<T> currentNode = root;

		while (currentNode != null) {
			int i = 0;
			while (i < currentNode.getKeynumber() && currentNode.getkeys()[i] != null
					&& currentNode.getkeys()[i].compareTo(data) < 0) {
				i++;
			}

			if (i < currentNode.getKeynumber() && currentNode.getkeys()[i] != null
					&& currentNode.getkeys()[i].equals(data)) {
				return currentNode;
			}

			if (currentNode.isLeaf(currentNode)) {
				return null;
			} else {
				currentNode = currentNode.getchildren()[i];
			}
		}

		return null;
	}

	public Node<T>[] nodes() {
		int numNodes = countNodes(root);
		Node<T>[] nodeArray = new Node[numNodes];
		int index = 0;

		if (root == null)
			return null;

		inorderTraversal(root, nodeArray, index);
		return nodeArray;
	}

	private int inorderTraversal(Node<T> node, Node<T>[] nodeArray, int index) {
		if (node == null) {
			return index;
		}

		for (int i = 0; i < node.getkeys().length + 1; i++) {
			if (node.getchildren()[i] != null) {
				index = inorderTraversal(node.getchildren()[i], nodeArray, index);
			}
			if (index < nodeArray.length) {
				nodeArray[index++] = node;
			}
		}
		if (node.getchildren()[node.getkeys().length] != null) {
			index = inorderTraversal(node.getchildren()[node.getkeys().length], nodeArray, index);
		}
		return index;
	}

	public int numKeys() {
		return countKeys(root);
	}

	private int countKeys(Node<T> node) {
		if (node == null) {
			return 0;
		}

		int count = node.getkeys().length;

		for (int i = 0; i < node.getchildren().length; i++) {
			count += countKeys(node.getchildren()[i]);
		}

		return count;
	}

	private int countNodes(Node<T> node) {
		if (node == null)
			return 0;

		int count = 1;

		for (int i = 0; i < node.getchildren().length; i++) {
			count += countNodes(node.getchildren()[i]);
		}
		return count;
	}

	public int countNumNodes() {
		// TODO - implement BTree.countNumLeaves
		// throw new UnsupportedOperationException();

		return countNodes(root);

	}

}