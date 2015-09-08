//Reverse every k nodes in a given linked list & function to get sum of two lists


//Defining a linked list node
class LNode
{
	private int value;
	private node next;
	
	LNode(int value)
	{
		this.value = value;
		this.next = null;
	}
	
	LNode()
	{
		this.value = 0;
		this.next = null;
	}
	
	int getValue()
	{
		return this.value;
	}
	
	void setValue(int v)
	{
		this.value=v;
	}
	
	node getNext()
	{
		return this.next;
	}
	
	void setNext(LNode node)
	{
		this.next = node;
	}
}

class LinkedList {
	
	private LNode list[] = new LNode[10];
	
	LinkedList() {
		for(int i=0; i<list.length; i++) {
			if(i!=list.length-1) {
				list[i].setNext(list[i+1]);	
			}
			else {
				list[i].setNext(null);
			}
		}
	}
	LinkedList(int[] values)
	{
		int[] temp = values;
		for(int i=0; i<list.length; i++) {
			LNode lNode = new node(values[i]);
			list[i] = lNode;
			if(i!=temp.length-1)
			{
				this.list[i].setNext(list[i+1]);	
			}
			else
			{
				this.list[i].setNext(null);
			}
			
		}
	}
	
	void printList()
	{
		for(int i=0;i<list.length;i++) {
			System.out.println(list[i].getValue());
		}
	}
	
	LNode[] getList() {
		return this.list;
	}
	
	void reverseK(int k) {
		if(k==0 || k>this.list.length) {
			return;
		}
		else {
		int iterations = this.list.length/k;
		int start_index, end_index;
		for(int i=0;i<iterations;i++) {
			start_index = k*i;
			end_index = start_index+k-1;
			int temp;
			while(start_index!=end_index) {
				temp = this.list[start_index].getValue();
				this.list[start_index].setValue(this.list[end_index].getValue());
				this.list[end_index].setValue(temp);
				start_index++;
				end_index--;
			}
		}	
		}
	}
}

public class ReverseKNodes {

	public static void main(String[] args) {
		
		int numbers[] = {1,2,3,4,5,6,7,8,9,10};
		
		LinkedList firstList = new LinkedList(numbers);
		LinkedList secondList = new LinkedList(numbers);
	
		firstList.printList();
		firstList.reversek(3);
		firstList.printList();
		firstList = sumlist(l1,l2);
		firstList.printList();
	}

	public static linkedlist sumlist(LinkedList firstList, LinkedList secondList)
	{
		node[] list1 = firstList.getList();
		node[] list2 = secondList.getList();
		for(int i=0;i<l1.getList().length;i++)
		{
			firstList[i].setValue(list1[i].getValue()+list2[i].getValue());
		}
		return firstList;
	}
	
}
