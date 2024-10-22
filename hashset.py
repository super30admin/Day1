"Time Complexity for getposition, add, remove, contains is O(1) which is the average, but the worst case can be O(n)"
"Space Complexity for getposition, add, remove, contains is O(n) becase we will be initializing an array with a bucket_size here 1000"


#Explanation of problem

"We first Initialize a 2D array of size 1000. 1000 because in general we take the root of maximum number of elements we are looking at."
"We make a new function getposition which tells, at which subarray does the key belong to"
"For add, we first check if the value is present in the correct subarray, if not we append it"
"For remove, we check if the value is present and then we remove it"
"For contains, we again check if the value is present or not and then just return true if yes or false if no"

class MyHashSet:

    def __init__(self):
        self.bucket_size = 1000

        self.buckets = [[] for _ in range(self.bucket_size)]
        
    
    def getposition(self, key:int):
        return key % self.bucket_size

    def add(self, key: int) -> None:
        position = self.getposition(key)

        if key not in self.buckets[position]:
            self.buckets[position].append(key)    

    def remove(self, key: int) -> None:
        position = self.getposition(key)

        if key in self.buckets[position]:
            self.buckets[position].remove(key)
        

    def contains(self, key: int) -> bool:

        position = self.getposition(key)

        return key in self.buckets[position]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)