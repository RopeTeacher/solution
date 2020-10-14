package Series.Recursion;


/**
 * @Author rope
 * @Date 2020/10/13 11:01
 * @Version 1.0
 */
/*
* 24. 两两交换链表中的节点
* */
public class Test24 {
    //链表的题目 通常都可以很自然的想到递归与迭代这两种方法
    //此为递归法
    public ListNode swapPairs(ListNode head) {
        //递归的终止条件:链表为空或者链表只有一个节点
        if(head == null || head.next == null) return head;
        ListNode newHead = head;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
    //此为迭代法
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) return head;

        return head;
    }
}
