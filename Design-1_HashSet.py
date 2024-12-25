class MyHashSet:

    # Brute force Approach 
    # Got TLE 
    # TC  - 
    #       add() - O(n)
    #       remove - O(n)
    #       contains - O(n)

    # def __init__(self):
    #     self.mySet = []
        

    # def add(self, key: int) -> None:
    #     exsistsflag = False
    #     for i in range(len(self.mySet)):
    #         if self.mySet[i] == key:
    #             exsistsflag = True
    #             break
    #     if exsistsflag== False:        
    #         self.mySet.append(key)
        

    # def remove(self, key: int) -> None:
    #     exsistingElement = False
    #     for i in range(len(self.mySet)):
    #         if self.mySet[i] == key:
    #             exsistingElement = True
    #             if i!=len(self.mySet)-1:
    #                 self.mySet[i],self.mySet[-1] = self.mySet[-1], self.mySet[i]
    #             break 
    #     if exsistingElement == True:          
    #         self.mySet.pop()    
        

    # def contains(self, key: int) -> bool:
    #     print(self.mySet)
    #     for i in range(len(self.mySet)):
    #         if self.mySet[i] == key:
    #             return True
    #     return False    

# Solution using double hashing  
# TC -
#  add- O(1)
#  remove - O(1)
#   contains - O(1)

  
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None]* self.buckets

    def getBucketIndex(self,key):
        return key%1000 

    def getBucketItemIndex(self,key):
        return key//1000

    def contains(self,key: int) -> bool:
        bucket = self.getBucketIndex(key)
        bucketItem = self.getBucketItemIndex(key) 

        if self.storage[bucket] is None:
            return False
        return  self.storage[bucket][bucketItem]                  
        

    def add(self, key: int) -> None:
        bucket = self.getBucketIndex(key)
        bucketItem = self.getBucketItemIndex(key)

        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketItems+1)
            else:
                 self.storage[bucket] = [False] * self.bucketItems


        self.storage[bucket][bucketItem] = True          
        
    def remove(self, key: int) -> None:
        bucket = self.getBucketIndex(key)
        bucketItem = self.getBucketItemIndex(key)

        if self.storage[bucket] is None:
            return

        self.storage[bucket][bucketItem] = False         
        

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
