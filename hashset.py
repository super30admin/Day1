# The code defines a simple hash set using a list of linked lists to handle collisions which is linear chaining in this case.
# Each position in the list starts with a dummy node (ListNode(0)), and the actual elements are added as nodes in the linked list for each respective bucket, determined by the modulus operation (key % len(self.set)). 
# The add method inserts a new key if it doesn't exist, remove deletes a key, and contains checks if a key is present in the hash set. 

#TC: Add - O(1) avg and O(n) worst case, Remove - O(1) avg and O(n) worst case, Contains - O(1) avg and O(n) worst case
#SC: O(m + n) where m is number of buckets(10^4) and n is unique elements stored in the hashset.

#Successful on Leetcode
class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None

class MyHashSet:

    def __init__(self):
        self.set = [ListNode(0) for i in range(10 ** 4)]

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


