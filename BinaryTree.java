import java.util.ArrayList;
@SuppressWarnings("unchecked")

class BinaryTree<T extends Comparable<T>> {
	
	Node<T> rootNode;
	int index = 0;
	int level = 0;
	int nodePointer = 0;
	Node<T> childNode;
	Node<T> traverseNode;
	Node<T> nextNode;
	ArrayList<T> preOrder = new ArrayList();
	ArrayList<T> postOrder = new ArrayList();
	ArrayList<T> inOrder = new ArrayList();
	public void insertElement(T element) {
		Node<T> newNode = new Node<T>();
		newNode.setElement(element);
		if (rootNode == null) {
			rootNode = newNode;
			traverseNode = newNode;
			nextNode = newNode;
			this.updateLevel(level);
			this.updateNodePointer();
		} else {
			if (childNode.getLeftNode() == null) {
			 	childNode.setLeftNode(newNode);
			} else if (childNode.getRightNode() == null) {
	 			childNode.setRightNode(newNode);
	 			this.updateNodePointer();
	 			this.updateLevel(level);
			}
			nextNode.setNextNode(newNode);
      		nextNode = newNode;
		}
		index++; 
	}

	public void updateNodePointer() {
		Node<T> node1 = traverseNode;
		int i = 0;
		if (nodePointer == 0) {
			childNode = rootNode;
		} else {
			while (i <= nodePointer) {
				childNode = node1;
				node1 = node1.getNextNode();
				i++;
			}
		}
		nodePointer++;
	}

	public void updateLevel(int presentLevel) {
		if (index == ((2^level) - 1)) {
			level++;
		}
	}

	public void preOrderTraversel(Node<T> root) {
		int i = 0;
		if (root != null) {
			preOrder.add(root.getElement());
			preOrderTraversel(root.getLeftNode());
			preOrderTraversel(root.getRightNode());
		}
	}

	public void postOrderTraversel(Node<T> root) {
		if (root != null) {
			postOrderTraversel(root.getLeftNode());
			postOrderTraversel(root.getRightNode());
			postOrder.add(root.getElement());
		}
	}

	public void inOrderTraversel(Node<T> root) {
		if (root != null) {
			inOrderTraversel(root.getLeftNode());
			inOrder.add(root.getElement());
			inOrderTraversel(root.getRightNode());
		}
	}

	public void printAllNodes(ArrayList<T> a) {
		for (int i = 0; i < a.size() - 1; i++) {
			System.out.print(a.get(i) + ",");
		}
		if (!a.isEmpty()) {
			System.out.println(a.get(a.size() - 1));			
		}
		preOrder = new ArrayList<T>();
		postOrder = new ArrayList<T>();
		inOrder = new ArrayList<T>();
	}

	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		bt.insertElement(1);
		bt.inOrderTraversel(bt.rootNode);
		bt.printAllNodes(bt.inOrder);
		bt.insertElement(2);
		bt.printAllNodes(bt.inOrder);
		bt.inOrderTraversel(bt.rootNode);
		bt.insertElement(3);
		bt.printAllNodes(bt.inOrder);
		bt.inOrderTraversel(bt.rootNode);
		bt.insertElement(14);
		bt.printAllNodes(bt.inOrder);
		bt.inOrderTraversel(bt.rootNode);
		bt.insertElement(15);
		bt.printAllNodes(bt.inOrder);
		bt.inOrderTraversel(bt.rootNode);
		bt.insertElement(5);
		bt.preOrderTraversel(bt.rootNode);
		bt.printAllNodes(bt.preOrder);
	}
}