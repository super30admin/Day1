"""
Time Complexity :
Space Complexity :

"""


class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None

class MyHashSet:

    def __init__(self):
        self.hash_set = [ListNode(0) for _ in range(10**4)]
        

    def add(self, key: int) -> None:
        """
        Time Complexity :O(1)
        Space Complexity :O(n + k) n isthe number of keys and k is the buckets
        """
        index = key % len(self.hash_set)
        curr = self.hash_set[index]
        
        while curr.next:
            if curr.next.val == key:
                return
            curr = curr.next
            
        curr.next = ListNode(key)
        
        
    def remove(self, key: int) -> None:
        curr = self.hash_set[key % len(self.hash_set)]
        while curr.next:
            if curr.next.val == key:
                curr.next = curr.next.next
                return
            
            curr = curr.next
                
    def contains(self, key: int) -> bool:
        curr = self.hash_set[key % len(self.hash_set)]
        while curr.next:
            if curr.next.val == key:
                return True
            curr = curr.next
            
        return False
            