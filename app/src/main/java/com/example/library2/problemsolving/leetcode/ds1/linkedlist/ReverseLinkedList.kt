package com.example.library2.problemsolving.leetcode.ds1.linkedlist


fun reverseLinkedList(head: ListNode?): ListNode?{
    var result: ListNode? = ListNode(-1)
    var head = result
    if(head == null)
        return null
    while(head != null){
        result?.next = head
        head = head.next
    }

    return head?.next
}