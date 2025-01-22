# Time Complexity : O(1)
# Space Complexity : O(n+k) n = number of elements in hashset and k = no of buckets 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I took time but I was able to figure it out


# Your code here along with comments explaining your approach

# used a linkedlists to handle collisions in a fixes size hash table 
# key is hashed to a bucket index using key % 10000 and 
# keys of the same buckets are stored as nodes in a linked list




class Node: # creating node for a linkedlist
    def __init__(self, key, next=None):
        self.val = key
        self.next = None

class MyHashSet:

    def __init__(self):
        # Hashset initialization
        self.length = 10000
        self.ll = [Node(None) for i in range(self.length)]        

    def add(self, key: int) -> None:
        curr = self.ll[self.hash(key)] # Get the linked list for the bucket
        while curr.next: # traversal
            if curr.next.val == key: #if key already exist then simply return
                return 
            curr = curr.next # move to next node
        curr.next = Node(key) # adding the new key at the end

    def remove(self, key: int) -> None:
        curr = self.ll[self.hash(key)] # Get the linked list for the bucket
        while curr.next: # traversal
            if curr.next.val == key: #if key already exist then remove it
                curr.next = curr.next.next #by skipping the node
                return 
            curr = curr.next # move to next node   

    def contains(self, key: int) -> bool:
        curr = self.ll[self.hash(key)] # Get the linked list for the bucket
        while curr.next: # traversal
            if curr.next.val == key: #if key already exist then return true
                return True
            curr = curr.next # move to next node
        return False #return false if key not found
    
    # Hash function to calculate the index for a given key
    def hash(self, key: int) -> int:
        index = key % self.length
        return index
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)