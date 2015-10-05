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
		head = chapter2.randomList(3, 10);
		chapter2.printList(head);
		current = head.next.next;
		chapter2.deleteNode(current);
		chapter2.printList(head);		
		
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
	
	private void printList(Node node){
		while(node!=null){
			System.out.print(node.data);
			System.out.print(" ");
			node = node.next;
		}
		System.out.println();
	}
	
	private void printNode(Node node){
		System.out.println(node.data);
		System.out.println();
	}
}

