class MyHashSet:

    def __init__(self):

        self.buckets = 1000 #size of the primary array
        self.bucketitems = 1000 #size of the secondary array
        self.storage = [None]*self.buckets # initialize to store pointers

    # generate hash 
    def hash1(self,key):
        return key% self.buckets
    
    def hash2(self,key):
        return key // self.bucketitems

#Time complexity O(1)
# Space complexity O(n)        
    def add(self, key: int) -> None:
        index1 = self.hash1(key)
        index2 = self.hash1(key)
        if self.storage is None:
            if index1 == 0: # for the edge case since the last element will be stored at index 0
                self.storage[index1] = [False]*(self.bucketitems+1)
            else:
                self.storage[index1] = [False]*self.bucketitems

        self.storage[index1][index2] = True
        
#Time complexity O(1)
# Space complexity O(n)
    def remove(self, key: int) -> None:
        index1 = self.hash1(key)
        index2 = self.hash1(key)
        if self.storage is None:
            return
        self.storage[index1][index2] = False

#Time complexity O(1)
# Space complexity O(1)           
    def contains(self, key: int) -> bool:
        index1 = self.hash1(key)
        index2 = self.hash1(key)
        if self.storage is None:
            return
        return self.storage[index1][index2] 
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)