class MyHashSet:

    def __init__(self):
# define a hash value to create hash
        self.val = 1000
        self.arr = [[] for i in range(self.val)]
    
    def get_hash(self,key):
# generate hash 
        return key% self.val
#Time complexity O(1)
# Space complexity O(n)        
    def add(self, key: int) -> None:
        hash = self.get_hash(key)

        if key not in self.arr[hash]:
            self.arr[hash].append(key)
        
#Time complexity O(n)
# Space complexity O(n)
    def remove(self, key: int) -> None:
        hash = self.get_hash(key)

        if key in self.arr[hash]:
            self.arr[hash].remove(key)
#Time complexity O(1)
# Space complexity O(1)           
    def contains(self, key: int) -> bool:

        hash = self.get_hash(key)

        if key in self.arr[hash]:
            return True
        else:
            return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)