#Time Complexity :
# Add : O(1)
# Remove : O(1)
# Contains : O(1)

#Space Complexity : O(n)

# We have implemented an hasset using an array
# By creating and array of size 1000001, as that is the range of our input values key
class MyHashSet:

    def __init__(self):
        self.data = [False] * 1000001

    def add(self, key: int) -> None:
        self.data[key] = True
        
    def remove(self, key: int) -> None:
        self.data[key] = False
        
    def contains(self, key: int) -> bool:
        return self.data[key]