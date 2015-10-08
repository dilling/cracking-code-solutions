import java.util.HashMap;
import java.util.Random;

public class Chapter2 {

	public static void main(String[] args) {
		
		Chapter2 chapter2 = new Chapter2();
		
		// 2.1 removeDuplicates
		Node head = chapter2.randomList(10, 10);
		chapter2.printList(head);
		chapter2.removeDuplicates(head);
		chapter2.printList(head);
		
		// 2.2 getNthFromLast
		head = chapter2.randomList(10, 10);
		chapter2.printList(head);
		Node current = chapter2.getNthFromLast(head, 7);
		chapter2.printNode(current);
		
		// 2.3 deleteNode
		head = chapter2.randomList(6, 10);
		chapter2.printList(head);
		current = head.next.next;
		chapter2.deleteNode(current);
		chapter2.printList(head);
		
		// 2.4 addLinkedLists
		Node list1 = chapter2.randomList(3, 10);
		Node list2 = chapter2.randomList(3, 10);
		chapter2.printList(list1);
		chapter2.printList(list2);
		Node sumList = chapter2.addLinkedLists(list1, list2);
		chapter2.printList(sumList);
		
		// 2.5 findCorruptNode
		Node corruptList = chapter2.randomCorruptList(6, 100);
		chapter2.printList(corruptList, 20);
		Node corruptNode = chapter2.findCorruptNode(corruptList);
		chapter2.printNode(corruptNode);		
	}
	
	// 2.1 Write code to remove duplicates from an unsorted linked list. (No temporary buffer)
	public void removeDuplicates(Node head){
		if(head==null) return;
		Node current = head;
		while(current.next!=null){
			if(current.next.data==head.data){
				current.next = current.next.next;
			}
			else current = current.next;
		}
		removeDuplicates(head.next);
	}
	
	// 2.2 Implement an algorithm to find the nth to last element of a singly linked list.
	public Node getNthFromLast(Node head, int n){
		int c=0;
		Node current = head;
		while(current!=null){
			current=current.next;
			c++;
		}
		if(c<n) return null;
		
		current = head;
		while(current!=null){
			if(c==n) return current;
			current=current.next;
			c--;
		}
		return null;
	}
	
	// 2.3 Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
	public void deleteNode(Node node){
		if(node==null||node.next==null) return;
		node.data = node.next.data;
		node.next = node.next.next;
	}
	
	// 2.4 You have two numbers represented by a linked list, where each node contains a single digit. 
	// 	   The digits are stored in reverse order, such that the 1’s digit is at the head of the list. 
	//     Write a function that adds the two numbers and returns the sum as a linked list.
	public Node addLinkedLists(Node list1, Node list2){
		Node sumHead = new Node(0), current = sumHead, previous = null;
		int carry = 0, sum;
		
		while(list1!=null||list2!=null||carry>0){
			sum = getValue(list1) + getValue(list2) + carry;
			current.data = sum%10;
			carry = sum/10;
			
			if(list1!=null) list1 = list1.next;
			if(list2!=null) list2 = list2.next;
			current.next = new Node(0);
			previous = current;
			current = current.next;
		}
		if(previous!=null) previous.next = null;
		
		return sumHead;
	}
	
	private int getValue(Node node){
		if(node==null) return 0;
		else return node.data;
	}
	
	// 2.5 Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
	public Node findCorruptNode(Node node){
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		String memoryLocation;
		while(node!=null){
			memoryLocation = node.toString();
			if(map.containsKey(memoryLocation))
				return node;
			map.put(memoryLocation, true);
			node = node.next;			
		}
		return null;
	}

	/************************************* HELPER METHODS ************************************************************/
	
	class Node {
		Node next = null;
		int data;
		public Node(int d) { data = d; }
		void appendToTail(int d) {
			Node end = new Node(d);
			Node n = this;
			while(n.next != null) { n = n.next; }
			n.next = end;
		}
	}
	
	private Node randomList(int length, int randConstraint){
		Random rand = new Random();
		Node head = new Node(rand.nextInt(randConstraint));
		Node current = head;
		for(int i=1; i<length; i++){
			current.next = new Node(rand.nextInt(randConstraint));
			current = current.next;
		}
		return head;
	}
	
	private Node randomCorruptList(int length, int randConstraint){
		Random rand = new Random();
		Node head = new Node(rand.nextInt(randConstraint));
		Node current = head;	
		Node corruptNode = head;
		int corruptLocation = rand.nextInt(length); 
		
		for(int i=1; i<length; i++){
			current.next = new Node(rand.nextInt(randConstraint));
			current = current.next;
			if(corruptLocation==i) corruptNode = current;
		}
		current.next = corruptNode;
		return head;
	}
	
	private void printList(Node node){
		while(node!=null){
			System.out.print(node.data);
			System.out.print(" ");
			node = node.next;
		}
		System.out.println();
	}
	
	private void printList(Node node, int maxLength){
		int i = 0;
		while(node!=null&&i<maxLength){
			System.out.print(node.data);
			System.out.print(" ");
			node = node.next;
			i++;
		}
		System.out.println();
	}
	
	private void printNode(Node node){
		System.out.println(node.data);
		System.out.println();
	}
}

