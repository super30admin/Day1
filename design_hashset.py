#Time Complexity - O(1) for all 3 methods
#Space Complexity - O(k + n) - k is array size and n is number of nodes 
#approach - 
#1) Used a fixed-size array with linked lists for collision handling.
#2) Hash keys using key % size to find the bucket.
#3) Traverse the bucket for add, remove, and contains operations.

class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None

class MyHashSet:
    def __init__(self):
        self.size = 10**4
        self.set = [ListNode(0) for _ in range(self.size)]
    #helper to get the bucket
    def _get_bucket(self, key: int) -> ListNode:
        return self.set[key % self.size]

    def add(self, key: int) -> None:
        bucket = self._get_bucket(key)
        while bucket.next:
            if bucket.next.key == key:
                return
            bucket = bucket.next
        bucket.next = ListNode(key)

    def remove(self, key: int) -> None:
        bucket = self._get_bucket(key)
        while bucket.next:
            if bucket.next.key == key:
                bucket.next = bucket.next.next
                return
            bucket = bucket.next

    def contains(self, key: int) -> bool:
        bucket = self._get_bucket(key)
        while bucket.next:
            if bucket.next.key == key:
                return True
            bucket = bucket.next
        return False
