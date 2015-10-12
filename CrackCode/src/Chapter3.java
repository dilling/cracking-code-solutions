import java.util.Random;

public class Chapter3 {

	public static void main(String[] args) {
		
		Chapter3 chapter3 = new Chapter3();
		
		// 3.1 TripleStack
		TripleStack tripleStack = chapter3.new TripleStack();
		Random rand = new Random();
		Integer[] randIntArray = new Integer[6];
		int size = 6, bound = 100, c=0;
		for(Integer integer : randIntArray) {
			integer = new Integer(rand.nextInt(bound));
			System.out.println(integer);
			tripleStack.push(integer, c+1);
			c++;
			c=c%3;
		}

		System.out.println();
		c=0;
		for(int i=0; i<size; i++){
			System.out.println(tripleStack.pop(c+1));
			c++;
			c=c%3;
		}
	}
	
	// 3.1 Describe how you could use a single array to implement three stacks.
	class TripleStack {
		int size=4, location;
		int[] top = {-1,-1,-1};
		Object[] stackArray = new Object[size];
		
		Object pop(int n){
			Object item;
			n--;
			if(top[n]<0) return null;
			location = calculateLocation(n);
			item = stackArray[location];
			stackArray[location] = null;
			top[n]--;
			return item;
		}
		void push(Object item, int n){
			n--;
			top[n]++;
			location = calculateLocation(n);
			if(location>=stackArray.length)
				stackArray = resizeArray(stackArray);
			stackArray[location] = item;
		}
		
		int calculateLocation(int n){
			return top[n]*3+n;
		}
		Object[] resizeArray(Object[] array){
			Object[] tempArray = new Object[array.length*2];
			for(int i=0; i<array.length; i++){
				tempArray[i] = array[i];
			}
			return tempArray;
		}
	}
	
/************************************* HELPER METHODS ************************************************************/
	
	class Node {
		Node next = null;
		Object data;
		public Node(Object d) { data = d; }
		void appendToTail(Object d) {
			Node end = new Node(d);
			Node n = this;
			while(n.next != null) { n = n.next; }
			n.next = end;
		}
	}
	
	class Stack {
		Node top;
		Object pop() {
			if (top!=null) {
				Object item = top.data;
				top = top.next;
				return item;
			}
			return null;
		}
		void push(Object item) {
			Node t = new Node(item);
			t.next = top;
			top = t;
		}
	}
	
	class Queue {
		Node first, last;
		void enqueue(Object item){
			if(first==null){
				last = new Node(item);
				first = last;
			} else {
				last.next = new Node(item);
				last = last.next;
			}
		}
		Object dequeue(Node n) {
			if(first!=null) {
				Object item = first.data;
				first = first.next;
				return item;
			}
			return null;
		}
	}
}
