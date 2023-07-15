package queue;

import java.util.*;

public class CircularArrayQueue {

	public static boolean add(int queue[],int front[],int rear[],int item) {
		
		if(rear[0]==queue.length-1) {
			rear[0] = 0;
		}else {
			rear[0]++;
		}
		if(front[0]==rear[0]) {
			System.out.println("Full");
			if(rear[0]==0) {
				rear[0] = queue.length-1;
			}else {
				rear[0]--;
			}
			return false;
		}else {
			queue[rear[0]] = item;
			return true;
		}
	}
	public static int delete(int queue[],int front[],int rear[]) {
		
		if(front[0]==rear[0]) {
			System.out.println("Empty");
			return -1;
		}else {
			if(front[0]==queue.length-1) {
				front[0] = 0;
			}else {
				front[0]++;
			}
			return queue[front[0]];
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("큐의 크기를 입력해주세요: ");
		
		int queueSize = scanner.nextInt();
		int queue[] = new int[queueSize];
		
		int front[] = {0};
		int rear[] = {0};
		
		boolean addCheck = true;
		while(true) {
			System.out.println("삽입 데이터를 입력해주세요: ");
			int item = scanner.nextInt();
			addCheck = add(queue,front,rear,item);
			if(addCheck==false) {
				break;
			}
		}
		
		int result;
		while(true) {
			result = delete(queue,front,rear);
			if(result==-1) {
				break;
			}
			System.out.println(result);
		}
		
	}

}
