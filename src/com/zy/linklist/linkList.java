package com.zy.linklist;

//1.单链表的创建和遍历
public class linkList {

	public Node head;
	public Node current;

	// 方法：向链表中添加数据
	public void add(int data) {
		// 判断链表为空的时候
		if (head == null) {// 如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
			head = new Node(data);
			current = head;
		} else {
			// 创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
			current.next = new Node(data);
			// 把链表的当前索引向后移动一位
			current = current.next;// 此步操作完成之后，current结点指向新添加的那个结点
		}
	}

	// 方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历）
	public void print(Node node) {
		if (node == null) {
			return;
		}
		current = node;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	/**
	 * 2.求单链表中节点的个数
	 * 
	 * @param head
	 * @return
	 */
	// 方法：获取单链表的长度
	public int getLength(Node head) {
		if (head == null) {
			return 0;
		}
		int length = 0;
		current = head;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

	// 两个参数代表的是两个链表的头结点
	public Node mergeLinkList(Node head1, Node head2) {

		if (head1 == null && head2 == null) { // 如果两个链表都为空
			return null;
		}
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		Node head; // 新链表的头结点
		Node current; // current结点指向新链表
		// 一开始，我们让current结点指向head1和head2中较小的数据，得到head结点
		if (head1.data < head2.data) {
			head = head1;
			current = head1;
			head1 = head1.next;
		} else {
			head = head2;
			current = head2;
			head2 = head2.next;
		}

		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				current.next = head1; // 新链表中，current指针的下一个结点对应较小的那个数据
				current = current.next; // current指针下移
				head1 = head1.next;
			} else {
				current.next = head2;
				current = current.next;
				head2 = head2.next;
			}
		}

		// 合并剩余的元素
		if (head1 != null) { // 说明链表2遍历完了，是空的
			current.next = head1;
		}

		if (head2 != null) { // 说明链表1遍历完了，是空的
			current.next = head2;
		}

		return head;
	}

	public static void main(String[] args) {
		linkList linkList = new linkList();
		// 向LinkList中添加数据
		for (int i = 0; i < 10; i++) {
			linkList.add(i);
		}
		linkList.print(linkList.head);// 从head节点开始遍历输出
		System.out.println("链表长度为： " + linkList.getLength(linkList.head));
	}
}
