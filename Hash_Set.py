#Time Complexity : O(1)
#Space Complexity : O(N+K), N unique value, M total elementclass MyHashSet:

    def __init__(self):
        #create main list
        self.priList=[[] for i in range(1000)]

    #hasing funtion
    def hash_funct(self, key):
        return key % 1000      

    def add(self, key: int) -> None:
        #find the hash value
        pos = self.hash_funct(key)
        #checks if key is already in the array
        if not self.contains(key):
            #if not it will append key to arry
            self.priList[pos].append(key)

    def remove(self, key: int) -> None:
        #find the hash value
        pos = self.hash_funct(key)
        #if key is already present it will remove key
        if self.contains(key):
            self.priList[pos].remove(key)

    
    def contains(self, key: int) -> bool:
        #find the hash value
        pos = self.hash_funct(key)
        #according to hash value checks if key is already there in list  
        return key in self.priList[pos]


        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)