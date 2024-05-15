"""
Time Complexity: O(1)
Space Complexity: O(n)
Did this run on leetcode.com: Yes
approach: looking at the constraints I can get keys from 0 to 10^6 so I find a balance for example here 10^3 * 10^3 (i could've also done 10^4 * 10^2)
Next, i define 2 hashing functions and define buckets, so first i initialise an array of None with length 1000 and there will be 
boolean buckets (or arrays) of 1000 at each of the index when needed. To get the initial index i mod the key with 1000 and get a index then 
on that index i make a bucket of length 1000 all of them False initially, then i perform the second hash function key / 1000 which gives me another index
in the second boolean array an then once i find the index i set it to True, this way i will have no collisions whatsoever
Things to remember: 
1. sometimes division (/) will give float remember to use either // or int()
2. there is an edge case involving 0 and 1000, for eg when an array of length 1000 wont have a index 1000 the highest index would be 999
just need to do a simple calculation we do have 1000 spaces
"""
class MyHashSet:

    def __init__(self):
        self.map = [None] * 1000
    def add(self, key: int) -> None:
        index = key % 1000
        if self.map[index] is None:
            self.map[index] = [False] * 1000
            index_2 = int(key / 1000) - 1 if key != 0 else int(key / 1000)
            self.map[index][index_2] = True
        else:
            index_2 = int(key / 1000) - 1 if key != 0 else int(key / 1000)
            self.map[index][index_2] = True

    def remove(self, key: int) -> None:
        index = key % 1000
        if self.map[index] is not None:
            index_2 = int(key / 1000) - 1 if key != 0 else int(key / 1000)
            self.map[index][index_2] = False

    def contains(self, key: int) -> bool:
        index = key % 1000
        if self.map[index] is not None:
            index_2 = int(key / 1000) - 1 if key != 0 else int(key / 1000)
            return self.map[index][index_2]