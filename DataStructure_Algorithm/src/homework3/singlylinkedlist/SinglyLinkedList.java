package homework3.singlylinkedlist;

import java.util.Scanner;

public class SinglyLinkedList {
	
	private Node header;
	private Node tailer;
	private int num_node;

	public SinglyLinkedList() {
		header = new Node();
		tailer = new Node();
		header.setNext(tailer);
		num_node = 0;
	}


	public void readData() {
		this.num_node++;
		System.out.print("Enter data : ");
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		Node currentNode = this.header;
		while(currentNode.getNext() != this.tailer ){
			currentNode = currentNode.getNext();
		}
		
		Node newNode = new Node(data);
		currentNode.setNext(newNode);
		newNode.setNext(this.tailer);
	}

	public void showData(int numInLine) {
		int numOfLines = this.num_node / numInLine;
		Node currentNode = this.header;
		for (int j = 0; j < numOfLines; j++) {
			for (int k = 0; k < numInLine; k++) {
				System.out.print(currentNode.getData() + ",\t");
				currentNode = currentNode.getNext();
			}
			System.out.println();
		}
		while (currentNode != null) {
			System.out.print(currentNode.getData() + ",\t");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public double findAverage(){
		Node currentNode = header.getNext();
		double avg = 0;
		while(currentNode != tailer){
			avg += currentNode.getData();
			currentNode = currentNode.getNext();
		}
		return avg/this.num_node;
	}
	
	public int findMinimum(){
		Node currentNode = header.getNext();
		int min = currentNode.getData();
		while(currentNode != tailer){
			min = currentNode.getData() < min ? currentNode.getData() : min;
			currentNode = currentNode.getNext();
		}
		return min;
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		 SinglyLinkedList sll = new SinglyLinkedList();
//		CircularlyLinkedList sll = new CircularlyLinkedList();
		sll.readData();
		sll.readData();
		sll.readData();
		sll.readData();
		sll.readData();
		sll.showData(2);

		 System.out.println("Average is " + sll.findAverage());
		 System.out.println("Minimum is " + sll.findMinimum());
	}
}
