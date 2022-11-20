package algorithm.recursion;

public class _206_reverseLinkedList {
    
    public ListNode reverseList(ListNode head) {
        //         if(head == null ){
        //             return head;
        //         }
        //         ListNode pre = null;
        //         ListNode cur = head;
        //         ListNode next = null;
                
        //         while(head!=null){
        //             next = head.next;
        //             head.next = pre;
        //             pre = head;
        //             head = next;
        //         }
                
        //         return pre;
                
                        
                return recursiveCall(head, null);
            }
            
            public ListNode recursiveCall(ListNode head, ListNode pre){
                if(head == null){
                    return head;
                }
                //recurrence relation: create a next and assign next val of head to it.
                ListNode next = head.next;
                //connect the head to the new next(flip the direction)
                head.next = pre;
                return recursiveCall(next, head);
            }
}
