import java.util.Random;

public class Chapter2 {

	public static void main(String[] args) {
		
		Chapter2 chapter2 = new Chapter2();
		
		// 2.1 removeDuplicates
		Node head = chapter2.randomList(10, 10);
		chapter2.printList(head);
		chapter2.removeDuplicates(head);
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
}
