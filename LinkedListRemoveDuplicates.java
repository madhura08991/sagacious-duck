package data.structures;
import java.util.*;

//Defining Node class for LinkedList
class Node {
	int data;
	Node next;
	
	Node(int value) {
		this.data = value;
		this.next = null;
	}
	
	Node() {
		this.data = 0;
		this.next = null;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}

//Defining LinkedList

class LinkedList {
	Node[] nodes = new Node[10];
	int listCount = 0;
	int maxnodes = 10;
	Node head = new Node();
	
	LinkedList() {
		nodes[0] = this.head;
		for(int i=1; i<=maxnodes-1; i++) {
			nodes[i] = new Node();
			nodes[i-1].setNext(this.nodes[i]);
		}
		this.head.setNext(this.nodes[1]);
	}
	
	int getListCount() {
		return this.listCount;
	}
	
	void deleteNode(int place) {
		Node deleteNext = new Node();
		for(int i=0; i<place-1; i++) {
			deleteNext = this.nodes[i].getNext();
		}
		deleteNext.setNext(this.nodes[place]);
		for(int i=place-2; i<this.listCount; i++) {
			nodes[i] = nodes[i+1];
		}
		nodes[listCount] = new Node();
		listCount--;
	}
	
	Node getHead() {
		return this.head;
	}
	
	void addEntries(int[] entries) {
		for(int i=0; i<=entries.length-1;i++) {
			this.nodes[i].setData(entries[i]);
			listCount++;
		}
	}
	
	void printList() {
		for(int i=0; i<=listCount-1;i++) {
			System.out.println(this.nodes[i].getData());
		}
	}
	
	
}

public class LinkedListRemoveDuplicates {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		int[] dataEntries = new int[]{2,3,4,5,3};
		list.addEntries(dataEntries);
		list.printList();
		removeDuplicates(list);
		list.printList();
	}
	
	//Removes duplicates from a linked list
	
	public static void removeDuplicates(LinkedList list) {
		int listLength =  list.getListCount();
		List<Integer> data = new ArrayList<Integer>();
		Node currentNode = list.getHead();
		for(int i=0; i<listLength; i++) {
			if(data.contains(currentNode.getData())) {
				list.deleteNode(i+1);
			}
			else {
				data.add(currentNode.getData());
				currentNode = currentNode.getNext();
			}
		}
	}

}
