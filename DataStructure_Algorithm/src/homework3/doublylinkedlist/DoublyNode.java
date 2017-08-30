package homework3.doublylinkedlist;

public class DoublyNode {

	private int data;
	private DoublyNode next;
	private DoublyNode prev;
	private final int dummy = -1;

	public DoublyNode(int x) {
		data = x;
		next = null;
		prev = null;
	}

	public DoublyNode() {
		data = dummy;
		next = null;
		prev = null;
	}

	public void setData(int x) {
		data = x;
	}

	public int getData() {
		return data;
	}

	public void setNext(DoublyNode n) {
		next = n;
	}

	public DoublyNode getNext() {
		return next;
	}

	public void setPrev(DoublyNode n) {
		prev = n;
	}

	public DoublyNode getPrev() {
		return prev;
	}
}