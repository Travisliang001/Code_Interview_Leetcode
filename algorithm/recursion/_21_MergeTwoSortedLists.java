package algorithm.recursion;

public class _21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // base case is if either one is null, then return the other node
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        //recursive relation:
        //compare the head who become the new head and connect to the matching
        if(list1.val > list2.val){
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        } else{
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
//         ListNode res = new ListNode();
        
//         ListNode dmy  = new ListNode();
//         dmy = res;
//         while(list1 != null || list2 != null){
//             int list1Val = -101;
//             int list2Val = -101;
//             if(list1 != null){
//                 list1Val = list1.val;
//             }
//             if(list2 != null) {
//                 list2Val = list2.val;
//             }
//             if(list1Val > -100 && list2Val > -100){
//                 if(list1Val > list2Val){
//                     res.next = (list2);
//                     list2 = list2.next;
//                 } else{
//                     res.next = (list1);
//                     list1 = list1.next;
//                 }
//                 res = res.next;
//             } else if(list1Val > -100){
//                 res.next = (list1);
//                     list1 = list1.next;
//                                 res = res.next;

//             } else if(list2Val > -100){
//                 res.next = (list2);
//                     list2 = list2.next;
//                                 res = res.next;

//             } 
            
//         }
//         return dmy.next;
    }
}
