package structure;

public class LinkedList {
	public static void main(String[] args) {

		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.appendFirst(7);
		head.retrieve();
		head.delete(0);
		head.retrieve();
		
	}
}

class Node{
	int data;
	Node next=null;
	Node(int d){
		this.data=d;
	}
	
	void appendFirst(int d) {
		Node n = new Node(this.data);
		n.next=this.next;
		this.data=d;
		this.next=n;
	}
	
	void append(int d, int pre) { // pre 뒤에 데이터 추가
		Node nn = new Node(d);
		Node n = this;
		while(n.data!=pre) {
			n=n.next;
		}
		nn.next=n.next;
		n.next=nn;
	}
	
	void append(int d) { //데이터 맨 끝에 추가
		Node end = new Node(d);
		Node n = this;
		while(n.next!=null) {
			n=n.next;
		}n.next=end;
	}
	
	void delete(int d) {
		Node n=this;
		while(n.next.data!=d) {
			n=n.next;
			if(n.next==null) //삭제할 데이터가 없을 때
				break;
		}
		if(n.next==null) //삭제할 데이터가 없을 때
			System.out.println("삭제할 데이터가 없습니다.");
		else
			n.next=n.next.next;
	}
	
	void retrieve() {
		Node n = this;
		while(n.next!=null) {
			System.out.print(n.data+"->");
			n=n.next;
		}System.out.println(n.data);
	}
}
