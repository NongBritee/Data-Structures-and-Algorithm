package homework3.doublylinkedlist;

import java.util.Scanner;

public class DoublyLinkedList {

	private DoublyNode header;
	private DoublyNode trailer;
	private int num_node;

	public DoublyLinkedList() {
		header = new DoublyNode();
		trailer = new DoublyNode();
		header.setNext(trailer);
		trailer.setPrev(header);
		num_node = 0;
	}
	
	public void readData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of node : ");
		this.num_node = sc.nextInt();
		
		DoublyNode newNode;
		DoublyNode lastNode;
		for (int i = 0; i < num_node; i++) {
			System.out.printf("Enter data of node %d : ", i+1);
			newNode = new DoublyNode(sc.nextInt());
			lastNode = trailer.getPrev();
			newNode.setNext(trailer);
			lastNode.setNext(newNode);
			newNode.setPrev(lastNode);
			trailer.setPrev(newNode);
		}
	}

	public void showData(int numInLine) {
		this.showDataForward(numInLine);
		this.showDataBackward(numInLine);
	}

	private void showDataForward(int numInLine) {
		int numOfLines = this.num_node / numInLine;
		int i = 0;
		DoublyNode currentNode = header.getNext();
		for (int j = 0; j < numOfLines; j++) {
			for (int k = 0; k < numInLine; k++) {
				System.out.print(currentNode.getData() + ",\t");
				currentNode = currentNode.getNext();
			}
			System.out.println();
		}
		while (currentNode != trailer) {
			System.out.print(currentNode.getData() + ",\t");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}

	private void showDataBackward(int numInLine) {
		int numOfLines = this.num_node / numInLine;
		int i = 0;
		DoublyNode currentNode = trailer.getPrev();
		for (int j = 0; j < numOfLines; j++) {
			for (int k = 0; k < numInLine; k++) {
				System.out.print(currentNode.getData() + ",\t");
				currentNode = currentNode.getPrev();
			}
			System.out.println();
		}
		while (currentNode != header) {
			System.out.print(currentNode.getData() + ",\t");
			currentNode = currentNode.getPrev();
		}
		System.out.println();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// SinglyLinkedList sll = new SinglyLinkedList();
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.readData();
		dll.showData(5);

		// System.out.println("Average is " + sll.findAverage());
		// System.out.println("Minimum is " + sll.findMinimum());

		return;
	}

}