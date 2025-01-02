# -------------------Double Hashing--------------------------
# 1. Uses Primary array and Secondary arrays each of length 1000 (Secondary array is initialized only when we get the corresponding index).
# 2. Primary array (initialized as null pointers and stores pointer to secondary arrays when required) uses Hash Function = key%1000 and Secondary array uses function = key//1000 to avoid collision.
# 3. As in total we have 1000000 + 1 elements we need one extra bucket for 1000000 index and is taken care of by using extra bucket in secondary array at 0th index 
class MyHashSet:
    def __init__(self):
        self.arr = [None] * 1000
    
    def _hash1(self, key):
        return key % 1000
    
    def _hash2(self, key):
        return key // 1000

    def add(self, key: int) -> None:
        bucket = self._hash1(key)
        bucketitem = self._hash2(key)
        if self.arr[bucket] is None:
            self.arr[bucket] = [False] * (1001 if bucket == 0 else 1000)
        self.arr[bucket][bucketitem] = True
    
    def remove(self, key: int) -> None:
        bucket = self._hash1(key)
        bucketitem = self._hash2(key)
        if self.arr[bucket] is None:
            return 
        else:
            self.arr[bucket][bucketitem] = False
    
    def contains(self, key: int) -> bool: 
        bucket = self._hash1(key)
        bucketitem = self._hash2(key)
        if self.arr[bucket] is None:
            return False
        else:
            return self.arr[bucket][bucketitem] == True


#-------------------------Linear Chaining---------------------------
# class MyHashSet:

#     def __init__(self):
#         self.arr1 = [[] for _ in range(1000)]
       
#     def _hash(self, key):
#         return key % 1000
        
#     def add(self, key: int) -> None:

#         if key not in self.arr1[self._hash(key)]:
#             self.arr1[self._hash(key)].append(key)

#     def remove(self, key: int) -> None:
#         if key in self.arr1[self._hash(key)]:
#             self.arr1[self._hash(key)].remove(key)
        
#     def contains(self, key: int) -> bool: 
#         return (key in self.arr1[self._hash(key)])
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)