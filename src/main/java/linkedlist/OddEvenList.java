package linkedlist;

// 328 https://leetcode-cn.com/problems/odd-even-linked-list/
/*
给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这
里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
输入: 2->1->3->5->6->4->7->NULL
输出: 2->3->6->7->1->5->4->NULL
 */
public class OddEvenList {

  public static ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode oddDummy = new ListNode(-1);
    ListNode odd = oddDummy;
    ListNode evenDummy = new ListNode(-1);
    ListNode even = evenDummy;
    int i = 1;
    while (head != null) {
      if (i % 2 == 0) {
        even.next = head;
        even = head;
      } else {
        odd.next = head;
        odd = head;
      }
      i++;
      head = head.next;
    }
    even.next = null; // 记得端口链接，否则循环链表
    odd.next = evenDummy.next;
    return oddDummy.next;
  }

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(4);
    ListNode listNode5 = new ListNode(5);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = null;
    oddEvenList(listNode1);

  }

}
