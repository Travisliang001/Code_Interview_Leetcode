package algorithm.recursion;

public class _24_SwapNodesInPairs {
    public static void main(String[] args) {
        System.out.println();
    }

    public ListNode swapPairs(ListNode head){
        ListNode dmy = new ListNode(0), pre = dmy;
        dmy.next = head;
        //pre.next = dmy.next = suc;
        while(pre.next != null && pre.next.next != null) {
            // pre->cur->suc->tmp
            ListNode cur = pre.next;
            ListNode suc = cur.next;
            ListNode tmp = suc.next;

            pre.next = suc;
            suc.next = cur;
            cur.next = tmp;
            pre = cur;
        }
        return dmy.next;
    }

    public ListNode swapPairsAlt(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        //head -> head.next -> head.next.next
        //1. Take the middle element out
        ListNode n = head.next;
        //2. Assign the previous first element to connect to the last element.
        head.next = swapPairsAlt(head.next.next);
        //3. update the new first element connect to the prevoius head.
        n.next = head;
        return n;
        
    }
}
