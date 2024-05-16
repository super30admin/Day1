""" 
Design-1

Problem 1:(https://leetcode.com/problems/design-hashset/)

Time Complexity : O(1)
Space Complexity : O(m+n) where n is no of elements in hashset & m is no of buckets
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Since hashset is an algorithm which performs operations in O(1), we're going to implement it using double hashing since 
that's the only collision technique which can give us O(1) T.C. Approach goes with using 2 hash functions and allocating 
bucketItems+1 in the buckets since there can be a case where the hash2 might return bucketItems and we store the value in the hashSet[hash1][hash2].

"""


class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.hashSet = [None] * 1000
        self.bucketItems = 1001

    def hash1(self, key) -> int:
        return key % self.buckets
    
    def hash2(self, key) -> int:
        return key // self.buckets
        
    def add(self, key: int) -> None:
        hash1_val = self.hash1(key)
        if self.hashSet[hash1_val] is None:
            self.hashSet[hash1_val] = [False] * self.bucketItems
        hash2_val = self.hash2(key)
        self.hashSet[hash1_val][hash2_val] = True

    def remove(self, key: int) -> None:
        hash1_val = self.hash1(key)
        if self.hashSet[hash1_val]:          
            hash2_val = self.hash2(key)
            self.hashSet[hash1_val][hash2_val] = False

    def contains(self, key: int) -> bool:
        hash1_val = self.hash1(key)
        if self.hashSet[hash1_val]:          
            hash2_val = self.hash2(key)
            return self.hashSet[hash1_val][hash2_val]
        return False
        


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
key = 3
obj.add(key)
obj.remove(key)
print(obj)
param_3 = obj.contains(key)
print(param_3)