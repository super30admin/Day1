#  Time Complexity : O(n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this :No

class ListNode:
    def __init__(self,key):
        self.key = key
        self.next = None

class MyHashSet:
    def __init__(self):
        self.capacity = 10 ** 4
        self.set = [ListNode(0) for _ in range(self.capacity)]
        

    def add(self, key: int) -> None:
        index = key % self.capacity
        curr = self.set[index] #we are at the dummyNode so need to start by checking the next node
        while curr.next:
            if curr.next.key == key:
                return
            curr = curr.next
        curr.next = ListNode(key)
        

    def remove(self, key: int) -> None:
        index = key % self.capacity
        curr = self.set[index] #we are at the dummyNode
        while curr.next:
            if curr.next.key == key:
                curr.next = curr.next.next
                return
            curr = curr.next

        

    def contains(self, key: int) -> bool:
        index = key % self.capacity
        curr = self.set[index] #we are at the dummyNode
        while curr.next:
            if curr.next.key == key:
                return True
            curr = curr.next
        return False