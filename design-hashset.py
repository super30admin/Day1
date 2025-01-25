"""

Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

 
Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)

Time Complexity:
- add(), remove(), and contains() operations all run in O(1) on average 
  since accessing and updating array elements takes constant time.

Space Complexity:
- Worst-case space complexity is O(10^6) (for storing all possible keys up to 10^6).
- However, due to the lazy initialization of the secondary bucket arrays, 
  the average space usage is much lower.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:
# used a two-dimensional array to simulate a hash set with separate chaining, 
# where the first hash function determines the primary bucket and the second determines the secondary bucket. 
# This minimizes memory usage while ensuring constant-time operations for add, remove, and contains.

class MyHashSet:

    def __init__(self):
        self.buckets = 1000     # primary
        self.bucketItems = 1000 # secondary
        self.storage = [None] * self.buckets


    def hash1(self, key: int) -> int:
        return key % self.buckets


    def hash2(self, key: int) -> int:
        return key // self.bucketItems
         

    def add(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [None] * (self.bucketItems + 1)
            else:
                self.storage[bucket] = [None] * self.bucketItems
        self.storage[bucket][bucketItem] = True
        

    def remove(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] is None:
            return
        self.storage[bucket][bucketItem] = None
        

    def contains(self, key: int) -> bool:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] is None:
            return False
        return self.storage[bucket][bucketItem] is True


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

