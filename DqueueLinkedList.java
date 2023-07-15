package queue;

import java.util.*;

class DQNode
{
	char data;
	DQNode rlink;
	DQNode llink;
}
class DQueue
{
	DQNode front;
	DQNode rear;
	
	public DQueue(){
		front = null;
	}
	
	public boolean isEmpty() {
		return front==null;
	}
	
	public void insertFront(char data) {
		DQNode newNode =  new DQNode();
		newNode.data = data;
		
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			front.llink = null;
			rear.rlink = null;
		}else {
			front.llink = newNode;
			newNode.rlink = front;
			newNode.llink = null;
			front = newNode;
		}
		System.out.println("Front New Item => "+data);
	}
	
	public void insertRear(char data) {
		DQNode newNode = new DQNode();
		newNode.data = data;
		
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			rear.rlink = null;
			front.llink = null;
		}else {
			rear.rlink = newNode;
			newNode.rlink = null;
			newNode.llink = rear;
			rear = newNode;
		}
		System.out.println("Rear New Item => "+data);
	}
	
	public char deleteFront() {
		
		if(isEmpty()) {
			System.out.println("Empty");
			return 0;
		}else {
			char data = front.data;
			if(front.rlink == null) {
				front = null;
				rear = null;
			}else {
				front = front.rlink;
				front.llink = null;
			}
			return data;
		}
	}
	
	public char deleteRear() {
		
		if(isEmpty()) {
			System.out.println("Empty");
			return 0;
		}else {
			char data = rear.data;
			if(rear.llink == null) {
				rear = null;
				front = null;
			}else {
				rear = rear.llink;
				rear.rlink = null;
			}
			return data;
		}
	}
	
	public char peekFront() {
		if(isEmpty()) {
			System.out.println("Empty");
			return 0;
		}else {
			return front.data;
		}
	}
	
	public char peekRear() {
		if(isEmpty()) {
			System.out.println("Empty");
			return 0;
		}else {
			return rear.data;
		}
	}
	
	public void printQueue() {
		
		if(isEmpty()) {
			System.out.println("Empty");
		}else {
			DQNode tmp = front;
			while(true) {
				System.out.println(tmp.data);
				if(tmp.rlink==null) {
					break;
				}
				tmp = tmp.rlink;
			}
		}
	}
}

public class DqueueLinkedList {

	public static void main(String[] args) {
		
		DQueue q = new DQueue();
		q.insertFront('A');
		q.insertFront('B');
		q.insertRear('C');
		q.insertRear('D');
		
		q.printQueue();
		System.out.println(q.peekFront());
		System.out.println(q.peekRear());
		
		q.deleteFront();
		q.deleteRear();
		q.printQueue();
		
		
	}

}
