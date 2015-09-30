class Node<T> {
	T element;
	Node<T> rightNode;
	Node<T> leftNode;
	Node<T> nextNode;
	public void setElement(T element) {
		this.element = element;
	}

	public T getElement() {
		return this.element;
	}

	public void setRightNode(Node<T> rightNode) {
		this.rightNode = rightNode;
	}

	public Node<T> getRightNode() {
		return this.rightNode;
	}

	public void setLeftNode(Node<T> leftNode) {
		this.leftNode = leftNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	public Node<T> getNextNode() {
		return this.nextNode;
	}

	public Node<T> getLeftNode() {
		return this.leftNode;
	}
}