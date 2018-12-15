package cn.sxt.collection;

import java.util.List;

/***
 * 链表LinkedList
 * 
 * @author Administrator
 *
 */
public class MyLinkedList /* implements List */ {
	private Node first;
	private Node last;

	private int size;

	public int size() {
		return size;
	}

	public Object get(int index) {
		// 0 1 2 3 4
		// index越界如何处理？
		rangeCheck(index);
		Node temp = node(index);
		if (temp != null) {
			return temp.getObj();
		}
		return null;

	}

	public Node node(int index) {
		Node temp = null;
		if (first != null) {
			if (index < (size >> 1)) { //// 提高便利的效率
				temp = first;

				// size:50; 2 48 [0,49]
				// index 跟size/2
				for (int i = 0; i < index; i++) {
					temp = temp.getNext();
				}
			} else {
				temp = last;
				for (int i = size-1; i > index; i--) {
					temp = temp.getPrevious();
				}
			}
		}
		return temp;
	}

	public void remove(int index) {
		rangeCheck(index);
		Node temp = node(index);
		if (temp != null) {
			Node up = temp.getPrevious();
			Node down = temp.getNext();
			up.setNext(down);
			down.setPrevious(up);
		}
		size--;
	}

	public void add(Object obj) {
		Node n = new Node();
		if (first == null) {
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);

			first = n;
			last = n;
		} else {
			// 直接往last节点后面增加新的节点
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);

			last.setNext(n);
			last = n;
		}
		size++;
	}

	public void add(int index, Object obj) {
		rangeCheck(index);
		Node temp = node(index);
		Node newNode = new Node();
		newNode.setObj(obj);

		if (temp != null) {
			Node up = temp.getPrevious();
			up.setNext(newNode);
			newNode.setPrevious(up);
			newNode.setNext(temp);
			temp.setPrevious(newNode);
		}
	}

	private void rangeCheck(int index) {
		// if (index < 0 || index >= size) {
		if (index >= size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add(3242);
		list.add("erw");
		list.add("erwccc");
		System.out.println(list.size());
		System.out.println(list.get(2));
		list.remove(1);
		System.out.println(list.get(1));
		list.add(1, "BBB");
		System.out.println(list.get(1));
	}
}

class Node {

	private Node previous; // 上一个节点
	private Object obj;
	private Node next; // 下一个节点

	public Node() {

	}

	public Node(Node previous, Object obj, Node next) {
		super();
		this.previous = previous;
		this.obj = obj;
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}