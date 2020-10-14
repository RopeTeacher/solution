package Series.Recursion;


/**
 * @Author rope
 * @Date 2020/8/27 0:52
 * @Version 1.0
 */
/*
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * */
public class Test83 {
    /*
    * 本题的链表问题可以通过递归解决
    * 递归的核心是分解出子问题来解决 本体的子问题？
    * 终止条件：链表为空/链表只有一个头节点
    * 递归过程：判断之后的节点是否与当前节点值相同，如果不相同，则对之后的节点进行递归，如果相同，则对下下的节点进行递归
    * //并不能确定head.next.next的值一定和head不同
       所以不能写head.next = deleteDuplicates(head.next.next);
    * */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        head.next = deleteDuplicates(head.next);
        if(head.next.val == head.val) head.next = head.next.next;

        return head;
    }
}
