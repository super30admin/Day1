# Time Complexity: O(1) average case, O(n) worst case for all operations
# Space Complexity: O(m + n), where m is the number of buckets and n is the number of unique elements

# Implementing a HashSet using Chaining

class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None

class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.buckets = [None] * self.size #[None for _ in range(10000)]
    
    def _hash(self, key:int) -> int:
        return key % self.size

    def add(self, key: int) -> None:
        index = self._hash(key)

        #if bucket is null
        if not self.buckets[index]:
            self.buckets[index] = ListNode(key)
        #if bucket is not null
        else:
            curr = self.buckets[index]
            #traverse
            while curr:
                #if its first node
                if curr.key == key:
                    return
                #if next node is null
                if not curr.next:
                    curr.next = ListNode(key)
                curr = curr.next

    def remove(self, key: int) -> None:
        index = self._hash(key)
        
        # If the bucket is empty, return
        if not self.buckets[index]:
            return

        curr = self.buckets[index]

        # If the first node is the one to remove
        if curr.key == key:
            self.buckets[index] = curr.next
            return

        # Traverse the list to find the node to remove
        while curr.next:
            if curr.next.key == key:
                curr.next = curr.next.next
                return
            curr = curr.next

    def contains(self, key: int) -> bool:
        index = self._hash(key)

        #if bucket is null
        if not self.buckets[index]:
            return False
        
        curr = self.buckets[index]
        while curr:
            if curr.key == key:
                return True
            curr = curr.next
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)