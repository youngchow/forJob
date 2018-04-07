package com.zy.linklist;

/**
 * 合并两个有序的单链表，合并之后的链表依然有序： 这道题经常被各公司考察。 例如： 链表1： 1->2->3->4 链表2： 2->3->4->5 合并后：
 * 1->2->2->3->3->4->4->5 解题思路： 挨着比较链表1和链表2。
 * 这个类似于归并排序。尤其要注意两个链表都为空、和其中一个为空的情况。只需要O (1) 的空间。时间复杂度为O (max(len1,len2))
 * 
 * @author admin
 *
 */
public class mergeLinkList {

	public static void main(String[] args) {
		linkList list1 = new linkList();
		linkList list2 = new linkList();
		// 向LinkList中添加数据
		for (int i = 0; i < 4; i++) {
			list1.add(i);
		}

		for (int i = 3; i < 8; i++) {
			list2.add(i);
		}

		linkList list3 = new linkList();
		list3.head = list3.mergeLinkList(list1.head, list2.head); // 将list1和list2合并，存放到list3中

		list3.print(list3.head);// 从head节点开始遍历输出
	}

}
