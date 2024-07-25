# Complexity : for push,pop,top, getMin  time complexity is O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [[] for _ in range(self.buckets)]
    def bucket(self, key: int)->int:
        # idx for primary array
        return key%self.buckets
    
    def bucketItem(self, key: int)-> int:
        # idx for seconedary array
        return key//self.bucketItems
    
    def add(self, key: int) -> None:
        # hash primary arr
        bucket = self.bucket(key)
        # hash for secondaey arr
        bucketItem = self.bucketItem(key)
        # add the first element to secondaey array
        # if hash is 0 them arr created should be 1001 to accomodate the last element
        if not self.storage[bucket]:
            if bucket == 0:
                self.storage[bucket]= [False] * (self.bucketItems+1)
            else:
                self.storage[bucket] = [False] * self.bucketItems
        # toggle flag in the boolean array
        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        # hash for primary arr
        bucket = self.bucket(key)
        # if it exists then go ahead and has for secondary and toggle the boolean otherwise nothing to remove
        if self.storage[bucket]:
            bucketItem = self.bucketItem(key)
            self.storage[bucket][bucketItem] = False
        

    def contains(self, key: int) -> bool:
        # hash primary arr
        bucket = self.bucket(key)
        # doesn't exist then return false nothing further to do
        if not self.storage[bucket]:
            return False
        # else hash for secondary arr and return element
        else:
            bucketItem = self.bucketItem(key)
            return self.storage[bucket][bucketItem]

            
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)