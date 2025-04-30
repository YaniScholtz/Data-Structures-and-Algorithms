public class Node<T extends Comparable<T>> {

	public Comparable<T>[] keys;
	public Node<T>[] children;
	private Node<T> parent;
	private int keyCount;
	private int m;
	int childCount;
	boolean leaf;

	/**
	 * 
	 * @param m
	 */
	@SuppressWarnings("unchecked")

	public Node(int m) {
		// TODO - implement Node.Node
		// throw new UnsupportedOperationException();

		children = new Node[m];
		keys = new Comparable[m - 1];
		parent = null;
		this.keyCount = 0;
		this.m = m;
		childCount = 0;
		leaf = false;

	}

	public void insertData(T data) {
		int dataCount = keys.length;
		int i = dataCount - 1;
		while (i >= 0 && this.keys[i].compareTo(data) < 0) {
			this.keys[i + 1] = this.keys[i];
			i--;
		}
		this.keys[i + 1] = data;
		dataCount++;
	}

	// public Comparable getKey(int index) {
	// if (index < keyCount)
	// return keys[index];
	// else
	// return null;

	// }

	public void incrementKeyCount() {
		this.keyCount++;
	}

	public int addChild(Node<T> child) {
		int i;
		for (i = 0; i < m - 1; i++) {
			if (children[i] == null) {
				children[i] = child;
				child.setParent(this);
				return i;
			}
		}
		children[i] = child;
		child.setParent(this);
		return i;
	}

	public boolean isLeaf() {
		return (getchildren()[0] == null);
	}

	public int addChild(int index, Node<T> child) {
		for (int i = m - 2; i > index; i--) {
			children[i + 1] = children[i];
			if (children[i] != null) {
				children[i].setParent(this);
			}
		}
		children[index + 1] = child;
		if (child != null) {
			child.setParent(this);
		}
		return index + 1;
	}

	public boolean isFull() {
		return keyCount == keys.length;
	}

	public void addKey(int index, Comparable key) {
		// Check for valid index

		if (index < 0 || index > keyCount) {
			throw new IndexOutOfBoundsException("Invalid index: " + index);
		}

		// Check if array is full
		if (keyCount == keys.length) {
			// Create new array with double the capacity
			Comparable[] newKeys = new Comparable[keys.length * 2];

			// Copy keys to new array
			for (int i = 0; i < keyCount; i++) {
				newKeys[i] = keys[i];
			}

			// Replace old array with new array
			keys = newKeys;
		}

		// Shift keys to the right to make room for new key
		for (int i = keyCount - 1; i >= index; i--) {
			keys[i + 1] = keys[i];
		}

		// Insert new key
		keys[index] = key;
		keyCount++;
	}

	public void removeKey(int index) {
		for (int i = index; i < keyCount - 1; i++) {
			keys[i] = keys[i + 1];
		}
		keys[keyCount - 1] = null;
		keyCount--;
	}

	public void removeChild(int index) {
		for (int i = index; i < childCount - 1; i++) {
			children[i] = children[i + 1];
		}
		children[childCount - 1] = null;
		childCount--;
	}

	public boolean isLeaf(Node<T> node) {
		return node.getchildren() == null;
	}

	public int indexOfChild(Node<T> child) {
		for (int i = 0; i < childCount; i++) {
			if (children[i] == child) {
				return i;
			}
		}
		// return -1;
		return -1;
	}

	public void setKeynumber(int count) {
		this.keyCount = count;
	}

	public int getKeynumber() {
		return keyCount;
	}

	public void setKey(int index, Comparable key) {
		keys[index] = (T) key;
	}

	public void setChild(int index, Node<T> child) {

		if (index < 0) {
			throw new IndexOutOfBoundsException("Index cannot be negative: " + index);
		}
		if (index >= children.length) {
			throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
		}
		children[index] = child;
		if (child != null) {
			child.setParent(this);
		}
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public Comparable[] getkeys() {
		return keys;
	}

	public Node[] getchildren() {
		return children;
	}

	@Override
	public String toString() {
		String res = "[";
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null)
				res += keys[i];
			else
				res += "null";
			res += ",";
		}
		if (res.length() > 1) {
			res = res.substring(0, res.length() - 1);
		}
		return res + "]";
	}

}