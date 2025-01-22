'''
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

time: add , remove, contains - o(1)
space - o(n)


// Your code here along with comments explaining your approach

'''
class MyHashSet:

    def __init__(self):
        self.size=1000
        self.bucket=[]
        for i in range(self.size):
            self.bucket.append([])
        print(self.bucket)
        
    def hash(self,key):
        return key%self.size

    def add(self, key: int) -> None:
        index=self.hash(key)
        if key not in self.bucket[index]:
            self.bucket[index].append(key)

    def remove(self, key: int) -> None:
        index=self.hash(key)
        if key in self.bucket[index]:
            self.bucket[index].remove(key)

        

    def contains(self, key: int) -> bool:
        index=self.hash(key)
        if key in self.bucket[index]:
            return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)