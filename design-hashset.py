# A hashmap corresponds to a dictionary of key value pair in python.
# // Initialize a hashmap of size (10^6 +1) as None. Map key-valuie pair for put.
# // 
# // Time Complexity : O(1) because hashmap 
# // Space Complexity : O(1) because no auxialliary space is required
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

class MyHashMap:

    def __init__(self):
        self.size = 1000001                                  # 10^6 +1 size 
        self.map = [None] * self.size                         

    def put(self, key: int, value: int) -> None:             # O(1)
        self.map[key] = value                                # key-value pair
        
    def get(self, key: int) -> int:                          # O(1)
        if self.map[key] == None:                            # if key is not present -1 else return value 
            return -1
        else:
            return self.map[key]
        

    def remove(self, key: int) -> None:                      # O(1) 
        self.map[key] = -1                                   # reset value to -1    



# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(2,1)
obj.put(3,6)
print(obj.get(3))
param_2 = obj.get(2)
obj.remove(2)
print(obj.get(2))
print(param_2)