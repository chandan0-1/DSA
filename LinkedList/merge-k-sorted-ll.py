# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq
import itertools
class Solution:
    def mergeRecursive(self, l1, l2):
        if not l1:
            return l2
        if not l2:
            return l1

        head = None
        if l1.val < l2.val:
            head = l1
            head.next = self.merge(l1.next, l2)
            
        else:
            head = l2
            head.next = self.merge(l1, l2.next)
        return head

    def mergeLinear(self, l1, l2):
        if not l1 or not l2:
            return l1 or l2
        
        head = h = ListNode()
        h.next = l1 if l1.val < l2.val else l2

        while l1 and l2:
            if l1.val < l2.val:
                h.next = l1
                l1 = l1.next
            else:
                h.next = l2
                l2 = l2.next
            h = h.next

        if l1 or l2:
            h.next = l1 or l2

        return head.next

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if len(lists) == 0:
            return None
        if len(lists) == 1:
            return lists[0]

        return self.mergePriorityQueue(lists)
        # return self.mergeDivideAndConquer(lists, 0, len(lists) - 1)
    
    def mergePriorityQueue(self, lists):
        counter = itertools.count()
        heap = []
        for _list in lists:
            if _list:
                heap.append((_list.val, (next(counter), _list)))
        heapq.heapify(heap)

        ansNode = head = ListNode()
        while len(heap) > 0:
            # De-constucting the values from the heap
            _val, counter_and_node = heapq.heappop(heap)
            _counter, node = counter_and_node

            head.next = node
            head = head.next

            if node.next:
                heapq.heappush(heap, (node.next.val, (next(counter), node.next)))

        return ansNode.next


    def mergeDivideAndConquer(self, lists, i, j):
        if i == j:
            return lists[i]

        mid = (i + j) // 2
        l1 = self.mergeDivideAndConquer(lists, i, mid)
        l2 = self.mergeDivideAndConquer(lists, mid + 1, j)
        return self.mergeLinear(l1, l2)
        
