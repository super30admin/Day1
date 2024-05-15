# Time Complexity : on average it's O(1), however in the worst case senario it's O(n)
# Space Complexity : is O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Faced an error when 10**6 was given as input, refered the class on how to tackle this 

# Your code here along with comments explaining your approach
# using a double hashing to solve the problem (by creating a 2d matrix that accounts to att the 10**6 possible values)
# used 2 distinctive hash functions to avoid collisions and ensured the answer is repeatable, initialized secondary array only if a new entry appears
# storing booleans insted of actual values 

class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.buckets = [None] * self.size

    def hash_func(self, key: int, operation: str) -> int:
        if operation == 'm':
            return key % self.size
        else:
            return key // self.size
    
    def add(self, key: int) -> None:
        
        h1_idx = self.hash_func(key, 'm')
        h2_idx = self.hash_func(key, 'd')

        if self.buckets[h1_idx] is None:
            if h1_idx == 0:
                self.buckets[h1_idx] = [None] * (self.size+1)
            else:
                self.buckets[h1_idx] = [None] * self.size

        self.buckets[h1_idx][h2_idx] = True

    def remove(self, key: int) -> None:
        
        h1_idx = self.hash_func(key, 'm')
        h2_idx = self.hash_func(key, 'd')

        if self.buckets[h1_idx] is None:
            return
        else:
            self.buckets[h1_idx][h2_idx] = None
        
    def contains(self, key: int) -> bool:
       
        h1_idx = self.hash_func(key, 'm')
        h2_idx = self.hash_func(key, 'd')

        if self.buckets[h1_idx] is None:
            return False
        else:
            return self.buckets[h1_idx][h2_idx]
            
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)