package homework3.singlylinkedlist;

public class Node {
	private int data;
	private Node next;
	private final int dummy = -1;

	public Node(int x) {
		data = x;
		next = null;
	}

	public Node() {
		data = dummy;
		next = null;
	}

	public void setData(int x) {
		data = x;
	}

	public int getData() {
		return data;
	}

	public void setNext(Node n) {
		next = n;
	}

	public Node getNext() {
		return next;
	}

}
