#Leetcode: 705 - Design a Hashset 

"""
- Create a ListNode to store the key. To add/remove/contains a key, calculate the index using the hash function and start at the head of the linked list.
- If the key is already present return the key/True for add and contains, add the key if not present or return False in case of contains. 
- To remove a key, update the current pointer to the current.next.next (remove the immediate node after current)
- Time complexity = O(1)
- Space complexity = O(n)

"""

class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None

class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.set = [ListNode(0) for i in range(self.size)]

    def add(self, key: int) -> None:
        cur = self.set[key % len(self.set)]
        while cur.next:
            if cur.next.key == key:
                return         
            cur = cur.next
        cur.next = ListNode(key)

    def remove(self, key: int) -> None:
        cur = self.set[key % len(self.set)]
        while cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return
            cur = cur.next

    def contains(self, key: int) -> bool:
        cur = self.set[key % len(self.set)]
        while cur.next:
            if cur.next.key == key:
                return True
            cur = cur.next
        return False
        