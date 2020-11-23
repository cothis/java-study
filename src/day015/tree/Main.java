package day015.tree;

public class Main {
	public static void main(String[] args) {
		Node node1 = new Node(111); // new Node(new Integer(111) 이랑 동일, auto boxing
		
		Node node2 = new Node(222);
		
		node1.makeLeftSubTree(node2);
		
		Node node3 = new Node(333);
		
		node1.getLeftSubTree().makeRightSubTree(node3);
	}
}

class Node {
	
	private Node left;
	private Node right;
	private Object data;
	
	public Node(Object data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	// 왼쪽 자식 Node와 연결해주는 메소드
	public void makeLeftSubTree(Node sub) {
		this.left = sub;
	}
	
	// 오른쪽 자식 Node와 연결해주는 메소드
	public void makeRightSubTree(Node sub) {
		this.right = sub;
	}

	public Object getData() {
		return data;
	}
	
	public Node getLeftSubTree() {
		return left;
	}
	
	public Node getRightSubTree() {
		return right;
	}
	
	
}
