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
		System.out.print("Enter number of node : ");
		Scanner sc = new Scanner(System.in);
		num_node = sc.nextInt();
		
		for( int i=0; i<num_node; i++){
			Node currentNode = header;
			while(currentNode.getNext() != tailer ){
				currentNode = currentNode.getNext();
			}
			
			System.out.printf("Enter data of node %d : ", i+1);
			int data = sc.nextInt();
			Node newNode = new Node(data);
			currentNode.setNext(newNode);
			newNode.setNext(tailer);
		}
	}

	public void showData(int numInLine) {
		int numOfLines = num_node / numInLine;
		Node currentNode = header.getNext();
		for (int j = 0; j < numOfLines; j++) {
			for (int k = 0; k < numInLine; k++) {
				System.out.print(currentNode.getData() + ",\t");
				currentNode = currentNode.getNext();
			}
			System.out.println();
		}
		while (currentNode != tailer) {
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
		return avg/(double)this.num_node;
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

	public void deleteData(int data){
		Node currentNode = header;
		boolean foundNode = false;
		for(int i=0; i<num_node; i++){
			if(currentNode.getNext().getData() == data){
				foundNode = true;
				break;
			}
			currentNode = currentNode.getNext();
		}

		if(foundNode){
			currentNode.setNext(currentNode.getNext().getNext());
			num_node--;
		}
	}
	
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		 SinglyLinkedList sll = new SinglyLinkedList();
//		CircularlyLinkedList sll = new CircularlyLinkedList();
		sll.readData();
		sll.deleteData(5);
		sll.showData(2);

		 System.out.println("Average is " + sll.findAverage());
		 System.out.println("Minimum is " + sll.findMinimum());
	}
}
