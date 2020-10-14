package Series.Smart;

/**
 * @Author rope
 * @Date 2020/8/26 23:41
 * @Version 1.0
 */
/*
* 83. 删除排序链表中的重复元素
* https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
* */
public class Test83 {
    public ListNode deleteDuplicates(ListNode head) {
        //head表示地址 并不是可以临时操作的节点
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        while (temp != null && temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }
}
