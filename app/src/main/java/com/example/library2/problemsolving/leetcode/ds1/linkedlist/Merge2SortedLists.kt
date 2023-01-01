package com.example.library2.problemsolving.leetcode.ds1.linkedlist


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun mergeTwoLinkedListsRecursion(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1
    return if (l1?.`val` < l2?.`val`) {
        l1.apply {
            next = mergeTwoLinkedListsRecursion(next, l2)
        }
    } else {
        l2.apply {
            next = mergeTwoLinkedListsRecursion(l1, next)
        }
    }
}

fun mergeTwoLinkedLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var result: ListNode? = ListNode(0)
    var current = result

    var node1 = l1
    var node2 = l2
    while (node1 != null || node2 != null) {
        if (node1 == null) {
            current?.next = node2
            break
        }
        if (node2 == null) {
            current?.next = node1
            break
        }

        if (node1?.`val` < node2?.`val`) {
            current?.next = node1
            node1 = node1?.next
        } else {
            current?.next = node2
            node2 = node2?.next
        }
        current = current?.next
    }
    return result?.next
}

fun main() {
    val list1: ListNode = ListNode(1)
    list1.next = ListNode(2)
    list1.next!!.next = ListNode(3)

    val list2: ListNode = ListNode(1)
    list2.next = ListNode(3)
    list2.next!!.next = ListNode(4)

    val x = mergeTwoLinkedLists(list1, list2)
    println(x?.next)
}